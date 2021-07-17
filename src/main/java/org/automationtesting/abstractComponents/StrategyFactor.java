package org.automationtesting.abstractComponents;

import org.automationtesting.pageComponents.MultiTrip;
import org.automationtesting.pageComponents.RoundTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StrategyFactor {

    WebDriver driver;
    By sectionElementMultitrip = By.id("flightSearchContainer");

    public StrategyFactor(WebDriver driver) {
        this.driver = driver;
    }

    public SearchFlightAvail createStrategy(String strategyType) {
        if (strategyType.equalsIgnoreCase("multitrip")) {
            return new MultiTrip(driver, sectionElementMultitrip);
        }
        if (strategyType.equalsIgnoreCase("roundtrip")) {
            return new RoundTrip(driver, sectionElementMultitrip);
        }
        return null;
    }
}
