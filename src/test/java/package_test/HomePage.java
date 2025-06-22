package package_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class HomePage {

    private static final String PAGE_URL = "https://automationintesting.online";

    private final WebDriver driver;

    @FindBy(css = "#root-container > div > div.container.my-5 > div > div.col-lg-4 > div > div > form > div.alert.alert-danger")
    private WebElement errorMessage;

    @FindBy(css = "#root-container > div > div.container.my-5 > div > div.col-lg-4 > div > div > form > div.card.bg-light.border-0.mb-4 > div > div.d-flex.justify-content-between.fw-bold > span:nth-child(2)")
    private WebElement totalSpan;


    private static final Map<String, By> navigationButtons = Map.of(
            "Book", By.cssSelector("#rooms > div > div.row.g-4 > div:nth-child(1) > div > div.card-footer.bg-white.d-flex.justify-content-between.align-items-center"),
            "Reserve", By.id("doReservation"),
            "ReserveNow", By.cssSelector("#root-container > div > div.container.my-5 > div > div.col-lg-4 > div > div > form > button.btn.btn-primary.w-100.mb-3")
    );

    private static final Map<String, By> reservationFieldList = Map.of(
            "FirstName", By.cssSelector("#root-container > div > div.container.my-5 > div > div.col-lg-4 > div > div > form > div.input-group.mb-3.room-booking-form > input"),
            "LastName", By.cssSelector("#root-container > div > div.container.my-5 > div > div.col-lg-4 > div > div > form > div:nth-child(2) > input"),
            "Email", By.cssSelector("#root-container > div > div.container.my-5 > div > div.col-lg-4 > div > div > form > div:nth-child(3) > input"),
            "PhoneNumber", By.cssSelector("#root-container > div > div.container.my-5 > div > div.col-lg-4 > div > div > form > div:nth-child(4) > input")
    );

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void closePage() {
        driver.quit();
    }

    public void fillOutReservationField(String field, String text) {
        driver.findElement(reservationFieldList.get(field)).sendKeys(text);
    }

    public void clickButton(String button) {
        driver.findElement(navigationButtons.get(button)).click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
//
    public String getTotal(){
        return totalSpan.getText();
    }

}
