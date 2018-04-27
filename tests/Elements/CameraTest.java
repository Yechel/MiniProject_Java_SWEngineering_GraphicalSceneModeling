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
        Vector exp = new Vector(1 / Math.sqrt(6), 1 / Math.sqrt(6), -Math.sqrt(2 / 3));
        assertTrue(ray.get_direction().equals(exp));
    }
}