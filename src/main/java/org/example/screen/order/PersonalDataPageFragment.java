package org.example.screen.order;

import org.example.model.OrderModel;
import org.example.model.UIElementModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalDataPageFragment extends OrderScreenPage {

    //Поле для ввода Имени
    private final By nameInput = By.cssSelector("input[placeholder$='Имя']");
    //Поле для ввода Фамилии
    private final By surnameInput = By.cssSelector("input[placeholder$='Фамилия']");
    //Поле для ввода Адреса
    private final By addressInput = By.cssSelector("input[placeholder$='Адрес: куда привезти заказ']");
    //Поле для ввода Станции метро
    private final By metroStationInput = By.cssSelector("input[placeholder$='Станция метро']");
    //Выпадающий список станций метро
    private final By metroStationSelect = By.xpath(".//div[@class='select-search__select']//button");

    //Поле для ввода Телефона
    private final By phoneInput = By.cssSelector("input[placeholder$='Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private final By continueButton = By.xpath(".//div[contains(@class,'Order_NextButton')]/button");

    public PersonalDataPageFragment(WebDriver driver) {
        super(driver);
    }


    public void setName(String name) {
        driver.findElement(nameInput).sendKeys(name);

    }
      public void setSurname(String surname) {
        driver.findElement(surnameInput).sendKeys(surname);

    }
      public void setAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);

    }
      public void setMetroStation(int metroStationIndex) {
              driver.findElement(metroStationInput).click();
              driver.findElements(metroStationSelect).get(metroStationIndex).click();
    }
      public void setPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);

    }
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public void setAllFields(OrderModel orderModel) {
        setName(orderModel.getName());
        setSurname(orderModel.getSurname());
        setAddress(orderModel.getAddress());
        setMetroStation(orderModel.getMetroStationIndex());
        setPhone(orderModel.getPhone());
    }

    public void continueOrder (OrderModel orderModel) {
        UIElementModel.waitForElement(driver, continueButton);
        setAllFields(orderModel);
        clickContinueButton();
    }

}
