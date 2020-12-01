import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues(){
        assertThrows(InvalidNumberException.class, () -> new ContactItem("",
                "","", ""));

    }

    @Test
    public void creationSucceedsWithBlankEmail(){
        ContactItem test = new ContactItem("Ron",
                "Campos","", "3214332345");
        assertEquals("", test.getEmail());

    }

    @Test
    public void creationSucceedsWithBlankFirstName(){
        ContactItem test = new ContactItem("",
                "Campos","ronccc@yahoo.com", "3214332345");
        assertEquals("", test.getFirstName());

    }

    @Test
    public void creationSucceedsWithBlankLastName(){
        ContactItem test = new ContactItem("Ron",
                "","ronccc@yahoo.com", "3214332345");
        assertEquals("", test.getLastName());

    }

    @Test
    public void creationSucceedsWithBlankPhone(){
        ContactItem test = new ContactItem("Ron",
                "Campos","ronccc@yahoo.com", "");
        assertEquals("", test.getNumber());

    }

    @Test
    public void creationSucceedsWithNonBlankValues(){
        ContactItem test = new ContactItem("Ron",
                "Campos","ronccc@yahoo.com", "3214332345");


        assertEquals("Ron Campos ronccc@yahoo.com 3214332345", test.getFirstName() + " " +
                test.getLastName()+ " " + test.getEmail()+ " " +test.getNumber());

    }

    @Test
    public void editingFailsWithAllBlankValues(){
        ContactItem t = new ContactItem("","", "", "");
        ContactList temp = new ContactList();
        temp.add(t);
        temp.editFirstName(t,"");
        temp.editLastName(t,"");
        temp.editNumber(t,"");
        temp.editEmail(t,"");

        assertThrows(InvalidNumberException.class,() -> t.isThereAtLeastOneInput(0));


    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactItem t = new ContactItem("Ron","v", "ronc@gmail.com", "2222223343");
        ContactList temp = new ContactList();
        temp.add(t);
        temp.editFirstName(t,"Ron");
        temp.editLastName(t,"C");
        temp.editNumber(t,"2222223343");
        temp.editEmail(t,"");

        assertEquals("RonC2222223343", t.getFirstName()+t.getLastName()+t.getNumber()+t.getEmail());


    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem t = new ContactItem("Ron","v", "ronc@gmail.com", "2222223343");
        ContactList temp = new ContactList();
        temp.add(t);
        temp.editFirstName(t,"");
        temp.editLastName(t,"C");
        temp.editNumber(t,"2222223343");
        temp.editEmail(t,"");

        assertEquals("C2222223343", t.getFirstName()+t.getLastName()+t.getNumber()+t.getEmail());

    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem t = new ContactItem("Ron","v", "ronc@gmail.com", "2222223343");
        ContactList temp = new ContactList();
        temp.add(t);
        temp.editFirstName(t,"Ron");
        temp.editLastName(t,"");
        temp.editNumber(t,"2222223343");
        temp.editEmail(t,"");

        assertEquals("Ron2222223343", t.getFirstName()+t.getLastName()+t.getNumber()+t.getEmail());

    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem t = new ContactItem("Ron","v", "ronc@gmail.com", "2222223343");
        ContactList temp = new ContactList();
        temp.add(t);
        temp.editFirstName(t,"Ron");
        temp.editLastName(t,"C");
        temp.editNumber(t,"");
        temp.editEmail(t,"");

        assertEquals("RonC", t.getFirstName()+t.getLastName()+t.getNumber()+t.getEmail());

    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem t = new ContactItem("Ron","v", "ronc@gmail.com", "2222223343");
        ContactList temp = new ContactList();
        temp.add(t);
        temp.editFirstName(t,"Ron");
        temp.editLastName(t,"C");
        temp.editNumber(t,"2222223343");
        temp.editEmail(t,"ron@ron.com");

        assertEquals("RonC2222223343ron@ron.com", t.getFirstName()+t.getLastName()+t.getNumber()+t.getEmail());

    }

    @Test
    public void testToString(){

    }
}
