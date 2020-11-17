import java.io.FileNotFoundException;
import java.util.*;


public class TaskList {


    private static Scanner input = new Scanner(System.in);

    List<TaskItem> task;
    List<TaskItem> comp;

        public TaskList() {
            task = new ArrayList<>();
            comp = new ArrayList<>();
        }

        public void add(TaskItem data) {
            task.add(data);
        }

        public TaskItem get(int number){
            TaskItem data = task.get(number);
            return data;
        }



        public void edit(TaskItem data, int edit){
            if (isIndexValid(edit)) {
                System.out.println("Enter which you would like to edit (title, description, date):");
                String whatToEdit = input.nextLine();
                if (whatToEdit.toLowerCase().equalsIgnoreCase("title")) {
                    String tempTitle = getTitle();
                    editTitle(data, tempTitle);
                }
                if (whatToEdit.toLowerCase().equalsIgnoreCase("description")) {
                    String tempDescription = getDescription();
                    editDescription(data, tempDescription);
                }
                if (whatToEdit.toLowerCase().contains("date")) {
                    String tempDate = getDueDate();
                    editDate(data, tempDate);
                }

                task.set(edit, data);
            }
            else{
                throw new IndexOutOfBoundsException("Your index is out of bounds");
            }
        }

        public void editTitle(TaskItem data, String change){
            data.setTitle(change); }

        public void editDescription(TaskItem data, String change){
            data.setDescription(change); }

        public void editDate(TaskItem data, String change){
                    data.setDueDate(change);
        }

        public void remove(int delete) {
            if(isIndexValid(delete)) {
                task.remove(delete);
            }
            else{
                throw new IndexOutOfBoundsException("This aint it, homie");
            }
        }

        public void view(){
            int i = 0;
            if (task.size()==0){
                throw new IndexOutOfBoundsException("This list is empty");
            }
            for(TaskItem task : task){
                System.out.println( i + ") ["+task.getDueDate()+"] "+ "Title: " +
                task.getTitle()+ ". Description: "+ task.getDescription()+ " Status: "
                                                        + task.getStatus());
                i++;
            }
        }

        public String load(TaskItem data, int number){
            if (isIndexValid(number)){
            System.out.println( number + ") ["+loadExistingDate(data)+"] "+ "Title " +
                    loadExistingTitle(data)+ ". Description: "+ loadExistingDescription(data));
        }
            else{
                throw new IndexOutOfBoundsException("Not a valid index there, bud");
            }

            return (number + ") ["+loadExistingDate(data)+"] "+
                    loadExistingTitle(data)+ ": "+ loadExistingDescription(data));
        }

        public String loadExistingTitle(TaskItem data){
            return data.getTitle();
        }

        public String loadExistingDescription(TaskItem data){
            return data.getDescription();
        }
        public String loadExistingDate(TaskItem data){
            return data.getDueDate();
        }

        public void changeStatusToComplete(TaskItem data, int index){
            if(isIndexValid(index)){
                data.setToComplete();
            }
            else{
                throw new IndexOutOfBoundsException("Your index is not in bounds");
            }
        }

        public void changeStatusToIncomplete(TaskItem data, int index){
            if(isIndexValid(index)){
                data.setToIncomplete();
            }
            else{
                throw new IndexOutOfBoundsException("Your index is not in bounds");
            }
        }


        public void write(String filename) {
            try(Formatter output = new Formatter(filename)) {
                for(int i = 0; i < task.size(); i++) {
                    TaskItem data = task.get(i);
                    output.format("%s;%s;%s%n", data.getTitle(), data.getDescription(),
                                                                    data.getDueDate());
                }

            } catch (FileNotFoundException ex) {
                System.out.println("Unable to find the file...");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    private String getTitle() {
        System.out.println("Enter the task title:");
        return input.nextLine();
    }

    private String getDescription() {
        System.out.println("Enter the description:");
        return input.nextLine();
    }

    private String getDueDate() {
        System.out.println("Enter the date in YYYY-MM-DD format:");
        return input.nextLine();
    }

        public int size(){
            int s = 0;
            for(TaskItem d: task){
                s++;
            }
            return s;
        }

        private boolean isIndexValid(int index){
            return (index <= task.size());
        }

}


