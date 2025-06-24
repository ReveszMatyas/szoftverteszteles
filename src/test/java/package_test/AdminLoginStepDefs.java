package package_test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdminLoginStepDefs extends AbstractStepDefs{

    @Then("the {string} message is shown in admin login")
    public void theErrorMessageIsShown(String msg){
        assertEquals(msg, homePage.getLoginErrorMessage().getText());
    }

    @Then("the admin page is shown")
    public void adminPageIsShown(){
        assertTrue(Objects.requireNonNull(homePage.getDriver().getCurrentUrl()).contains("/admin"));
    }

}
