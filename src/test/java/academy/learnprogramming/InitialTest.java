package academy.learnprogramming;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitialTest {
    @Test
    public void openURL() {
        final ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://learnprogramming.academy/");
        chromeDriver.quit();
    }
}
