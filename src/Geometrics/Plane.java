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


    ///////////////////////////
    //////////getters//////////
    ///////////////////////////
    public Vector get_N() {
        return new Vector(_N);
    }

    public Point3D get_p0() {
        return new Point3D(_p0);
    }

    @Override
    public Material get_material() {
        return new Material(_material);
    }

    @Override
    public Color get_emission() {
        return new Color(_emission);
    }

    ////////////////////////////
    //////////setters//////////
    ///////////////////////////

    public void set_N(Vector n) {
        _N = n.normalize();
    }

    public void set_p0(Point3D _p0) {
        this._p0 = _p0;
    }

    @Override
    public void set_emission(Color emission) {
        _emission = emission;
    }

    @Override
    public void set_material(Material material) {
        _material = material;
    }

    ////////////////////////////
    ////////constructors////////
    ///////////////////////////
   /* public Plane() {
        set_N(new Vector());
        set_p0(new Point3D(0, 0, 0));
    }*/
     /*  public Plane(Plane p) {
        set_N(p.get_N());
        set_p0(p.get_p0());
    }*/


    public Plane(Point3D p, Vector v, Material material, Color emission) {
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
    ///////////////////////////


    /**
     * two Planes are equal if the vector V (a vector that connect point in one plane and point from the other plane)
     * dot product with the normal is 0.
     *
     * @param obj
     * @return
     * @throws IllegalArgumentException
     */
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
            intersections.add(new Point3D(0, 0, 0));
            return intersections;
        }
        Vector u = new Vector(ray.get_POO(), get_p0());
        double t = get_N().scale(-1).dotProduct(u);
        t = t / (get_N().dotProduct(ray.get_direction()));
        if (t > 0) {
            Point3D p = ray.get_POO().add(ray.get_direction().scale(t));
            intersections.add(p);
        }
        return intersections;
    }

    @Override
    public Vector getNormal(Point3D point) {
        return new Vector(get_N());
    }


}
