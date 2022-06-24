package tests;

import manager.Configuration;
import manager.ConfigurationRealPhone;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class LaunchTestRealPhone extends ConfigurationRealPhone {

        @Test
        public void appLaunch(){
            String version = new SplashScreen(driver).getCurrentVersion();
            Assert.assertEquals(version,"0.0.3");
       }
}
