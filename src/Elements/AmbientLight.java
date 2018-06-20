package Elements;

import Primitives.Color;
import Primitives.Point3D;
import Primitives.Vector;

public class AmbientLight extends Light {

    private Color _color;
    private double _Ka;

    ////////////////////////////
    //////////getters//////////
    ///////////////////////////

    public Color get_color() {
        return _color;
    }

    public double get_Ka() {
        return _Ka;
    }

    ////////////////////////////
    //////////setters//////////
    ///////////////////////////

    public void set_color(Color _color) {
        this._color = _color;
    }

    public void set_Ka(double _Ka) {
        this._Ka = _Ka;
    }
    ////////////////////////////
    ////////constructors////////
    ///////////////////////////

    public AmbientLight(Color color, double ka) {
        set_color(color);
        set_Ka(ka);
    }

    ///////////////////////////

    /**
     * @return the intensity of the color. I*Ka
     */
    @Override
    public Color getIntensity() {
        return new Color(get_color().scale(get_Ka()));
    }

    /**
     * @param point
     * @return AmbentLight return ths same intensity no matter the point
     */
    @Override
    public Color getIntensity(Point3D point) {
        return  getIntensity();
    }

    /**
     * @param point
     * @return Ambient Light have no position therefroe it have no Vector L
     */
    @Override
    public Vector getL(Point3D point) {
        return null;
    }
}
