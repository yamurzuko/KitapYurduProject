package tests;

import driver.BaseTest;
import org.junit.Test;

public class CartPageTests extends BaseTest {

    @Test
    public void testCartActions(){

        getLoginPage().login();
        getProductPage().searchAndFavoriteProducts();
        getHomePage().actionsHomePage();
        getCartPage().cartActions();
    }
}
