import static java.lang.Math.*;

public class Circle extends Shape2D{
    private String name = "circle";
    private double radius;


    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public double getArea(){
        return radius * Math.PI * radius;
    }
}

