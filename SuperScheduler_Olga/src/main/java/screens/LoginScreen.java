package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.User;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginScreen extends BaseScreen {

    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']")
    MobileElement emailEditText;

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passwordEditText;

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginButton;

    public LoginScreen fillEmail(String email) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(emailEditText));
        type(emailEditText, email);
        return this;
    }
     public LoginScreen fillPassword(String password) {
        type(passwordEditText, password);
        return this;
    }

    public HomeScreen clickLoginBtn() {
        driver.hideKeyboard();
        loginButton.click();
        return new HomeScreen(driver);
    }

    public HomeScreen complexLogin(User user){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(emailEditText));
        type(emailEditText,user.getEmail());
        type(passwordEditText, user.getPassword());
        driver.hideKeyboard();
        loginButton.click();

        return new HomeScreen(driver);
    }

    public WizardScreen clickLoginBtnForReg() {
        driver.hideKeyboard();
        loginButton.click();
        return new WizardScreen(driver);
    }
    public WizardScreen complexRegist(User user){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(emailEditText));
        type(emailEditText,user.getEmail());
        type(passwordEditText, user.getPassword());
        driver.hideKeyboard();
        loginButton.click();

        return new WizardScreen(driver);
    }

    public boolean loginBtnIsPresent(){
        return loginButton.isDisplayed();
    }

}