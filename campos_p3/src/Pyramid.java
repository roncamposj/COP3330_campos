public class Pyramid extends Shape3D {
    private String name = "pyramid";
    private double length;
    private double height;
    private double width;

    public Pyramid (double length, double width, double height){
        this.name = name;
        this.length = length;
        this.height = height;
        this.width = width;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public double getArea(){
        return (length * width) + (length*Math.sqrt(Math.pow((width/2),2) + Math.pow(height, 2)))
                +(width*Math.sqrt(Math.pow(length/2, 2)+Math.pow(height,2)));
    }

    @Override
    public double getVolume(){
        return (length*width*height)/3;
    }
}
