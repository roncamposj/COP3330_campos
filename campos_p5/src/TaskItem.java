
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class TaskItem extends Item{

    private String title;
    private String description;
    private String dueDate;
    private String status= "incomplete";

    public TaskItem(String title, String description, String dueDate, String status) {
        TaskList t = new TaskList();

        if (isStringValid(title)) {
            this.title = title;
        } else {
            throw new InvalidTitleException("Title is not valid; must be at least 1 character long");
        }

        if (isStringValid(description)) {
            this.description = description;
        } else {
            throw new InvalidDescriptionException("Description is not valid; must be at least 1 character long");
        }

        if (isDueDateValid(dueDate)) {
            this.dueDate = dueDate;
        } else {
            throw new InvalidDateException("Due date must be in YYYY-MM-DD format.");
        }

        this.status = status;
    }



    private boolean isDueDateValid(String dueDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(dueDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    public String getTitle() {
        return this.title;
    }

    public String setTitle(String title){
        return this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public String setDescription(String description) {
        return this.description = description;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public String setDueDate(String dueDate) {
        return this.dueDate = dueDate;
    }

    public String getStatus(){
        return this.status = status;
    }

    public String setToComplete(){
        return this.status = "complete";
    }

    public String setToIncomplete(){
        return this.status = "incomplete";
    }
}



