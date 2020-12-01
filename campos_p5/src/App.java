import java.util.Scanner;
import static java.lang.System.exit;

public class App {


    private static Scanner input = new Scanner(System.in);
    private static Scanner intput = new Scanner(System.in);


    public static void main(String[] args) {
        App m = new App();

        m.mainMenu();

    }

    public void mainMenu() {

        int menu;
        do {
            System.out.println("Select your Application\n"+
                    "---------\n" +
                    "1) task list\n" +
                    "2) contact list \n" +
                    "3) quit");
            menu = intput.nextInt();

            switch(menu){
                case 1:
                    TaskApp l = new TaskApp();
                    l.taskMenu();
                    break;
                case 2:
                    ContactApp n = new ContactApp();
                    n.contactMenu();
                    break;
                case 3:
                    exit(0);
                    break;
                default:
                    System.out.println("Choices are only between 1-3");

            }
        }while(menu!= 3);


    }


    public String getFileName(){
        System.out.println("Enter the name of file you want to save as");
        return input.nextLine();
    }

    public static int askWhatToLoad() {
        System.out.println("What would you like to load? (Type in the number)");
        return intput.nextInt();
    }


    public static int askWhatToEdit() {
        System.out.println("What would you like to edit? (Type in the number)");
        return intput.nextInt();
    }

    public static int askWhatToDelete() {
        System.out.println("What would you like to delete? (Type in the number)");
        return intput.nextInt();
    }

    public static int askWhatToMark() {
        System.out.println("What would you like to mark as complete or incomplete? (Type in the number)");
        return intput.nextInt();
    }

}
