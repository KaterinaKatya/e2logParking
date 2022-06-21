package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.Driver;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ReserveSpotPage {

    public ReserveSpotPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[contains(@class, 'add-new')]")
    public WebElement addNewBtn;

    @FindBy(xpath = "//input[@id='license-plate']")
    public WebElement licensePlateBox;

    @FindBy(xpath = "//div[@class='form-action']//button[contains(@class, 'ant-btn-primary')]")
    public WebElement confirmationCheck;

    @FindBy(xpath = "//button[contains(@class, 'show-calendar')]")
    public WebElement checkInOutBtn;

    @FindBy(xpath = "//input[@placeholder='Select date']")
    public WebElement selectDate;

    @FindBy(xpath = "//a[normalize-space(.)='Today']")
    public WebElement todayDate;

    @FindBy(xpath = "//input[@placeholder='Select time']")
    public WebElement selectTime;

    @FindBy(xpath = "//span[normalize-space(.)='Ok']")
    public WebElement timeOkBtn;

    @FindBy(xpath = "//div[contains(@class,'input-container')]//button[contains(@class, 'ant-btn-primary')]")
    public WebElement checkInConfirm;

    @FindBy(xpath = "(//span[contains(.,' Select a parking spot ')])[2]")
    public WebElement selectParkingBtn;

    public void clickAddNewReservation(){
        addNewBtn.click();
    }

    public void inputLicensePlate(){
        Faker faker = new Faker();
        licensePlateBox.sendKeys(faker.bothify("??? #####"));
    }

    public void confirmLicensePlate(){
        BrowserUtils.highlight(confirmationCheck);
        confirmationCheck.click();
    }

    public void checkInOut(){
        BrowserUtils.highlight(checkInOutBtn);
        checkInOutBtn.click();
    }

    public void clickTimeOk(){
        timeOkBtn.click();
    }

    public void clickSelectDateBox(){
        selectDate.click();
    }

    public void clickSelectTimeBox(){
        selectTime.click();
    }

    public void clickCheckInConfirm(){
        checkInConfirm.click();
    }

    public void selectTodayDate(){
        BrowserUtils.clickWithJS(todayDate);
    }

    public void selectParkingSpot(){
        BrowserUtils.highlight(selectParkingBtn);
        selectParkingBtn.click();
    }

    public void selectDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDateTime now = LocalDateTime.now();

        String date = "";
        if(formatter.format(now).startsWith("0")){
            date = formatter.toString().substring(1);
        }else{
            date = formatter.toString();
        }

        checkInOutBtn.click();
        selectDate.sendKeys(date);
    }

    public void selectTime(int timeToAdd){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalDateTime now = LocalDateTime.now().plus(Duration.of(timeToAdd, ChronoUnit.MINUTES));

        String time = formatter.format(now);

        if(time.startsWith("0")){
            time = time.substring(1);
        }

        selectTime.sendKeys(time);
        timeOkBtn.click();
        BrowserUtils.highlight(checkInConfirm);
        checkInConfirm.click();
    }

}
