package tests;

import manager.ConfigurationRealPhone;
import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.LoginScreen;

public class RegistrationTests extends ConfigurationRealPhone {
    //public class RegistSuccess extends Configuration {

    int i = (int)(System.currentTimeMillis())/1000%3600;
    @Test
    public void registSuccess1(){
//       new SplashScreen(driver).checkVersion("0.0.3").fillEmail("all"+i+"@gmail.com").
//                fillPassword("As12345$").clickLoginBtnForReg().skipWizard().isPlusBtnPresentAssert()
//               .openMenu().logout();
        new LoginScreen(driver).fillEmail("all"+i+"@gmail.com").
                fillPassword("As12345$").clickLoginBtnForReg().skipWizard().isPlusBtnPresentAssert()
                .openMenu().logout();

    }
    @Test
    public void registSuccess2(){
//        new LoginScreen(driver).fillEmail("all"+i+1+"@gmail.com").
//                fillPassword("As12345$").clickLoginBtnForReg().skipWizard().isPlusBtnPresentAssert()
//                .openMenu().logout();
        User user = User.builder().email("all"+i+1+"@gmail.com").password("As12345$").build();
        new LoginScreen(driver).complexRegist(user).skipWizard()
                .isPlusBtnPresentAssert().openMenu().logout();
    }
    @Test
    public void registrationWrongEmail(){
        new LoginScreen(driver).complexRegist(User.builder().email("All@gmailcom").password("As12345$").build())
                .skipWizard().isPlusBtnPresentAssert().openMenu().logout();

    }
    @Test
    public void registrationWrongPass(){
        new LoginScreen(driver).fillEmail("all@gmail.com").fillPassword("as12345")
                .clickLoginBtn();
        Alert alert = new WebDriverWait(driver,5).until(ExpectedConditions.alertIsPresent());
        if (alert==null){
            System.out.println("Alert doesn't present");
        }
        else{
            driver.switchTo().alert();
        }
        String message = alert.getText();
        alert.accept();
        System.out.println(message);

    }

}
