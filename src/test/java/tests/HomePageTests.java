package tests;

import driver.BaseTest;
import org.junit.Test;

public class HomePageTests extends BaseTest {

    @Test
    public void testHomePageActions(){

        getLoginPage().login();
        getProductPage().searchAndFavoriteProducts();
        getHomePage().actionsHomePage();
    }
}
