package org.example.screen.order;

import org.example.model.OrderModel;
import org.example.model.UIElementModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderDetailsPageFragment extends OrderScreenPage {

    //Пикер даты
    private final By datePicker = By.xpath(".//div[@class='react-datepicker-wrapper']//input");

    //"Стрелочка" в поле "Срок аренды"
    private final By rentPeriodField = By.xpath(".//span[@class='Dropdown-arrow']");
    //Варианты из выпадающего списка "Срока аренды"
    private final By rentPeriods = By.xpath(".//div[@class='Dropdown-option']");
    //Кнопка "Заказать"
    private final By orderButton = By.xpath(".//div[contains(@class,'Order_Buttons')]/button[text()='Заказать']");

    public OrderDetailsPageFragment(WebDriver driver) {
        super(driver);
    }

    public void setDate(String date) {
        driver.findElement(datePicker).sendKeys(date);
    }

    public void setRentPeriod(int periodIndex) {
        driver.findElement(rentPeriodField).click();
        List<WebElement> rentPeriodsList = driver.findElements(rentPeriods);
        rentPeriodsList.get(periodIndex).click();
    }

    public void clickOrderButton () {
        driver.findElement(orderButton).click();
    }

    public void setAllFields(String date, int periodIndex) {
        setDate(date);
        setRentPeriod(periodIndex);
    }

    public void continueOrder(OrderModel orderModel) {
        UIElementModel.waitForElement(driver, orderButton);
        setAllFields(orderModel.getDate(), orderModel.getPeriodIndex());
        clickOrderButton();
    }


}
