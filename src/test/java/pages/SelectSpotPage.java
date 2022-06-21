package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.Driver;

public class SelectSpotPage {

    public SelectSpotPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[normalize-space(.)='Select']")
    public WebElement selectBtn;

    public void clickSelectSpot(){
        BrowserUtils.highlight(selectBtn);
        selectBtn.click();
    }
}
