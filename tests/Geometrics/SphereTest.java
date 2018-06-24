package Geometrics;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SphereTest {

    @Test
    public void findIntersections() {
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

        Sphere s = new Sphere(1,new Point3D(0,0,-3));
        ArrayList<Point3D> intersections = new ArrayList <>()  ;
        for (Ray r:ray_list) {
            intersections.addAll(s.findIntersections(r));
        }
        assertTrue(intersections.size() == 2);

        s.set_radius(2.5);
        s.set_center(new Point3D(0,0,-3));
        intersections.clear();
        for (Ray r:ray_list) {
            addAll(s.findIntersections(r) ,intersections);
        }
        assertTrue(intersections.size() == 18);

        s.set_radius(2.5);
        s.set_center(new Point3D(0,0,-3));
        intersections.clear();
        for (Ray r:ray_list) {
            addAll(s.findIntersections(r) ,intersections);
        }
        assertTrue(intersections.size() == 18);

        s.set_radius(2);
        s.set_center(new Point3D(0,0,-2.5));
        intersections.clear();
        for (Ray r:ray_list) {
            addAll(s.findIntersections(r) ,intersections);
        }
        assertTrue(intersections.size() == 10);


        s.set_radius(4);
        s.set_center(new Point3D(0,0,-1));
        intersections.clear();
        for (Ray r:ray_list) {
            addAll(s.findIntersections(r) ,intersections);
        }
        assertTrue(intersections.size() == 9);


        s.set_radius(1);
        s.set_center(new Point3D(0,0,2));
        intersections.clear();
        for (Ray r:ray_list) {
            addAll(s.findIntersections(r) ,intersections);
        }
        assertTrue(intersections.isEmpty());


        //Ray.p0 is in the  surface from inside -> every 9 of the rays are intersect in (0,0,0)
        s.set_radius(1);
        s.set_center(new Point3D(0,0,1));
        intersections.clear();
        for (Ray r:ray_list) {
            addAll(s.findIntersections(r) ,intersections);
        }
        assertTrue(intersections.size() == 9);

        //Ray.p0 is in the surface from outside
        s.set_radius(1);
        s.set_center(new Point3D(0,0,-1));
        intersections.clear();
        for (Ray r:ray_list) {
            addAll(s.findIntersections(r) ,intersections);
        }
        assertTrue(intersections.size() == 18);
    }



    private void addAll(List<Point3D> from, ArrayList<Point3D> to) {
        while(!from.isEmpty())
        {
            to.add(from.get(0));
            from.remove(0);
        }
    }
}