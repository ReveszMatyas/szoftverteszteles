package package_test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class ReservingRoomStepDefs extends AbstractStepDefs {

    @Then("the {string} message is shown in reservation")
    public void theErrorMessageIsShown(String msg){
        List<String> expectedMessages = Arrays.asList(msg.split(";"));
        List<String> actualMessages = Arrays.stream(homePage.getReserveErrorMessage().split("\\r?\\n"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        Collections.sort(expectedMessages);
        Collections.sort(actualMessages);

        assertEquals(expectedMessages, actualMessages);
    }

    @Then("{string} full screen message is shown.")
    public void fullScreenErrorMessage(String msg) {
        assertEquals(msg, homePage.getFullScreenErrorMessage());
    }
}
