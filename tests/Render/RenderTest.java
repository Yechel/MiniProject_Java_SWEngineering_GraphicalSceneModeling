package Render;

        import Geometrics.Geometry;
        import Geometrics.Sphere;
        import Geometrics.Triangle;
        import Primitives.Point3D;
        import Scene.Scene;
        import org.junit.Test;


public class RenderTest {

    @Test
    public void basicRendering() throws Exception {

        Scene scene = new Scene();
       scene.addGeometry(new Sphere(35, new Point3D(0, 0, -50)));

        Triangle triangle = new Triangle(new Point3D( 1, 0, -1),
                new Point3D(  0, 1, -1),
                new Point3D( 1, 1, -1));

        Triangle triangle5 = new Triangle(new Point3D( 100, 0, -50),
                new Point3D(  0, 100, -50),
                new Point3D( 100, 100, -50));

        Triangle triangle2 = new Triangle(new Point3D( -100, 0, -49),
                new Point3D(  0, 100, -49),
                new Point3D( -100,100, -49));

        Triangle triangle3 = new Triangle(new Point3D(100, 0, -49),
                new Point3D(  0, -100, -49),
                new Point3D(100, -100, -49));

        Triangle triangle4 = new Triangle(new Point3D(-100, 0, -49),
                new Point3D(  0,  -100, -49),
                new Point3D(-100, -100, -49));

     //   scene.addGeometry(triangle);
        //scene.addGeometry(triangle2);
        //scene.addGeometry(triangle3);
        //scene.addGeometry(triangle4);

        ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);

        Render render = new Render(scene,imageWriter);

        render.renderImage();
        render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }


}