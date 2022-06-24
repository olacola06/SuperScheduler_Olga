package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WizardScreen extends BaseScreen{
    public WizardScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath="//*[@resource-id='com.example.svetlana.scheduler:id/wizard_settings_skip']")
    MobileElement skipWizard;

    public HomeScreen skipWizard(){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(skipWizard));
        skipWizard.click();
        return new HomeScreen(driver);
    }
}

