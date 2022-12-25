package tests;

import driver.BaseTest;
import org.junit.Test;

public class AppTest extends BaseTest {

    @Test
    public void testLogin(){
        getLoginPage().login();
    }

    @Test
    public void testSearchProduct(){
        getLoginPage().login();
        getProductPage().searchAndFavoriteProducts();
    }

    @Test
    public void testHomePageActions(){

        getLoginPage().login();
        getProductPage().searchAndFavoriteProducts();
        getHomePage().actionsHomePage();
    }

    @Test
    public void testCartActions(){

        getLoginPage().login();
        getProductPage().searchAndFavoriteProducts();
        getHomePage().actionsHomePage();
        getCartPage().cartActions();
    }
}
