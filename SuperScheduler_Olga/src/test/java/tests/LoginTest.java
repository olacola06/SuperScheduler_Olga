package tests;

import manager.Configuration;
import org.testng.annotations.Test;
import screens.LoginScreen;

public class LoginTest extends Configuration {
    @Test
    public void loginPos1(){
        new LoginScreen(driver).fillEmail("olla@gmail.com").fillPassword("Cd12345$").clickLoginBtn()
                .isPlusBtnPresentAssert().openMenu().logout();
    }

    @Test
    public void loginPos2(){
        new LoginScreen(driver).fillEmail("Ola@mail.com").fillPassword("qQ12345@").clickLoginBtn()
                .isPlusBtnPresentAssert().openMenu().logout();
    }
}
