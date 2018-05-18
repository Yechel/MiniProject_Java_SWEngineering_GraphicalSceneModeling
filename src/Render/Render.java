package Render;

import Geometrics.Geometry;
import Primitives.Color;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import Scene.Scene;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Render {
    private Scene _scene;
    private ImageWriter _imageWriter;


    public Scene get_scene() {
        return _scene;
    }

    public ImageWriter get_imageWriter() {
        return _imageWriter;
    }

    public void set_scene(Scene _scene) {
        this._scene = _scene;
    }

    public void set_imageWriter(ImageWriter _imageWriter) {
        this._imageWriter = _imageWriter;
    }

    public Render(Scene scene, ImageWriter imageWriter) {
        set_scene(scene);
        set_imageWriter(imageWriter);
    }

    public void renderImage() {


    }

   /*TODO: public void printGrid(interval) {}*/

    private Color calcColor(Point3D p) {
        return get_scene().get_ambientLight().getIntensity();
    }

    private Point3D getClosestPoint(List <Point3D> intersectionPoints) {
        double distance = Double.MAX_VALUE;
        Point3D P0 = get_scene().get_camera().get_P0();
        Point3D minDistancePoint = null;
        for (Point3D point : intersectionPoints)
            if (P0.distane(point) < distance) {
                minDistancePoint = new Point3D(point);
            }

        return minDistancePoint;
    }

    private ArrayList <Point3D> getSceneRayIntersections(Ray ray) {
        Iterator <Geometry> geometries = get_scene().getGeometriesIterator();
        ArrayList <Point3D> intersectionPoints = new ArrayList <>();
        while (geometries.hasNext()) {
            Geometry geometry = geometries.next();
            ArrayList <Point3D> geometryIntersectionPoints = (ArrayList <Point3D>) geometry.findIntersections(ray);
            addIntersectionPoints(intersectionPoints, geometryIntersectionPoints);
        }
        return intersectionPoints;
    }

    private void addIntersectionPoints(ArrayList <Point3D> toIntersectionPoints, ArrayList <Point3D> fromGeometryIntersectionPoints) {
        for (Point3D p : fromGeometryIntersectionPoints) {
            toIntersectionPoints.add(p);
        }
    }

   }


