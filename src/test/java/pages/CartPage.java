package pages;

import methods.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class CartPage {
    private final BaseMethods method;

    private final String name = "Ugur";

    private final String surname = "Yagmur";

    private final String country = "Türkiye";

    private final String city = "Antalya";

    private final String distict = "DEMRE";

    private final String address = "aslkdmasdma";

    private Long phone = 5940039393l;

    private final By myCart = By.xpath("//div[@id='cart']/div/div[2]/h4");

    private final By goToCartButton = By.xpath("//div[@id='cart']/div[2]/div[2]/div[2]/div/a");

    private final By productCount = By.xpath("//div[@class='cart-info']/table/tbody/tr/td[4]/form/input");

    private final By buyButton = By.xpath("//div[@class='cart-info']/table/thead/tr/td[8]/a");

    private final By insertName = By.cssSelector("#address-firstname-companyname");

    private final By insertSurname = By.cssSelector("#address-lastname-title");

    private final By insertCountry = By.cssSelector("#address-country-id");

    private final By insertCity = By.cssSelector("#address-zone-id");

    private final By insertDistrict = By.cssSelector("#address-county-id");

    private final By insertAddress = By.cssSelector("#address-address-text");

    private final By insertPhone = By.cssSelector("#address-mobile-telephone");

    private final By continueButton = By.cssSelector("#button-checkout-continue");

    private final By newAddress = By.cssSelector("//div[@id='shipping-tabs']/a[2]");

    Integer number = (1 + (int) (Math.random() * 15));

    public CartPage(){
        method = new BaseMethods();
    }

    public void goToCart(){
        method.click(myCart);
        method.waitBySeconds(1);
        method.click(goToCartButton);
        method.waitBySeconds(2);
        method.sendKeys(productCount,number.toString());
        method.waitBySeconds(1);
        method.findElement(productCount).sendKeys(Keys.ENTER);
        method.waitBySeconds(2);
        method.click(buyButton);
        method.waitBySeconds(2);
        method.click(newAddress);
        method.waitBySeconds(2);
        method.sendKeys(insertName,name);
        method.waitBySeconds(2);
        method.sendKeys(insertSurname,surname);
        method.waitBySeconds(2);
        method.selectByText(insertCountry,country);
        method.waitBySeconds(2);
        method.selectByText(insertCity,city);
        method.waitBySeconds(2);
        method.selectByText(insertDistrict,distict);
        method.waitBySeconds(2);
        method.sendKeys(insertAddress,address);
        method.waitBySeconds(2);
        method.sendKeys(insertPhone,phone.toString());
        method.waitBySeconds(2);
        method.click(continueButton);
        method.waitBySeconds(2);
        method.click(continueButton);
        method.waitBySeconds(2);
    }
}
