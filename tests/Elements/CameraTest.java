package Elements;

import Primitives.Ray;
import Primitives.Vector;
import org.junit.Test;

import static org.junit.Assert.*;

public class CameraTest {
    Camera cam = new Camera();
    @Test
    public void constructRayThroughPixel() {
        Ray ray = cam.constructRayThroughPixel(3, 3, 3, 3, 100, 150, 150);
        double d = Math.sqrt(2)/Math.sqrt(3);
        Vector exp = new Vector(1 / Math.sqrt(6), 1 / Math.sqrt(6), -d);
        assertEquals("",
                exp.get_head().get_up().get_coordinate(),
                ray.get_direction().get_head().get_up().get_coordinate(),
                1e-10);
        assertEquals("",
                exp.get_head().get_right().get_coordinate(),
                ray.get_direction().get_head().get_right().get_coordinate(),
                1e-10);
        assertEquals("",
                exp.get_head().get_to().get_coordinate(),
                ray.get_direction().get_head().get_to().get_coordinate(),
                1e-10);
            }





}