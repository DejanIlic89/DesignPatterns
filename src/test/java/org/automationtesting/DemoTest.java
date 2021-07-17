package org.automationtesting;

import org.automationtesting.dataLoads.DataReader;
import org.automationtesting.pageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoTest extends BaseTest {
    WebDriver driver;
    TravelHomePage travelHomePage;

    @BeforeTest
    public void setup() {
        driver = initializeDriver();
        travelHomePage = new TravelHomePage(driver);
    }

    @Test(dataProvider = "getData")
    public void flightTest(Map<String, String> reservationDetails) {
        travelHomePage.goTo();

        //SRP single responsibility principle
        System.out.println(travelHomePage.getFooterNav().getFlightAttribute());
        System.out.println(travelHomePage.getNavigationBar().getFlightAttribute());
        System.out.println(travelHomePage.getFooterNav().getLinkCount());
        System.out.println(travelHomePage.getNavigationBar().getLinkCount());

        //Strategy design pattern
        travelHomePage.setBookingStrategy("multitrip");
        travelHomePage.checkAvail(reservationDetails);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<Map<String, String>> l = DataReader.getJsonData(System.getProperty("user.dir") + "/src/test/java/org/automationtesting/dataLoads/reservationDetails.json");
        return new Object[][] {
                { l.get(0) }, { l.get(1) }
        };
    }

}
