package Primitives;

import Elements.Camera;

public class Main {

    public static void main(String[] args) {
        Camera cam = new Camera();
        Ray ray = cam.constructRayThroughPixel(3, 3, 3, 3, 100, 150, 150);
         Vector exp = new Vector(1 / Math.sqrt(6), 1 / Math.sqrt(6), -Math.sqrt(2 / 3));
        boolean b = ray.get_direction().equals(exp);
        int i =0;


    }
}
