package package_test;

import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CorrectTotalStepDefs extends AbstractStepDefs{
    @Then("the total should read {string}")
    public void theCorrectTotalShouldRead(String total){
        assertEquals(total, homePage.getTotal());
    }
}
