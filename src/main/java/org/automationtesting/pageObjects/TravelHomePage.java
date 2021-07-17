package org.automationtesting.pageObjects;

import org.automationtesting.abstractComponents.SearchFlightAvail;
import org.automationtesting.abstractComponents.StrategyFactor;
import org.automationtesting.pageComponents.FooterNav;
import org.automationtesting.pageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class TravelHomePage {

    WebDriver driver;
    SearchFlightAvail searchFlightAvail;

    By footerNavSectionElement = By.id("traveller-home");
    By headerNavSectionElement = By.id("buttons");

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
    }

    public NavigationBar getNavigationBar() {
        return new NavigationBar(driver, headerNavSectionElement);
    }

    public FooterNav getFooterNav() {
        return new FooterNav(driver, footerNavSectionElement);
    }

    public void setBookingStrategy(String strategyType) {
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        this.searchFlightAvail = strategyFactor.createStrategy(strategyType);
    }

    public void checkAvail(Map<String, String> reservationDetails) {
        this.searchFlightAvail.checkAvail(reservationDetails);
    }

    public String getTitle() {
        System.out.println("Hello");
        return driver.getTitle();
    }

}
