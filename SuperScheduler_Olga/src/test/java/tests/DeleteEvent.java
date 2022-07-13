package tests;

import manager.Configuration;
import manager.ConfigurationRealPhone;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.*;

//public class DeleteEvent extends Configuration {
    public class DeleteEvent extends ConfigurationRealPhone {

    @BeforeClass
    public void preCondition(){
        new LoginScreen(driver).complexLogin(User.builder()
                .email("olla@gmail.com").password("Cd12345$").build());
    }

    @Test
    public void deleteExistEventFirstInList(){
        Boolean check = new HomeScreen(driver)
                .deleteEvent();
        Assert.assertTrue(check);
    }
    @Test(enabled = true)
    public void deleteExistEventWithDetails(){
        new HomeScreen(driver).deleteEventDetails("Low");

    }
    @AfterClass(enabled = false)
    public void postCondition(){
        new HomeScreen(driver).openMenu().logout();
    }
}
