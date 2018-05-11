package Geometrics;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TriangleTest {
    Triangle triangle = new Triangle(new Point3D(1, 1, 0), new Point3D(0, 1, 1), new Point3D(1, 0, 1));

    public TriangleTest() throws Exception {
    }

    //tests:
    //crossing point
    //not crossing the plane ray
    //A ray that crossing the plane but not the triangle
    @Test
    public void findIntersections() {
        //crossing point
        Ray ray = new Ray(new Vector(2, 2, 2), new Point3D(0, 0, 0));
        ArrayList <Point3D> list = (ArrayList <Point3D>) triangle.findIntersections(ray);
        assertTrue(!list.isEmpty());
        list.clear();

        //not crossing the plane ray
        ray.set_direction(new Vector(-2, -2, -2));
        list = (ArrayList <Point3D>) triangle.findIntersections(ray);
        assertTrue(list.isEmpty());
        list.clear();

        //A ray that crossing the plane but not the triangle
        ray.set_direction(new Vector(2, 2, -1));
        list = (ArrayList <Point3D>) triangle.findIntersections(ray);
        assertTrue(list.isEmpty());
        list.clear();
    }
}