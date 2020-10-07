public class Cube extends Shape3D {
    private String name = "cube";
    private double area;

    public Cube(double area){
        this.name = name;
        this.area = area;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public double getArea(){
        return 6 * area * area;
    }

    @Override
    public double getVolume(){
        return area * area * area;
    }
}
