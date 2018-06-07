package Elements;

import Primitives.Color;
import Primitives.Point3D;
import Primitives.Vector;

public class AmbientLight extends Light {
    private Color _color;
    private double _Ka;

    public AmbientLight(Color color, double ka) {
        set_color(color);
        set_Ka(ka);
    }

    public Color get_color() {
        return _color;
    }

    public void set_color(Color _color) {
        this._color = _color;
    }

    public double get_Ka() {
        return _Ka;
    }

    public void set_Ka(double _Ka) {
        this._Ka = _Ka;
    }

    @Override
    public Color getIntensity(){
        return new Color(get_color().scale(get_Ka()));
    }

    @Override
    public Color getIntensity(Point3D point) {
        return null;
    }

    @Override
    public Vector getL(Point3D point) {
        return null;
    }
}
