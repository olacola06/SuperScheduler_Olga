package tests;

import manager.ConfigurationRealPhone;
import models.Event;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;

public class CreateNewEventTests extends ConfigurationRealPhone {

    @BeforeClass
    public void preConditions(){
        new LoginScreen(driver).complexLogin(User.builder()
                .email("olla@gmail.com").password("Cd12345$").build());
    }

    @Test
    public void addNewEventSuccess(){
        Event event = Event.builder().title("Today").type("Full-day").breaks(3)
                .wage(50).build();
        new HomeScreen(driver).initEventCreate().createNewEvent(event).isPlusBtnPresentAssert();

    }
    @Test
    public void addNewEventSuccessSecond(){
        Event event = Event.builder().title("Tomorrow").type("Half-day").breaks(2)
                .wage(30).build();
        boolean isPlusBtnPresent = new HomeScreen(driver).initEventCreate().createNewEvent(event)
                .isPlusBtnPresent();
        Assert.assertTrue(isPlusBtnPresent);

    }

    @AfterClass
    public void postCondition(){
        new HomeScreen(driver).openMenu().logout();
    }
}
