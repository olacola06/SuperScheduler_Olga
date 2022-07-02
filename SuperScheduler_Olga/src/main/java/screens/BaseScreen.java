package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseScreen {
    AppiumDriver<MobileElement> driver;
    Logger logger = LoggerFactory.getLogger(BaseScreen.class);

    public BaseScreen(AppiumDriver<MobileElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    public void type(MobileElement el, String email) {
        if (email != null) {
            el.click();
            el.clear();
            el.sendKeys(email);
        }
    }

}
