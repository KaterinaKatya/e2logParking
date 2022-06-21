package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.Driver;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[contains(., 'Reserve a spot')]")
    public WebElement reserveSpotBtn;

    @FindBy(xpath =
            "//button[contains(., 'Reserve a spot')]/following-sibling::a[.='Check in my spot and pay later']")
    public WebElement checkInPayLaterBtn;

    @FindBy(xpath = "//h1[.='Welcome, How Can We Help You Today']")
    public WebElement welcomeMsg;

    @FindBy(xpath = "//div[contains(@class, 'desktop')]//span[@class='brand-container']")
    public WebElement e2parkingTab;

    @FindBy(xpath = "//div[contains(@class, 'desktop')]//a[.='Reservation']")
    public WebElement reservationTab;

    @FindBy(xpath = "//div[contains(@class, 'desktop')]//a[.='Log Out']")
    public WebElement logOutTab;

    public void clickReserveSpot(){
        reserveSpotBtn.click();
    }

    public String retrieveActualWelcomeMsg (){
        BrowserUtils.highlight(welcomeMsg);
        return welcomeMsg.getText();

    }


}
