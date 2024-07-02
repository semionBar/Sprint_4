package org.example.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;

public class OrderModel {
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final int metroStationIndex;
    private final String phone;
    private final String date;
    private final int periodIndex;
    private final boolean isHeaderButton;

    public OrderModel(String name, String surname, String address, int metroStationIndex, String phone, String date, int periodIndex, boolean isHeaderButton) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStationIndex = metroStationIndex;
        this.phone = phone;
        this.date = date;
        this.periodIndex = periodIndex;
        this.isHeaderButton = isHeaderButton;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getAddress() {
        return address;
    }
    public int getMetroStationIndex() {
        return metroStationIndex;
    }
    public String getPhone() {
        return phone;
    }
    public String getDate() {
        return date;
    }
    public int getPeriodIndex() {
        return periodIndex;
    }

    public boolean getIsHeaderButton() {
        return isHeaderButton;
    }

}
