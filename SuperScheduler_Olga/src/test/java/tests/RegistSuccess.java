package tests;

import manager.Configuration;
import manager.ConfigurationRealPhone;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.SplashScreen;

      public class RegistSuccess extends ConfigurationRealPhone {
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

}
