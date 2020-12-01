import java.util.Scanner;

import static java.lang.System.exit;


public class TaskApp extends App{

    private final TaskList task;
    private static Scanner taskInput = new Scanner(System.in);
    private static Scanner taskNumber = new Scanner(System.in);


    public TaskApp() {
        task = new TaskList();

    }


    public void processTaskItem() {
        TaskItem data = makeNewTaskItem();

        storeTaskItem(data);
    }


    private void viewTheList(){
        task.view();
    }

    private void loadList(int load){
        try{
            TaskItem data = task.get(load);
            task.load(data,load);
        } catch(IndexOutOfBoundsException ex) {
            System.out.println("This task doesn't exist.");

        }
    }

    private void completeStatus(int number){
        try {
            TaskItem data = task.get(number);
            task.changeStatusToComplete(data, number);
        }   catch(IndexOutOfBoundsException ex) {
            System.out.println("This task doesn't exist.");

        }
    }

    private void incompleteStatus(int number){
        try {
            TaskItem data = task.get(number);
            task.changeStatusToIncomplete(data, number);
        } catch(IndexOutOfBoundsException ex) {
            System.out.println("This task doesn't exist.");

        }
    }

    private void writeTaskItem(String file) {
        task.write(file);
    }

    private void storeTaskItem(TaskItem data) {
        task.add(data);
    }

    public void editItem(int edit) {
        try {
            TaskItem data = task.get(edit);
            task.edit(data, edit);
        } catch(IndexOutOfBoundsException ex) {
            System.out.println("This task doesn't exist.");

        }
    }
    private void deleteTaskItem(int delete) {
        try{
            task.remove(delete);
        } catch(IndexOutOfBoundsException ex) {
            System.out.println("This task doesn't exist.");

        }
    }


    public TaskItem makeNewTaskItem(){
        TaskItem data = null;

        try {
            String title = getTitle();
            String description = getDescription();
            String dueDate = getDueDate();
            String status = "incomplete";

            data = new TaskItem( title, description, dueDate, status);

        } catch (InvalidTitleException ex) {
            System.out.println("Warning: your title was invalid, please double check it and try again");
        } catch (InvalidDescriptionException ex) {
            System.out.println("Warning: your description was invalid, please double check it and try again");
        } catch (InvalidDateException ex) {
            System.out.println("Warning: your date was invalid, please double check it and try again");
        }

        return data;
    }


    public void taskMenu() {

        int menu;
        do {
            System.out.println("Task Main Menu:\n"+
                    "---------\n" +
                    "1) create a new list\n" +
                    "2) load an existing list\n" +
                    "3) quit");
            menu = taskNumber.nextInt();

            switch (menu){
                case 1: nextOption();
                    break;
                case 2:
                    int load = askWhatToLoad();
                    loadList(load);
                    break;
                case 3:
                    exit(0);
                    break;
                default:
                    System.out.println("Choices are only between 1-3");

            }
        }while(menu!= 3);
    }


    private void nextOption(){

        int choice;
        do{
            System.out.println("List Operation Menu:");
            System.out.println("---------\n" +
                    "\n" +
                    "1) view the list\n" +
                    "2) add an item\n" +
                    "3) edit an item\n" +
                    "4) remove an item\n" +
                    "5) mark an item as completed\n" +
                    "6) unmark an item as completed\n" +
                    "7) save the current list\n" +
                    "8) quit to the main menu");

            choice = taskNumber.nextInt();
            switch (choice){
                case 1:
                    viewTheList();
                    break;
                case 2:
                    processTaskItem();
                    break;
                case 3:
                    int edit = askWhatToEdit();
                    editItem(edit);
                    break;
                case 4:
                    int delete = askWhatToDelete();
                    deleteTaskItem(delete);
                    break;
                case 5:
                    int complete = askWhatToMark();
                    completeStatus(complete);
                    break;
                case 6:
                    int incomplete = askWhatToMark();
                    incompleteStatus(incomplete);
                case 7:
                    String file = getFileName();
                    writeTaskItem(file);
                case 8:
                    taskMenu();
                    break;
                default:
                    System.out.println("Choices are only between 1-8");

            }
        }while(choice!=8);
    }

    public String getTitle() {
        System.out.println("Enter the task title:");
        return taskInput.nextLine();
    }

    public String getDescription() {
        System.out.println("Enter the description:");
        return taskInput.nextLine();
    }

    public String getDueDate() {
        System.out.println("Enter the date in YYYY-MM-DD format:");
        return taskInput.nextLine();
    }


}