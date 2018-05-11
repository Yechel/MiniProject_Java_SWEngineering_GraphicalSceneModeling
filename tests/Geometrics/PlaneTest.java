package Geometrics;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

public class PlaneTest {

    Plane tester = new Plane(new Point3D(1,0,0),new Vector(new Point3D(0,4,3)));

    @Test
    public void equals() {
        Plane true_test = new Plane(new Point3D(2,0,0),new Vector(new Point3D(0,4,3)));
        Plane false_test = new Plane(new Point3D(1,0,0),new Vector(new Point3D(1,4,3)));
        assertTrue(tester.equals(tester));
        assertTrue(tester.equals(true_test));
        assertTrue(true_test.equals(tester));
        assertFalse(tester.equals(false_test));
        assertFalse(false_test.equals(tester));
    }

    /*
    testing:
   - parallel Ray
   - crossing Ray
   - some intersect Ray
   - non intersect Ray
   - ray that comes out from the plane
   - the point of the ray is the point of the plane
   */
    @Test (expected = IllegalArgumentException.class)
    public void findIntersections() {
        ArrayList<Point3D> list;

        //parallel
        Point3D p = tester.get_p0().scale(3);
        Vector v = new Vector(tester.get_p0(),p);
        v.normalize();
        Ray ray = new Ray(v,new Point3D(0,0,0));
        list = (ArrayList <Point3D>) tester.findIntersections(ray);
        assertTrue(list.isEmpty());
        list.clear();

        //cross
        ray.set_direction(tester.get_N());
        ray.set_POO(tester.get_p0().add(tester.get_N().scale(-1)));
        list = (ArrayList <Point3D>) tester.findIntersections(ray);
        assertTrue(list.get(0).equals(tester.get_p0()));
        list.clear();
//TODO these tests
      /*  //some intersect Ray
        Plane tester2 = new Plane(new Point3D(1,2,4),new Vector(new Point3D(0,4,3)));
        ray.set_direction(new Vector(new Point3D(20,20,20)));
        ray.set_POO(new Point3D(0,0,0));
        list = (ArrayList <Point3D>) tester.findIntersections(ray);
        Point3D point = tester2.get_p0().subtract(new Vector(list.get(0)));
        assertTrue(tester2.get_N().dotProduct(new Vector(point))==0);
        list.clear();


        //Ray that comes out from the plane
        ray.set_direction(new Vector(new Point3D(1,1,1)));
        ray.set_POO(new Point3D(0,0,0));
        list = (ArrayList <Point3D>) tester.findIntersections(ray);
        assertTrue(list.isEmpty());
        list.clear();

        //non intersect Ray


*/
     //the point of the ray is the point of the plane - throw exeption
        ray.set_POO(tester.get_p0());
        list = (ArrayList <Point3D>) tester.findIntersections(ray);
    }


}