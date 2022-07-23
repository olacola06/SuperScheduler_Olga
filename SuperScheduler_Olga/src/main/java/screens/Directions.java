package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class Directions extends BaseScreen {

    public Directions(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/directions_list_fab']")
    MobileElement plusBtnDirections;
    @FindBy(xpath = "//*[text()='Place from']")//com.example.svetlana.scheduler:id/driving_cost_fr_direct_path_from_res
    MobileElement placeFrom;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/driving_cost_fr_direct_path_to_res']")
    MobileElement placeTo;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/driving_cost_fr_direct_path_swap']")
    MobileElement swapPlace;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/row_money']")
    MobileElement rowMoney;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/row_money_txt']")
    MobileElement chooseCurrency;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/driving_cost_fr_direct_path_swap']")
    MobileElement ;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/row_money']")
    MobileElement ;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/row_money_txt']")
    MobileElement ;

    public void addDirection(){
        plusBtnDirections.click();



    }

}
