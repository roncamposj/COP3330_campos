import java.util.Scanner;

public class ContactApp extends App{


    private final ContactList contact;
    private static Scanner contactInput = new Scanner(System.in);
    private static Scanner contactNum = new Scanner(System.in);

    public ContactApp() {
        contact = new ContactList();

    }

    public void processContactItem() {
        ContactItem data = makeNewContactItem();

        storeContactItem(data);
    }


    public ContactItem makeNewContactItem(){
        ContactItem data = null;

        try {
            String firstName = getFirstName();
            String lastName = getLastName();
            String phone = getPhone();
            String email = getEmail();


            data = new ContactItem( firstName, lastName, phone, email);

        } catch (InvalidFirstOrLastNameException ex) {
            System.out.println("Warning: your name was invalid, please double check it and try again");
        } catch (InvalidEmailException ex) {
            System.out.println("Warning: your email was invalid, please double check it and try again");
        } catch (InvalidNumberException ex) {
            System.out.println("Warning: your phone number was invalid, please double check it and try again");
        }

        return data;
    }


    private void viewTheList(){
        contact.view();
    }

    private void loadList(int load){
        try{
            ContactItem data = contact.get(load);
            contact.load(data,load);
        } catch(IndexOutOfBoundsException ex) {
            System.out.println("This task doesn't exist.");

        }
    }


    private void writeTaskItem(String file) { contact.write(file); }

    private void storeContactItem(ContactItem data) { contact.add(data); }

    public void editItem(int edit) {
        try {
            ContactItem data = contact.get(edit);
            contact.edit(data, edit);
        } catch(IndexOutOfBoundsException ex) {
            System.out.println("This task doesn't exist.");

        }
    }
    private void deleteContactItem(int delete) {
        try{
            contact.remove(delete);
        } catch(IndexOutOfBoundsException ex) {
            System.out.println("This task doesn't exist.");

        }
    }

    public void contactMenu() {
        int menu;
        do {
            System.out.println("List Operation Menu\n" +
                    "---------\n" +
                    "\n" +
                    "1) view the list\n" +
                    "2) add an item\n" +
                    "3) edit an item\n" +
                    "4) remove an item\n" +
                    "5) save the current list\n" +
                    "6) quit to the main menu");
            menu = contactNum.nextInt();


        switch (menu) {
            case 1:
                viewTheList();
                break;
            case 2:
                processContactItem();
                break;
            case 3:
                int edit = askWhatToEdit();
                editItem(edit);
                break;
            case 4:
                int delete = askWhatToDelete();
                deleteContactItem(delete);
                break;
            case 5:
                String file = getFileName();
                writeTaskItem(file);
                break;
            case 6:
                mainMenu();
                break;
            default:
                System.out.println("Choices are only between 1-6");
        }

        } while (menu != 6);
    }


    public String getFirstName() {
        System.out.println("Enter first name:");
        return contactInput.nextLine();
    }

    public String getLastName() {
        System.out.println("Enter last name:");
        return contactInput.nextLine();
    }

    public String getPhone() {
        System.out.println("Enter 10 digit phone number:");
        return contactInput.nextLine();
    }

    public String getEmail() {
        System.out.println("Enter email:");
        return contactInput.nextLine();
    }


}
