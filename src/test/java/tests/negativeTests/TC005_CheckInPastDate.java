package tests.negativeTests;

import org.testng.annotations.Test;
import pages.*;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.TestBase;

public class TC005_CheckInPastDate extends TestBase {

    @Test(priority=1, description = "Check In with time in past")
    public void checkInWithTimeInPast(){
        ReserveSpotPage reserveSpotPage = new ReserveSpotPage();

        driver.get(ConfigReader.read("url"));
        BrowserUtils.waitForPageToLoad(2);
        new HomePage().clickReserveSpot();
        BrowserUtils.waitForPageToLoad(2);
        reserveSpotPage.clickAddNewReservation();
        BrowserUtils.waitForPageToLoad(2);
        reserveSpotPage.inputLicensePlate();
        reserveSpotPage.confirmLicensePlate();

        reserveSpotPage.checkInOut();
        BrowserUtils.waitForPageToLoad(2);
        reserveSpotPage.clickSelectDateBox();
        BrowserUtils.waitForPageToLoad(2);
        reserveSpotPage.selectTodayDate();
        BrowserUtils.waitForPageToLoad(2);
        reserveSpotPage.clickSelectTimeBox();
        BrowserUtils.waitForPageToLoad(2);
        reserveSpotPage.subtractSelectedTime(30);
        BrowserUtils.waitForPageToLoad(2);

        reserveSpotPage.verifyDateErrorMsgDisplayed(true);
    }
}
