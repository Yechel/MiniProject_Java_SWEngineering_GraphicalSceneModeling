package Render;

import Elements.*;
import Geometrics.Geometry;
import Geometrics.Plane;
import Geometrics.Sphere;
import Geometrics.Triangle;
import Primitives.*;
import Scene.Scene;
import org.junit.Test;

import java.util.ArrayList;


public class RenderTest {

    @Test
    public void basicRendering() throws Exception {

        Scene scene = new Scene();
        scene.addGeometry(new Sphere(100, new Point3D(0, 0, -500),
                new Material(1, 3, 9),
                new Color(50, 100, 150)));
        //    scene.addGeometry(new Sphere(40, new Point3D(10, 90, -400),new Material(),new Color(10,10,10)));
        // scene.addGeometry(new Sphere(60, new Point3D(-100, 0, -500)));

/*
        Triangle triangle = new Triangle(new Point3D(100, 0, -490),
                new Point3D(0, 100, -490),
                new Point3D(100, 100, -490)
                , new Material(), new Color());
*/

//        Triangle triangle2 = new Triangle(new Point3D( -100, 0, -490),
//                new Point3D(  0, 100, -490),
//                new Point3D( -100,100, -490),new Material(),new Color(0,255,255));
//
//        Triangle triangle3 = new Triangle(new Point3D(100, 0, -490),
//                new Point3D(  0, -100, -490),
//                new Point3D(100, -100, -490),new Material(),new Color(255,0,255));
//
//        Triangle triangle4 = new Triangle(new Point3D(-100, 0, -490),
//                new Point3D(  0,  -100, -490),
//                new Point3D(-100, -100, -490),new Material(),new Color(255,255,0));
//
//       scene.addGeometry(triangle);
//       scene.addGeometry(triangle2);
//       scene.addGeometry(triangle3);
//       scene.addGeometry(triangle4);
       /* Plane plane = new Plane(new Point3D(-10,-10,-500),
                new Point3D(-10,10,-500),
                new Point3D(-11,0,-500),
        new Material(0,5,5),
        new Color(140,10,200));*/
       // scene.addGeometry(plane);
        ArrayList <Light> lights = new ArrayList <>();
        lights.add(new PointLight(new Color(150,24,50)
        ,new Point3D(-175,-175,-395),
                0,0,0.00005));
/*        lights.add(new PointLight(new Color(150,24,50)
                ,new Point3D(-250,-250,-400),
                0.002,0.0000001,0.000009));*/
        lights.add(new SpotLight(new Color(230, 0, 0)
                , new Point3D(-75, -75, -375),
                0, 0, 0.0000005, new Vector(0, 0, -1)));
        //  lights.add(new DirectionalLight());

        scene.set_lights(lights);
        ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        scene.get_ambientLight().set_Ka(0.15);
        render.renderImage();
         render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }


}