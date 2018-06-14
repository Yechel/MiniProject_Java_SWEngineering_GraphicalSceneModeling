package Elements;

import Primitives.Color;
import Primitives.Point3D;
import Primitives.Vector;

import java.util.ArrayList;


public class AreaLight extends Light implements LightSource {

    private ArrayList <Light> _areaLights;
    private PointLight _center = null;

    public ArrayList <Light> get_areaLights() {
        return new ArrayList <>(_areaLights);
    }

    public void set_areaLights(ArrayList <Light> _areaLights) {
        this._areaLights = _areaLights;
    }

    public Light get_center() {
        return _center;
    }


    public AreaLight(ArrayList <Light> areaLights) {
        _areaLights.addAll(areaLights);
    }

    //create cube of lights 3X3 distance 2;
    public AreaLight(PointLight pl) {
        _areaLights = new ArrayList <>();
        _center = pl;

        for (int x = 0; x < 6; x += 5) {
            for (int y = 0; y < 6; y += 5) {
                for (int z = 0; z < 6; z += 5) {
                    Point3D newPosition = _center.get_position();
                    newPosition.add(new Vector(new Point3D(x, y, z)));
                    PointLight newPl = new PointLight(_center);
                    newPl.set_position(newPosition);
                    _areaLights.add(newPl);
                }
            }
        }
    }


    @Override
    public Color getIntensity(Point3D point) {
        return _areaLights.get(0).get_color();
    }

    @Override
    public Vector getL(Point3D point) {
        int center = (int) _areaLights.size() / 2;
        return _areaLights.get(center).getL(point);
    }
}
