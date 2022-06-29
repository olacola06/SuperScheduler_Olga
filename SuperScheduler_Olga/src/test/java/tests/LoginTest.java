package tests;

import manager.Configuration;
import manager.ConfigurationRealPhone;
import models.User;
import org.testng.annotations.Test;
import screens.LoginScreen;

public class LoginTest extends ConfigurationRealPhone {
    @Test
    public void loginPos1(){
        new LoginScreen(driver).fillEmail("olla@gmail.com").fillPassword("Cd12345$").clickLoginBtn()
                .isPlusBtnPresentAssert().openMenu().logout();
    }

    @Test
    public void loginPos2(){
        User user = User.builder().email("Ola@mail.com").password("qQ12345@").build();
        new LoginScreen(driver).complexLogin(user).isPlusBtnPresentAssert().openMenu().logout();

    }
}
