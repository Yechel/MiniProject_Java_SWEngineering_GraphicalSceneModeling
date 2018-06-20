package Primitives;

public class Point3D extends Point2D {
    private Coordinate _to;

    //getter
    public Coordinate get_to() {
        return _to;
    }

    //setter
    public void set_to(double _to) {
        this._to = new Coordinate(_to);
    }

    //Ctors
    public Point3D() {
        set_up(0);
        set_right(0);
        set_to(0);
    }

    public Point3D(Point3D head) {
        set_up(head.get_up().get_coordinate());
        set_right(head.get_right().get_coordinate());
        set_to(head.get_to().get_coordinate());
    }

    public Point3D(Coordinate up, Coordinate right, Coordinate to) {
        super(up.get_coordinate(), right.get_coordinate());
        set_to(to.get_coordinate());
    }

    public Point3D(double up, double right, double to) {
        super(up, right);
        set_to(to);
    }

    public Point3D(Point2D p, Coordinate to) {
        super(p);
        set_to(to.get_coordinate());
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", super.toString(), get_to());
    }

    @Override
    public boolean equals(Object obj) throws IllegalArgumentException {
        if (obj instanceof Point3D) {
            Point2D p1 = new Point2D(get_up().get_coordinate(), get_right().get_coordinate());
            Point2D p2 = new Point2D(((Point3D) obj).get_up().get_coordinate(), ((Point3D) obj).get_right().get_coordinate());
            if (p1.equals(p2)) {
                if (get_to().equals(((Point3D) obj).get_to())) {
                    return true;
                }
            }
            return false;
        }
        throw new

                IllegalArgumentException("the object is not Point3D type");

    }


    public Point3D scale(double d) {
        this.set_up(this.get_up().get_coordinate() * d);
        this.set_right(this.get_right().get_coordinate() * d);
        this.set_to(this.get_to().get_coordinate() * d);
        return this;
    }

    public Point3D add(Vector vector) {
        this.set_up(this.get_up().add(vector.get_head().get_up()).get_coordinate());
        this.set_right(this.get_right().add(vector.get_head().get_right()).get_coordinate());
        this.set_to(this.get_to().add(vector.get_head().get_to()).get_coordinate());
        return this;
    }

    public Point3D subtract(Vector vector) {
        this.set_up(this.get_up().subtract(vector.get_head().get_up()).get_coordinate());
        this.set_right(this.get_right().subtract(vector.get_head().get_right()).get_coordinate());
        this.set_to(this.get_to().subtract(vector.get_head().get_to()).get_coordinate());
        return this;
    }

    public double distance(Point3D point) {
        return Math.sqrt(
                Math.pow(point.get_up().get_coordinate() - get_up().get_coordinate(), 2) +
                        Math.pow(point.get_right().get_coordinate() - get_right().get_coordinate() , 2) +
                        Math.pow(point.get_to().get_coordinate() - get_to().get_coordinate(), 2));
    }


    /*public boolean inSameLine(Point3D p1,Point3D p2)
    {
        if ((this.substruct(p1)).substruct(p2).length == 0)
        {
            return true;
        }
        return false;
    }*/
}//end of Point3D
