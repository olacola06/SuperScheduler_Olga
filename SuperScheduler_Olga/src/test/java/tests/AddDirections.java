package tests;

import manager.Configuration;
import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;

public class AddDirections extends Configuration {

    @BeforeClass
    public void preCondition(){
        new LoginScreen(driver).complexLogin(User.builder()
                .email("olla@gmail.com").password("Cd12345$").build());
    }
    @Test
    public void addNewDirection(){
        new HomeScreen(driver).openMenu().clickDirection();

    }
}
