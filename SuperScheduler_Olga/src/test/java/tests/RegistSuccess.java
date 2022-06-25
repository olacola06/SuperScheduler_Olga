package tests;

import manager.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.SplashScreen;

public class RegistSuccess extends Configuration{

//    @BeforeMethod
//    public void preCondition(){
//        Boolean check = new LoginScreen(driver).loginBtnIsPresent();
//        if(check){
//            new SplashScreen(driver).returnFromLoginScreen();
//        }
//    }

    int i = (int)(System.currentTimeMillis())/1000%3600;
    @Test
    public void registSuccess1(){
       new SplashScreen(driver).checkVersion("0.0.3").fillEmail("all"+i+"@gmail.com").
                fillPassword("As12345$").clickLoginBtnForReg().skipWizard().isPlusBtnPresentAssert()
               .openMenu().logout();

    }
    @Test
    public void registSuccess2(){
        new LoginScreen(driver).fillEmail("all"+i+1+"@gmail.com").
                fillPassword("As12345$").clickLoginBtnForReg().skipWizard().isPlusBtnPresentAssert()
                .openMenu().logout();
    }

}
