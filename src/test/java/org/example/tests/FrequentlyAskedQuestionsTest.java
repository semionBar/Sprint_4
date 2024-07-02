package org.example.tests;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.example.screen.MainScreenPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FrequentlyAskedQuestionsTest {

    private WebDriver driver;


    @Test
    public void testFrequentlyAskedQuestions() {
        //Открыть страницу
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainScreenPage objMainScreen = new MainScreenPage(driver);
        //Получить массив ответов
        String[] actualAnswers = objMainScreen.getAnswersArray();

        String[] expectedAnswers = new String[]{
                "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                "Да, обязательно. Всем самокатов! И Москве, и Московской области."
        };
        //Сравнить ответы
        assertEquals(expectedAnswers,actualAnswers);

    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
