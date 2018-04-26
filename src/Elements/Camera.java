package Elements;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

public class Camera {
    private Point3D _P0;
    private Vector _vUp;
    private Vector _vRight;
    private Vector _vTo;

    public Camera(Point3D p0, Vector vUp, Vector vRight, Vector vTo) {
        set_P0(p0);
        set_vUp(vUp);
        set_vTo(vTo);
        set_vRight(vRight);
        _vUp.normalize();
        _vTo.normalize();
        _vRight.normalize();
    }

    public Camera(Point3D p0, Vector vUp, Vector vTo) {
        set_P0(p0);
        set_vUp(vUp);
        set_vTo(vTo);
        set_vRight(vTo.crossProduct(vUp));
        _vUp.normalize();
        _vTo.normalize();
        _vRight.normalize();
    }

    public Camera() {
        set_P0(new Point3D(0, 0, 0));
        set_vUp(new Vector(new Point3D(0, 1, 0)));
        set_vTo(new Vector(new Point3D(0, 0, 1)));
        set_vRight(new Vector(new Point3D(1, 0, 0)));
    }


    public Point3D get_P0() {
        return _P0;
    }

    public void set_P0(Point3D _P0) {
        this._P0 = _P0;
    }

    public Vector get_vUp() {
        return _vUp;
    }

    public void set_vUp(Vector _vUp) {
        this._vUp = _vUp;
    }

    public Vector get_vRight() {
        return _vRight;
    }

    public void set_vRight(Vector _vRight) {
        this._vRight = _vRight;
    }

    public Vector get_vTo() {
        return _vTo;
    }

    public void set_vTo(Vector _vTo) {
        this._vTo = _vTo;
    }


    public Ray constructRayThroughPixel(int Nx, int Ny,
                                        double x, double y,
                                        double screenDistance,
                                        double screenWidth,
                                        double screenHeight) {
        //assuming that p0 = (0,0,0).
        Vector Pc = new Vector(get_vTo());
        Pc.scale(screenDistance);
        double Rx = screenWidth / Nx;
        double Ry = screenHeight / Ny;
        double Xd = (x - (screenWidth / 2)) * Rx + (Rx / 2);
        double Yd = (y - (screenHeight / 2)) * Ry + (Ry / 2);
        Vector P = new Vector(Pc.add(get_vRight().scale(Xd).subtract(get_vUp().scale(Yd))));
        P.normalize();
        return new Ray(P,new Point3D(0,0,0));
    }
}
