package Mesh;

import Geometrics.Triangle;
import Primitives.Color;
import Primitives.Material;

import java.util.ArrayList;

public interface Mesh {

    public void move(int up, int right, int to);
    public void rotrate(int upline, int rightline, int toline);
  //  public void resize(int percent);
    public void set_material(Material material);
    public void set_emission(Color emission);
    public ArrayList<Triangle> toTriangle() throws Exception;
    

}
