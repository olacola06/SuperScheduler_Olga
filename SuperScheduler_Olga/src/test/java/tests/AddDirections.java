package tests;

import lombok.extern.java.Log;
import manager.Configuration;
import manager.MyDataProvider;
import models.Direction;
import models.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.Directions;
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
        new HomeScreen(driver).openMenu().clickDirection()
                .addDirection("Tel Shomer","Akko","180","40","British pound");
    }
    @Test
    public void addNewDirectionLombok(){
        Direction dir = Direction.builder().from("Paris").to("Vienna")
                .numberKm("900").cost("20").currency("Lao kip").build();
        new HomeScreen(driver).openMenu().clickDirection().addDirectionLombok(dir);
    }
    @Test(dataProvider = "directionsSetting",dataProviderClass = MyDataProvider.class)
    public void addNewDirectionData(Direction dir){
        new HomeScreen(driver).openMenu().clickDirection().addDirectionLombok(dir);
    }
    @AfterClass
    public void postCondition(){
        new HomeScreen(driver).openMenu().logout();
    }
}
