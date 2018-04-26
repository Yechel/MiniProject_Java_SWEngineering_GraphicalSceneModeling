package Primitives;

public class Ray {
    private Point3D _POO;
    private Vector _direction;


    public Point3D get_POO() {
        return _POO;
    }

    public void set_POO(Point3D _POO) {
        this._POO = _POO;
    }

    public Vector get_direction() {
        return _direction;
    }

    public void set_direction(Vector _direction) {
        this._direction = _direction;
    }
    public Ray()
    {
        set_direction(new Vector(new Point3D()));
        set_POO(new Point3D());
    }

    public Ray(Vector dirction, Point3D POO)
    {
        set_direction(dirction);
        set_POO(POO);
    }
}
