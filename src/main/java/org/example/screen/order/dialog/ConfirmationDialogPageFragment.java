package org.example.screen.order.dialog;

import org.example.model.UIElementModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationDialogPageFragment extends OrderDialogPage {

    //Кнопка "Да"
    private final By confirmButton = By.xpath(".//div[contains(@class,'Order_Modal')]//button[text()='Да']");

    public ConfirmationDialogPageFragment(WebDriver driver) {
        super(driver);
    }

    public void clickConfirmButton () {
        UIElementModel.waitForElement(driver,confirmButton);
        driver.findElement(confirmButton).click();
    }
}
