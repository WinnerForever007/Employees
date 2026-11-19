public class Rectangle implements Shape {
    private final double width;
    private final double height;

    //Exercise 2.1
    public Rectangle(double width, double height) {
        //width = width;
        //height = height;
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

}
