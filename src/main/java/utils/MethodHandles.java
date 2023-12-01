package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodHandles {
    WebDriver driver;

    WebDriverWait wait;

    private final By loader = By.cssSelector(".ajax-loading-block-window");
    public MethodHandles(WebDriver driver){
        this.driver =driver;
    }

    protected void invisibilityOfElement(By locator, int time){
        try {
            wait = new WebDriverWait(driver,Duration.ofSeconds(time));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        }catch (NoSuchElementException e){

        }
    }
    protected void explicitWait(By locator, int time){
        wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(driver.findElement(locator)),
                ExpectedConditions.visibilityOfElementLocated(locator),
                ExpectedConditions.presenceOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator)));
    }

    protected void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(
                "arguments[0].scrollIntoView({ behavior: 'auto', block: 'center', inline: 'center' });"
                , element);
    }

    protected WebElement webElement(By locator){
        return driver.findElement(locator);
    }

    protected void click(By locator){
        // wait until  inv of loader
        invisibilityOfElement(loader,20);

        // wait
        explicitWait(locator,20);
        // scroll into element
        scrollToElement(driver, driver.findElement(locator));

        // actions
        webElement(locator).click();

    }
}
