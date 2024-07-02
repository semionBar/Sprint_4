package org.example.screen;

import org.example.model.OrderModel;
import org.example.model.UIElementModel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainScreenPage {
    private WebDriver driver;

    //Кнопка "Заказать" в хэдэре
    private By headerOrderButton = By.xpath(".//div[contains(@class,'Header_Header')]//button[text()='Заказать']");

    //Кнопка "Заказать" в roadmap
    private By roadmapOrderButton = By.xpath(".//div[contains(@class,'Home_ThirdPart')]//button");

    //FAQ вопросы
    private By frequentlyAskedQuestions = By.xpath(".//div[@class='accordion__item']//div[@class='accordion__button']");

    //FAQ ответы
    private By frequentlyAskedQuestionsAnswers = By.xpath(".//div[@class='accordion__item']/div[@class='accordion__panel']");


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

    public int getQuestionsCount() {
        return driver.findElements(frequentlyAskedQuestions).size();
    }

    public void clickOnQuestion(int index) {
        UIElementModel.scrollToElement(driver, driver.findElements(frequentlyAskedQuestions).get(index));
        driver.findElements(frequentlyAskedQuestions).get(index).click();
    }

    public String getAnswerText(int index) {
        return driver.findElements(frequentlyAskedQuestionsAnswers).get(index).getText();
    }

    public String getAnswerOfQuestion(int index) {
        clickOnQuestion(index);
        return getAnswerText(index);
    }

    public String[] getAnswersArray() {
        String[] answers = new String[getQuestionsCount()];
        for (int i = 0; i < getQuestionsCount(); i++) {
            answers[i] = getAnswerOfQuestion(i);
        }
        return answers;
    }


}
