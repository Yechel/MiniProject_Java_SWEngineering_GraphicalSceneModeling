package Scene;

import Elements.AmbientLight;
import Elements.Camera;
import Geometrics.Geometry;
import Primitives.Color;

import java.util.ArrayList;
import java.util.Iterator;

public class Scene {
    private String _sceneName;
    private Color _background;
    private AmbientLight _ambientLight;
    private ArrayList <Geometry> _geometries;
    private Camera _camera;
    private double _screenDistance;


    public Scene(Geometry geometry, String sceneName, Color background, AmbientLight ambientLight, ArrayList <Geometry> geometries, Camera camera, double screenDistance) {
        set_sceneName(sceneName);
        set_background(background);
        set_ambientLight(ambientLight);
        set_geometries(geometries);
        set_camera(camera);
        set_screenDistance(screenDistance);
    }

    public Scene(){

        set_sceneName("default Scene");
        set_background(new Color(0,0,0));
        set_ambientLight(new AmbientLight(new Color(255,255,255), 1));
        set_geometries(new ArrayList <>()  );
        set_camera(new Camera());
        set_screenDistance(50);
    }




    public String get_sceneName() {
        return _sceneName;
    }

    public void set_sceneName(String _sceneName) {
        this._sceneName = _sceneName;
    }

    public java.awt.Color get_background() {
        return _background.get_color();
    }

    public void set_background(Color _background) {
        this._background = _background;
    }

    public AmbientLight get_ambientLight() {
        return _ambientLight;
    }

    public void set_ambientLight(AmbientLight _ambientLight) {
        this._ambientLight = _ambientLight;
    }

    public ArrayList <Geometry> get_geometries() {
        return _geometries;
    }

    public void set_geometries(ArrayList <Geometry> _geometries) {
        this._geometries = _geometries;
    }

    public Camera get_camera() {
        return _camera;
    }

    public void set_camera(Camera _camera) {
        this._camera = _camera;
    }

    public double get_screenDistance() {
        return _screenDistance;
    }

    public void set_screenDistance(double _screenDistance) {
        this._screenDistance = _screenDistance;
    }

public void addGeometry(Geometry geometry)
{
    get_geometries().add(geometry);
}

public Iterator<Geometry>getGeometriesIterator(){
    return get_geometries().iterator();

}

}