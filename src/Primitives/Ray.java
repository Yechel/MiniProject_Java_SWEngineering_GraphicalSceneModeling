package Primitives;

public class Ray {
    private Point3D _POO;
    private Vector _direction;


    public Point3D get_POO() {
        return new Point3D(_POO);
    }

    public void set_POO(Point3D _POO) {
        this._POO = _POO;
    }

    public Vector get_direction() {
        return new Vector(_direction);
    }

    public void set_direction(Vector _direction) {
        this._direction = _direction.normalize();
    }
    public Ray()
    {
        set_direction(new Vector(new Point3D()));
        set_POO(new Point3D(0,0,0));
    }

    public Ray(Vector direction, Point3D POO)
    {
        set_direction(direction);
        set_POO(POO);
    }

    @Override
    public String toString() {
        return String.format("Ray: p%s %s", get_POO().toString(), get_direction().toString());
    }
}
