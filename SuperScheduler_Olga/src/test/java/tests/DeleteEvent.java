package tests;

import manager.Configuration;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.*;

public class DeleteEvent extends Configuration {

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
    public void deleteExistEventWIthDetails(){
        new HomeScreen(driver).deleteEventDetails("Low");

    }
//    @AfterClass
//    public void postCondition(){
//        new HomeScreen(driver).openMenu().logout();
//    }
}
