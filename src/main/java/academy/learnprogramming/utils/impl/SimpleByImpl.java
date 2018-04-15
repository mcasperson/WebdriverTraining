package academy.learnprogramming.utils.impl;

import academy.learnprogramming.exceptions.WebElementException;
import academy.learnprogramming.utils.ExpectedConditionCallback;
import academy.learnprogramming.utils.SimpleBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.toList;

public class SimpleByImpl implements SimpleBy {
    private static final int MILLISECONDS_PER_SECOND = 1000;
    private static final int TIME_SLICE = 100;

    private final List<Constructor<? extends By>> byConstructors;

    public SimpleByImpl() {
        byConstructors = Arrays.asList(
                getConstructor(By.ById.class),
                getConstructor(By.ByClassName.class),
                getConstructor(By.ByCssSelector.class),
                getConstructor(By.ByLinkText.class),
                getConstructor(By.ByName.class),
                getConstructor(By.ByXPath.class)
        );
    }

    private Constructor<? extends By> getConstructor(Class<? extends By> clazz) {
        try {
            return clazz.getConstructor(String.class);
        } catch (NoSuchMethodException ex) {
            return null;
        }
    }

    private By getByInstance(Constructor<? extends By> constructor, String locator) {
        try {
            return constructor.newInstance(locator);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            return null;
        }
    }

    @Override
    public WebElement getElement(
            WebDriver webDriver,
            String locator,
            int waitTime,
            ExpectedConditionCallback expectedConditionCallback) {
        long time = -1;

        List<By> byInstances = byConstructors.stream()
                .map(constructor -> getByInstance(constructor, locator))
                .collect(toList());

        while (time < waitTime * MILLISECONDS_PER_SECOND) {
            for (final By by : byInstances) {
                try {
                    final WebDriverWaitEx wait = new WebDriverWaitEx(
                            webDriver,
                            TIME_SLICE,
                            TimeUnit.MILLISECONDS);
                    final ExpectedCondition<WebElement> condition =
                            expectedConditionCallback.getExpectedCondition(by);

                    return wait.until(condition);
                } catch (final Exception ignored) {
					/*
						Do nothing
					 */
                }

                time += TIME_SLICE;
            }
        }

        throw new WebElementException("All attempts to find element failed");
    }
}
