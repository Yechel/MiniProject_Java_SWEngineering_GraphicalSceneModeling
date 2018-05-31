package Primitives;

public class Vector {
    private Point3D _head;
    private Point3D _tail; //needed to vector that start from (0,0,0).

    public Vector() {
        set_head(new Point3D(1,0,0));
        set_tail(new Point3D(0,0,0));
    }

    public Vector(Vector vector) {
        set_head(vector.get_head());
        set_tail(vector.get_tail());
    }

    /**
     * sets (0,0,0) as a default tail.
     * @param head
     */
    public Vector(Point3D head) {
        set_head(head);
        set_tail(new Point3D(0, 0, 0));
    }

    /**
     * @param head the head of the vector
     * @param tail the tail of the vector
     */
    public Vector(Point3D head, Point3D tail) {
        set_head(head.subtract(new Vector(tail)));
        set_tail(new Point3D(0,0,0));
    }

    /**
     * sets the point(x,y,z) as a head of the vector
     * @param x
     * @param y
     * @param z
     */
    public Vector(double x, double y, double z) {
        set_head(new Point3D(x, y, z));
        set_tail(new Point3D(0, 0, 0));
    }


    public Point3D get_head() {
        return new Point3D(_head);
    }

    public Point3D get_tail() {
        return new Point3D(_tail);
    }


    public void set_head(Point3D _head) {
        this._head = new Point3D(_head);
    }

    public void set_tail(Point3D _tail) {
        this._tail = _tail;
    }


    //methods

    public double length() {
        Point3D zero = new Point3D(0,0,0);
        Point3D s = get_head();
        return  zero.distance(s);
    }


    public Vector crossProduct(Vector v) {
        Point3D u = new Point3D();
        u.set_x((get_head().get_y().mult(v.get_head().get_z())).get_coordinate());
        u.set_y((get_head().get_z().mult(v.get_head().get_x())).get_coordinate());
        u.set_z((get_head().get_x().mult(v.get_head().get_y())).get_coordinate());
        Point3D w = new Point3D();
        w.set_x((get_head().get_z().mult(v.get_head().get_y())).get_coordinate());
        w.set_y((get_head().get_x().mult(v.get_head().get_z())).get_coordinate());
        w.set_z((get_head().get_y().mult(v.get_head().get_x())).get_coordinate());
        return new Vector(u.subtract(new Vector(w)));
    }

    public Vector normalize() throws ArithmeticException {
        if (length() == 0) {
            throw new ArithmeticException("cannot divide by zero");
        }
        return this.scale(1 / this.length());
        //TODO: why its needed to scale with -1?
    }

    // TODO: see where to put this
    public Vector getNormal(Point3D point) {
        Vector U = new Vector(point);
        Vector N = new Vector(this.crossProduct(U));
        N.normalize();
        N.scale(-1);
        return N;
    }

    public Vector scale(double d) {
        set_head(get_head().scale(d));
        return this;
    }

    @Override
    public boolean equals(Object obj) throws IllegalArgumentException {
        //vectors are equal if the have the same length
        //and the same direction therefor:
        if (obj instanceof Vector) {
            if (((Vector) obj).isZero()) {
                return (this.isZero());
            }
            return ((this.length()) == ((Vector) obj).length() &&
                    ((Vector) obj).normalize().get_head().equals(this.normalize().get_head()));
        }
        throw new IllegalArgumentException("the object is not a Vector type");
    }

    private boolean isZero() {
        return (get_head().get_x().get_coordinate() == 0 &&
                get_head().get_y().get_coordinate() == 0 &&
                get_head().get_z().get_coordinate() == 0);
    }

    public Vector add(Vector v) {
        set_head(get_head().add(v));
        return this;
    }

    public Vector subtract(Vector v) {
        set_head(get_head().subtract(v));

        return this;
    }

    public double dotProduct(Vector v) {
             return (get_head().get_x().mult(v.get_head().get_x())).get_coordinate() +
                (get_head().get_y().mult(v.get_head().get_y())).get_coordinate() +
                (get_head().get_z().mult(v.get_head().get_z())).get_coordinate();
    }


    @Override
    public String toString() {
        return String.format("Vec%s",get_head().toString());
    }


}//end of Vector