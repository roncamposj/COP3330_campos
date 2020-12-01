import java.io.FileNotFoundException;
import java.util.*;

public class ContactList {

    private static Scanner input = new Scanner(System.in);

    List<ContactItem> contact;

    public ContactList(){
        contact = new ArrayList<>();
    }

    public void add(ContactItem data) {
        contact.add(data);
    }

    public ContactItem get(int number){
        ContactItem data = contact.get(number);
        return data;
    }

    public void view(){
        int i = 0;
        if (contact.size()==0){
            throw new IndexOutOfBoundsException("This list is empty");
        }
        for(ContactItem contact : contact){
            System.out.println(i);
            System.out.println("First Name: " + contact.getFirstName());
            System.out.println("Last Name: " + contact.getLastName());
            System.out.println("Phone Number: " + contact.getNumber());
            System.out.println("Email: " + contact.getEmail());
            i++;
        }
    }

    public String load(ContactItem data, int number){
        if (isIndexValid(number)){
            System.out.println(number);
            System.out.println("First Name: " + loadExistingFirstName(data));
            System.out.println("Last Name: " + loadExistingLastName(data));
            System.out.println("Phone Number: " + loadExistingNumber(data));
            System.out.println("Email: " + loadExistingEmail(data));
        }
        else{
            throw new IndexOutOfBoundsException("Not a valid index there, bud");
        }

        return       number + "\n" +
                    "First Name: " + loadExistingFirstName(data) + "\n" +
                    "Last Name: " + loadExistingLastName(data) + "\n" +
                    "Phone Number: " + loadExistingNumber(data) + "\n" +
                    "Email: " + loadExistingEmail(data);
    }

    public String loadExistingFirstName(ContactItem data){
        return data.getFirstName();
    }

    public String loadExistingLastName(ContactItem data){
        return data.getLastName();
    }
    public String loadExistingNumber(ContactItem data){ return data.getNumber(); }
    public String loadExistingEmail(ContactItem data){ return data.getEmail(); }

    public void edit(ContactItem data, int edit){
         if (isIndexValid(edit)) {
        System.out.println("Enter which you would like to edit (first, last, phone, email.):");
        String whatToEdit = input.nextLine();
        if (whatToEdit.toLowerCase().equalsIgnoreCase("first")) {
            String tempName = data.getFirstName();
            editFirstName(data, tempName);
        }
        if (whatToEdit.toLowerCase().equalsIgnoreCase("last")) {
            String tempName = data.getLastName();
            editLastName(data, tempName);
        }
        if (whatToEdit.toLowerCase().equalsIgnoreCase("phone")) {
            String tempNumber = data.getNumber();
            editNumber(data, tempNumber);
        }
        if (whatToEdit.toLowerCase().contains("date")) {
            String tempEmail = data.getEmail();
            editEmail(data, tempEmail);
        }

        contact.set(edit, data);
    }
        else{
        throw new IndexOutOfBoundsException("Your index is out of bounds");
    }
}
    public void remove(int delete) {
        if(isIndexValid(delete)) {
            contact.remove(delete);
        }
        else{
            throw new IndexOutOfBoundsException("This aint it, homie");
        }
    }

    public void write(String filename) {
        try(Formatter output = new Formatter(filename)) {
            for(int i = 0; i < contact.size(); i++) {
                ContactItem data = contact.get(i);
                output.format("%s;%s;%s%n", data.getFirstName(),data.getLastName(), data.getNumber(),
                        data.getEmail());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void editEmail(ContactItem data, String tempEmail) {
        data.setEmail(tempEmail);
    }

    public void editNumber(ContactItem data, String tempNumber) {
        data.setNumber(tempNumber);
    }

    public void editLastName(ContactItem data, String tempName) {
         data.setLastName(tempName);
    }

    public void editFirstName(ContactItem data, String tempName) {
        data.setFirstName(tempName);
    }

    public String getFirstName() {
        System.out.println("Enter first name:");
        return input.nextLine();
    }
    public String getLastName() {
        System.out.println("Enter last name:");
        return input.nextLine();
    }

    public String getPhone() {
        System.out.println("Enter 10 digit phone number:");
        return input.nextLine();
    }

    public String getEmail() {
        System.out.println("Enter email:");
        return input.nextLine();
    }

    public int size(){
        int s = 0;
        for(ContactItem d: contact){
            s++;
        }
        return s;
    }
    private boolean isIndexValid(int index){
        return (index <= contact.size());
    }

}
