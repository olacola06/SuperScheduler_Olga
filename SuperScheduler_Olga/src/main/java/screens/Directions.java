package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Direction;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class Directions extends BaseScreen {

    public Directions(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/directions_list_fab']")
    MobileElement plusBtnDirections;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/driving_cost_fr_direct_path_from_res']")
    MobileElement placeFrom;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/driving_cost_fr_direct_path_to_res']")
    MobileElement placeTo;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/driving_cost_fr_direct_path_swap']")
    MobileElement swapPlace;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/driving_cost_fr_direct_path_cost_res']")
    MobileElement costPerKm;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/driving_cost_fr_direct_path_car_currency']")
    MobileElement chooseCurrency;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/driving_cost_fr_direct_path_num_km_res']")
    MobileElement numberOfKm;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/driving_cost_fr_save_btn']")
    MobileElement addButton;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/currency_row_title']")
    List<MobileElement> currencyTitleList;

    public Directions addDirection(String from,String to,String numberKm, String cost, String currency){
        plusBtnDirections.click();
        feelDetails(from,to,numberKm,cost,currency);
        addButton.click();
        Assert.assertTrue(plusBtnDirections.isDisplayed());

        return this;
    }
    public Directions addDirectionLombok(Direction dir){
        plusBtnDirections.click();
        feelDetailsLB(dir);
        addButton.click();
        Assert.assertTrue(plusBtnDirections.isDisplayed());

        return this;
    }
    private void feelDetails(String from,String to,String numberKm, String cost, String currency){
        type(placeFrom,from);
        type(placeTo,to);
        typeInt(numberOfKm, numberKm);
        chooseCurrencyMethod(currency);
        typeInt(costPerKm, cost);
        driver.hideKeyboard();
    }
    private void feelDetailsLB(Direction dir){
        type(placeFrom,dir.getFrom());
        type(placeTo,dir.getTo());
        typeInt(numberOfKm, dir.getNumberKm());
        chooseCurrencyMethod(dir.getCurrency());
        typeInt(costPerKm, dir.getCost());
        driver.hideKeyboard();
    }
    public void chooseCurrencyMethod(String countryOfCurrency) {
        chooseCurrency.click();
        if (countryOfCurrency != null) {
            int i = 10;
            boolean flag = false;
            do {
                for (MobileElement el : currencyTitleList) {
                    if (el.getAttribute("text").equals(countryOfCurrency)) {
                        el.click();
                        flag = true;
                        break;
                    }
                }
                scrollUp();
                i--;
            }
            while (!flag || i == 1);
        }
    }
}
