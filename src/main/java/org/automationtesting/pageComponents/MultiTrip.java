package org.automationtesting.pageComponents;

import org.automationtesting.abstractComponents.AbstractComponent;
import org.automationtesting.abstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail {

    private final By rdo = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private final By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private final By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private final By submit = By.id("ctl00_mainContent_btn_FindFlights");
    private final By from2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private final By alert = By.id("MultiCityModelAlert");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(Map<String, String> reservationDetails) {
        makeStateReady(s -> selectOriginCity(reservationDetails.get("origin")));
        selectDestinationCity(reservationDetails.get("destination"));
        selectOriginCity2(reservationDetails.get("destination2"));
        findElement(submit).click();
    }

    public void selectOriginCity(String origin) {
        findElement(from).click();
        findElement(By.xpath("//a[@value='" + origin + "']")).click();
    }

    public void selectDestinationCity(String destination) {
        findElement(to).click();
        findElement(By.xpath("(//a[@value='" + destination + "'])[2]")).click();
    }

    public void selectOriginCity2(String origin2) {
        findElement(from2).click();
        findElement(By.xpath("(//a[@value='" + origin2 + "'])[3]")).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer) {
        findElement(rdo).click();
        findElement(alert).click();
        waitForElementToDisappear(alert);
        consumer.accept(this);
    }

}
