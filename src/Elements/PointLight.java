package Elements;

import Primitives.Color;
import Primitives.Point3D;
import Primitives.Vector;

public class PointLight extends Light implements LightSource {
    Point3D _position;
    double _Kc, _Kl, _Kq;

    public Point3D get_position() {
        return new Point3D(_position);
    }

    //TODO see if need deep copy
    public double get_Kc() {
        return _Kc;
    }

    public double get_Kl() {
        return _Kl;
    }

    public double get_Kq() {
        return _Kq;
    }


    public void set_Kc(double _Kc) {
        this._Kc = _Kc;
    }

    public void set_Kl(double _Kl) {
        this._Kl = _Kl;
    }

    public void set_Kq(double _Kq) {
        this._Kq = _Kq;
    }

    public void set_position(Point3D _position) {
        this._position = _position;
    }

    public PointLight(Color color, Point3D position, double Kc, double Kl, double Kq) {
        set_color(color);
        set_position(position);
        set_Kc(Kc);
        set_Kl(Kl);
        set_Kq(Kq);
    }


    public PointLight(PointLight PL) {
        set_color(PL.get_color());
        set_position(PL.get_position());
        set_Kc(PL.get_Kc());
        set_Kl(PL.get_Kl());
        set_Kq(PL.get_Kq());
    }


    @Override
    public Color getIntensity(Point3D point) {
        double distance = get_position().distance(point);
        double attenuation = 1/(get_Kc() + (get_Kl()*distance) + (get_Kq()*distance*distance));
        return new Color(get_color().scale(attenuation));
    }

    @Override
    public Vector getL(Point3D point) {
        return new Vector(point,get_position()).normalize();
    }
}
