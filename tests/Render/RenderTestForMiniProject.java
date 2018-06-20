package Render;

import Elements.Light;
import Elements.SpotLight;
import Geometrics.Plane;
import Geometrics.Sphere;
import Geometrics.Triangle;
import Mesh.RectangleMesh;
import Primitives.Color;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Vector;
import Scene.Scene;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RenderTestForMiniProject {

    @Test
    void renderImage() throws Exception {
        Scene scene = new Scene();

        //////////////////////////////////
        ///////////GEOMETRIES/////////////
        //////////////////////////////////
        scene.addGeometry(new Sphere(50, new Point3D(0, -0, -440),
                new Material(1, 1, 0, 0, 5),
                new Color(java.awt.Color.ORANGE)));
        scene.addGeometry(new Plane(new Point3D(0, 0, -506), new Vector(0, 0, 1),
                new Material(1, 1, 0, 0, 15), new Color(java.awt.Color.DARK_GRAY)));

        scene.addGeometry(new Triangle(new Point3D(250, 0, -250),
                new Point3D(0, 100, -250),
                new Point3D(0, -100, -250)
                , new Material(1, 1, 1, 1, 15), new Color(25, 200, 10)));




        /////////////////////////////////////
        ////////////////LIGHTS///////////////
        /////////////////////////////////////

        ArrayList<Light> lights = new ArrayList <>();
        lights.add(new SpotLight(new Color(255, 255, 255)
                , new Point3D(250, 250, -350),
                0, 0, 0.000001, new Vector(-2, -2, 1)));


        ///////////////////////////////////////
        //////////RENDERING ATTRIBUTES/////////
        ///////////////////////////////////////
        scene.set_lights(lights);
        ImageWriter imageWriter = new ImageWriter("Render test - Houses - MinProject", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        scene.get_ambientLight().set_Ka(0.0005);
        render.renderImage();
        //   render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }

    @Test
    void renderImage_parts() throws Exception {
        Scene scene = new Scene();

        //////////////////////////////////
        ///////////GEOMETRIES/////////////
        //////////////////////////////////
//wallE
        /*for (Triangle triangle: scene.buildSquare(
                new Point3D(50, -230,-450 ),
                new Point3D(50, -90,-300 ),
                new Point3D(-50, -90, -300),
                new Point3D(-50, -230, -450),
                new Material(1, 1, 0, 1, 8), new Color(150, 10, 10))) {
            scene.addGeometry(triangle);
        }*/
/*
        for (Triangle triangle: scene.buildSquare(
                new Point3D(50, -240,-450 ),
                new Point3D(50, -100,-300 ),
                new Point3D(-50, -100, -300),
                new Point3D(-50, -240, -450),
                new Material(1, 1, 0, 1, 8), new Color(150, 10, 10))) {
            scene.addGeometry(triangle);
        }*/

        /*
        //wallE
        for (Triangle triangle: scene.buildSquare(
                new Point3D(0, -230, -500),
                new Point3D(20, -50, -250),
                new Point3D(5, -50, -250),
                new Point3D(-20, -230, -500),
                new Material(1, 1, 0, 1, 8), new Color(150, 10, 10))) {
            scene.addGeometry(triangle);
        }

        for (Triangle triangle: scene.buildSquare(
                new Point3D(-60, -230, -500),
                new Point3D(-35, -50, -250),
                new Point3D(-70, -50, -250),
                new Point3D(-100, -230, -500),
                new Material(1, 1, 0, 1, 8), new Color(150, 10, 10))) {
            scene.addGeometry(triangle);
        }


        for (Triangle triangle: scene.buildSquare(
                new Point3D(-15, -230, -500),
                new Point3D(-35, -150, -250),
                new Point3D(-70, -150, -250),
                new Point3D(-65, -230, -500),
                new Material(1, 1, 0, 1, 8), new Color(150, 10, 10))) {
            scene.addGeometry(triangle);
        }
      /*  //wallE
        for (Triangle triangle: scene.buildSquare(
                new Point3D(0, -230, -500),
                new Point3D(5, -210, -480),
                new Point3D(-105, -210, -480),
                new Point3D(-100, -230, -500),
                new Material(1, 1, 0, 0, 8), new Color(25, 200, 10))) {
            scene.addGeometry(triangle);
        }*/



       /* for (Triangle triangle: scene.buildSquare(new Point3D(0, -230, -450),
                new Point3D(-100, -230, -500),
                new Point3D(-70, -50, -250),
                new Point3D(20, -50, -250),
                new Material(1, 1, 0, 0, 8), new Color(25, 200, 10))) {
            scene.addGeometry(triangle);
        }*/



        /*scene.addGeometry((new Point3D(250, 0, -250),
                new Point3D(0, 100, -250),
                new Point3D(0, -100, -250)
                , new Material(1, 1, 1, 1, 15), new Color(25, 200, 10)));*/



        /////////////////////////////////////
        ////////////////LIGHTS///////////////
        /////////////////////////////////////

        ArrayList<Light> lights = new ArrayList <>();
        lights.add(new SpotLight(new Color(255, 255, 255)
                , new Point3D(250, 250, -350),
                0, 0, 0.000001, new Vector(-2, -2, 1)));


        ///////////////////////////////////////
        //////////RENDERING ATTRIBUTES/////////
        ///////////////////////////////////////
        scene.set_lights(lights);
        ImageWriter imageWriter = new ImageWriter("Roof1", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        scene.get_ambientLight().set_Ka(0.0005);
        render.renderImage();
        render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }

    @Test
    public void triangle_test() throws Exception {

        Scene scene = new Scene();

        //////////////////////////////////
        ///////////GEOMETRIES/////////////
        //////////////////////////////////
       /*ectangleMesh rec1 = new RectangleMesh(20, 30, new Material(1, 1, 0, 0, 15), new Color(150, 0, 0));
        rec1.moveTO(-150);
        //rec1.moveRIGHT(-50);
        for (Triangle t : rec1.toTriangle()) {
            scene.addGeometry(t);
        }*/

        RectangleMesh rec = new RectangleMesh(100, 200, new Material(1, 1, 0, 0, 15), new Color(0, 0, 150));
       // rec.moveUP(25);
       // rec.moveRIGHT(-25);
        rec.rotrateTO(100);
        for (Triangle t : rec.toTriangle()) {
            scene.addGeometry(t);
        }
        /////////////////////////////////////
        ////////////////LIGHTS///////////////
        /////////////////////////////////////

        ArrayList <Light> lights = new ArrayList <>();
        lights.add(new SpotLight(new Color(255, 255, 255)
                , new Point3D(250, 250, -350),
                0, 0, 0.000001, new Vector(-2, -2, 1)));


        ///////////////////////////////////////
        //////////RENDERING ATTRIBUTES/////////
        ///////////////////////////////////////
        scene.set_lights(lights);
        ImageWriter imageWriter = new ImageWriter("Rectangle_test", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        scene.get_ambientLight().set_Ka(0.0005);
        render.renderImage();
        render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }


    }
