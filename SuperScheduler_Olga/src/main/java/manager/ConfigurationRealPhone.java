package manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class ConfigurationRealPhone {
    protected static AppiumDriver<MobileElement> driver;

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","R58N75HPY8E");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","12");
        capabilities.setCapability("appPackage","com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity",".presentation.splashScreen.SplashScreenActivity");
        capabilities.setCapability("automationName","Appium");

        driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }
    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

}


