package academy.learnprogramming.utils.impl;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Clock;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.SystemClock;

import java.util.concurrent.TimeUnit;

public class WebDriverWaitEx extends FluentWait<WebDriver> {
    public static final long DEFAULT_SLEEP_TIMEOUT = 10;
    private final WebDriver driver;

    public WebDriverWaitEx(final WebDriver driver, final long timeOutInSeconds) {
        this(driver, new SystemClock(), Sleeper.SYSTEM_SLEEPER, timeOutInSeconds, DEFAULT_SLEEP_TIMEOUT);
    }

    public WebDriverWaitEx(final WebDriver driver, final long timeOut, final TimeUnit time) {
        this(driver, new SystemClock(), Sleeper.SYSTEM_SLEEPER, timeOut, DEFAULT_SLEEP_TIMEOUT, time);
    }

    public WebDriverWaitEx(final WebDriver driver, final long timeOutInSeconds, final long sleepInMillis) {
        this(driver, new SystemClock(), Sleeper.SYSTEM_SLEEPER, timeOutInSeconds, sleepInMillis);
    }

    public WebDriverWaitEx(
            final WebDriver driver,
            final Clock clock,
            final Sleeper sleeper,
            final long timeOutInSeconds,
            final long sleepTimeOut) {

        this(driver, clock, sleeper, timeOutInSeconds, sleepTimeOut, TimeUnit.SECONDS);
    }

    public WebDriverWaitEx(
            final WebDriver driver,
            final Clock clock,
            final Sleeper sleeper,
            final long timeOut,
            final long sleepTimeOut,
            final TimeUnit time) {

        super(driver, clock, sleeper);
        withTimeout(timeOut, time);
        pollingEvery(sleepTimeOut, TimeUnit.MILLISECONDS);
        ignoring(NotFoundException.class);
        this.driver = driver;
    }

    @Override
    protected RuntimeException timeoutException(String message, Throwable lastException) {
        WebDriver exceptionDriver = driver;
        TimeoutException ex = new TimeoutException(message, lastException);
        ex.addInfo(WebDriverException.DRIVER_INFO, exceptionDriver.getClass().getName());
        while (exceptionDriver instanceof WrapsDriver) {
            exceptionDriver = ((WrapsDriver) exceptionDriver).getWrappedDriver();
        }
        if (exceptionDriver instanceof RemoteWebDriver) {
            RemoteWebDriver remote = (RemoteWebDriver) exceptionDriver;
            if (remote.getSessionId() != null) {
                ex.addInfo(WebDriverException.SESSION_ID, remote.getSessionId().toString());
            }
            if (remote.getCapabilities() != null) {
                ex.addInfo("Capabilities", remote.getCapabilities().toString());
            }
        }
        throw ex;
    }
}
