import java.lang.Math;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class BodyMassIndex {

double weight, height, bmiAdder;



    BodyMassIndex(BodyMassIndex values){
       weight = values.weight;
       height = values.height;

    }

    BodyMassIndex(double h, double w){
       weight = w;
       height = h;

    }

   public double returnBmi() {
       DecimalFormat df = new DecimalFormat("#.##");
       df.setRoundingMode(RoundingMode.CEILING);

       double bmi = (703*weight)/(height*height);
        bmi = Double.parseDouble(df.format(bmi));

       bmiAdder += bmi;
       return bmi;
   }

    public String whereDoIStand(double data){

        String toReturn = "";

        if(data >= 30){
             toReturn = ("Obese = BMI of 30 or greater");
        }
        else if(data >=25){
             toReturn =("Overweight = 25–29.9 ");
        }
        else if(data >=18.5){
             toReturn = ("Normal weight = 18.5–24.9");
        }
        else{
             toReturn =("Underweight <= 18.5");
        }
        return toReturn;
    }

    public double getAvg(){
        return bmiAdder;
}



}
