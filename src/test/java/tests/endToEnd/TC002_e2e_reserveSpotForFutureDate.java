package tests.endToEnd;

import org.testng.annotations.Test;
import pages.*;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.TestBase;

public class TC002_e2e_reserveSpotForFutureDate extends TestBase {

    @Test(priority = 1, description = "Reserve parking spot for future date successfully")
    public void reserve() {

        ReserveSpotPage reserveSpotPage = new ReserveSpotPage();
        SelectSpotPage selectSpotPage = new SelectSpotPage();
        ReviewReservationPage reviewReservationPage = new ReviewReservationPage();
        MakePaymentPage makePaymentPage = new MakePaymentPage();


        driver.get(ConfigReader.read("url"));
        new HomePage().clickReserveSpot();
        BrowserUtils.waitForPageToLoad(2);
        reserveSpotPage.clickAddNewReservation();
        BrowserUtils.waitForPageToLoad(2);
        reserveSpotPage.inputLicensePlate();
        reserveSpotPage.confirmLicensePlate();

        reserveSpotPage.checkInOut();
        BrowserUtils.waitForPageToLoad(2);
        reserveSpotPage.clickSelectDateBox();
        BrowserUtils.waitFor(5);
        reserveSpotPage.selectDate(5);
        BrowserUtils.waitForPageToLoad(2);
        reserveSpotPage.clickSelectTimeBox();
        BrowserUtils.waitForPageToLoad(2);
        reserveSpotPage.selectTime(10);
        BrowserUtils.waitForPageToLoad(2);

        reserveSpotPage.checkInOut();
        reserveSpotPage.clickSelectDateBox();
        BrowserUtils.waitForPageToLoad(2);
        reserveSpotPage.selectDate(7);
        BrowserUtils.waitForPageToLoad(2);
        reserveSpotPage.clickSelectTimeBox();
        reserveSpotPage.selectTime(30);
        BrowserUtils.waitForPageToLoad(2);

        reserveSpotPage.selectParkingSpot();
        BrowserUtils.waitForPageToLoad(2);

        selectSpotPage.clickSelectSpot();
        BrowserUtils.waitForPageToLoad(2);

        reviewReservationPage.reviewReservation();
        BrowserUtils.waitForPageToLoad(2);

        makePaymentPage.verifyMakePaymentBtnDisplayed();

    }
}
