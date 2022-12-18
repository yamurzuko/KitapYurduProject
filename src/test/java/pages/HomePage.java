package pages;

import methods.BaseMethods;
import org.openqa.selenium.By;

public class HomePage {
    private final BaseMethods method;

    private final By logoClick = By.cssSelector(".logo-icon>a");

    private final By pointCatalog = By.xpath("//a[@href='puan-katalogu']");

    private final By classicButton = By.xpath("//div[@class='landing-block']/a[2]/img");

    private final By sortButton = By.cssSelector(".product-filter-header>div>select");

    private final By allBookButton = By.xpath("//ul[@class='js-ajaxCt js-bookCt']/li[3]/span");

    private final By hobiButton = By.xpath("//ul[@class='js-ajaxCt js-bookCt']/li[3]/div/div/div/ul[2]/li[14]/a");

    private final By addCartButton = By.cssSelector("#button-cart");

    private final By favoriteButton = By.xpath("//*[@class='menu top my-list']/ul/li/div/ul/li[1]/a");

    private final By myListButton = By.xpath("//*[@class='menu top my-list']/ul/li[1]/a");

    private final By removeProduct = By.xpath("//div[@class='product-list']/div[3]");

    private final By removeProductButton = By.xpath("//div[@class='product-list']/div[3]/div[2]/div[@class='hover-menu']/a[@data-title='Favorilerimden Sil']");

    public HomePage(){
        method = new BaseMethods();
    }

    public void actionsHomePage(){
        method.click(logoClick);
        method.click(pointCatalog, 2);
        method.scrollAction(classicButton, 2);
        method.click(classicButton, 2);
        method.waitBySeconds(2);
        method.selectByText(sortButton,"Yüksek Oylama");
        method.waitBySeconds(2);
        method.hover(allBookButton);
        method.click(hobiButton, 2);
        method.waitBySeconds(2);
    }
    public void addProductToCart(){
        Integer number = (1 + (int) (Math.random() * 14));
        var product = By.xpath(String.format("//ul[@class='product-grid jcarousel-skin-opencart']/li[%d]",number));

        method.hover(product);
        method.waitBySeconds(2);
        method.click(product);
        method.waitBySeconds(2);
        method.click(addCartButton);
        method.waitBySeconds(2);
        method.scrollAction(myListButton);
        method.hover(myListButton);
        method.click(favoriteButton);
        method.waitBySeconds(3);
        method.scrollAction(removeProduct);
        method.waitBySeconds(2);
        method.click(removeProductButton);
        method.waitBySeconds(2);
    }
}
