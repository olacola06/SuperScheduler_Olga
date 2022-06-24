package tests;

import manager.Configuration;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class RegistSuccess extends Configuration{

    @Test
    public void registSuccess1(){

        int i = (int)(System.currentTimeMillis())/1000%3600;
        new SplashScreen(driver).checkVersion("0.0.3").fillEmail("all"+i+"@gmail.com").
                fillPassword("As12345$").clickLoginBtn().openMenu().logout();

    }

    @Test
    public void registSuccess2(){
        int i = (int)(System.currentTimeMillis())/1000%3600;
        new SplashScreen(driver).checkVersion("0.0.3").fillEmail("all"+i+"@gmail.com").
                fillPassword("As12345$").clickLoginBtnForRes().skipWizard().openMenu().logout();

    }

}
