package tests;

import manager.Configuration;
import models.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;

    public class RegistrationTests extends Configuration {
    int i = (int) (System.currentTimeMillis()) / 1000 % 3600;

    @Test
    public void registSuccess1() {
//       new SplashScreen(driver).checkVersion("0.0.3").fillEmail("all"+i+"@gmail.com").
//                fillPassword("As12345$").clickLoginBtnForReg().skipWizard().isPlusBtnPresentAssert()
//               .openMenu().logout();
        new LoginScreen(driver).fillEmail("all" + i + "@gmail.com").
                fillPassword("As12345$").clickLoginBtnForReg().skipWizard().isPlusBtnPresentAssert()
                .openMenu().logout();

    }

    @Test
    public void registSuccess2() {
//        new LoginScreen(driver).fillEmail("all"+i+1+"@gmail.com").
//                fillPassword("As12345$").clickLoginBtnForReg().skipWizard().isPlusBtnPresentAssert()
//                .openMenu().logout();
        User user = User.builder().email("all" + i + 1 + "@gmail.com").password("As12345$").build();
        new LoginScreen(driver).complexRegist(user).skipWizard()
                .isPlusBtnPresentAssert().openMenu().logout();
    }

    @Test
    public void registrationWrongEmail() {
        User user = User.builder().email("All@gmailcom").password("As12345$").build();
//        boolean res = new LoginScreen(driver).fillEmail(user.getEmail()).fillPassword(user.getPassword())
//                .clickLoginBtnForNegativeTests();
//        Assert.assertTrue(res);
        new LoginScreen(driver).fillEmail(user.getEmail()).fillPassword(user.getPassword()).clickLoginBtnLoginNeg()
                        .clickOnRedSign().loginButtonPresent();
        logger.info("Put attention on the appeared message!!! 'Check . in email' ");

    }

    @Test
    public void registrationWrongPassLessSymbols() {
//        boolean res = new LoginScreen(driver).fillEmail("all@gmail.com").fillPassword("as12345")
//                .clickLoginBtnForNegativeTests();
//        Assert.assertTrue(res);
        new LoginScreen(driver).fillEmail("all@gmail.com").fillPassword("as12345").clickLoginBtnLoginNeg()
                .clickOnRedSign().loginButtonPresent();
        logger.info("Put attention on the appeared message!!! 'Password can't be smaller then 8 symbols' ");

    }
        @Test
        public void registrationNotSkip(){
            String currencyCountry = "British pound";
            String wageRate = "1200";
            User user = User.builder().email("Dudy"+i+"@gmail.com").password("Oo12345@").build();

            new LoginScreen(driver).complexRegist(user).setDetails(currencyCountry,wageRate)
                    .isPlusBtnPresentAssert().openMenu().logout();

        }

}
