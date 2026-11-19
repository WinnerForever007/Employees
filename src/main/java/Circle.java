public class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    //Exercise 3.2
    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return radius * radius * Math.PI;
    }
}
