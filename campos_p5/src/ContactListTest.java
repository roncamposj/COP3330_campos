import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ContactListTest {

    @Test
    public void addingItemsIncreasesSize(){
        ContactItem t = new ContactItem("l","take", "2020-02-03", "incomplete");
        ContactItem u = new ContactItem("hihi","take", "2018-02-03", "incomplete");
        ContactList temp = new ContactList();
        temp.add(t);
        temp.add(u);
        assertEquals(2, temp.size());

    }

    @Test
    public void editingItemsFailsWithAllBlankValues(){
        ContactItem t = new ContactItem("","", "", "");
        ContactList temp = new ContactList();
        temp.add(t);
        temp.editFirstName(t,"");
        temp.editLastName(t,"");
        temp.editNumber(t,"");
        temp.editEmail(t,"");

        assertThrows(InvalidNumberException.class,() -> temp.edit(t,0));

    }

    @Test
    public void editingItemsFailsWithInvalidIndex(){
        ContactItem t = new ContactItem("l","take", "roncc@gmail.com", "3333334434");
        ContactList temp = new ContactList();
        temp.add(t);
        temp.editEmail(t, "ronronj@gmail.com");

        assertThrows(IndexOutOfBoundsException.class,() -> temp.edit(t,4));



    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem t = new ContactItem("l","take", "roncc@gmail.com", "3333334434");
        ContactList temp = new ContactList();
        temp.add(t);
        temp.editFirstName(t, "");

        assertEquals("takeroncc@gmail.com3333334434",
                t.getFirstName()+t.getLastName()+t.getEmail()+t.getNumber());

    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem t = new ContactItem("l","", "roncc@gmail.com", "3333334434");
        ContactList temp = new ContactList();
        temp.add(t);
        temp.editLastName(t, "");

        assertEquals("lroncc@gmail.com3333334434",
                t.getFirstName()+t.getLastName()+t.getEmail()+t.getNumber());

    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem t = new ContactItem("l","take", "roncc@gmail.com", "3333334434");
        ContactList temp = new ContactList();
        temp.add(t);
        temp.editEmail(t, "");

        assertEquals("ltake3333334434",
                t.getFirstName()+t.getLastName()+t.getEmail()+t.getNumber());

    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem t = new ContactItem("l","take", "roncc@gmail.com", "3333334434");
        ContactList temp = new ContactList();
        temp.add(t);
        temp.editNumber(t, "");

        assertEquals("ltakeroncc@gmail.com",
                t.getFirstName()+t.getLastName()+t.getEmail()+t.getNumber());

    }

    @Test
    public void newListIsEmpty(){
        ContactList temp = new ContactList();
        assertThrows(IndexOutOfBoundsException.class, () -> temp.view());

    }

    @Test
    public void removingItemsDecreasesSize(){
        ContactItem t = new ContactItem("l","take", "okay@gmail.com", "3332223323");
        ContactItem u = new ContactItem("hihi","take", "kkwj@gmail.com","3332223323");
        ContactItem w = new ContactItem("hoho","take", "yo@yahoo.com","3332223323");
        ContactList temp = new ContactList();
        temp.add(t);
        temp.add(u);
        temp.add(w);

        temp.remove(1);

        assertEquals(2, temp.size());

    }

    @Test
    public void removingItemsFailsWithInvalidIndex(){
        ContactItem t = new ContactItem("l","take", "okay@gmail.com", "3332223323");
        ContactItem u = new ContactItem("hihi","take", "kkwj@gmail.com","3332223323");
        ContactItem w = new ContactItem("hoho","take", "yo@yahoo.com","3332223323");
        ContactList temp = new ContactList();
        temp.add(t);
        temp.add(u);
        temp.add(w);

        assertThrows(IndexOutOfBoundsException.class,() -> temp.remove(8));

    }

    @Test
    public void savedContactListCanBeLoaded(){
        ContactItem t = new ContactItem("l","take", "okay@gmail.com","3332223323");
        ContactList temp = new ContactList();
        temp.add(t);
        temp.load(t, 1);
        assertEquals("1\n" +
                "FirstName: l\nLast Name: take\nPhone Number: 3332223323\n" +
                "Email: okay@gmail.com", temp.load(t,1));

    }
}
