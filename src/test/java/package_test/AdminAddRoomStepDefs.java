package package_test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;

public class AdminAddRoomStepDefs extends AbstractStepDefs{

    private int roomCountBefore;

    @Then("the number of rooms should be {int}")
    public void theNumberOfRoomsShouldBeRoomCount(int cnt) {
        assertEquals(cnt, homePage.countRooms());
    }


    @And("the room count is saved into memory")
    public void theRoomCountIsSavedIntoMemory() {
        roomCountBefore = homePage.countRooms();
    }

    @Then("the room count should change to roomCount + {int}")
    public void theRoomCountShouldChangeToRoomCount(int val) {
        int roomCountNow = homePage.countRooms();
        assertEquals( roomCountBefore + val, roomCountNow);
    }

    @And("all rooms are deleted")
    public void allRoomsAreDeleted() {
        homePage.deleteAllRooms();
    }

    @Then("the number of rooms should be unchanged")
    public void theNumberOfRoomsShouldBeUnchanged() {
        int roomCountNow = homePage.countRooms();
        assertEquals( roomCountBefore, roomCountNow);
    }
}
