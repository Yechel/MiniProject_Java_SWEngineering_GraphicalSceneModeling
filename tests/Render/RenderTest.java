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
                new Material(1, 1,1,1, 15),
                new Color(20, 50, 100)));
        scene.addGeometry(new Sphere(40, new Point3D(10, 90, -400), new Material(), new Color(10, 10, 10)));

        Triangle triangle = new Triangle(new Point3D(100, 0, -490),
                new Point3D(0, 100, -490),
                new Point3D(100, 100, -490)
                , new Material(1,1,1,1,15), new Color(25,200,10));


//
//       scene.addGeometry(triangle);

       /* Plane plane = new Plane(new Point3D(-10,-10,-500),
                new Point3D(-10,10,-500),
                new Point3D(-11,0,-500),
        new Material(0,5,5),
        new Color(140,10,200));*/
        // scene.addGeometry(plane);
        ArrayList <Light> lights = new ArrayList <>();
        lights.add(new PointLight(new Color(150, 24, 50)
                , new Point3D(-130, -130, -300),
                0.0001, 0.005, 0.000001));
/*        lights.add(new PointLight(new Color(150,24,50)
                ,new Point3D(-250,-250,-400),
                0.002,0.0000001,0.000009));*/
  /*      lights.add(new SpotLight(new Color(230, 0, 0)
                , new Point3D(75, 75, -400),
                0, 0, 0.0000005, new Vector(0, 0, -1)));*/
        //  lights.add(new DirectionalLight());

        scene.set_lights(lights);
        ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        scene.get_ambientLight().set_Ka(0.15);
        render.renderImage();
        //   render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }

    @Test
    public void lightRendering1() throws Exception {

        Scene scene = new Scene();

        //////////////////////////////////
        ///////////GEOMETRIES/////////////
        //////////////////////////////////
        scene.addGeometry(new Sphere(100, new Point3D(0, 0, -500),
                new Material(2, 2,1,1, 15),
                new Color(20, 50, 100)));

        Triangle triangle1 = new Triangle(new Point3D(-35, -60, -390),
                new Point3D(-80, -30, -400),
                new Point3D(-80, -90, -455)
                , new Material(1,1,1,1,15), new Color(25,200,10));
        scene.addGeometry(triangle1);

        Triangle triangle = new Triangle(new Point3D(-90, -30, -390),
                new Point3D(-110, -0, -455),
                new Point3D(-110, -60, -455)
                , new Material(1,1,1,1,15), new Color(25,200,10));
        scene.addGeometry(triangle);


       /////////////////////////////////////
       ////////////////LIGHTS///////////////
       /////////////////////////////////////
        ArrayList <Light> lights = new ArrayList <>();
        lights.add(new PointLight(new Color(150, 24, 50)
                , new Point3D(-140, -70,-330),
                0.0001, 0.005, 0.000001));
/*        lights.add(new PointLight(new Color(150,24,50)
                ,new Point3D(-250,-250,-400),
                0.002,0.0000001,0.000009));*/
  /*      lights.add(new SpotLight(new Color(230, 0, 0)
                , new Point3D(75, 75, -400),
                0, 0, 0.0000005, new Vector(0, 0, -1)));*/




        ///////////////////////////////////////
        //////////RENDERING ATTRIBUTES/////////
        ///////////////////////////////////////
        scene.set_lights(lights);
        ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        scene.get_ambientLight().set_Ka(0.15);
        render.renderImage();
        //   render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }

    @Test
    public void lightRendering2() throws Exception {
//TODO need to take care of the both lights and shadows of the plane
        Scene scene = new Scene();

        //////////////////////////////////
        ///////////GEOMETRIES/////////////
        //////////////////////////////////
        scene.addGeometry(new Sphere(50,new Point3D(0, 0, -500),
                new Material(1, 1, 1,1,15),
                new Color(20, 50, 100)));
/* Triangle triangle1 = new Triangle(new Point3D(-250, 250, -500),
                new Point3D(-250, -250, -500),
                new Point3D(500,0, -500)
                , new Material(1,1,15), new Color(25,200,10));
        scene.addGeometry(triangle1);*/
        /*Triangle triangle1 = new Triangle(new Point3D(-100, -1000, -1000),
                new Point3D(-100, 1000, -1000),
                new Point3D(-100, 0, 0)
                , new Material(1,1,15), new Color(25,200,10));
        scene.addGeometry(triangle1);*/
        Plane plane = new Plane(new Point3D(0,0,-506),new Vector(0,0,1),
                new Material(1,1,1,1,15), new Color(140,10,200));
        scene.addGeometry(plane);

        /////////////////////////////////////
        ////////////////LIGHTS///////////////
        /////////////////////////////////////
        ArrayList <Light> lights = new ArrayList <>();
      /* lights.add(new PointLight(new Color(150, 24, 50)
                , new Point3D(50, 50,-600),
                0.0001, 0.005, 0.00001));
       lights.add(new PointLight(new Color(20, 200, 20)
              , new Point3D(50, -50,-400),
                0.0001, 0.005, 0.000001));*/
        lights.add(new SpotLight(new Color(150, 24, 50)
                , new Point3D(10, 10,-450),
                0, 0.0001, 0.00000005,new Vector(0,-0.5,-1)));
  /*      lights.add(new SpotLight(new Color(150, 24, 50)
                , new Point3D(-70, -70,-400),
                0.00001, 0.0005, 0.0000000001,new Vector(new Point3D(1,1,-1))));*/
/*        lights.add(new PointLight(new Color(150,24,50)
                ,new Point3D(-250,-250,-400),
                0.002,0.0000001,0.000009));*/
  /*      lights.add(new SpotLight(new Color(230, 0, 0)
                , new Point3D(75, 75, -400),
                0, 0, 0.0000005, new Vector(0, 0, -1)));*/
        //  lights.add(new DirectionalLight());



        ///////////////////////////////////////
        //////////RENDERING ATTRIBUTES/////////
        ///////////////////////////////////////
        scene.set_lights(lights);
        ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        scene.get_ambientLight().set_Ka(0.0005);
        render.renderImage();
        //   render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }





}