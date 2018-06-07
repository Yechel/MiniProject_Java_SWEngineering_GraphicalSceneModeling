package Elements;

import Primitives.Color;
import Primitives.Point3D;
import Primitives.Vector;

public class SpotLight extends PointLight implements LightSource {
    Vector _direction;

    public Vector get_direction() {
        return new Vector(_direction);
    }

    public void set_direction(Vector _direction) {
        this._direction = _direction.normalize();
    }

    public SpotLight(Color color, Point3D position, double Kc, double Kl, double Kq ,Vector direction) {
        super(color, position, Kc, Kl, Kq);
        set_direction(direction.normalize());
}



    public SpotLight(PointLight PL) {
        super(PL);
    }

    @Override
    public Color getIntensity(Point3D point) {
        Color color =  super.getIntensity(point);
        Vector L = getL(point);
        return color.scale(L.dotProduct(get_direction()));
    }
}
