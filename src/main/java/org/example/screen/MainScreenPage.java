package org.example.screen;

import org.example.model.OrderModel;
import org.example.model.UIElementModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainScreenPage {
    private final WebDriver driver;

    //Кнопка "Заказать" в хэдэре
    private final By headerOrderButton = By.xpath(".//div[contains(@class,'Header_Header')]//button[text()='Заказать']");

    //Кнопка "Заказать" в roadmap
    private final By roadmapOrderButton = By.xpath(".//div[contains(@class,'Home_ThirdPart')]//button");

    //FAQ вопросы
    private final By frequentlyAskedQuestions = By.xpath(".//div[@class='accordion__item']//div[@class='accordion__button']");

    //FAQ ответы
    private final By frequentlyAskedQuestionsAnswers = By.xpath(".//div[@class='accordion__item']/div[@class='accordion__panel']");


    public MainScreenPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHeaderOrderButton () {
        driver.findElement(headerOrderButton).click();
    }
    public void clickRoadmapOrderButton() {
        UIElementModel.scrollToElement(driver, driver.findElement(roadmapOrderButton));
        driver.findElement(roadmapOrderButton).click();
    }

    public void clickOrderButton (OrderModel orderModel) {
        if (orderModel.getIsHeaderButton()) {
            clickHeaderOrderButton();
        }
        else {
            clickRoadmapOrderButton();
        }
    }

    public void clickOnQuestion(int index) {
        UIElementModel.scrollToElement(driver, driver.findElements(frequentlyAskedQuestions).get(index));
        driver.findElements(frequentlyAskedQuestions).get(index).click();
    }

    public boolean checkIsAnswerDisplayed(int index) {
        return driver.findElements(frequentlyAskedQuestionsAnswers).get(index).isDisplayed();
    }

    public String getAnswerText(int index) {

        if (checkIsAnswerDisplayed(index)) {
            return driver.findElements(frequentlyAskedQuestionsAnswers).get(index).getText();
        }
        else {
            return "Ошибка! Элемент не отображается на экране!";
        }
    }

    public String getAnswerOfQuestion(int index) {
        clickOnQuestion(index);
        return getAnswerText(index);
    }
}
