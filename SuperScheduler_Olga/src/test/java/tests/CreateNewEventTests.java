package tests;

import manager.Configuration;
import manager.ConfigurationRealPhone;
import models.Event;
import models.User;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;

//public class CreateNewEventTests extends ConfigurationRealPhone {
    public class CreateNewEventTests extends Configuration {

    @BeforeClass
    public void preConditions(){
        new LoginScreen(driver).complexLogin(User.builder()
                .email("olla@gmail.com").password("Cd12345$").build());
    }

    @Test(invocationCount = 1)
    public void addNewEventSuccess(){
        Event event = Event.builder().title("Reality").type("Full-day").breaks(3)
                .wage(50).build();
        logger.info("New Event with details:->> Title 'Real', Type 'Full-day', Wage= '50'");
        new HomeScreen(driver).initEventCreate().createNewEvent(event).isPlusBtnPresentAssert();
        logger.info("Event was added Successfully");

    }
    @Test
    public void addNewEventSuccessSecond(){
        Event event = Event.builder().title("Next day").type("Half-day").breaks(2)
                .wage(30).build();
        logger.info("New Event with details:->> Title 'Next day', Type 'Half-day', Wage= '30'");
        boolean isPlusBtnPresent = new HomeScreen(driver).initEventCreate().createNewEvent(event)
                .isPlusBtnPresent();
        Assert.assertTrue(isPlusBtnPresent);
        logger.info("Event was added Successfully");

    }
    @Test
    public void addNewEventSuccessDate(){
        new HomeScreen(driver).initEventCreate().createNewEventDate(Event.builder().
                        title("Low").type("Half-day").breaks(2).wage(30).build())
                .isPlusBtnPresentAssert();
    }

    @AfterClass
    public void postCondition(){
        new HomeScreen(driver).openMenu().logout();
    }
}
