package methods;

import driver.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class BaseMethods {
    private final WebDriver driver;
    private final FluentWait<WebDriver> driverWait;
    private final JavascriptExecutor jsdriver;
    Logger logger = LogManager.getLogger(BaseMethods.class);

    public BaseMethods(){
        driver = BaseTest.driver;
        driverWait = new FluentWait<>(driver);
        driverWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchFieldException.class);
        jsdriver =(JavascriptExecutor) driver;
    }

    public WebElement findElement(By by) {

        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public void click(By by){
        driverWait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }
    /*
    public void click(By by, long waitSeconds){
        if (waitSeconds != 0){
            waitBySeconds(waitSeconds);
        }
        driverWait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }
    */
    public void sendKeys(By by, String text){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        findElement(by).sendKeys(text);
    }
    public void sendKeys(By by, String text, long waitSeconds){
        if (waitSeconds != 0){
            waitBySeconds(waitSeconds);
        }
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        findElement(by).sendKeys(text);
    }
    public boolean isElementVisible(By by){
        try{
            Thread.sleep(1 * 1000);
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info("Login successful");
            return true;
        }catch (Exception e){
            logger.info("Login Failed");
            return false;
        }
    }
    public void scrollAction(By by){
        Actions action = new Actions(driver);
        driverWait.until(ExpectedConditions.elementToBeClickable(by));
        action.moveToElement(findElement(by)).build().perform();
    }

    public Select getSelect(By by){
        return new Select(findElement(by));
    }

    public void selectByText(By by, String text){
        getSelect(by).selectByVisibleText(text);
    }

    public void waitBySeconds(long seconds){
        try {
            Thread.sleep(seconds * 1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getText(By by){
        return findElement(by).getText();
    }
    public void hover(By by) {
        WebElement element = findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
}
