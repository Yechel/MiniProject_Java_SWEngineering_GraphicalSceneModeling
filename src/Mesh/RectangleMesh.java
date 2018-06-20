package Mesh;

import Geometrics.Triangle;
import Primitives.Color;
import Primitives.Material;
import Primitives.Point3D;

import java.util.ArrayList;

public class RectangleMesh implements Mesh {
    private ArrayList <Point3D> _pointList = new ArrayList <>();
    private Material _material;
    private Color _emission;

    public Color get_emission() {
        return new Color(_emission);
    }

    public Material get_material() {
        return new Material(_material);
    }

    public ArrayList <Point3D> get_pointList() {
        return _pointList;
    }

    public void set_pointList(ArrayList <Point3D> _pointList) {

        get_pointList().clear();
        get_pointList().addAll(_pointList);
    }

    @Override
    public void set_emission(Color emission) {
        _emission = emission;
    }

    @Override
    public void set_material(Material material) {
        _material = material;
    }

    public RectangleMesh(int height, int width, Material material, Color emission) {
        ArrayList <Point3D> list = new ArrayList <>();
        list.add(new Point3D(height / 2, -width / 2, -500));
        list.add(new Point3D(height / 2, width / 2, -500));
        list.add(new Point3D(-height / 2, width / 2, -500));
        list.add(new Point3D(-height / 2, -width / 2, -500));
        set_pointList(list);
        set_material(material);
        set_emission(emission);
    }

    public RectangleMesh(ArrayList <Point3D> pointList, Material material, Color emission) {
        set_pointList(pointList);
        set_material(material);
        set_emission(emission);
    }

    public void addToX(Point3D p, double up) {
        p.set_up(p.get_up().get_coordinate() + up);
    }

    public void addToRIGHT(Point3D p, double right) {
        p.set_right(p.get_right().get_coordinate() + right);
    }

    public void addToTO(Point3D p, double to) {
        p.set_to(p.get_to().get_coordinate() + to);
    }


    public void moveTO(int z) {
        for (Point3D p : get_pointList()) {
            addToTO(p, z);
        }
    }


    public void moveRIGHT(int y) {
        for (Point3D p : get_pointList()) {
            addToRIGHT(p, y);
        }
    }


    public void moveUP(int x) {
        for (Point3D p : get_pointList()) {
            addToX(p, x);
        }
    }


    public void rotrateRIGHT(int angle) {

    }


    public void rotrateUP(int angle) {

    }

    public void rotrateTO(int size) {
        Point3D p0 = get_pointList().get(0);
        Point3D p1 = get_pointList().get(1);
        Point3D p2 = get_pointList().get(2);
        Point3D p3 = get_pointList().get(3);
        p0.set_right(p0.get_right().get_coordinate() - size);
        p0.set_up(p0.get_up().get_coordinate() - size);
        p1.set_right(p1.get_right().get_coordinate() - size);
        p1.set_up(p1.get_up().get_coordinate() + size);
        p2.set_right(p2.get_right().get_coordinate() + size);
        p2.set_up(p2.get_up().get_coordinate() + size);
        p3.set_right(p3.get_right().get_coordinate() + size);
        p3.set_up(p3.get_up().get_coordinate() - size);

    }

  /*  public void rotrateTO(int angle) {

        for (Point3D p: get_pointList()
             ) {
            double x = p.get_right().get_coordinate();
            double y = p.get_up().get_coordinate();


            p.set_right(x + x*Math.cos(Math.toRadians(angle)));
            p.set_up(y + y *Math.sin(Math.toRadians(angle)));
        }


        }*/


   /* public void rotrateTO(int angle) {
        Point3D pUpLeft = get_pointList().get(0);
        Point3D pUpRight = get_pointList().get(1);
        Point3D pDownRight = get_pointList().get(2);
           for (Point3D p : get_pointList()) {
            double newRight = getNewValueToCos(pUpLeft, pUpRight, pDownRight, p, angle);
            p.set_right(newRight);
            double newUP = getNewValueToSin(pUpLeft, pUpRight, pDownRight, p, angle);
            p.set_right(newUP);
        }
    }*/

/*

    private double getNewValueToSin(Point3D pUpLeft, Point3D pUpRight, Point3D pDownRight, Point3D P, int angle) {
        double radius = getDis(pUpLeft, pDownRight, 0.5);
        double center = getDis(pUpLeft, pUpRight, 0.5);
        double delta = getDis(pUpLeft, pUpRight, 1);
        double rad = Math.asin(delta / radius);
        rad += Math.toRadians(angle);
        return center + radius * Math.sin(rad);
    }

    private double getNewValueToCos(Point3D pUpLeft, Point3D pUpRight, Point3D pDownRight, Point3D P, int angle) {
        double radius =  pUpLeft.distance(pDownRight)* 0.5;
        double center = pUpLeft.distance(pUpRight)*0.5;
        double delta = ;
        double rad = Math.acos(delta / radius);
        rad += Math.toRadians(angle);
        return center + radius * Math.cos(rad);
    }*/

    @Override
    public void move(int up, int right, int to) {
        moveUP(up);
        moveRIGHT(right);
        moveTO(to);
    }

    @Override
    public void rotrate(int upline, int rightline, int toline) {
        if (upline != 0) {
            rotrateUP(upline);
        }
        if (rightline != 0) {
            rotrateRIGHT(rightline);
        }
        if (toline == 0) {
            //rotrateTO(toline);
        }
    }




 /*   @Override
    public void rotrateRIGHT(int angle) {
        double cosa = Math.cos(Math.toRadians(angle));
        double sina = Math.sin(Math.toRadians(angle));
        double lenY = get_pointList().get(0).distance(get_pointList().get(3)) * 0.5;
        double lenX = get_pointList().get(0).distance(get_pointList().get(1)) * 0.5;
        for (Point3D p : get_pointList()) {
            addToX(p, -lenX);
            addToX(p, lenX * sina);
            addToRIGHT(p, -lenY);
            addToRIGHT(p, lenX * cosa);
        }
    }*/

  /*  @Override
    public void resize(int percent) {

    }*/


    @Override
    public ArrayList <Triangle> toTriangle() throws Exception {
        ArrayList <Triangle> square = new ArrayList <>();
        square.add(new Triangle(get_pointList().get(0).scale(1.05),
                get_pointList().get(1),
                get_pointList().get(2).scale(1.05), get_material(), get_emission()));
        square.add(new Triangle(get_pointList().get(2).scale(1.05),
                get_pointList().get(3),
                get_pointList().get(0).scale(1.05), get_material(), get_emission()));
        return square;
    }


}
