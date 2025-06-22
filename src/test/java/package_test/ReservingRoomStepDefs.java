package package_test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReservingRoomStepDefs extends AbstractStepDefs {
    @Given("the {string} field is filled with {string}")
    public void theFieldIsFilledWithText(String field, String text) {
        homePage.fillOutReservationField(field, text);
    }

    @When("the {string} button is clicked")
    public void theButtonIsClicked(String button) {
        homePage.clickButton(button);
    }

    @Then("the {String} message is shown")
    public void theErrorMessageIsShown(String msg){
        assertEquals(msg, homepage.getErrorMessage());
    }
}
