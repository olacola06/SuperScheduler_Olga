package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Event;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditCreateEventScreen extends BaseScreen {
    public EditCreateEventScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath="//*[@resource-id='com.example.svetlana.scheduler:id/info_title_input']")
    MobileElement title;
    @FindBy(xpath="//*[@resource-id='com.example.svetlana.scheduler:id/info_type_input']")
    MobileElement type;
    @FindBy(xpath="//*[@resource-id='com.example.svetlana.scheduler:id/info_break_plus_btn']")
    MobileElement breakPlusBtn;
    @FindBy(xpath="//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_edit']")
    MobileElement wageEdit;
    @FindBy(xpath="//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_input']")
    MobileElement wageInput;
    @FindBy(xpath="//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_save']")
    MobileElement wageSave;
    @FindBy(xpath="//*[@resource-id='com.example.svetlana.scheduler:id/info_save_btn']")
    MobileElement saveBtn;

    public HomeScreen createNewEvent(Event event){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(title));
        type(title,event.getTitle());
        type(type,event.getType());
        driver.hideKeyboard();
        int breaksAmount = event.getBreaks();
        if(breaksAmount>0 && breaksAmount<5) {
            for (int i = 0; i < breaksAmount; i++) {
                breakPlusBtn.click();
            }
        }
        wageEdit.click();
        type(wageInput,String.valueOf(event.getWage()));
        wageSave.click();
        saveBtn.click();

        return new HomeScreen(driver);
    }

}

