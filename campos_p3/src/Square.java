public class Square extends Shape2D {
    private String name = "square";
    private double length;

    public Square(double length){
        this.length = length;
    }

    @Override
    public String getName(){
      return name;
    }


    @Override
    public double getArea(){
        return length*length;
    }
}
