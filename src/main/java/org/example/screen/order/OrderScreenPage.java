package org.example.screen.order;

import org.openqa.selenium.WebDriver;

abstract public class OrderScreenPage {
    protected WebDriver driver;

    OrderScreenPage(WebDriver driver) {
        this.driver = driver;
    }
}
