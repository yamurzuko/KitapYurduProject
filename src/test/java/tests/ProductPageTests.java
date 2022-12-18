package tests;

import driver.BaseTest;
import org.junit.Test;

public class ProductPageTests extends BaseTest {
    @Test
    public void testSearchProduct(){
        getLoginPage().login();
        getProductPage().searchAndFavoriteProducts();
    }
}
