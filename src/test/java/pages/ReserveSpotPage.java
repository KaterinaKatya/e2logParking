package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//div[contains(@class,'error-message') and contains(., 'Check In Date has to be in the future')]")
    public WebElement checkInDateErrorMsg;

    @FindBy(xpath = "//div[contains(@class, 'vehicle-info')]/child::span[1]")
    public WebElement licensePlate;

    public void clickAddNewReservation(){
        addNewBtn.click();
    }

    public String inputLicensePlate(){
        Faker faker = new Faker();
        String licensePlate = faker.bothify("??? #####");
        licensePlateBox.sendKeys(licensePlate);
        BrowserUtils.highlight(licensePlateBox);
        return licensePlate;
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
        BrowserUtils.highlight(todayDate);
        BrowserUtils.clickWithJS(todayDate);
    }

    public void selectParkingSpot(){
        BrowserUtils.highlight(selectParkingBtn);
        selectParkingBtn.click();
    }

    public void selectDate(int daysInFuture){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");

        LocalDateTime day = LocalDateTime.now().plus(Duration.of(daysInFuture, ChronoUnit.DAYS));

        String date = formatter.format(day);
        System.out.println("date = " + date);

        if(date.startsWith("0")){
            date = date.substring(1);
        }

        WebElement dateElement = Driver.getDriver().findElement(By.xpath("//div[@aria-selected='false' and normalize-space(.)='" + date + "']"));
        BrowserUtils.highlight(dateElement);
        dateElement.click();
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

    public void subtractSelectedTime(int timeToSubtract){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalDateTime now = LocalDateTime.now().minus(Duration.of(timeToSubtract, ChronoUnit.MINUTES));

        String time = formatter.format(now);

        if(time.startsWith("0")){
            time = time.substring(1);
        }

        selectTime.sendKeys(time);
        timeOkBtn.click();
        BrowserUtils.highlight(checkInConfirm);
        checkInConfirm.click();
    }

    public void verifyDateErrorMsgDisplayed(boolean expectedStatus) {
        if (expectedStatus) {
            BrowserUtils.highlight(checkInDateErrorMsg);
            BrowserUtils.verifyElementDisplayed(checkInDateErrorMsg);
        } else {
            BrowserUtils.verifyElementNotDisplayed(checkInDateErrorMsg);
        }
    }

    public String retrieveLicensePlate(){
        return licensePlate.getText();
    }
}
