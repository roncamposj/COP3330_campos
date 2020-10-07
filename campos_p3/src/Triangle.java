public class Triangle extends Shape2D {
 private String name = "triangle";
 private double height;
 private double base;


    public Triangle(double height,double base){
        this.height = height;
        this.base =  base;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public double getArea(){
        return (height *(base/2));
    }
}
