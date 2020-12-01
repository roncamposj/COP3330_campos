
public class Item {

    public Item() { }

    public boolean isStringValid(String input) {
        return input.length() > 0;
    }

}

class InvalidTitleException extends IllegalArgumentException {
    public InvalidTitleException(String msg) {
        super(msg);
    }
}

class InvalidDescriptionException extends IllegalArgumentException {
    public InvalidDescriptionException(String msg) {
        super(msg);
    }
}

class InvalidDateException extends IllegalArgumentException {
    public InvalidDateException(String msg) {
        super(msg);
    }
}

class InvalidFirstOrLastNameException extends IllegalArgumentException {
    public InvalidFirstOrLastNameException(String msg) {
        super(msg);
    }
}
class InvalidNumberException extends IllegalArgumentException {
    public InvalidNumberException(String msg) {
        super(msg);
    }
}

class InvalidEmailException extends IllegalArgumentException {
    public InvalidEmailException(String msg) {
        super(msg);
    }
}

