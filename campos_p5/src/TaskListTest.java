import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    public void newTaskListIsEmpty(){
        TaskList temp = new TaskList();
        assertThrows(IndexOutOfBoundsException.class, () -> temp.view());

    }

    @Test
    public void addingTaskItemsIncreasesSize(){
        TaskItem t = new TaskItem("l","take", "2020-02-03", "incomplete");
        TaskItem u = new TaskItem("hihi","take", "2018-02-03", "incomplete");
        TaskList temp = new TaskList();
        temp.add(t);
        temp.add(u);
        assertEquals(2, temp.size());
    }

    @Test
    public void removingTaskItemsDecreasesSize(){
        TaskItem t = new TaskItem("l","take", "2020-02-03", "incomplete");
        TaskItem u = new TaskItem("hihi","take", "2018-02-03","incomplete");
        TaskItem w = new TaskItem("hoho","take", "2019-02-03","incomplete");
        TaskList temp = new TaskList();
        temp.add(t);
        temp.add(u);
        temp.add(w);

        temp.remove(1);

        assertEquals(2, temp.size());

    }

    @Test
    public void editingTaskItemChangesValues(){
        TaskItem t = new TaskItem("l","take", "2020-02-03","incomplete");
        TaskList temp = new TaskList();
        temp.add(t);

        temp.editTitle(t,"blach");
        temp.editDescription(t,"mooh");
        temp.editDate(t,"2020-04-20");
        assertEquals("2020-04-20: blach: mooh", t.getDueDate()+": "+ t.getTitle()+ ": "+ t.getDescription());
    }

    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskItem t = new TaskItem("l","take", "2020-02-03","incomplete");
        TaskList temp = new TaskList();
        temp.add(t);

        temp.editTitle(t,"blah");

        assertEquals("blah", t.getTitle());

    }
    @Test
    public void editingTaskItemDescriptionChangesValue(){
        TaskItem t = new TaskItem("l","take", "2020-02-03","incomplete");
        TaskList temp = new TaskList();
        temp.add(t);

        temp.editDescription(t,"dat old new");

        assertEquals("dat old new", t.getDescription());

    }
    @Test
    public void editingTaskItemDateChangesValue(){
        TaskItem t = new TaskItem("l","take", "2020-02-03","incomplete");
        TaskList temp = new TaskList();
        temp.add(t);

        temp.editDate(t,"2020-10-02");

        assertEquals("2020-10-02", t.getDueDate());

    }


    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){
        TaskItem t = new TaskItem("l","take", "2020-02-03","incomplete");
        TaskList temp = new TaskList();
        temp.add(t);

        temp.editTitle(t, "okay");

        assertThrows(IndexOutOfBoundsException.class, () ->  temp.edit(t,3));

    }
    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskItem t = new TaskItem("l","take", "2020-02-03","incomplete");
        TaskList temp = new TaskList();
        temp.add(t);

        temp.editDescription(t, "bob loblaw is the best");

        assertThrows(IndexOutOfBoundsException.class, () ->  temp.edit(t,3));

    }

    @Test
    public void editingTaskItemDateFailsWithInvalidIndex(){
        TaskItem t = new TaskItem("l","take", "2020-02-03","incomplete");
        TaskList temp = new TaskList();
        temp.add(t);

        temp.editDate(t, "2019-02-02");

        assertThrows(IndexOutOfBoundsException.class, () ->  temp.edit(t,3));

    }

    @Test
    public void savedTaskListCanBeLoaded(){
        TaskItem t = new TaskItem("l","take", "2020-02-03","incomplete");
        TaskList temp = new TaskList();
        temp.add(t);
        temp.load(t, 1);
        assertEquals("1) [2020-02-03] l: take", temp.load(t,1));

    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){
        TaskItem t = new TaskItem("l","take", "2020-02-03","incomplete");
        TaskList temp = new TaskList();
        temp.add(t);

        assertEquals("l", temp.loadExistingTitle(t));
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){
        TaskItem t = new TaskItem("l","take", "2020-02-03","incomplete");
        TaskList temp = new TaskList();
        temp.add(t);

        assertEquals("take", temp.loadExistingDescription(t));
    }

    @Test
    public void gettingTaskItemDateSucceedsWithValidIndex(){
        TaskItem t = new TaskItem("l","take", "2020-02-03","incomplete");
        TaskList temp = new TaskList();
        temp.add(t);

        assertEquals("2020-02-03", temp.loadExistingDate(t));
    }



    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){
        TaskItem t = new TaskItem("l","take", "2020-02-03","incomplete");
        TaskList temp = new TaskList();
        temp.add(t);

        temp.loadExistingTitle(t);
        assertThrows(IndexOutOfBoundsException.class,() -> temp.load(t,3));
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskItem t = new TaskItem("l","take", "2020-02-03","incomplete");
        TaskList temp = new TaskList();
        temp.add(t);

        temp.loadExistingDescription(t);
        assertThrows(IndexOutOfBoundsException.class,() -> temp.load(t,3));
    }


    @Test
    public void gettingTaskItemDateFailsWithInvalidIndex(){
        TaskItem t = new TaskItem("l","take", "2020-02-03","incomplete");
        TaskList temp = new TaskList();
        temp.add(t);

        temp.loadExistingDate(t);
        assertThrows(IndexOutOfBoundsException.class,() -> temp.load(t,3));
    }


    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){
        TaskItem t = new TaskItem("l","take", "2020-02-03","incomplete");
        TaskItem u = new TaskItem("hihi","take", "2018-02-03","incomplete");
        TaskItem w = new TaskItem("hoho","take", "2019-02-03","incomplete");
        TaskList temp = new TaskList();
        temp.add(t);
        temp.add(u);
        temp.add(w);

        assertThrows(IndexOutOfBoundsException.class, () -> temp.remove(12));

    }

    @Test
    public void completingTaskItemChangesStatus(){
        TaskItem t = new TaskItem("l","take", "2020-02-03","incomplete");
        TaskList temp = new TaskList();
        temp.add(t);
        temp.changeStatusToComplete(t,1);
        assertEquals("complete", t.getStatus());

    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskItem t = new TaskItem("l","take", "2020-02-03","incomplete");
        TaskList temp = new TaskList();
        temp.add(t);

        assertThrows(IndexOutOfBoundsException.class,()->  temp.changeStatusToComplete(t,6));

    }

    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskItem t = new TaskItem("l","take", "2020-02-03","incomplete");
        TaskList temp = new TaskList();
        temp.add(t);
        temp.changeStatusToIncomplete(t,1);
        assertEquals("incomplete", t.getStatus());

    }
    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskItem t = new TaskItem("l","take", "2020-02-03","incomplete");
        TaskList temp = new TaskList();
        temp.add(t);

        assertThrows(IndexOutOfBoundsException.class,()->  temp.changeStatusToIncomplete(t,6));

    }



}