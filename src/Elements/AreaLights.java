package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.util.ArrayList;

public class AreaLights {
    private ArrayList <PointLight> _areaLights;


    public ArrayList <PointLight> get_areaLights() {
        return new ArrayList <>(_areaLights);
    }

    public void set_areaLights(ArrayList <PointLight> _areaLights) {
        this._areaLights = _areaLights;
    }

    public AreaLights(ArrayList <PointLight> areaLights) {
        _areaLights.addAll(areaLights);
    }

    //create cube of lights 3X3 distance 2;
    public AreaLights(PointLight pl) {
         for (int x = -2; x < 3; x += 2) {
            for (int y = -2; y < 3; y += 2) {
                for (int z = -2; z < 3; z += 2) {
                    PointLight newPl = new PointLight(pl);
                    Point3D newPosition = newPl.get_position();
                    newPosition.add(new Vector(new Point3D(x, y, z)));
                    newPl.set_position(newPosition);
                    _areaLights.add(newPl);
                }
            }
        }
    }


}
