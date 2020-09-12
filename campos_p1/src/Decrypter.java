//Ronald Campos
// The purpose of this program is to encrypt/decrypt and
// output a four digit number input into the Virtual Machine

import java.util.Arrays;
import java.util.Scanner;


public class Decrypter {

    public Decrypter() { }


    public String decrypt(String decryptedVal) {

        int[] arr = new int[decryptedVal.length()];

        for (int i = 0; i < decryptedVal.length(); i++) {
            arr[i] = Integer.parseInt(decryptedVal.split("")[i]);
            if (arr[i] < 8 && arr[i] > 0) {
                arr[i] += 3;
                if (arr[i] == 10)
                    arr[i] = 0;
            } else if (arr[i] >= 8)
                arr[i] = Math.abs(arr[i] - 7);
            else if (arr[i] == 0)
                arr[i] = 3;
        }

        change(arr);
       String finalString = convertToString(arr);
       return finalString;
    }

    public String convertToString(int arr[]){
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < 4; i++){
            b.append(String.valueOf(arr[i]));
        }

        String newStr = b.substring(0,4);
        System.out.println(newStr);
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

}       //ends class Decrypter
