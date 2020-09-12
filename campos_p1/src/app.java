import java.util.Scanner;

public class app {
    public static void main(String[] args) {


        System.out.println("Write in a four digit number");
        Scanner in = new Scanner(System.in);
        String numbers = in.next();


        Encrypter encrypt1 = new Encrypter();
        encrypt1.encrypt(numbers);
        System.out.println("");
        Decrypter decrypt1 = new Decrypter();
        decrypt1.decrypt(numbers);

    }

}
