package pages;

import methods.BaseMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.List;

public class ProductPage {
    private final BaseMethods method;
    private final Random rnd;
    private final int maxProductCountInPage = 20;
    private final String searchText = "Oyuncak";
    private String addToFavoriteXPath = "//div[@class='product-list']/div[@class='product-cr'][%d]" +
            "/div[@class='grid_2 alpha omega relative']/div[@class='hover-menu']/a[@class='add-to-favorites']";
    private final By searchProduct = By.cssSelector("#search-input");
    private final By searchButton = By.cssSelector(".common-sprite.button-search");
    private final By scrollBook = By.xpath("//div[@class='product-list']/div[@class='product-cr'][6]");
    private final By favoriteButton = By.xpath("//*[@class='menu top my-list']/ul/li/div/ul/li[1]/a");
    private final By myListButton = By.xpath("//*[@class='menu top my-list']/ul/li[1]/a");

    private final By favoriteProductGridElement = By.cssSelector(".product-cr");

    public ProductPage(){
        method = new BaseMethods();
        rnd = new Random();
    }

    public void searchAndFavoriteProducts(){
        searchProduct();
        method.waitBySeconds(3);
        addProductToFavorite();
        method.waitBySeconds(3);
        controlFavoriteProductCount();
    }

    private void searchProduct(){
        method.sendKeys(searchProduct, searchText);
        method.click(searchButton);
        method.scrollAction(scrollBook, 3);
    }

    private void addProductToFavorite(){
        Set<Integer> s = new HashSet<>();
        int favoriteProductCount = 4;

        //Random numbers pre-generated for each element
        while(s.size() != favoriteProductCount){
            s.add(1 + (int)(Math.random() * (maxProductCountInPage - 1)));
        }

        Integer[] arr = s.toArray(new Integer[s.size()]);

        for (int i=0; i<favoriteProductCount; i++){
            var product = By.xpath(String.format(addToFavoriteXPath, arr[i]));
            method.scrollAction(product);
            method.click(product, 2);
            method.waitBySeconds(2);
        }

        method.scrollAction(myListButton);
        method.hover(myListButton);
        method.click(favoriteButton);
    }

    private void controlFavoriteProductCount(){
        List<WebElement> elements = method.findElements(favoriteProductGridElement);
        Assert.assertEquals(4, elements.size());
    }
}
