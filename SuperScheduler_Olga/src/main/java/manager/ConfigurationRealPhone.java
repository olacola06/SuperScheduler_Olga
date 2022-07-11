package manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class ConfigurationRealPhone {
    protected static AppiumDriver<MobileElement> driver;

    protected Logger logger = LoggerFactory.getLogger(ConfigurationRealPhone.class);

    @BeforeMethod
    public void loggerStart(Method m){
        logger.info("Method to be tested:->>"+m.getName() );
    }
    @AfterMethod
    public void loggerStop(Method m){
        logger.info("Test named:->>"+m.getName()+" finished");
    }

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","R58N75HPY8E");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","12");
        capabilities.setCapability("appPackage","com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity",".presentation.splashScreen.SplashScreenActivity");
        capabilities.setCapability("automationName","Appium");
        //capabilities.setCapability("app","C:/Users/Olga/v.0.0.3.apk");

        driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new MyListener());
    }
    @AfterSuite(enabled = false)
    public void tearDown(){
        driver.quit();
    }

}


