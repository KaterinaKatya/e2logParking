package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.Driver;

public class ReviewReservationPage {

    public ReviewReservationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//button//span[normalize-space(.)='Review Reservation'])[2]")
    public WebElement reviewReservationBtn;

    public void reviewReservation(){
        BrowserUtils.highlight(reviewReservationBtn);
        reviewReservationBtn.click();
    }
}
