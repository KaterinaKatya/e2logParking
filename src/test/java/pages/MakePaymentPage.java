package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.Driver;

public class MakePaymentPage {
    public MakePaymentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[normalize-space(.)='Make a Payment'])[2]")
    public WebElement makePayment;

    public void verifyMakePaymentBtnDisplayed(){
        BrowserUtils.waitForPageToLoad(2);
        BrowserUtils.highlight(makePayment);
        BrowserUtils.verifyElementDisplayed(makePayment);
    }
}
