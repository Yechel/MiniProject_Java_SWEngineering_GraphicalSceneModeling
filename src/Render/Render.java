package Render;

import Elements.LightSource;
import Geometrics.FlatGeometry;
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
            for (int j = 0; j < get_imageWriter().get_Ny(); j++) {  // for each point (i,j) in the image
                Ray ray = get_scene().get_camera().constructRayThroughPixel
                        (get_imageWriter().get_Nx(), get_imageWriter().get_Ny(),
                                i, j, get_scene().get_screenDistance(),
                                get_imageWriter().get_imageWidth(), get_imageWriter().get_imageHeight()); //sets a ray that fits to the point
                HashMap <Geometry, ArrayList <Point3D>> intersectionPoints = new HashMap <>();
                get_scene().get_geometries().forEach(geometry -> { // for each geometry find intersection with the ray
                    ArrayList <Point3D> geometryIntersectionPoints = (ArrayList <Point3D>) geometry.findIntersections(ray);
                    if (!geometryIntersectionPoints.isEmpty()) {
                        intersectionPoints.put(geometry, geometryIntersectionPoints); // if there is intersections so add them
                    }
                });
                if (intersectionPoints.isEmpty()) {
                    get_imageWriter().writePixel(j, i, get_scene().get_background());
                } else {
                    HashMap <Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints); // get the closest point to the ray
                    Geometry key = (Geometry) closestPoint.keySet().toArray()[0];
                    Point3D value = closestPoint.get(key);
                    get_imageWriter().writePixel(j, i, calcColor(key, value,ray)); // set the color of the point
                }
            }
        }
    }

    public void printGrid(int interval, Color color) {
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
        printGrid(interval, get_scene().get_ambientLight().get_color());
    }

    private java.awt.Color calcColor(Geometry geometry, Point3D p,Ray ray) {
        Color ambientLight = get_scene().get_ambientLight().getIntensity();
        Color emissionLight = geometry.get_emission();
        Vector n = geometry.getNormal(p);
        int nShininess = geometry.get_material().get_nShininess();
        double kd = geometry.get_material().get_Kd();
        double ks = geometry.get_material().get_Ks();
        Color color = ambientLight.add(emissionLight) ;
        Vector v = new Vector(p, get_scene().get_camera().get_P0()).normalize();

        for (LightSource lightSrc : get_scene().get_lights()) {
            Color lightIntensity = lightSrc.getIntensity(p);
            Vector l = lightSrc.getL(p);
            if (n.dotProduct(l) * n.dotProduct(v) > 0) {
                if (!occluded(l, p)) {
                    color.add(calcDiffusive(kd, l, n, lightIntensity));
                    color.add(calcSpecular(ks, l, n, v, nShininess, lightIntensity));
               }
           }
        }
        return color.get_color();
    }

    private boolean occluded(Vector l, Point3D p) {
        Vector lightDirection = l.scale(-1); // from point to light source
        Ray lightRay = new Ray(lightDirection, p);
        HashMap <Geometry, ArrayList <Point3D>> intersectionPoints = new HashMap <>();
        get_scene().get_geometries().forEach(geometry -> {
            Vector epsVector = geometry.getNormal(p).scale(geometry.getNormal(p).dotProduct(lightDirection) >0 ? 2 : -2);
            Point3D geoPoint = p.add(epsVector);
            lightRay.set_POO(geoPoint);
            ArrayList <Point3D> intersections = (ArrayList <Point3D>) geometry.findIntersections(lightRay);

            if (!intersections.isEmpty()) {
                intersectionPoints.put(geometry, intersections);
            }
        });
        return !intersectionPoints.isEmpty();
     //  return false;
    }

    private Color calcSpecular(double ks, Vector _l, Vector _n, Vector _v, int nShininess, Color lightIntensity) {
        Vector v = new Vector(_v);
        Vector n = new Vector(_n);
        Vector l = new Vector(_l);
        Vector r = l.subtract(n.scale(l.dotProduct(n)).scale(2));
        double vectorProduct = Math.pow(r.dotProduct(v.scale(-1)), nShininess);
        return lightIntensity.scale(vectorProduct).scale(ks);
    }

    private Color calcDiffusive(double kd, Vector l, Vector n, Color lightIntensity) {
                return lightIntensity.scale(kd).scale(/*Math.abs*/(l.dotProduct(n)));
    }

    private HashMap <Geometry, Point3D> getClosestPoint
            (HashMap <Geometry, ArrayList <Point3D>> intersectionPoints) {
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

/* CalcCOLOR working Ver no reflections and reflactors
* private java.awt.Color calcColor(Geometry geometry, Point3D p,Ray ray) {
        Color ambientLight = get_scene().get_ambientLight().getIntensity();
        Color emissionLight = geometry.get_emission();
        Vector n = geometry.getNormal(p);
        int nShininess = geometry.get_material().get_nShininess();
        double kd = geometry.get_material().get_Kd();
        double ks = geometry.get_material().get_Ks();
        Color color = ambientLight.add(emissionLight) ;
        Vector v = new Vector(p, get_scene().get_camera().get_P0()).normalize();

        for (LightSource lightSrc : get_scene().get_lights()) {
            Color lightIntensity = lightSrc.getIntensity(p);
            Vector l = lightSrc.getL(p);
            if (n.dotProduct(l) * n.dotProduct(v) > 0) {
                if (!occluded(l, p)) {
                    color.add(calcDiffusive(kd, l, n, lightIntensity));
                    color.add(calcSpecular(ks, l, n, v, nShininess, lightIntensity));
               }
           }
        }
        return color.get_color();
    }
*/