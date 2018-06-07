package Geometrics;

import Primitives.*;

import java.util.List;

public interface Geometry {


    public List <Point3D> findIntersections(Ray ray);

    public Vector getNormal(Point3D point);

    public  void set_material(Material material);

    public  Material get_material();

    public  void set_emission(Color color);

    public  Color get_emission();


}
