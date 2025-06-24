package package_test;

import io.cucumber.java.en.Then;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class SendMessageStepDefs extends AbstractStepDefs {
    @Then("the following messages are shown in errormessage:")
    public void theErrorMessageIsShowninMessage(List<String> msg) {
        List<String> expectedMessages = new ArrayList<>(msg);
        List<String> actualMessages = Arrays.stream(homePage.getContactErrorMessage().split("\\r?\\n"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        Collections.sort(expectedMessages);
        Collections.sort(actualMessages);

        assertEquals(expectedMessages, actualMessages);
    }


    @Then("the {string} message is shown in errormessage")
    public void the_message_is_shown_in_message(String string) {
        assertEquals(string, homePage.getContactErrorMessage());
    }

    // test
}
