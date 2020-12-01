import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TaskItemTest {


    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        assertThrows(InvalidDateException.class, () -> new TaskItem("Hello",
                "Darkness My old friend","02-02-1993", "incomplete"));

    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        TaskItem testDate = new TaskItem("Hello",
                "Darkness My old friend","1999-03-02", "incomplete");
        assertEquals("1999-03-02", testDate.getDueDate());

    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        assertThrows(InvalidTitleException.class, () -> new TaskItem("",
                "Darkness My old friend","03-02-1999", "incomplete"));

    }
    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        TaskItem testTitle = new TaskItem("Hello",
                "Darkness My old friend","1999-03-02", "incomplete");
        assertEquals("Hello", testTitle.getTitle());
    }

    @Test
    public void creatingTaskItemFailsWithInvalidDescription(){
        assertThrows(InvalidDescriptionException.class, () -> new TaskItem("Hello",
                "","03-02-1999", "incomplete"));

    }

    @Test
    public void creatingTaskItemSucceedsWithValidDescription() {
        TaskItem testDescription = new TaskItem("Hello",
                "Darkness My old friend","1999-03-08", "incomplete");
        assertEquals("Darkness My old friend", testDescription.getDescription());
    }


}

