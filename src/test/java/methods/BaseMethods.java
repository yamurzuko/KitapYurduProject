package methods;

import driver.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseMethods {
    private final WebDriver driver;
    private final FluentWait<WebDriver> driverWait;
    private final JavascriptExecutor jsdriver;

    public BaseMethods(){
        driver = BaseTest.driver;
        driverWait = new FluentWait<>(driver);
        driverWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchFieldException.class);
        jsdriver =(JavascriptExecutor) driver;
    }

    public WebElement findElement(By by) {
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public void click(By by){
        click(by, 0);
    }
    public void click(By by, long waitSeconds){
        if (waitSeconds != 0){
            waitBySeconds(waitSeconds);
        }
        driverWait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }
    public void sendKeys(By by, String text){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        findElement(by).sendKeys(text);
    }
    public boolean isElementVisible(By by){
        try{
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public void scrollAction(By by) {
        scrollAction(by, 0);
    }

    public void scrollAction(By by, long waitSeconds){
        if (waitSeconds != 0){
            waitBySeconds(waitSeconds);
        }
        Actions action = new Actions(driver);
        action.moveToElement(findElement(by)).build().perform();
    }

    public void scrollDown(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        jsdriver.executeScript("arguments[0].scrollIntoView()", element);
    }
    public Select getSelect(By by){
        return new Select(findElement(by));
    }
    public void selectByText(By by, String text){
        getSelect(by).selectByVisibleText(text);
    }
    public String getAttribute(By by, String attributeName){
        return findElement(by).getAttribute(attributeName);
    }
    public String getText(By by){
        return findElement(by).getText();
    }
    public String getValue(By by){
        return jsdriver.executeScript("return arguments[0].value;",findElement(by)).toString();
    }

    public void waitBySeconds(long seconds){
        try {
            Thread.sleep(seconds * 1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void hover(By by) {
        WebElement element = findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
}
