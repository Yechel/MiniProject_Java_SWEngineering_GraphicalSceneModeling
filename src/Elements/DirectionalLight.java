package Elements;

import Primitives.Color;
import Primitives.Point3D;
import Primitives.Vector;

public class DirectionalLight extends Light implements LightSource {

    Vector _direction;

    public Vector get_direction() {
        return new Vector(_direction);
    }

    public void set_direction(Vector _direction) {
        this._direction = _direction.normalize();
    }

    public DirectionalLight(Color color, Vector direction) {
        set_color(color);
        set_direction(direction);
    }


    public DirectionalLight(DirectionalLight DL) {
        set_color(DL.get_color());
        set_direction(DL.get_direction());
    }

    @Override
    public Color getIntensity(Point3D point) {
        return null;
    }

    @Override
    public Vector getL(Point3D point) {
        return get_direction();
    }
}
