//Ronald Campos
// The purpose of this program is to encrypt/decrypt and
// output a four digit number input into the Virtual Machine

import java.util.Arrays;
import java.util.Scanner;


public class Encrypter {

    public Encrypter (){ }

    public String encrypt(String encryptedVal) {

        int[] arr = new int[encryptedVal.length()];

        for (int i = 0; i < encryptedVal.length(); i++) {
            arr[i] = Integer.parseInt(encryptedVal.split("")[i]);
            arr[i] += 7;
            arr[i] %= 10;
        }

        change(arr);
        String finalString = convertToString(arr);
        return finalString;
    }

    public String convertToString(int arr[]){
        StringBuilder b = new StringBuilder();
        for (int i=0; i <4; i++) {
            b.append(String.valueOf(arr[i]));
        }

        String newStr = b.substring(0,4);
        System.out.print(newStr);
        return newStr;
    }

    public void change(int arr[]){
        int temp, temp2;
        temp = arr[0];
        arr[0] = arr[2];
        arr[2] = temp;
        temp2 = arr[1];
        arr[1] = arr[3];
        arr[3] = temp2;

    }

}
