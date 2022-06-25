package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomeScreen extends BaseScreen{

    public HomeScreen(AppiumDriver<MobileElement> driver){
        super(driver);
    }
    @FindBy(xpath="//*[@content-desc='Open']")
    MobileElement burgerMenu;
    @FindBy (xpath="//*[@resource-id='com.example.svetlana.scheduler:id/nav_fr_logout_container']")
    MobileElement logout;

    @FindBy(xpath="//*[@resource-id='com.example.svetlana.scheduler:id/fab_main']")
    MobileElement plusButton;

    public HomeScreen openMenu(){
        burgerMenu.click();
        return this;
    }
    public LoginScreen logout(){
        logout.click();
        return new LoginScreen(driver);
    }
    public HomeScreen isPlusBtnPresentAssert(){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(plusButton));
        Assert.assertTrue(plusButton.isDisplayed());
        return this;
    }
    public boolean isPlusBtnPresent(){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(plusButton));
        return (plusButton.isDisplayed());
    }


}
