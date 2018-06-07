package Render;

import Elements.LightSource;
import Geometrics.Geometry;
import Primitives.Color;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import Scene.Scene;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

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
                        (get_imageWriter().get_Nx(), get_imageWriter().get_Ny(),
                                i, j, get_scene().get_screenDistance(),
                                get_imageWriter().get_imageWidth(), get_imageWriter().get_imageHeight());
                HashMap <Geometry, ArrayList <Point3D>> intersectionPoints = new HashMap <>();
                get_scene().get_geometries().forEach(geometry -> {
                    ArrayList <Point3D> geometryIntersectionPoints = (ArrayList <Point3D>) geometry.findIntersections(ray);
                    if (!geometryIntersectionPoints.isEmpty()) {
                        intersectionPoints.put(geometry, geometryIntersectionPoints);
                    }
                });
                if (intersectionPoints.isEmpty()) {
                    get_imageWriter().writePixel(j, i, get_scene().get_background());
                } else {
                    HashMap <Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints);
                    Geometry key = (Geometry) closestPoint.keySet().toArray()[0];
                    Point3D value = closestPoint.get(key);
                    get_imageWriter().writePixel(j, i, calcColor(key, value));
                }
            }

        }


    }

    public void printGrid(int interval ,Color color) {
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

    public void printGrid(int interval) {
        printGrid(interval,get_scene().get_ambientLight().get_color());
    }

    private java.awt.Color calcColor(Geometry geometry, Point3D p) {
        Color ambientLight = get_scene().get_ambientLight().getIntensity();
        Color emissionLight = geometry.get_emission();
        Vector n = geometry.getNormal(p);
        int nShininess = geometry.get_material().get_nShininess();
        double kd = geometry.get_material().get_Kd();
        double ks = geometry.get_material().get_Ks();
        Color color = new Color(ambientLight.add(emissionLight).get_color());
        for (LightSource lightSrc : get_scene().get_lights()) {
            Color lightIntensity = lightSrc.getIntensity(p);
            Vector l = lightSrc.getL(p);
            Vector v = new Vector(p, get_scene().get_camera().get_P0()).normalize();
            color.add(calcDiffusive(kd, l, n, lightIntensity));
            color.add(calcSpecular(ks, l, n, v, nShininess, lightIntensity));
        }
        return color.get_color();
    }

    private Color calcSpecular(double ks, Vector l, Vector n, Vector v, int nShininess, Color lightIntensity) {
        Vector r = l.subtract(n.scale(l.dotProduct(n)).scale(2));
        double vectorProduct = Math.pow(r.dotProduct(v.scale(-1)), nShininess);
        return lightIntensity.scale(vectorProduct).scale(ks);
    }

    private Color calcDiffusive(double kd, Vector l, Vector n, Color lightIntensity) {
        return lightIntensity.scale(kd).scale(l.dotProduct(n));
    }

    private HashMap <Geometry, Point3D> getClosestPoint(HashMap <Geometry, ArrayList <Point3D>> intersectionPoints) {
        final double[] distance = {Double.MAX_VALUE};
        Point3D P0 = get_scene().get_camera().get_P0();
        HashMap <Geometry, Point3D> minDistancePoint = new HashMap <>();


        intersectionPoints.forEach((Geometry geometry, ArrayList <Point3D> points) ->
        {
            points.forEach((Point3D point) -> {
                if (P0.distance(point) < distance[0]) {
                    minDistancePoint.clear();
                    minDistancePoint.put(geometry, new Point3D(point));
                    distance[0] = P0.distance(point);
                }
            });
        });
        return minDistancePoint;
    }

    private void addIntersectionPoints
            (ArrayList <Point3D> toIntersectionPoints, ArrayList <Point3D> fromGeometryIntersectionPoints) {
        for (Point3D p : fromGeometryIntersectionPoints) {
            toIntersectionPoints.add(p);
        }
    }

}


/*
    private ArrayList <Point3D> getSceneRayIntersections(Ray ray) {
        Iterator <Geometry> geometries = get_scene().getGeometriesIterator();
        ArrayList <Point3D> intersectionPoints = new ArrayList <>();


        while (geometries.hasNext()) {
            Geometry geometry = geometries.next();
            ArrayList <Point3D> geometryIntersectionPoints = (ArrayList <Point3D>) geometry.findIntersections(ray);
            addIntersectionPoints(intersectionPoints, geometryIntersectionPoints);
        }
        return intersectionPoints;
    }*/
