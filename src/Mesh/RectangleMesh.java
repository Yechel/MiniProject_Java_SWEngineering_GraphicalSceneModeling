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
    private double[] angels;

    public Color get_emission() {
        return new Color(_emission);
    }

    public Material get_material() {
        return new Material(_material);
    }

    public ArrayList <Point3D> get_pointList() {
        return _pointList;
    }

    public void set_pointList(ArrayList <Point3D> pointList) {

        get_pointList().clear();
        for (Point3D p: pointList
             ) {
            get_pointList().add(new Point3D(p));
        }
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
        angels = new double[]{0,0,0};
}

    public RectangleMesh(RectangleMesh rectangleMesh) {
        set_pointList(rectangleMesh.get_pointList());
        set_material(rectangleMesh.get_material());
        set_emission(rectangleMesh.get_emission());
        angels = new double[]{0,0,0};
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


    public void rotrateAxisRIGHT(int angle) {
        double centerY = (get_pointList().get(0).get_up().get_coordinate() +
                get_pointList().get(2).get_up().get_coordinate()) * 0.5;
        double centerX = get_pointList().get(0).get_to().get_coordinate();
        double radius = get_pointList().get(0).distance(get_pointList().get(2)) * 0.5;
        double deg0;
        if (get_pointList().get(0).get_to().equals(get_pointList().get(1).get_to())) {
            deg0 = 90;
        } else {
            deg0 = Math.acos((centerX - get_pointList().get(0).get_to().get_coordinate()) / radius);
            deg0 = Math.toDegrees(deg0);
        }
        double deg[] = new double[4];
        deg[0] = 180 - deg0;
        deg[1] = deg0;
        deg[2] = -deg0;
        deg[3] = deg0 - 180;
        int i = 0;
        for (Point3D p : get_pointList()
                ) {
            p.set_to(centerX + radius * Math.cos(Math.toRadians(deg[i] + angle + angels[2])));
            p.set_up(centerY + radius * Math.sin(Math.toRadians(deg[i] + angle + angels[0])));
            i++;
        }
        angels[0] = angels[0] + angle;
        angels[2] = angels[2] + angle;
    }


    public void rotrateAxisUP(int angle) {
        double centerY = (get_pointList().get(0).get_right().get_coordinate() +
                get_pointList().get(2).get_right().get_coordinate()) * 0.5;
        double centerX = (get_pointList().get(0).get_to().get_coordinate() +
                get_pointList().get(2).get_to().get_coordinate()) * 0.5;;
        double radius = get_pointList().get(0).distance(get_pointList().get(2)) * 0.5;
        double deg0;
        if (get_pointList().get(0).get_to().equals(get_pointList().get(1).get_to())) {
            deg0 = 60;
        } else {
            deg0 = Math.acos((centerX - get_pointList().get(0).get_to().get_coordinate()) / radius);
            deg0 = Math.toDegrees(deg0);
        }
        double deg[] = new double[4];
        deg[0] = 180 - deg0;
        deg[1] = deg0;
        deg[2] = -deg0;
        deg[3] = deg0 - 180;
        int i = 0;
        for (Point3D p : get_pointList()
                ) {
            p.set_to(centerX + radius * Math.cos(Math.toRadians(deg[i] + angle + angels[2])));
            p.set_right(centerY + radius * Math.sin(Math.toRadians(deg[i] + angle +angels[1])));
            i++;
        }

    }

    public void rotrateAxisTO(int angle) {
        double centerX = (get_pointList().get(0).get_right().get_coordinate() +
                get_pointList().get(2).get_right().get_coordinate()) * 0.5;
        double centerY = (get_pointList().get(0).get_up().get_coordinate() +
                get_pointList().get(2).get_up().get_coordinate()) * 0.5;
        double radius = get_pointList().get(0).distance(get_pointList().get(2)) * 0.5;
        double deg0;
        if (get_pointList().get(0).get_right().equals(get_pointList().get(1).get_right())) {
            deg0 = 90;
        } else {
            deg0 = Math.acos((centerX - get_pointList().get(0).get_right().get_coordinate()) / radius);
            deg0 = Math.toDegrees(deg0);
        }
        double deg[] = new double[4];
        deg[0] = 180 - deg0;
        deg[1] = deg0;
        deg[2] = -deg0;
        deg[3] = deg0 - 180;
        int i = 0;
        for (Point3D p : get_pointList()
                ) {
            p.set_right(centerX + radius * Math.cos(Math.toRadians(deg[i] + angle + angels[1] )));
            p.set_up(centerY + radius * Math.sin(Math.toRadians(deg[i] + angle + angels[0])));
            i++;
        }
        angels[1] = angels[1] + angle;
        angels[0] = angels[0] + angle;

    }






    @Override
    public void move(int up, int right, int to) {
        moveUP(up);
        moveRIGHT(right);
        moveTO(to);
    }

    @Override
    public void rotrate(int upline, int rightline, int toline) {
        if (upline != 0) {
            rotrateAxisUP(upline);
        }
        if (rightline != 0) {
            rotrateAxisRIGHT(rightline);
        }
        if (toline != 0) {
            rotrateAxisTO(toline);
        }
    }


    @Override
    public ArrayList <Triangle> toTriangle() throws Exception {
        ArrayList <Triangle> square = new ArrayList <>();

       square.add(new Triangle(get_pointList().get(0),
                get_pointList().get(1),
                get_pointList().get(2), get_material(), get_emission()));
        square.add(new Triangle(get_pointList().get(2),
                get_pointList().get(3),
                get_pointList().get(0), get_material(), get_emission()));
        return square;
    }


}
