package tests;

import driver.BaseTest;
import org.junit.Test;
import pages.LoginPage;

public class LoginPageTests extends BaseTest {

    @Test
    public void testLogin(){
        getLoginPage().login();
    }
}
