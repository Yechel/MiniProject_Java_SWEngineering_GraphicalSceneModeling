package Elements;

import Primitives.Color;

public class AmbientLight {
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

    public Color getIntensity(){
        return new Color(get_color().scale(get_Ka()));
    }

}
