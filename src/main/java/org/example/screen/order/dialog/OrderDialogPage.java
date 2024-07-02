package org.example.screen.order.dialog;

import org.example.model.UIElementModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

abstract public class OrderDialogPage {

    protected WebDriver driver;

    protected By message = By.xpath(".//div[contains(@class,'Order_ModalHeader')]");
    public OrderDialogPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getMessage() {
        UIElementModel.waitForElement(driver, message);
        return driver.findElement(message).getText();
    }
}
