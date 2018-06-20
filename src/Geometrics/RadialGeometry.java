package Geometrics;

import Primitives.Color;
import Primitives.Material;

public abstract class RadialGeometry implements Geometry{

    double _radius;
    private Material _material;
    private Color _emission;

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


    public Material get_material() {
        return new Material(_material);
    }


    public void set_material(Material material) {
        _material = material;
    }


    public Color get_emission() {
        return new Color(_emission);
    }


    public void set_emission(Color emission) {
        _emission = emission;
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
