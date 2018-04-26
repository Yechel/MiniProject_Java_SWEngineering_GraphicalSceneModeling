package Primitives;

public class Point2D {

    protected Coordinate _x;
    protected Coordinate _y;

    public Coordinate get_x() {
        return _x;
    }

    public Coordinate get_y() {
        return _y;
    }

    public void set_x(double _x) {
        this._x = new Coordinate(_x);
    }

    public void set_y(double _y) {
        this._y = new Coordinate(_y);
    }

    public Point2D() {
        set_x(0);
        set_y(0);
    }

    public Point2D(double x, double y) {
        set_x(x);
        set_y(y);
    }

    public Point2D(Point2D p) {
        set_x(p.get_x().get_coordinate());
        set_y(p.get_y().get_coordinate());
    }

    @Override
    public String toString() {
        return String.format("%s,%s",get_x(),get_y());
    }

    @Override
    public boolean equals(Object obj)  throws ExceptionInInitializerError{
        if (obj instanceof Point2D) {
            if (get_x().equals(((Point2D) obj).get_x()))
                if (get_y().equals(((Point2D) obj).get_y()))
                    return true;
        }

        throw new ExceptionInInitializerError("the object is not Point2D type");
    }


}
