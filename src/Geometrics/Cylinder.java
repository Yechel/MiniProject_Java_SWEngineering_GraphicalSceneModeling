package Geometrics;

import Primitives.Point3D;
import Primitives.Vector;

public class Cylinder extends RadialGeometry {
    private Point3D _axisPoint;
    private Vector _axisDirection;


    public Point3D get_axisPoint() {
        return _axisPoint;
    }

    public Vector get_axisDirection() {
        return _axisDirection;
    }

    public void set_axisPoint(Point3D _axisPoint) {
        this._axisPoint = _axisPoint;
    }


    public void set_axisDirection(Vector _axisDirection) {
        this._axisDirection = _axisDirection;
    }

    public Cylinder() {
        super();
        set_axisPoint(new Point3D(0, 0, 1));
        set_axisDirection(new Vector(get_axisPoint()));
        _axisDirection.normalize();
    }

    public Cylinder(Point3D axisPoint, Vector axisDirection, double radius) {
        super(radius);
        set_axisDirection(axisDirection);
        set_axisPoint(axisPoint);
        _axisDirection.normalize();
    }




    /**
     * Cylinders are equal if they have the same radius,
     * the same direction,
     * and thier points are in the same line (UV) (=> UV.dotproduct(dirction) == 0).
     * @param obj The Cylinder to compare with
     * @return true - if the Cylinders are equal, false - if not.
     * @throws ExceptionInInitializerError if obj isn't Cylinder.
     */
    @Override
    public boolean equals(Object obj) throws IllegalArgumentException {
        if (obj instanceof Cylinder) {
            if (get_axisDirection() == ((Cylinder) obj).get_axisDirection()) {
                Vector V = new Vector(get_axisPoint(), ((Cylinder) obj).get_axisPoint());
                if (V.dotProduct(get_axisDirection()) == 0)
                if (get_radius() == ((Cylinder) obj).get_radius()) {
                    return true;
                }
            }
        }
        throw new IllegalArgumentException("the object is not Cylinder type");
    }

    @Override
    public String toString() {
        return String.format("Cylinder: r=%s, center=%s, direction=%s.", get_radius(), get_axisPoint(), get_axisDirection());
    }
}
