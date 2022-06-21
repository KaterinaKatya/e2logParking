package tests.negativeTests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ReserveSpotPage;
import utils.AppCommonVariables;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.TestBase;

public class TC005_VerifyJSAlert extends TestBase {
    HomePage homePage = new HomePage();
    ReserveSpotPage reserveSpotPage = new ReserveSpotPage();
    AppCommonVariables appCommonVariables = new AppCommonVariables();

    @Test(priority = 1, description = "Try to check in for reservation without entering date")
    public void checkInWithoutDate(){
        driver.get(ConfigReader.read("url"));
        new HomePage().clickReserveSpot();
        BrowserUtils.waitForPageToLoad(2);
        reserveSpotPage.clickAddNewReservation();
        BrowserUtils.waitForPageToLoad(2);
        reserveSpotPage.inputLicensePlate();
        reserveSpotPage.confirmLicensePlate();

        reserveSpotPage.checkInOut();
        BrowserUtils.waitForPageToLoad(2);

        reserveSpotPage.clickSelectTimeBox();
        BrowserUtils.waitForPageToLoad(2);
        reserveSpotPage.selectTime(10);

        BrowserUtils.waitForJSAlert(5);
        Alert alert = driver.switchTo().alert();
        BrowserUtils.waitFor(3);
        String alertActualText = alert.getText();
        System.out.println("alertActualText = " + alertActualText);
        alert.accept();

        Assert.assertEquals(alertActualText, appCommonVariables.noDateReservationAlert);
    }

    @Test(priority = 2, description = "Try to check in for reservation without entering time")
    public void checkInWithoutTime(){
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
        BrowserUtils.waitForPageToLoad(2);
        reserveSpotPage.selectTodayDate();
        reserveSpotPage.clickCheckInConfirm();

        BrowserUtils.waitForJSAlert(5);
        Alert alert = driver.switchTo().alert();
        BrowserUtils.waitFor(3);
        String alertActualText = alert.getText();
        System.out.println("alertActualText = " + alertActualText);
        alert.accept();

        Assert.assertEquals(alertActualText, appCommonVariables.noTimeReservationAlert);
    }
}
