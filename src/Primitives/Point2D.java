package Primitives;

public class Point2D {

    protected Coordinate _up;
    protected Coordinate _right;

    public Coordinate get_up() {
        return _up;
    }

    public Coordinate get_right() {
        return _right;
    }

    public void set_up(double _up) {
        this._up = new Coordinate(_up);
    }

    public void set_right(double _right) {
        this._right = new Coordinate(_right);
    }

    public Point2D() {
        set_up(0);
        set_right(0);
    }

    public Point2D(double up, double right) {
        set_up(up);
        set_right(right);
    }

    public Point2D(Point2D p) {
        set_up(p.get_up().get_coordinate());
        set_right(p.get_right().get_coordinate());
    }

    @Override
    public String toString() {
        return String.format("%s,%s", get_up(), get_right());
    }

    @Override
    public boolean equals(Object obj)  throws ExceptionInInitializerError{
        if (obj instanceof Point2D) {
            if (get_up().equals(((Point2D) obj).get_up())) {
                {
                    if (get_right().equals(((Point2D) obj).get_right()))
                        return true;
                }
            }
            return false;
        }

        throw new ExceptionInInitializerError("the object is not Point2D type");
    }


}
