package Elements;

import Primitives.Color;
import Primitives.Point3D;
import Primitives.Vector;

/**
 * class that demonstrate a directional light
 */
public class DirectionalLight extends Light implements LightSource {

    Vector _direction;

///////////////////////////
//////////getters//////////
///////////////////////////

    public Vector get_direction() {
        return new Vector(_direction);
    }

////////////////////////////
//////////setters//////////
///////////////////////////

    public void set_direction(Vector _direction) {
        this._direction = _direction.normalize();
    }

////////////////////////////
////////constructors////////
///////////////////////////

    public DirectionalLight(Color color, Vector direction) {
        set_color(color);
        set_direction(direction);
    }

    public DirectionalLight(DirectionalLight DL) {
        set_color(DL.get_color());
        set_direction(DL.get_direction());
    }

///////////////////////////

    /**
     * @param point
     * @return the color og the light
     */
    @Override
    public Color getIntensity(Point3D point) {
        return get_color();
    }


    /**
     * @param point
     * @return Directional Light has the same direction no matters the point
     */
    @Override
    public Vector getL(Point3D point) {
        return get_direction();
    }
}
