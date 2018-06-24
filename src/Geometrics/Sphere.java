package Geometrics;

import Primitives.*;
import Primitives.Vector;

import java.util.*;

public class Sphere extends RadialGeometry {

    private Point3D _center;

    ///////////////////////////
    //////////getters//////////
    ///////////////////////////

    public Point3D get_center() {
        return new Point3D(_center);
    }

    ////////////////////////////
    //////////setters//////////
    ///////////////////////////

    public void set_center(Point3D _center) {
        this._center = _center;
    }

    ////////////////////////////
    ////////constructors////////
    ///////////////////////////


    public Sphere(double radius, Point3D center, Material material, Color emission) {
        super(radius);
        set_center(center);
        set_material(material);
        set_emission(emission);

    }

    public Sphere() {
        super();
        set_center(new Point3D(0, 0, 0));
        set_material(new Material());
        set_emission(new Color());
    }

    ///////////////////////////


    @Override
    public String toString() {
        return String.format("Sphere: radius=%s, center=%s.", get_radius(), get_center());
    }


    @Override
    public boolean equals(Object obj) throws IllegalArgumentException {
        if (obj instanceof Sphere) {
            return (get_radius() == ((Sphere) obj).get_radius() &&
                    get_center() == ((Sphere) obj).get_center());
        }
        throw new IllegalArgumentException("the parameter is not Sphere");
    }


    /**
     * @param ray
     * @return list of points that intersect with the given raty
     */
    @Override
    public List <Point3D> findIntersections(Ray ray) {
        ArrayList <Point3D> point3DList = new ArrayList <Point3D>();
        Vector L = new Vector(get_center(), ray.get_POO());
        double tm = L.dotProduct(ray.get_direction());
        double d = Math.sqrt(Math.pow(L.length(), 2) - Math.pow(tm, 2));
        if (d > get_radius()) {
            return point3DList;
        }
        double th = Math.sqrt(Math.pow(get_radius(), 2) - Math.pow(d, 2));
        double[] t = new double[2];
        t[0] = tm - th;
        t[1] = tm + th;
        for (double i : t) {
            if (i >= 0) {
                point3DList.add(ray.get_POO().add(ray.get_direction().scale(i)));
            }
        }
        return point3DList;
    }

    @Override
    public Vector getNormal(Point3D point) {
        return new Vector(point, get_center()).normalize();
    }


}
