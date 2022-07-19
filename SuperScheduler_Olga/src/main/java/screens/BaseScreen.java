package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BaseScreen {
    AppiumDriver<MobileElement> driver;
    Logger logger = LoggerFactory.getLogger(BaseScreen.class);

    public BaseScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void type(MobileElement el, String email) {
        if (email != null) {
            el.click();
            el.clear();
            el.sendKeys(email);
        }
    }

    public void pause(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void refreshScreen() {
        Dimension screenSizes = driver.manage().window().getSize();
        int x = screenSizes.getWidth() / 2;
        int yFrom = (int) (screenSizes.getHeight() * 0.2);
        int yTo = (int) (screenSizes.getHeight() * 0.8);
        TouchAction<?> action = new TouchAction<>(driver);
        action.longPress(PointOption.point(x, yFrom)).moveTo(PointOption.point(x, yTo))
                .release().perform();

    }

    public void scrollUp() {
        Dimension screenSize = driver.manage().window().getSize();
        int x = screenSize.getWidth() / 2;
        int yFrom = (int) (screenSize.getHeight() * 0.2);
        int yTo = (int) (screenSize.getHeight() * 0.8);

        TouchAction<?> action = new TouchAction<>(driver);
        action.press(PointOption.point(x, yTo)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(x, yFrom)).release().perform();
    }
}

