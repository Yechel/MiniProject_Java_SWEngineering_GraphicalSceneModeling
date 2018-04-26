package Geometrics;

public abstract class RadialGeometry {

    protected double _radius;

    public RadialGeometry(double radius) {
        set_radius(radius);
    }

    public RadialGeometry() {
        set_radius(0);
    }

    public double get_radius() {
        return _radius;
    }

    public void set_radius(double _radius) {
        this._radius = _radius;
    }

    @Override
    public String toString() {
        return "RadialGeometry type, radius " + get_radius();
    }

    @Override
    public boolean equals(Object obj)  throws IllegalArgumentException  {
        if (obj instanceof RadialGeometry) {
            return get_radius() == ((RadialGeometry) obj).get_radius();
        }
      throw new IllegalArgumentException("RadialGeometry class Error : Cannot compare different type object");
    }
}
