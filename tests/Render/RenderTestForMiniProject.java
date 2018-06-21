package Render;

import Elements.Light;
import Elements.PointLight;
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

        ArrayList <Light> lights = new ArrayList <>();
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
        RectangleMesh wallE;

        wallE = new RectangleMesh(100, 200, new Material(1, 1, 0, 0, 8), new Color(0, 0, 150));
        wallE.rotrateAxisUP(60);
        wallE.rotrateAxisRIGHT(45);
       // wallE.rotrateAxisTO(45);
     //   wallE.rotrateAxisRIGHT(45);
        //wallE.move(-50,-150,0);
        for (Triangle t:wallE.toTriangle()
             ) {
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
        ImageWriter imageWriter = new ImageWriter("part1", 500, 500, 500, 500);
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

        RectangleMesh[] wallE = new RectangleMesh[7];
        wallE[0] = new RectangleMesh(30, 200, new Material(1, 1, 0, 0, 8), new Color(100, 120, 100));
        wallE[0].rotrate(60,0,0);
        wallE[0].move(-15,-85,40);
        wallE[1] = new RectangleMesh(50, 50, wallE[0].get_material(), wallE[0].get_emission());
        wallE[1].rotrate(60,0,0);
        wallE[1].move(-50,-140,0);
        wallE[1].get_pointList().set(0,wallE[0].get_pointList().get(3));
        wallE[2] = new RectangleMesh(70, 200, wallE[0].get_material(), wallE[0].get_emission());
        wallE[2].rotrate(60,0,0);
        wallE[2].move(-110,-85,0);
        wallE[2].get_pointList().set(0,wallE[1].get_pointList().get(3));
        wallE[3] = new RectangleMesh(50, 20, new Material(1, 1, 0, 0, 8), new Color(150, 0, 0));
        wallE[3].rotrate(150,0,0);
        wallE[3].move(-50,-115,0);
        wallE[3].get_pointList().set(0,wallE[1].get_pointList().get(1));
        wallE[3].get_pointList().set(3,wallE[1].get_pointList().get(2));
//        wallE[3].get_pointList().get(0).set_right( wallE[3].get_pointList().get(0).get_right().get_coordinate()+30);
//        wallE[3].get_pointList().get(3).set_right( wallE[3].get_pointList().get(3).get_right().get_coordinate()+30);
        wallE[4] = new RectangleMesh(20, 80, new Material(1, 1, 0, 0, 8), new Color(0, 150, 0));
        wallE[4].rotrate(60,0,0);
        wallE[4].move(-80,-75,-10);
        wallE[4].get_pointList().set(0,wallE[3].get_pointList().get(2));
        wallE[4].get_pointList().set(3,wallE[3].get_pointList().get(3));
//        wallE[4].get_pointList().get(0).set_to( wallE[4].get_pointList().get(0).get_to().get_coordinate()-20);
//        wallE[4].get_pointList().get(1).set_to( wallE[4].get_pointList().get(1).get_to().get_coordinate()-20);
        wallE[5] = new RectangleMesh (50, 100, new Material(1, 1, 0, 0.9, 8), new Color(0, 70, 150));
        wallE[5].rotrate(60,0,0);
        wallE[5].move(-55,-55,-30);
        wallE[5].get_pointList().set(0,wallE[3].get_pointList().get(1));
        wallE[5].get_pointList().set(3,wallE[4].get_pointList().get(0));
        wallE[6] = new RectangleMesh(50, 50, wallE[0].get_material(), wallE[0].get_emission());
        wallE[6].rotrate(60,0,0);
        wallE[6].move(-55,-15,20);
        wallE[6].get_pointList().set(1,wallE[2].get_pointList().get(2));
        wallE[6].get_pointList().set(2,wallE[0].get_pointList().get(1));
        for (RectangleMesh rec : wallE
                ) {
            for (Triangle t : rec.toTriangle()) {
                scene.addGeometry(t);
            }
        }

        RectangleMesh[] wallN = new RectangleMesh[4];
        wallN[0] = new RectangleMesh(30, 140, wallE[0].get_material(), wallE[0].get_emission());
        wallN[0].rotrate(150,0,0);
        wallN[0].move(-15,55,0);
        wallN[0].get_pointList().set(0,wallE[0].get_pointList().get(1));
        wallN[0].get_pointList().set(3,wallE[0].get_pointList().get(2));
        wallN[1] = new RectangleMesh(120, 30,wallE[0].get_material(), wallE[0].get_emission());
        wallN[1].rotrate(150,0,0);
        wallN[1].move(-105,40,20);
        wallN[1].get_pointList().set(0,new Point3D(wallE[0].get_pointList().get(1)));
        wallN[1].get_pointList().set(3,new Point3D(wallE[2].get_pointList().get(2)));
        wallN[1].get_pointList().get(1).set_right( wallN[1].get_pointList().get(1).get_right().get_coordinate()-60);
        wallN[1].get_pointList().get(2).set_right( wallN[1].get_pointList().get(2).get_right().get_coordinate()-60);
        wallN[1].get_pointList().get(1).set_up( wallN[1].get_pointList().get(1).get_up().get_coordinate()-20);
        wallN[2] = new RectangleMesh(wallN[1]);
        wallN[2].move(0,0,-80);

        /*wallN[2] = new RectangleMesh(120, 30,wallE[0].get_material(), wallE[0].get_emission());
        wallN[2].rotrate(150,0,0);
        wallN[2].move(-85,55,-20);
        wallN[2].get_pointList().get(0).set_right( wallN[2].get_pointList().get(0).get_right().get_coordinate()+60);
        wallN[2].get_pointList().get(3).set_right( wallN[2].get_pointList().get(3).get_right().get_coordinate()+60);
       */ wallN[3] = new RectangleMesh(120, 20, new Material(1, 1, 0, 0, 8), new Color(150, 0, 0));
        wallN[3].rotrate(60,0,0);
        wallN[3].move(-90,55,0);
//        wallN[3].get_pointList().get(0).set_right(wallN[3].get_pointList().get(0).get_right().get_coordinate()+60);
//        wallN[3].get_pointList().get(3).set_right(wallN[3].get_pointList().get(3).get_right().get_coordinate()+60);
//        wallN[3].get_pointList().get(1).set_right(wallN[3].get_pointList().get(1).get_right().get_coordinate()-30);
//        wallN[3].get_pointList().get(2).set_right(wallN[3].get_pointList().get(2).get_right().get_coordinate()-30);
       for (RectangleMesh rec : wallN
                ) {
            for (Triangle t : rec.toTriangle()) {
                scene.addGeometry(t);
            }
        }

        RectangleMesh[] Roof = new RectangleMesh[1];
        Roof[0] = new RectangleMesh(133, 220, new Material(1, 1, 0, 0, 8), new Color(150, 100, 100));
        Roof[0].rotrate(60,0,0);
        Roof[0].move(60,-95,20);
        Roof[0].get_pointList().get(0).set_to( Roof[0].get_pointList().get(0).get_to().get_coordinate()-150);
        Roof[0].get_pointList().get(0).set_up( Roof[0].get_pointList().get(0).get_up().get_coordinate()-50);
        Roof[0].get_pointList().get(1).set_to( Roof[0].get_pointList().get(1).get_to().get_coordinate()-150);
        Roof[0].get_pointList().get(1).set_up( Roof[0].get_pointList().get(1).get_up().get_coordinate()-50);
     /* Roof[1] = new RectangleMesh(120, 30, new Material(1, 1, 0, 0, 8), new Color(0, 0, 150));
        Roof[1].rotrate(150,0,0);
        Roof[1].move(-90,50,20);
        Roof[1].get_pointList().get(1).set_right( Roof[1].get_pointList().get(1).get_right().get_coordinate()-60);
        Roof[1].get_pointList().get(2).set_right( Roof[1].get_pointList().get(2).get_right().get_coordinate()-60);
        Roof[2] = new RectangleMesh(120, 30, new Material(1, 1, 0, 0, 8), new Color(0, 0, 150));
        Roof[2].rotrate(150,0,0);
        Roof[2].move(-85,55,-20);
        Roof[2].get_pointList().get(0).set_right( Roof[2].get_pointList().get(0).get_right().get_coordinate()+60);
        Roof[2].get_pointList().get(3).set_right( Roof[2].get_pointList().get(3).get_right().get_coordinate()+60);*/
        for (RectangleMesh rec : Roof
                ) {
            for (Triangle t : rec.toTriangle()) {
                scene.addGeometry(t);
            }
        }

        Triangle frontRoof = new Triangle(Roof[0].get_pointList().get(1),
                Roof[0].get_pointList().get(2),new Point3D(wallN[0].get_pointList().get(1)),
                Roof[0].get_material(),Roof[0].get_emission());
        frontRoof.set_p3( new Point3D(frontRoof.get_p3().get_up().get_coordinate(),
                                      frontRoof.get_p3().get_right().get_coordinate() + 40,
                                      frontRoof.get_p3().get_to().get_coordinate()-40));
        scene.addGeometry(frontRoof);



            /////////////////////////////////////
            ////////////////LIGHTS///////////////
            /////////////////////////////////////

            ArrayList <Light> lights = new ArrayList <>();
            lights.add(new PointLight(new Color(255, 255, 255)
                    , new Point3D(100, -50, 0),
                    0, 0, 0.00001));


            ///////////////////////////////////////
            //////////RENDERING ATTRIBUTES/////////
            ///////////////////////////////////////
            scene.set_lights(lights);
            ImageWriter imageWriter = new ImageWriter("house_test_1", 500, 500, 500, 500);
            Render render = new Render(scene, imageWriter);
            scene.get_ambientLight().set_Ka(0.0005);
            render.renderImage();
          //  render.printGrid(50);
            render.get_imageWriter().writeToimage();
        }


    }
