package Geometrics;

import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Vector;

import static java.lang.String.format;

public class Plane {
    private Point3D _p1;
    private Point3D _p2;
    private Point3D _p3;

    /*constructors*/
    public Plane(Point3D p1, Point3D p2, Point3D p3) throws Exception {
        Vector V = new Vector(p1,p2);
        Vector U = new Vector(p1,p3);
        //if the vectors are parallel and cross the same point then they on the same line.
        if (V.dotProduct(U)==0) {
            throw new Exception("Plane Exeption: the points are in the same line");
        }
        set_p1(p1);
        set_p2(p2);
        set_p3(p3);
    }
    public Plane() {
        set_p1(new Point3D(0,0,1));
        set_p2(new Point3D(1,0,1));
        set_p3(new Point3D(0,1,1));
    }

    /*getters*/

    public Point3D get_p1() {
        return _p1;
    }

    public Point3D get_p2() {
        return _p2;
    }

    public Point3D get_p3() {
        return _p3;
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
        if (obj instanceof Plane) { //Palanes are equal if they parallel and the they had the sme normalize vector
            if (this.getNormal().equals(((Plane) obj).getNormal())) {
                if (getDistance((Plane) obj) == 0) {
                    return true;
                }
            }
            return false;
        }
        throw new IllegalArgumentException("the Parameter isnt Plane");
    }

    @Override
    public String toString() {
        return format("Plane that expands from P1:%s, P2:%s, P3:%s",
                get_p1().toString(),
                get_p2().toString(),
                get_p3().toString());
    }


    public Vector getNormal() {
        Vector U = new Vector(get_p1(),get_p2());
        Vector V = new Vector(get_p1(),get_p3());
        Vector N = U.crossProduct(V);
        N.normalize();
        N.scale(-1);
        return N;
    }

    protected double getDistance(Plane p){
        Vector N1 = getNormal();
        Vector N2 = p.getNormal();
        if (!N1.equals(N2)){ //not parallel
            return 0;
        }
        Coordinate a2x1 = N2.get_head().get_x().mult(get_p1().get_x());
        Coordinate b2y1 = N2.get_head().get_y().mult(get_p1().get_y());
        Coordinate c2z1 = N2.get_head().get_z().mult(get_p1().get_z());
        Coordinate d = new Coordinate( N1.dotProduct(new Vector(get_p1()))*-1);
        return Math.abs((a2x1.add(b2y1).add(c2z1).add(d)).get_coordinate())/ N2.length();
    }

}
