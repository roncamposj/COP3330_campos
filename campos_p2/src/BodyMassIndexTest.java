import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class BodyMassIndexTest {

    double height, weight;

    @Test
    void testBMI() {
        height = 72;
        weight = 200;
        BodyMassIndex i = new BodyMassIndex(height, weight);
        double testBmi = i.returnBmi();


        assertEquals(testBmi, 27.13);

    }


    @Test
    void obeseCategory() {
        double bmiCategory = 42.02;
        BodyMassIndex i = new BodyMassIndex(0, 0);
        assertEquals(i.whereDoIStand(bmiCategory), "Obese = BMI of 30 or greater");

    }
    @Test
    void overweightCategory() {
        double bmiCategory = 28.13;
        BodyMassIndex i = new BodyMassIndex(0, 0);
        assertEquals(i.whereDoIStand(bmiCategory), "Overweight = 25–29.9 ");
    }
        @Test
    void normalCategory() {
        double bmiCategory = 22.55;
        BodyMassIndex i = new BodyMassIndex(0, 0);
        assertEquals(i.whereDoIStand(bmiCategory), "Normal weight = 18.5–24.9");

    }
    @Test
    void underweightCategory() {
        double bmiCategory = 16;
        BodyMassIndex i = new BodyMassIndex(0, 0);
        assertEquals(i.whereDoIStand(bmiCategory), "Underweight <= 18.5");

    }

    @Test
    void testBmiAdder(){
        BodyMassIndex i = new BodyMassIndex(0, 0);
        assertEquals(i.getAvg(),(0.0));        //since my actual average calculator is in main class,
                                              //I'm testing getAvg() just to ensure it returns a double.

    }
}
