package academy.learnprogramming.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public interface ExpectedConditionCallback {
    ExpectedCondition<WebElement> getExpectedCondition(By by);
}
