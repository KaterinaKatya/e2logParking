package tests.positiveTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.AppCommonVariables;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.TestBase;

public class TC009_VerifyWelcomeText extends TestBase {

    @Test(priority = 1, description = "Verify that 'Welcome text' on the home page dispalyed")
    public void verifyWelcomeMsg(){
        HomePage homePage = new HomePage();
        AppCommonVariables appCommonVariables = new AppCommonVariables();

        driver.get(ConfigReader.read("url"));
        BrowserUtils.waitFor(5);
        String actualText = homePage.retrieveActualWelcomeMsg();
        String expectedText = appCommonVariables.welcomeText;

        Assert.assertEquals(actualText,expectedText,"ERROR! actual text is not as expected");
    }
}
