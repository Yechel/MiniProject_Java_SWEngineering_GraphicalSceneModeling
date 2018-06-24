package Mesh;

import Geometrics.Triangle;
import Primitives.Color;
import Primitives.Material;
import Primitives.Point3D;

import java.util.ArrayList;

public interface Mesh {

    public void move(int up, int right, int to);
    public void rotrate(int upAxis, int righAxis, int toAxis);
    public void set_material(Material material);
    public void set_emission(Color emission);
    public ArrayList<Triangle> toTriangle() throws Exception;
    //public void connect(Mesh obj1, int pointNum1, Mesh obj2, int PointNum2);
    //  public void resize(int percent);

}
