import static org.junit.Assert.*;

public class TaskTest {

    @org.junit.Test
    public void isMultipleQuarterHour() {
        Task task = new Task("1234", "", "07:35", "08:45");
        // assertEqual(expected result, actual results)
        // task.isMultipleQuarterHour()  returns a boolean value
        assertEquals(task.isMultipleQuarterHour(), false);
    }
}