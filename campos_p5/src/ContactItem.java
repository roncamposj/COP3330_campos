import javax.naming.InvalidNameException;
import java.util.logging.SimpleFormatter;
import javax.swing.text.MaskFormatter;

public class ContactItem extends Item{

    private String fName;
    private String lName;
    private String email;
    private String phone;
    private int counter =4;

    public ContactItem(String fName, String lName, String email, String phone){
        ContactList c = new ContactList();

        if(!isStringValid(fName)){
            counter--;
        }
            this.fName = fName;

        if(!isStringValid(lName)){
            counter--;
        }
            this.lName = lName;

        if (isPhoneNumberValid(phone)) {
            this.phone = phone;
        } else {
            throw new InvalidNumberException("Phone Number is not valid; must be exactly 10 characters long.");
        }

        if (isEmailValid(email)) {
            this.email = email;
        } else {
            throw new InvalidEmailException("Email is not valid.");
        }

        if(!isThereAtLeastOneInput(counter)){
            throw new InvalidNumberException("You have to enter at least one input.");
        }

    }

    private boolean isPhoneNumberValid(String phone){

    if (phone.length()==10) {
        String.format("(%s) %s-%s", phone.substring(0, 3), phone.substring(3, 6),
                phone.substring(6, 10));
    }

    if (phone.length()!=10)
    {
        if(!isStringValid(phone)){
           counter--;
    }
        else{
            return false;
            }
    }

    return true;

    }

    private boolean isEmailValid(String email){
        if (!email.contains("@") && !email.contains(".")){
            if(!isStringValid(email)){
                counter--;
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean isThereAtLeastOneInput(int counter){
        return counter >= 1;
    }

    public String getFirstName (){
        return this.fName;
    }
    public String getLastName (){
        return this.lName;
    }
    public String getEmail (){
        return this.email;
    }
    public String getNumber (){
        return this.phone;
    }

    public String setFirstName(String fName){
        return this.fName = fName;
    }
    public String setLastName(String lName){
        return this.lName = lName;
    }
    public String setEmail(String email){
        return this.email = email;
    }
    public String setNumber(String phone){
        return this.phone = phone;
    }

}


