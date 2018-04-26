package Geometrics;

import Primitives.Point3D;

public class Sphere extends RadialGeometry  {
    private Point3D _center;

    public Point3D get_center() {
        return _center;
    }

    public void set_center(Point3D _center) {
        this._center = _center;
    }

    public Sphere(double radius , Point3D center) {
        super(radius);
        set_center(center);
    }

    public Sphere() {
        super();
        set_center(new Point3D(0,0,0));
    }

    @Override
    public String toString(){
         return String.format( "Sphere: radius=%s, center=%s.", get_radius(),get_center());
    }


    @Override
    public boolean equals(Object obj) throws IllegalArgumentException{
        if (obj instanceof Sphere) {
            return (get_radius() == ((Sphere) obj).get_radius() &&
                    get_center() == ((Sphere) obj).get_center());
        }
        throw new IllegalArgumentException("the parameter is not Sphere");
    }
}
