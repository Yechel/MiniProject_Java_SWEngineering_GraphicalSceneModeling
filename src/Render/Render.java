package Render;

import Geometrics.Geometry;
import Primitives.Color;
import Primitives.Point3D;
import Primitives.Ray;
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
        for (int i = 0; i < get_imageWriter().get_Nx(); i++) {
            for (int j = 0; j < get_imageWriter().get_Ny(); j++) {
                Ray ray = get_scene().get_camera().constructRayThroughPixel
                        (get_imageWriter().get_Nx(),
                                get_imageWriter().get_Ny(),
                                i, j,
                                get_scene().get_screenDistance(),
                                get_imageWriter().get_imageWidth(),
                                get_imageWriter().get_imageHeight());
                List <Point3D> intersectionPoints = getSceneRayIntersections(ray);
                if (intersectionPoints.isEmpty()) {
                    get_imageWriter().writePixel(j, i, get_scene().get_background());
                } else {
                    Point3D closestPoint = getClosestPoint(intersectionPoints);
                    get_imageWriter().writePixel(j, i, calcColor(closestPoint));
                }
            }

        }


    }

    public void printGrid(int interval) {
        Color color = new Color(get_scene().get_ambientLight().getIntensity().get_color());
        for (int y = 0; y < get_imageWriter().get_Ny(); y++) {
            if (y % interval == 0) {
                //set line
                for (int x = 0; x < get_imageWriter().get_Nx(); x++) {
                    get_imageWriter().writePixel(x, y, color.get_color());
                }
            } else {
                for (int x = 0; x < get_imageWriter().get_Nx(); x = x + interval) {
                    get_imageWriter().writePixel(x, y, color.get_color());
                }
            }

        }

    }

    private java.awt.Color calcColor(Point3D p) {
        return get_scene().get_ambientLight().getIntensity().get_color();
    }

    private Point3D getClosestPoint(List <Point3D> intersectionPoints) {
        double distance = Double.MAX_VALUE;
        Point3D P0 = get_scene().get_camera().get_P0();
        Point3D minDistancePoint = null;
        for (Point3D point : intersectionPoints)
            if (P0.distance(point) < distance) {
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


