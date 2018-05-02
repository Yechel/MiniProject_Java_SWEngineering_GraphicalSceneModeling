package Geometrics;

import Primitives.Point3D;
import Primitives.Ray;

import java.util.List;

public interface Geometry {
    public List<Point3D> findIntersections(Ray ray);
}
