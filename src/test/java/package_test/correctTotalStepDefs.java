package package_test;

import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class correctTotalStepDefs extends AbstractStepDefs{
    @Then("the total should read {String}")
    public void theCorrectTotalShouldRead(String total){
        assertEquals(total, homePage.getTotal());
    }
}
