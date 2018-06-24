package Geometrics;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.lang.reflect.Array;
import java.util.*;

import static java.lang.String.format;

public class Triangle implements Geometry {
    private Point3D _p1;
    private Point3D _p2;
    private Point3D _p3;

    /*constractors*/
    public Triangle(Point3D p1, Point3D p2, Point3D p3) throws Exception {
        Vector V = new Vector(p1, p2);
        Vector U = new Vector(p1, p3);
        Vector zero = new Vector(new Point3D(0, 0, 0));
        if (V.crossProduct(U).equals(zero)) {
            throw new Exception("Triangle Exeption: the points are in the same line");
        }
        set_p1(p1);
        set_p2(p2);
        set_p3(p3);
    }

    public Triangle() {
        set_p1(new Point3D(1, 1, 1));
        set_p2(new Point3D(1, 0, 1));
        set_p3(new Point3D(0, 1, 0));
    }

    /*getters*/

    public Point3D get_p1() {
        return new Point3D(_p1);
    }

    public Point3D get_p2() {
        return new Point3D(_p2);
    }

    public Point3D get_p3() {
        return new Point3D(_p3);
    }

    /*setters*/
    public void set_p1(Point3D _p1) {
        this._p1 = _p1;
    }

    public void set_p2(Point3D _p2) {
        this._p2 = _p2;
    }

    public void set_p3(Point3D _p3) {
        this._p3 = _p3;
    }


    @Override
    public boolean equals(Object obj) throws IllegalArgumentException {
        if (obj instanceof Triangle) {
            Vector V1 = new Vector(get_p1(), get_p2());
            Vector V2 = new Vector(get_p1(), get_p3());
            Vector V3 = new Vector(get_p3(), get_p2());
            Vector U1 = new Vector(((Triangle) obj).get_p1(), ((Triangle) obj).get_p2());
            Vector U2 = new Vector(((Triangle) obj).get_p1(), ((Triangle) obj).get_p2());
            Vector U3 = new Vector(((Triangle) obj).get_p1(), ((Triangle) obj).get_p2());
            double[] Len = new double[6];
            Len[0] = V1.length();
            Len[1] = V2.length();
            Len[2] = V3.length();
            Len[3] = U1.length();
            Len[4] = U2.length();
            Len[5] = U3.length();
            Arrays.sort(Len);
            for (int i = 0; i < 6; i = i + 2) {
                if (Len[i] != Len[i + 1]) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalArgumentException("the parameter isn't Triangle.");
    }

    @Override
    public String toString() {
        return format("Triangle that expands from P1:%s, P2:%s, P3:%s",
                get_p1().toString(),
                get_p2().toString(),
                get_p3().toString());
    }

    /**
     * @param ray the ray that need to check if cross the triangle
     * @return list that includes the point that cross, if exists.
     */
    @Override
    public List <Point3D> findIntersections(Ray ray) {
        Vector v1 = new Vector(get_p1(), ray.get_POO());
        Vector v2 = new Vector(get_p2(), ray.get_POO());
        Vector v3 = new Vector(get_p3(), ray.get_POO());
        Plane p = new Plane(get_p1(), get_p2(), get_p3());
        ArrayList <Point3D> list = (ArrayList <Point3D>) p.findIntersections(ray);
        if (list.isEmpty()) {
            return list;
        }
        Point3D point = list.get(0);
        Vector v = new Vector(point, ray.get_POO());
        Vector n1 = v1.crossProduct(v2).normalize();
        Vector n2 = v3.crossProduct(v1).normalize();
        Vector n3 = v2.crossProduct(v3).normalize();
        if (v.dotProduct(n1) * v.dotProduct(n2) > 0 && v.dotProduct(n2) * v.dotProduct(n3) > 0) {
            return list;
        }

        list.clear();
        return list;
    }
}//end of Triangle