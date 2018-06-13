package Geometrics;

import Primitives.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class Plane implements Geometry, FlatGeometry {
    private Vector _N;
    private Point3D _p0;
    private Material _material;
    private Color _emission;


    /*constructors*/
    public Plane() {
        set_N(new Vector());
        set_p0(new Point3D(0, 0, 0));
    }

    public Plane(Point3D p, Vector v, Material material,Color emission) {
        set_N(v);
        set_p0(p);
        set_material(material);
        set_emission(emission);
    }

    public Plane(Point3D p1, Point3D p2, Point3D p3) throws IllegalArgumentException {
        Vector V = new Vector(p2, p1);
        Vector U = new Vector(p3, p1);
        //if the vectors are parallel and cross the same point then they on the same line.
        if (Math.abs(V.dotProduct(U)) == 1) {
            throw new IllegalArgumentException("Plane Exeption: the points are in the same line");
        }
        set_N(V.crossProduct(U));
        set_p0(p1);
    }

    public Plane(Point3D p1, Point3D p2, Point3D p3, Material material,Color emission ) throws IllegalArgumentException {
       //TODO test that line
        Vector V = new Vector(p2, p1);
        Vector U = new Vector(p3, p1);
        //if the vectors are parallel and cross the same point then they on the same line.
        if (Math.abs(V.dotProduct(U)) == 1) {
            throw new IllegalArgumentException("Plane Exeption: the points are in the same line");
        }
        set_N(V.crossProduct(U));
        set_p0(p1);
        set_material(material);
        set_emission(emission);

    }

    public Plane(Plane p) {
        set_N(p.get_N());
        set_p0(p.get_p0());
    }

    /*getters*/
    public Vector get_N() {
        return new Vector(_N);
    }

    public Point3D get_p0() {
        return new Point3D(_p0);
    }

    /*setters*/
    public void set_N(Vector n) {
        _N = n.normalize();
    }

    public void set_p0(Point3D _p0) {
        this._p0 = _p0;
    }

    /**
     * two Planes are equal if the vector V (a vector that connect point in one plane and point from the other plane)
     * dot product with the normal is 0.
     *
     * @param obj
     * @return
     * @throws IllegalArgumentException
     */
    //TODO reimplement
    @Override
    public boolean equals(Object obj) throws IllegalArgumentException {
        if (obj instanceof Plane) { //Planes are equal if they parallel and the they had the sme normalize vector
            if (get_p0().equals(((Plane) obj).get_p0())) {
                return (get_N().equals(((Plane) obj).get_N().scale(-1)) ||
                        get_N().equals(((Plane) obj).get_N()));
            }
            Vector V = new Vector(((Plane) obj).get_p0(), get_p0());
            return (V.dotProduct(get_N()) == 0);
        }
        throw new IllegalArgumentException("the Parameter isnt Plane");
    }

    @Override
    public String toString() {
        return format("Plane that expands from P0:%s and Normal:%s",
                get_p0().toString(),
                get_N().toString());
    }

    /**
     * @param ray - aray that needs to check if it intersect with the Plane.
     * @return list of one point if there is intersection or no points in there isn't.
     */
    @Override
    public List <Point3D> findIntersections(Ray ray) throws IllegalArgumentException {
        ArrayList <Point3D> intersections = new ArrayList <>();
        if (ray.get_direction().dotProduct(get_N()) == 0) { // the ray and the plane are parallel
            return intersections;
        }
        if (ray.get_POO().equals(get_p0())) {
           intersections.add(new Point3D(0,0,0));
            return intersections;
        }
        Vector u = new Vector(ray.get_POO(), get_p0());
        double t = get_N().scale(-1).dotProduct(u);
        t = t / (get_N().dotProduct(ray.get_direction()));
        if (t> 0)
        {
            Point3D p = ray.get_POO().add(ray.get_direction().scale(t));
            intersections.add(p);
        }
        return intersections;
    }

    @Override
    public Vector getNormal(Point3D point) {
        return new Vector(get_N());
    }

    @Override
    public Material get_material() {
        return new Material(_material);
    }

    @Override
    public void set_material(Material material) {
        _material = material;
    }

    @Override
    public Color get_emission() {
        return new Color(_emission);
    }


    @Override
    public void set_emission(Color emission) {
        _emission = emission;
    }



}
//
//public class Plane implements Geometry{
//    private Point3D _p1;
//    private Point3D _p2;
//    private Point3D _p3;
//
//    /*constructors*/
//    public Plane(Point3D p1, Point3D p2, Point3D p3) throws Exception {
//        Vector V = new Vector(p1,p2);
//        Vector U = new Vector(p1,p3);
//        //if the vectors are parallel and cross the same point then they on the same line.
//        if (V.dotProduct(U)==0) {
//            throw new Exception("Plane Exeption: the points are in the same line");
//        }
//        set_p1(p1);
//        set_p2(p2);
//        set_p3(p3);
//    }
//    public Plane() {
//        set_p1(new Point3D(0,0,1));
//        set_p2(new Point3D(1,0,1));
//        set_p3(new Point3D(0,1,1));
//    }
//
//    /*getters*/
//
//    public Point3D get_p1() {
//        return _p1;
//    }
//
//    public Point3D get_p2() {
//        return _p2;
//    }
//
//    public Point3D get_p3() {
//        return _p3;
//    }
//
//    /*setters*/
//    public void set_p1(Point3D _p1) {
//        this._p1 = _p1;
//    }
//
//    public void set_p2(Point3D _p2) {
//        this._p2 = _p2;
//    }
//
//    public void set_p3(Point3D _p3) {
//        this._p3 = _p3;
//    }
//
//    @Override
//    public boolean equals(Object obj) throws IllegalArgumentException {
//        if (obj instanceof Plane) { //Palanes are equal if they parallel and the they had the sme normalize vector
//            if (this.getNormal().equals(((Plane) obj).getNormal())) {
//                if (getDistance((Plane) obj) == 0) {
//                    return true;
//                }
//            }
//            return false;
//        }
//        throw new IllegalArgumentException("the Parameter isnt Plane");
//    }
//
//    @Override
//    public String toString() {
//        return format("Plane that expands from P1:%s, P2:%s, P3:%s",
//                get_p1().toString(),
//                get_p2().toString(),
//                get_p3().toString());
//    }
//
//
//    public Vector getNormal() {
//        Vector U = new Vector(get_p1(),get_p2());
//        Vector V = new Vector(get_p1(),get_p3());
//        Vector N = U.crossProduct(V);
//        N.normalize();
//        N.scale(-1);
//        return N;
//    }
//
//    protected double getDistance(Plane p){
//        Vector N1 = getNormal();
//        Vector N2 = p.getNormal();
//        if (!N1.equals(N2)){ //not parallel
//            return 0;
//        }
//        Coordinate a2x1 = N2.get_head().get_x().mult(get_p1().get_x());
//        Coordinate b2y1 = N2.get_head().get_y().mult(get_p1().get_y());
//        Coordinate c2z1 = N2.get_head().get_z().mult(get_p1().get_z());
//        Coordinate d = new Coordinate( N1.dotProduct(new Vector(get_p1()))*-1);
//        return Math.abs((a2x1.add(b2y1).add(c2z1).add(d)).get_coordinate())/ N2.length();
//    }
//
//
//    @Override
//    public List <Point3D> findIntersections(Ray ray) {
//        return null;
//    }
//}