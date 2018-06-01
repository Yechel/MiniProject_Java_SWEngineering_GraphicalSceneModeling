package Geometrics;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TriangleTest {
      public TriangleTest() throws Exception {
    }

    //tests:
    //crossing point
    //not crossing the plane ray
    //A ray that crossing the plane but not the triangle
    @Test
    public void findIntersections() throws Exception {
        ArrayList<Ray> ray_list = new ArrayList <>();
        ray_list.add( new Ray(new Vector(-1,1,-1), new Point3D(0,0,0)));
        ray_list.add( new Ray(new Vector(0,1,-1), new Point3D(0,0,0)));
        ray_list.add( new Ray(new Vector(1,1,-1), new Point3D(0,0,0)));
        ray_list.add( new Ray(new Vector(-1,0,-1), new Point3D(0,0,0)));
        ray_list.add( new Ray(new Vector(0,0,-1), new Point3D(0,0,0)));
        ray_list.add( new Ray(new Vector(1,0,-1), new Point3D(0,0,0)));
        ray_list.add( new Ray(new Vector(-1,-1,-1), new Point3D(0,0,0)));
        ray_list.add( new Ray(new Vector(0,-1,-1), new Point3D(0,0,0)));
        ray_list.add( new Ray(new Vector(1,-1,-1), new Point3D(0,0,0)));

        Triangle t = new Triangle(new Point3D(0, 100, -20),
                new Point3D(  100, -100, -20),
                new Point3D( -100, -100, -20));
        ArrayList<Point3D> intersections = new ArrayList <>()  ;
        for (Ray r:ray_list) {
            intersections.addAll(t.findIntersections(r));
        }
        assertTrue(intersections.size() == 9);


    }
}