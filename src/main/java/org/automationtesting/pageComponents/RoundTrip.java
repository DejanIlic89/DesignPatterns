package org.automationtesting.pageComponents;

import org.automationtesting.abstractComponents.AbstractComponent;
import org.automationtesting.abstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RoundTrip extends AbstractComponent implements SearchFlightAvail {

    private final By rdo = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private final By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private final By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private final By cb = By.id("ctl00_mainContent_chk_IndArm");
    private final By search = By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(Map<String, String> reservationDetails) {
        findElement(rdo).click();
        selectOriginCity(reservationDetails.get("origin"));
        selectDestinationCity(reservationDetails.get("destination"));
        findElement(cb).click();
        findElement(search).click();
    }

    public void selectOriginCity(String origin) {
        findElement(from).click();
        findElement(By.xpath("//a[@value='" + origin + "']")).click();
    }

    public void selectDestinationCity(String destination) {
        findElement(to).click();
        findElement(By.xpath("(//a[@value='" + destination + "'])[2]")).click();
    }

}
