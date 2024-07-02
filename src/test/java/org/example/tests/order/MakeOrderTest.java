package org.example.tests.order;

import org.example.model.OrderModel;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.example.screen.MainScreenPage;
import org.example.screen.order.OrderDetailsPageFragment;
import org.example.screen.order.PersonalDataPageFragment;
import org.example.screen.order.dialog.ConfirmationDialogPageFragment;
import org.example.screen.order.dialog.SuccessDialogPageFragment;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class MakeOrderTest {
    private WebDriver driver;
    private final OrderModel orderModel;

    public MakeOrderTest(
            String name,
            String surname,
            String address,
            int metroStationIndex,
            String phone,
            String date,
            int periodIndex,
            boolean isHeaderButton
    ) {
        this.orderModel = new OrderModel(
                name,
                surname,
                address,
                metroStationIndex,
                phone,
                date,
                periodIndex,
                isHeaderButton
        );
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][] {
                { "Алексей", "Иванов", "ул. Пушкина", 0, "880055533535", "08.07.2024", 0, true},
                { "аааааа", "бббббб", "ул. Ленина", 30, "+79248222222", "10.07.2024", 0, false},
        };
    }


    @Test
    public void testMakeOrder() {
        //Загрузить страницу
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        //Нажать на кнопку "Заказать"
        MainScreenPage objMainScreen = new MainScreenPage(driver);
        objMainScreen.clickOrderButton(orderModel);
        //Заполнить данные пользователя и нажать на кнопку "Далее"
        PersonalDataPageFragment objPersonalData = new PersonalDataPageFragment(driver);
        objPersonalData.continueOrder(orderModel);
        //Заполнить данные про аренду и нажать на кнопку "Заказать"
        OrderDetailsPageFragment objOrderDetails = new OrderDetailsPageFragment(driver);
        objOrderDetails.continueOrder(orderModel);
        //Нажать на кнопку "Да" в диалоговом окне
        ConfirmationDialogPageFragment objConfirmationDialog = new ConfirmationDialogPageFragment(driver);
        objConfirmationDialog.clickConfirmButton();
        //Получить сообщение из диалога и сравнить с ожидаемым
        SuccessDialogPageFragment objSuccessDialog = new SuccessDialogPageFragment(driver);
        String successMessage = objSuccessDialog.getMessage();
        String regex = "Заказ оформлен\nНомер заказа: \\d{5,7}.  Запишите его:\nпригодится, чтобы отслеживать статус";
        assertTrue("Фактическое сообщение \"" + successMessage + "\" не соответствует regex: \"" + regex+"\"",successMessage.matches(regex));

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
