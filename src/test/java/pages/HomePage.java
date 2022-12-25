package pages;

import methods.BaseMethods;
import org.openqa.selenium.By;

public class HomePage {
    private final BaseMethods method;

    private String selectProduct = "//div[@id='content']/div/div[1]/div/div[2]/ul/li[%d]";
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
        bookListFilter();
        addProductToCart();
        removeProductFavorites();
        method.waitBySeconds(1);
    }
    public void bookListFilter(){
        method.click(logoClick);
        method.click(pointCatalog);
        method.scrollAction(classicButton);
        method.click(classicButton);
        method.selectByText(sortButton,"Yüksek Oylama");
        method.hover(allBookButton);
        method.click(hobiButton);
    }
    public void addProductToCart(){
        Integer number = (1 + (int) (Math.random() * 14));
        var product = By.xpath(String.format(selectProduct,number));

        method.scrollAction(product);
        method.click(product);
        method.click(addCartButton);
    }
    public void removeProductFavorites(){
        method.scrollAction(myListButton);
        method.hover(myListButton);
        method.click(favoriteButton);
        method.scrollAction(removeProduct);
        method.click(removeProductButton);
    }
}
