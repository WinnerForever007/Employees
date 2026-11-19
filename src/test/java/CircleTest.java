import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    //Exercise 3.1
    @Test
    void testShapeArray() {
        final int COUNT = 4;
        Shape[] shapes = new Shape[COUNT];
        shapes[0] = new Circle(3.8);
        shapes[1] = new Triangle(3, 7);
        shapes[2] = new Rectangle(5.6, 7.8);
        shapes[3] = new Rectangle(4.8, 5.2);
        double sum = 0;
        for(int i = 0; i < COUNT; i++) {
            sum += shapes[i].area();
        }
        assertEquals(124.5046, sum, 0.0001);
    }


}