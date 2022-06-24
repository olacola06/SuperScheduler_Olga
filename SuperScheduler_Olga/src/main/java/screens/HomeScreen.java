package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class HomeScreen extends BaseScreen{

    public HomeScreen(AppiumDriver<MobileElement> driver){
        super(driver);
    }
    @FindBy(xpath="//*[@content-desc='Open']")
    MobileElement burgerMenu;
    @FindBy (xpath="//*[@resource-id='com.example.svetlana.scheduler:id/nav_fr_logout_container']")
    MobileElement logout;

    public HomeScreen openMenu(){
        burgerMenu.click();
        return this;
    }
    public LoginScreen logout(){
        logout.click();
        return new LoginScreen(driver);
    }

}
