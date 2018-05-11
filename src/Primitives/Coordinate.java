package Primitives;

public class Coordinate {
    private double _coordinate;

    //getter
    public double get_coordinate() {
        return _coordinate;
    }

    //setter
    public void set_coordinate(double _coordinate) {
        this._coordinate = _coordinate;
    }

    //ctors
    public Coordinate() {
        set_coordinate(0);
    }

    public Coordinate(double d) {
        set_coordinate(d);
    }


    @Override
    public boolean equals(Object obj) throws ExceptionInInitializerError {
        if (obj instanceof Coordinate) {
            return get_coordinate() == ((Coordinate) obj).get_coordinate();
        }
        throw new ExceptionInInitializerError("the object is not Cylinder type");
    }

    @Override
    public String toString() {
        return String.format("%.2f", get_coordinate());
    }

    public Coordinate mult(double d) {
        return new Coordinate(get_coordinate()*d);
    }
    public Coordinate mult(Coordinate d) {
        return mult(d.get_coordinate());
    }


 public Coordinate add(Coordinate coordinate)
 {
     set_coordinate(this.get_coordinate() + coordinate.get_coordinate());
     return this;
 }
    public Coordinate subtract (Coordinate coordinate){
     set_coordinate(this.get_coordinate() - coordinate.get_coordinate());
     return this;
 }

}//end class Coordinate
