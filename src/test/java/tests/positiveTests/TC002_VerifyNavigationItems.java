package tests.positiveTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import utils.AppCommonVariables;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.TestBase;

public class TC002_VerifyNavigationItems extends TestBase {

    SoftAssert softAssert = new SoftAssert();
    HomePage homePage = new HomePage();
    AppCommonVariables appCommonVariables = new AppCommonVariables();

    @Test(priority = 1, description = "Verify HOme page navigation items are present")
    public void VerifyHomePageNavigationItems(){

        driver.get(ConfigReader.read("url"));
        BrowserUtils.verifyElementDisplayed(homePage.reserveSpotBtn);
        BrowserUtils.highlight(homePage.reserveSpotBtn);
        String navigatorText1 = homePage.reserveSpotBtn.getText();
        softAssert.assertEquals(navigatorText1,appCommonVariables.homePageNavigator1);

        BrowserUtils.verifyElementDisplayed(homePage.checkInPayLaterBtn);
        BrowserUtils.highlight(homePage.checkInPayLaterBtn);
        String navigatorText2 = homePage.checkInPayLaterBtn.getText();
        softAssert.assertEquals(navigatorText2,appCommonVariables.homePageNavigator2);

        softAssert.assertAll();
    }
}
