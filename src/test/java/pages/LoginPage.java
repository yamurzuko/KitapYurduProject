package pages;

import methods.BaseMethods;
import org.junit.Assert;
import org.openqa.selenium.By;


public class LoginPage {

    private final BaseMethods method;

    private final By homeLoginButton = By.cssSelector(".menu-top-button.login>a");

    private final By emailBox = By.cssSelector("#login-email");

    private final By passwordBox = By.xpath("//input[@id='login-password']");

    private final By loginButton = By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn");

    private final By accountVisible = By.cssSelector(".section");

    public LoginPage(){
        method = new BaseMethods();
    }

    public void login(){
        method.click(homeLoginButton);
        method.sendKeys(emailBox,"yamurzcan@gmail.com");
        method.sendKeys(passwordBox,"deneme1234");
        method.waitBySeconds(5);
        method.click(loginButton);
        method.waitBySeconds(3);
        Assert.assertTrue(method.isElementVisible(accountVisible));
    }
}
