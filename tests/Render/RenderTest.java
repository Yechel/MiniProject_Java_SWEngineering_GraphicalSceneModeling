package Render;

        import Geometrics.Geometry;
        import Geometrics.Sphere;
        import Geometrics.Triangle;
        import Primitives.Point3D;
        import Primitives.Ray;
        import Primitives.Vector;
        import Scene.Scene;
        import org.junit.Test;


public class RenderTest {

    @Test
    public void basicRendering() throws Exception {

        Scene scene = new Scene();
       scene.addGeometry(new Sphere(50, new Point3D(0, 0, -500)));

        Triangle triangle = new Triangle(new Point3D( 100, 0, -149),
                new Point3D(  0, 100, -149),
                new Point3D( 100, 100, -149));

        Triangle triangle2 = new Triangle(new Point3D( -100, 0, -149),
                new Point3D(  0, 100, -149),
                new Point3D( -100,100, -149));

        Triangle triangle3 = new Triangle(new Point3D(100, 0, -149),
                new Point3D(  0, -100, -149),
                new Point3D(100, -100, -149));

        Triangle triangle4 = new Triangle(new Point3D(-100, 0, -149),
                new Point3D(  0,  -100, -149),
                new Point3D(-100, -100, -149));

       scene.addGeometry(triangle);
       scene.addGeometry(triangle2);
       scene.addGeometry(triangle3);
       scene.addGeometry(triangle4);

        ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);

        Render render = new Render(scene,imageWriter);

        render.renderImage();
        render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }


}