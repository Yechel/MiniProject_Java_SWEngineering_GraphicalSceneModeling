package Geometrics;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
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
   - the ray comes out from the plane
   */
    @Test
    public void findIntersections1() {
        ArrayList <Ray> ray_list = new ArrayList <>();
        ray_list.add(new Ray(new Vector(-1, 1, -1), new Point3D(0, 0, 0)));
        ray_list.add(new Ray(new Vector(0, 1, -1), new Point3D(0, 0, 0)));
        ray_list.add(new Ray(new Vector(1, 1, -1), new Point3D(0, 0, 0)));
        ray_list.add(new Ray(new Vector(-1, 0, -1), new Point3D(0, 0, 0)));
        ray_list.add(new Ray(new Vector(0, 0, -1), new Point3D(0, 0, 0)));
        ray_list.add(new Ray(new Vector(1, 0, -1), new Point3D(0, 0, 0)));
        ray_list.add(new Ray(new Vector(-1, -1, -1), new Point3D(0, 0, 0)));
        ray_list.add(new Ray(new Vector(0, -1, -1), new Point3D(0, 0, 0)));
        ray_list.add(new Ray(new Vector(1, -1, -1), new Point3D(0, 0, 0)));

        ArrayList <Point3D> intersections = new ArrayList <>();
        Plane p = new Plane(new Point3D(0, 0, -1), new Vector(0, 0, 1));

        for (Ray r : ray_list) {
            intersections.addAll(p.findIntersections(r));
        }
        assertTrue(intersections.size() == 9);

        p.set_N(new Vector(0.5, 0, -1));
        intersections.clear();
        for (Ray r : ray_list) {
            addAll(p.findIntersections(r), intersections);
        }
        assertTrue(intersections.size() == 9);

        p.set_N(new Vector(1, 0, -1));
        intersections.clear();
        for (Ray r : ray_list) {
            addAll(p.findIntersections(r), intersections);
        }
        assertTrue(intersections.size() == 6);

        p.set_N(new Vector(1, 0, 0));
        intersections.clear();
        for (Ray r : ray_list) {
            addAll(p.findIntersections(r), intersections);
        }
        assertTrue(intersections.isEmpty());

        p.set_N(new Vector(0, 0, -1));
        p.set_p0(new Point3D(0,0,0));
        intersections.clear();
        for (Ray r : ray_list) {
            addAll(p.findIntersections(r), intersections);
        }
        assertTrue(intersections.size() == 9);

        p.set_p0(new Point3D(0,0,1));
        intersections.clear();
        for (Ray r : ray_list) {
            addAll(p.findIntersections(r), intersections);
        }
        assertTrue(intersections.isEmpty());


            }//end of find intersection

        private void addAll (List < Point3D > from, ArrayList < Point3D > to){
            while (!from.isEmpty()) {
                to.add(from.get(0));
                from.remove(0);
            }
        }


}