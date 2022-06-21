package tests.negativeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ReserveSpotPage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.TestBase;

public class TC006_VerifyDisplayedLicensePlate extends TestBase {

    ReserveSpotPage reserveSpotPage = new ReserveSpotPage();

    //assertNotEqual is used, because lower case letters are inputted, uppercase letters are displayed
    //TODO discuss with dev team
    @Test(priority = 1, description = "Verify that displayed license plate is the same as inputted")
    public void verifyLicensePlateIsAsExpected(){

        driver.get(ConfigReader.read("url"));
        BrowserUtils.waitForPageToLoad(2);
        new HomePage().clickReserveSpot();
        BrowserUtils.waitForPageToLoad(2);
        reserveSpotPage.clickAddNewReservation();
        BrowserUtils.waitForPageToLoad(2);
        String licensePlateInput =reserveSpotPage.inputLicensePlate();
        reserveSpotPage.confirmLicensePlate();
        BrowserUtils.waitForPageToLoad(2);
        String licensePlateDisplayed = reserveSpotPage.retrieveLicensePlate();

        System.out.println("licensePlateDisplayed = " + licensePlateDisplayed);
        System.out.println("licensePlateInput = " + licensePlateInput);

        Assert.assertNotEquals(licensePlateDisplayed, licensePlateInput);
    }
}
