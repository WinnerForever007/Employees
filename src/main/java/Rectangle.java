public class Rectangle {
    private int width;
    private int height;

    //Exercise 2.1
    public Rectangle(int width, int height) {
        //width = width;
        //height = height;
        this.width = width;
        this.height = height;
        System.out.println(area());
    }

    public int area() {
        return width * height;
    }

}
