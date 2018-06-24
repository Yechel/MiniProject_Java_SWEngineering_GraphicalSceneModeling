package Elements;

import Primitives.Color;


/**
 * abstract class that demonstrate the Lights
 */
public abstract class Light implements LightSource {
    Color _color;

    ///////////////////////////
    //////////getters//////////
    ///////////////////////////
    public Color get_color() {
        return new Color(_color.get_color());
    }

    public Color getIntensity() {
        return get_color();
    }

    ////////////////////////////
    //////////setters//////////
    ///////////////////////////

    public void set_color(Color _color) {
        this._color = _color;
    }

    ////////////////////////////
}
