package Primitives;

public class Point3D extends Point2D {
    private Coordinate _z;

    //getter
    public Coordinate get_z() {
        return _z;
    }

    //setter
    public void set_z(double _z) {
        this._z = new Coordinate(_z);
    }

    //Ctors
    public Point3D() {
        set_x(0);
        set_y(0);
        set_z(0);
    }

    public Point3D(Point3D head) {
        set_x(head.get_x().get_coordinate());
        set_y(head.get_y().get_coordinate());
        set_z(head.get_z().get_coordinate());
    }
    public Point3D(Coordinate x,Coordinate y,Coordinate z) {
        super(x.get_coordinate(),y.get_coordinate());
        set_z(z.get_coordinate());
    }
    public Point3D(double x,double y,double z) {
        super(x,y);
        set_z(z);
    }

    public Point3D(Point2D p,Coordinate z) {
        super(p);
        set_z(z.get_coordinate());
    }

    @Override
    public String toString() {
        return   String.format("%s,%s",super.toString(),get_z());
    }

    @Override
    public boolean equals(Object obj)  throws ExceptionInInitializerError{
        if (obj instanceof Point3D) {
            if ( super.equals(obj))
                if (get_z().equals(((Point3D) obj).get_z()))
                    return true;
        }

        throw new ExceptionInInitializerError("the object is not Point3D type");
    }


    public void scale(double d) {
        this.set_x(this.get_x().get_coordinate()*d);
        this.set_y(this.get_y().get_coordinate()*d);
        this.set_z(this.get_z().get_coordinate()*d);
    }

    public Point3D add (Vector vector){
        this.set_x(this.get_x().add(vector.get_head().get_x()).get_coordinate());
        this.set_y(this.get_y().add(vector.get_head().get_y()).get_coordinate());
        this.set_z(this.get_z().add(vector.get_head().get_z()).get_coordinate());
        return this;
    }

    public Point3D subtract (Vector vector) {
        this.set_x(this.get_x().subtract(vector.get_head().get_x()).get_coordinate());
        this.set_y(this.get_y().subtract(vector.get_head().get_y()).get_coordinate());
        this.set_z(this.get_z().subtract(vector.get_head().get_z()).get_coordinate());
        return this;
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
