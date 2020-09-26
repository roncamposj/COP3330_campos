import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class App {



    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();


            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);


            displayBmiInfo(bmi);

        }

          displayBmiStatistics(bmiData);

        }


    public static void displayBmiInfo(BodyMassIndex bmi) {
       double data = bmi.returnBmi();
        System.out.println("[BMI of " + data + "]  You are " + bmi.whereDoIStand(data));
    }


     public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData){
        double addBmi =0, counter = 0;
        for (int i =0; i< bmiData.size();i++){
            addBmi += bmiData.get(i).getAvg();
            counter++;
        }

         DecimalFormat df = new DecimalFormat("#.##");
         df.setRoundingMode(RoundingMode.CEILING);

        double avg = Double.parseDouble(df.format(addBmi/counter));
         System.out.println("The average BMI is: " + avg );
        }




    public static Boolean moreInput() {
        System.out.println("Would you like to add more measurements? (Enter either Y or N)");
        Scanner ans = new Scanner(System.in);
        String answer = ans.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            return true;
        }
        else if (answer.equalsIgnoreCase("n")) {
            return false;
        }
    return false;
    }


    public static double getUserHeight(){
        System.out.println("Enter your height:");
        Scanner in = new Scanner(System.in);
        double height = Double.parseDouble(in.nextLine());
        while (height < 0)
        {
            System.out.println("Please enter a positive value");
            height = in.nextDouble();
        }
            return height;
    }

    public static double getUserWeight(){
        System.out.println("Enter your weight:");
        Scanner in = new Scanner(System.in);
        double weight = Double.parseDouble(in.nextLine());
        while (weight < 0)
        {
            System.out.println("Please enter a positive value");
            weight = in.nextDouble();
        }
        return weight;
    }

}


