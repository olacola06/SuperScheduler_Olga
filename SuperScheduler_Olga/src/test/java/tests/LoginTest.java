package tests;

import manager.Configuration;
import org.testng.annotations.Test;
import screens.LoginScreen;

public class LoginTest extends Configuration {
    @Test
    public void loginPos(){

        new LoginScreen(driver).fillEmail("olla@gmail.com").fillPassword("Cd12345$").clickLoginBtn();
    }
}
