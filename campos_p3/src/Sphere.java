public class Sphere extends Shape3D{
    private String name = "sphere";
    private double radius;

    public Sphere (double radius){
        this.name = name;
        this.radius = radius;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public double getArea(){
        return 4 * Math.PI * Math.pow(radius,2);

    }

    @Override
    public double getVolume(){
        return (4 * (Math.PI/3) * Math.pow(radius,3));
    }
}
