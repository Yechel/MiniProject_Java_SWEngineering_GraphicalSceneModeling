package Render;

import Elements.Light;
import Elements.PointLight;
import Elements.SpotLight;
import Geometrics.Plane;
import Geometrics.Sphere;
import Geometrics.Triangle;
import Primitives.Color;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Vector;
import Scene.Scene;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RenderTest1 {

 //test case: 1 sphere in the center, 4 triangles around it, and checking printGrid func

    @Test
    public void basicRendering() throws Exception {

        Scene scene = new Scene();
        scene.addGeometry(new Sphere(50, new Point3D(0, 0, -500),
                new Material(1, 1, 1, 0, 15),
                new Color(255, 255, 255)));
        scene.addGeometry(new Triangle(new Point3D(100, 100, -500),
                new Point3D(0, 100, -500),
                new Point3D(100, 0, -500)
                , new Material(1, 1, 1, 0, 15), new Color(0, 255, 255)));
        scene.addGeometry(new Triangle(new Point3D(-100, 100, -500),
                new Point3D(0, 100, -500),
                new Point3D(-100, 0, -500)
                , new Material(1, 1, 1, 0, 15), new Color(25, 200, 10)));
        scene.addGeometry(new Triangle(new Point3D(100, -100, -500),
                new Point3D(0, -100, -500),
                new Point3D(100, 0, -500)
                , new Material(1, 1, 1, 0, 15), new Color(25, 200, 10)));
        scene.addGeometry(new Triangle(new Point3D(-100, -100, -500),
                new Point3D(0, -100, -500),
                new Point3D(-100, 0, -500)
                , new Material(1, 1, 1, 1, 15), new Color(25, 200, 10)));


//
        ArrayList<Light> lights = new ArrayList <>();
        lights.add(new PointLight( new Color(255,255,255)
                ,new Point3D(0,0,-1),0,0,0.000000001 ));


        scene.set_lights(lights);
        ImageWriter imageWriter = new ImageWriter("Render test- basic test1", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        render.renderImage();
        render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }

//test case: 1 sphere in the center, 4 triangles around it with colors

    @Test
    public void basicRendering1() throws Exception {

        Scene scene = new Scene();
        scene.addGeometry(new Sphere(50, new Point3D(0, 0, -500),
                new Material(1, 1, 1, 0, 15),
                new Color(255, 255, 255)));
        scene.addGeometry(new Triangle(new Point3D(100, 100, -500),
                new Point3D(0, 100, -500),
                new Point3D(100, 0, -500)
                , new Material(1, 1, 1, 0, 15), new Color(0, 150, 150)));
        scene.addGeometry(new Triangle(new Point3D(-100, 100, -500),
                new Point3D(0, 100, -500),
                new Point3D(-100, 0, -500)
                , new Material(1, 1, 1, 0, 15), new Color(150, 150, 0)));
        scene.addGeometry(new Triangle(new Point3D(100, -100, -500),
                new Point3D(0, -100, -500),
                new Point3D(100, 0, -500)
                , new Material(1, 1, 1, 0, 15), new Color(150, 0, 150)));
        scene.addGeometry(new Triangle(new Point3D(-100, -100, -500),
                new Point3D(0, -100, -500),
                new Point3D(-100, 0, -500)
                , new Material(1, 1, 1, 1, 15), new Color(50, 100, 150)));


//
 ArrayList <Light> lights = new ArrayList <>();
        lights.add(new PointLight( new Color(255,255,255)
                ,new Point3D(0,0,-1),0,0,0.000000001 ));



        //scene.set_lights(lights);
        ImageWriter imageWriter = new ImageWriter("Render test- basic test2", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        scene.get_ambientLight().set_Ka(0.15);
        render.renderImage();
        render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }

 //test case: 1 sphere in the center, 4 triangles around it with colors
  //  adding other light source and reduce the ambient light to 0

    @Test
    public void basicRendering2() throws Exception {

        Scene scene = new Scene();
        scene.addGeometry(new Sphere(50, new Point3D(0, 0, -500),
                new Material(1, 1, 1, 0, 15),
                new Color(255, 255, 255)));
        scene.addGeometry(new Triangle(new Point3D(100, 100, -500),
                new Point3D(0, 100, -500),
                new Point3D(100, 0, -500)
                , new Material(1, 1, 1, 0, 15), new Color(0, 150, 150)));
        scene.addGeometry(new Triangle(new Point3D(-100, 100, -500),
                new Point3D(0, 100, -500),
                new Point3D(-100, 0, -500)
                , new Material(1, 1, 1, 0, 15), new Color(150, 150, 0)));
        scene.addGeometry(new Triangle(new Point3D(100, -100, -500),
                new Point3D(0, -100, -500),
                new Point3D(100, 0, -500)
                , new Material(1, 1, 1, 0, 15), new Color(150, 0, 150)));
        scene.addGeometry(new Triangle(new Point3D(-100, -100, -500),
                new Point3D(0, -100, -500),
                new Point3D(-100, 0, -500)
                , new Material(1, 1, 1, 1, 15), new Color(50, 100, 150)));

        ArrayList <Light> lights = new ArrayList <>();
        lights.add(new PointLight( new Color(255,255,255)
                ,new Point3D(0,0,-1),0,0,0.00000001 ));
        scene.set_lights(lights);
        ImageWriter imageWriter = new ImageWriter("Render test- basic test3", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        scene.get_ambientLight().set_Ka(0.0);
        render.renderImage();
        render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }

    @Test
    public void basicRendering3() throws Exception {

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
        new Material(0,5,5,1,1),
        new Color(140,10,200));*/

        // scene.addGeometry(plane);
        ArrayList <Light> lights = new ArrayList <>();
        lights.add(new PointLight(new Color(150, 24, 50)
                , new Point3D(-130, -130, -300),
                0.0001, 0.005, 0.000001));
        lights.add(new PointLight(new Color(150,24,50)
                ,new Point3D(-250,-250,-400),
                0.002,0.0000001,0.000009));

      lights.add(new SpotLight(new Color(230, 0, 0)
                , new Point3D(75, 75, -400),
                0, 0, 0.0000005, new Vector(0, 0, -1)));

        //  lights.add(new DirectionalLight());

        scene.set_lights(lights);
        ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        scene.get_ambientLight().set_Ka(0.15);
        render.renderImage();
        //   render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }


   // test case: throw lights in diffrente angles on planes and spheres


    @Test
    public void deffuiseAndSpecularTestint_PointLight_plane() throws Exception {

        Scene scene = new Scene();
        scene.addGeometry(new Plane(new Point3D(-100,0,0),
                new Vector(1,0,0),
                new Material(0,5,0,0,1),
                new Color(140,10,200)));


        ArrayList <Light> lights = new ArrayList <>();
        lights.add(new Elements.PointLight(new Color(150, 24, 50)
                , new Point3D(-50, 0, -500),
                0.00001, 0.0005, 0.000001));

        scene.set_lights(lights);
        ImageWriter imageWriter = new ImageWriter("deffuiseAndSpecularTestint_PointLight_plane", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        scene.get_ambientLight().set_Ka(0.15);
        render.renderImage();
        //   render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }

    @Test
    public void deffuiseAndSpecularTestint_SpotLight_plane() throws Exception {

        Scene scene = new Scene();
        scene.addGeometry(new Plane(new Point3D(-100,0,0),
                new Vector(1,0,0),
                new Material(0,5,0,0,1),
                new Color(140,10,200)));


        ArrayList <Light> lights = new ArrayList <>();
        lights.add(new Elements.SpotLight(new Color(150, 24, 50)
                , new Point3D(200, -100, -300),
                0.0001, 0.005, 0.0000001, new Vector(-1,1,-1)));

        scene.set_lights(lights);
        ImageWriter imageWriter = new ImageWriter("deffuiseAndSpecularTestint_SpotLight_plane", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        scene.get_ambientLight().set_Ka(0.15);
        render.renderImage();
        //   render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }
    @Test
    public void deffuiseAndSpecularTestint_PointLight_sphere() throws Exception {

        Scene scene = new Scene();
        scene.addGeometry(new Sphere(100, new Point3D(0, 0, -500),
                new Material(1, 1, 1, 1, 15),
                new Color(20, 50, 100)));
        ArrayList <Light> lights = new ArrayList <>();
        lights.add(new Elements.PointLight(new Color(150, 24, 50)
                , new Point3D(-130, -130, -300),
                0.0001, 0.005, 0.000001));


        scene.set_lights(lights);
        ImageWriter imageWriter = new ImageWriter("deffuiseAndSpecularTestint_PointLight_Sphere", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        scene.get_ambientLight().set_Ka(0.15);
        render.renderImage();
        //   render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }
    @Test
    public void deffuiseAndSpecularTestint_SpotLight_sphere() throws Exception {


        Scene scene = new Scene();
        scene.addGeometry(new Sphere(100, new Point3D(0, 0, -500),
                new Material(1, 1, 1, 1, 15),
                new Color(20, 50, 100)));
        ArrayList <Light> lights = new ArrayList <>();
        lights.add(new Elements.SpotLight(new Color(150, 24, 50)
                , new Point3D(-100, -100, -400),
                0.0001, 0.005, 0.0000001,new Vector(9,9,-1)));


        scene.set_lights(lights);
        ImageWriter imageWriter = new ImageWriter("deffuiseAndSpecularTestint_SpotLight_Sphere", 500, 500, 500, 500);
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
        lights.add(new PointLight(new Color(150,24,50)
                ,new Point3D(-250,-250,-400),
                0.002,0.0000001,0.000009));

      lights.add(new SpotLight(new Color(230, 0, 0)
                , new Point3D(75, 75, -400),
                0, 0, 0.0000005, new Vector(0, 0, -1)));





        ///////////////////////////////////////
        //////////RENDERING ATTRIBUTES/////////
        ///////////////////////////////////////
        scene.set_lights(lights);
        ImageWriter imageWriter = new ImageWriter("Render test - shadows 2", 500, 500, 500, 500);
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
                new Material(2, 2, 1,1,15),
                new Color(20, 50, 100)));
        Plane plane = new Plane(new Point3D(0,0,-506),new Vector(0,0,1),
                new Material(1,1,1,1,15), new Color(140,10,200));
        scene.addGeometry(plane);

        /////////////////////////////////////
        ////////////////LIGHTS///////////////
        /////////////////////////////////////
        ArrayList <Light> lights = new ArrayList <>();
        lights.add(new SpotLight(new Color(150, 24, 50)
                , new Point3D(10, 10,-445),
                0, 0.0001, 0.00000005,new Vector(0,-0.5,-1)));


        ///////////////////////////////////////
        //////////RENDERING ATTRIBUTES/////////
        ///////////////////////////////////////
        scene.set_lights(lights);
        ImageWriter imageWriter = new ImageWriter("Render test - Shadow4", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        scene.get_ambientLight().set_Ka(0.0005);
        render.renderImage();
        //   render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }

    @Test
    public void lightRendering_refracting() throws Exception {

        Scene scene = new Scene();

        //////////////////////////////////
        ///////////GEOMETRIES/////////////
        //////////////////////////////////
        scene.addGeometry(new Sphere(50,new Point3D(0, 0, -460),
                new Material(1, 1, 3,0.5,1),
                new Color(100, 0, 0)));
        scene.addGeometry(new Sphere(100,new Point3D(0, 0, -500),
                new Material(1, 1, 0,0.5,3),
                new Color(0, 0, 100)));
        Triangle triangle1 = new Triangle(new Point3D(0, 0, -500),
                new Point3D(0, 400, -500),
                new Point3D(200, 200, -500)
                , new Material(1,1,1,1,15), new Color(25,200,10));
        scene.addGeometry(triangle1);


        /////////////////////////////////////
        ////////////////LIGHTS///////////////
        /////////////////////////////////////
        ArrayList <Light> lights = new ArrayList <>();
        lights.add(new SpotLight(new Color(255, 255, 255)
                , new Point3D(90, -90,-390),
                0.001, 0.0001, 0.000000001,new Vector(0,1,-1)));




        ///////////////////////////////////////
        //////////RENDERING ATTRIBUTES/////////
        ///////////////////////////////////////
        scene.set_lights(lights);
        ImageWriter imageWriter = new ImageWriter("Render test - Sphere within Sphere", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        scene.get_ambientLight().set_Ka(0.0005);
        render.renderImage();
        //   render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }

    @Test
    public void lightRendering_reflecting() throws Exception {

        Scene scene = new Scene();

        //////////////////////////////////
        ///////////GEOMETRIES/////////////
        //////////////////////////////////
        scene.addGeometry(new Sphere(30,new Point3D(50, -50, -430),
                new Material(1, 1, 3,1,5),
                new Color(java.awt.Color.RED)));
        scene.addGeometry(new Sphere(50,new Point3D(-70, 70, -430),
                new Material(1, 1, 0.0005,0.005,5),
                new Color(java.awt.Color.BLUE)));
        Triangle triangle1 = new Triangle(new Point3D(250, -250, -500),
                new Point3D(-250, 250, -500),
                new Point3D(125, 125, -250)
                , new Material(1,1,3,1,2), new Color(java.awt.Color.GRAY));
        scene.addGeometry(triangle1);


        /////////////////////////////////////
        ////////////////LIGHTS///////////////
        /////////////////////////////////////
        ArrayList <Light> lights = new ArrayList <>();
        lights.add(new SpotLight(new Color(255, 0, 0)
                , new Point3D(100, -100,-400),
                0, 0.0001, 0.00000005,new Vector(-1,1,0)));




        ///////////////////////////////////////
        //////////RENDERING ATTRIBUTES/////////
        ///////////////////////////////////////
        scene.set_lights(lights);
        ImageWriter imageWriter = new ImageWriter("Render test - reflection2", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        scene.get_ambientLight().set_Ka(0.0005);
        render.renderImage();
        //   render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }

    @Test
    public void lightRendering_softShadows1() throws Exception {

        Scene scene = new Scene();

        //////////////////////////////////
        ///////////GEOMETRIES/////////////
        //////////////////////////////////
        scene.addGeometry(new Sphere(50,new Point3D(0, -0, -440),
                new Material(2, 2, 0,0,5),
                new Color(java.awt.Color.ORANGE)));
        scene.addGeometry( new Plane(new Point3D(0,0,-506),new Vector(0,0,1),
                new Material(1,1,1,1,15), new Color(java.awt.Color.DARK_GRAY)));




        /////////////////////////////////////
        ////////////////LIGHTS///////////////
        /////////////////////////////////////
        ArrayList <Light> lights = new ArrayList <>();
        lights.add(new SpotLight(new Color(255, 255, 255)
                , new Point3D(250, 250,-400),
                0, 0.0001, 0.00000005,new Vector(-2,-2,1)));




        ///////////////////////////////////////
        //////////RENDERING ATTRIBUTES/////////
        ///////////////////////////////////////
        scene.set_lights(lights);
        ImageWriter imageWriter = new ImageWriter("Render test - softShadows21", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        scene.get_ambientLight().set_Ka(0.0005);
        render.renderImage();
        //   render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }

    @Test
    public void lightRendering_softShadows_get_closer() throws Exception {

        Scene scene = new Scene();
        scene.get_camera().set_P0(new Point3D(-50,-50,-100));
        //////////////////////////////////
        ///////////GEOMETRIES/////////////
        //////////////////////////////////
        scene.addGeometry(new Sphere(50,new Point3D(0, -0, -440),
                new Material(2, 2, 0,0,5),
                new Color(java.awt.Color.ORANGE)));
        scene.addGeometry( new Plane(new Point3D(0,0,-506),new Vector(0,0,1),
                new Material(1,1,1,1,15), new Color(java.awt.Color.DARK_GRAY)));




        /////////////////////////////////////
        ////////////////LIGHTS///////////////
        /////////////////////////////////////
        ArrayList <Light> lights = new ArrayList <>();
        lights.add(new SpotLight(new Color(255, 255, 255)
                , new Point3D(150, 150,-200),
                0, 0.0001, 0.00000005,new Vector(-2,-2,1)));




        ///////////////////////////////////////
        //////////RENDERING ATTRIBUTES/////////
        ///////////////////////////////////////
        scene.set_lights(lights);
        ImageWriter imageWriter = new ImageWriter("Render test - softShadows-get closer", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        scene.get_ambientLight().set_Ka(0.0005);
        render.renderImage();
        //   render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }

    @Test
    public void lightRendering_softShadows_get_farther() throws Exception {

        Scene scene = new Scene();

        //////////////////////////////////
        ///////////GEOMETRIES/////////////
        //////////////////////////////////
        scene.addGeometry(new Sphere(50,new Point3D(0, -0, -440),
                new Material(2, 2, 0,0,5),
                new Color(java.awt.Color.ORANGE)));
        scene.addGeometry( new Plane(new Point3D(0,0,-506),new Vector(0,0,1),
                new Material(1,1,1,1,15), new Color(java.awt.Color.DARK_GRAY)));




        /////////////////////////////////////
        ////////////////LIGHTS///////////////
        /////////////////////////////////////
        ArrayList <Light> lights = new ArrayList <>();
        lights.add(new SpotLight(new Color(255, 255, 255)
                , new Point3D(450, 450,-400),
                0, 0.0001, 0.00000005,new Vector(-2,-2,1)));




        ///////////////////////////////////////
        //////////RENDERING ATTRIBUTES/////////
        ///////////////////////////////////////
        scene.set_lights(lights);
        ImageWriter imageWriter = new ImageWriter("Render test - softShadows-get farther", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        scene.get_ambientLight().set_Ka(0.0005);
        render.renderImage();
        //   render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }
}
