package Elements;


import Primitives.Color;

public abstract class Light implements LightSource {
    Color _color;

    public Color get_color() {
        return new Color(_color.get_color());
    }

    public void set_color(Color _color) {
        this._color = _color;
    }

    public Color getIntensity() {
        return get_color();
    }


}
