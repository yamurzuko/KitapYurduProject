package pages;

import methods.BaseMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class CartPage {
    private final BaseMethods method;

    Logger logger = LogManager.getLogger(CartPage.class);

    private final String name = "Ugur";

    private final String surname = "Yagmur";

    private final String country = "Türkiye";

    private final String city = "Antalya";

    private final String distict = "DEMRE";

    private final String address = "aslkdmasdma";

    private Long phone = 5940039393l;

    private final By myCart = By.cssSelector("#cart>.heading>.fl>.common-sprite");

    private final By goToCartButton = By.xpath("//div[@id='cart']/div[2]/div[2]/div[2]/div/a");

    private final By productCount = By.xpath("//div[@class='cart-info']/table/tbody/tr/td[4]/form/input");

    private final By buyButton = By.cssSelector(".right>.red.button");

    private final By insertName = By.cssSelector("#address-firstname-companyname");

    private final By insertSurname = By.cssSelector("#address-lastname-title");

    private final By insertCountry = By.cssSelector("#address-country-id");

    private final By insertCity = By.cssSelector("#address-zone-id");

    private final By insertDistrict = By.cssSelector("#address-county-id");

    private final By insertAddress = By.cssSelector("#address-address-text");

    private final By insertPhone = By.cssSelector("#address-mobile-telephone");

    private final By continueButton = By.cssSelector("#button-checkout-continue");

    private final By newAddress = By.xpath("//div[@id='shipping-tabs']/a[2]");

    private final By cardHolderName = By.xpath("//*[@id='form-credit-card']/div[2]/table/tbody/tr[3]/td/input");

    private final By cardNumber1 = By.xpath("//*[@id='form-credit-card']/div[2]/table/tbody/tr[5]/td/input[1]");
    private final By cardNumber2 = By.xpath("//*[@id='form-credit-card']/div[2]/table/tbody/tr[5]/td/input[2]");
    private final By cardNumber3 = By.xpath("//*[@id='form-credit-card']/div[2]/table/tbody/tr[5]/td/input[3]");
    private final By cardNumber4 = By.xpath("//*[@id='form-credit-card']/div[2]/table/tbody/tr[5]/td/input[4]");
    private final By selectDate = By.xpath("//*[@id='form-credit-card']/div[2]/table/tbody/tr[7]/td/select[1]");
    private final By selectDate1 = By.xpath("//*[@id='form-credit-card']/div[2]/table/tbody/tr[7]/td/select[2]");
    private final By cvvNumber = By.xpath("//*[@id='form-credit-card']/div[2]/table/tbody/tr[9]/td/input");
    private final By error = By.xpath("//*[@id='form-credit-card']/div[2]/table/tbody/tr[5]/td/span");
    private final By logoClick = By.cssSelector(".logo-icon>a");
    private final By logoutHover = By.xpath("//div[@class='menu top login']/ul/li/a/b");
    private final By logoutButton = By.xpath("//div[@class='menu top login']/ul/li/div/ul/li[4]/a");
    Integer number = (1 + (int) (Math.random() * 5));

    public CartPage(){
        method = new BaseMethods();
    }

    public void cartActions(){
        goToCartAndUpdate();
        updateToAddress();
        method.click(continueButton);
        method.click(continueButton);
        paymentMethod();
        method.click(continueButton);
        errorPayment();
        logoutAccount();
    }
    public void goToCartAndUpdate(){
        method.click(myCart);
        method.waitBySeconds(1);
        method.click(goToCartButton);
        method.sendKeys(productCount,number.toString());
        method.findElement(productCount).sendKeys(Keys.ENTER);
        method.click(buyButton);
    }
    public void updateToAddress(){
        method.click(newAddress);
        method.sendKeys(insertName,name);
        method.sendKeys(insertSurname,surname);
        method.selectByText(insertCountry,country);
        method.selectByText(insertCity,city);
        method.selectByText(insertDistrict,distict);
        method.sendKeys(insertAddress,address);
        method.sendKeys(insertPhone,phone.toString());
    }
    public void paymentMethod(){
        method.sendKeys(cardHolderName,"sadasd");
        method.sendKeys(cardNumber1,"1234");
        method.sendKeys(cardNumber2,"5678");
        method.sendKeys(cardNumber3,"9876");
        method.sendKeys(cardNumber4,"5432");
        method.selectByText(selectDate,"04");
        method.selectByText(selectDate1,"2029");
        method.sendKeys(cvvNumber,"453");
    }
    public void errorPayment(){

        String expected = "Kart numarası geçersiz. Kontrol ediniz!";
        String actual = method.getText(error);

        Assert.assertEquals("Card info is wrong!",expected,actual);
        logger.info("Card info is correct.");
    }
    public void logoutAccount(){
        method.click(logoClick);
        method.hover(logoutHover);
        method.click(logoutButton);
    }
}
