package package_test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage {

    private static final String HOMEPAGE_URL = "https://automationintesting.online";
    private static final String ADMINPAGE_URL = "https://automationintesting.online/admin";


    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "#root-container > div > div.container.my-5 > div > div.col-lg-4 > div > div > form > div.alert.alert-danger")
    private WebElement reserveErrorMessage;

    @FindBy(xpath = "//*[@id=\"root-container\"]/div/div[2]/div/div[2]/div/div/h2")
    private WebElement reservationHeadline;

    @FindBy(css="#contact > div > div > div > div > div > div")
    private static WebElement contactErrorMessage;

    @FindBy(xpath="/html/body/div/div/div/div/div/div[2]/div/div[2]/div")
    private WebElement loginErrorMessage;

    @FindBy(css = "#root-container > div > div.container.my-5 > div > div.col-lg-4 > div > div > form > div.card.bg-light.border-0.mb-4 > div > div.d-flex.justify-content-between.fw-bold > span:nth-child(2)")
    private WebElement totalSpan;

    @FindBy(xpath = "/html/body/div/div/h2")
    private WebElement fullScreenErrorMessage;


    private static final Map<String, By> navigationButtons = Map.of(
            "BookSingle", By.cssSelector("#rooms > div > div.row.g-4 > div:nth-child(1) > div > div.card-footer.bg-white.d-flex.justify-content-between.align-items-center > a"),
            "BookDouble", By.cssSelector("#rooms > div > div.row.g-4 > div:nth-child(2) > div > div.card-footer.bg-white.d-flex.justify-content-between.align-items-center > a"),
            "Reserve", By.id("doReservation"),
            "ReserveNow", By.cssSelector("#root-container > div > div.container.my-5 > div > div.col-lg-4 > div > div > form > button.btn.btn-primary.w-100.mb-3"),
            "SubmitMessage", By.cssSelector("#contact > div > div > div > div > div > form > div.d-grid > button"),
            "Login", By.id("doLogin"),
            "CreateRoom", By.id("createRoom")
            );

    private static final Map<String, By> inputFieldList = new HashMap<>(){{
        put("CheckInDate",By.xpath("/html/body/div/div/div/section[1]/div/div/div/form/div/div[1]/div/div/input"));
        put("CheckOutDate",By.xpath("/html/body/div/div/div/section[1]/div/div/div/form/div/div[2]/div/div/input"));
        put("FirstNameReserve", By.cssSelector("#root-container > div > div.container.my-5 > div > div.col-lg-4 > div > div > form > div.input-group.mb-3.room-booking-form > input"));
        put("LastNameReserve", By.cssSelector("#root-container > div > div.container.my-5 > div > div.col-lg-4 > div > div > form > div:nth-child(2) > input"));
        put("EmailReserve", By.cssSelector("#root-container > div > div.container.my-5 > div > div.col-lg-4 > div > div > form > div:nth-child(3) > input"));
        put("PhoneNumberReserve", By.cssSelector("#root-container > div > div.container.my-5 > div > div.col-lg-4 > div > div > form > div:nth-child(4) > input"));
        put("NameMessage", By.id("name"));
        put("EmailMessage", By.id("email"));
        put("PhoneNumberMessage", By.id("phone"));
        put("SubjectMessage", By.id("subject"));
        put("DescriptionField", By.id("description"));
        put("Username", By.id("username"));
        put("Password", By.id("password"));
        put("RoomName", By.id("roomName"));
        put("RoomPrice", By.id("roomPrice"));
    }};


    private static final Map<String, By> checkBoxList = Map.of(
            "Wifi", By.id("wifiCheckbox"),
            "Refreshments", By.id("refreshCheckbox"),
            "TV", By.id("tvCheckbox"),
            "Safe", By.id("safeCheckbox"),
            "Radio", By.id("RadioCheckbox"),
            "Views", By.id("viewsCheckbox")

    );


    private static final Map <String, By> selectorList = Map.of(
            "RoomType", By.id("type"),
            "RoomAccessible", By.id("accessible")
    );

    public void openHomePage() {
        driver.get(HOMEPAGE_URL);
        PageFactory.initElements(driver, this);
    }


    public void openAdminPage() {
        driver.get(ADMINPAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void closePage() {
        driver.quit();
    }

    public void fillOutField(String field, String text) {
        WebElement element = driver.findElement(inputFieldList.get(field));
        element.clear();
        element.sendKeys(text);
    }

    public void setSelectorTo(String selector, String setTo) {
        WebElement dropdown = driver.findElement(selectorList.get(selector));
        Select select = new Select(dropdown);
        select.selectByVisibleText(setTo);
    }
    public WebElement getLoginErrorMessage() {
        return loginErrorMessage;
    }

    public String getFullScreenErrorMessage() {
        return fullScreenErrorMessage.getText();
    }

    public void setCheckBoxes(String checkBox){
        driver.findElement(checkBoxList.get(checkBox)).click();
    }


    public void clickButton(String button) {
        WebElement element = driver.findElement(navigationButtons.get(button));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);
    }

    public String getReserveErrorMessage() {
        return reserveErrorMessage.getText();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public int countRooms(){
        return driver.findElements(By.cssSelector("[data-type='room']")).size();
    }

    public void deleteAllRooms() {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        while (true) {
            List<WebElement> deleteButtons = driver.findElements(By.cssSelector(".roomDelete"));

            if (deleteButtons.isEmpty()) {
                break;
            }
            WebElement button = deleteButtons.getFirst();
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

            button.click();

            //wait.until(ExpectedConditions.stalenessOf(button));
        }
    }


    public String getReservationHeadlineText() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return reservationHeadline.getText();
    }


    public String getContactErrorMessage() { return contactErrorMessage.getText(); }

    public String getTotal(){
        return totalSpan.getText();
    }

}
