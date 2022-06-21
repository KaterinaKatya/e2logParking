package tests.positiveTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ReserveSpotPage;
import utils.AppCommonVariables;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.TestBase;

public class TC003_VerifyNewReservationFields extends TestBase {

    HomePage homePage = new HomePage();
    ReserveSpotPage reserveSpotPage = new ReserveSpotPage();
    AppCommonVariables appCommonVariables = new AppCommonVariables();

    @Test(priority = 1, description = "Verify that fields required for new reservation are present")
    public void verifyFields() {

        driver.get(ConfigReader.read("url"));
        new HomePage().clickReserveSpot();
        BrowserUtils.waitForPageToLoad(2);
        reserveSpotPage.clickAddNewReservation();
        BrowserUtils.waitForPageToLoad(2);

        for (String eachField : appCommonVariables.newReservationFields) {

            WebElement eachFieldLocator = driver
                    .findElement(By.xpath("//h5[contains(normalize-space(.),'"+ eachField +"')]"));

            BrowserUtils.highlight(eachFieldLocator);
            BrowserUtils.verifyElementDisplayed(eachFieldLocator);
            String actualFieldText = eachFieldLocator.getText();

            Assert.assertEquals(actualFieldText,eachField, "Error! The field is not as expected");
        }

    }
}
