package Primitives;

import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {
    Vector v,u;
    @Test
    public void length() {
        v = new Vector(1, 0, 0);
        assertEquals("works!", 1, v.length(), 1e-10);

        v = new Vector(0, 1, 0);
        assertEquals("works!", 1, v.length(), 1e-10);

        v = new Vector(0, 0, 1);
        assertEquals("works!", 1, v.length(), 1e-10);

        v = new Vector(2, 2, 2);
        assertEquals("works!", Math.sqrt(12), v.length(), 1e-10);

        v = new Vector(0, 0, 0);
        assertEquals("works!", 0, v.length(), 1e-10);

        v = new Vector(3, 1, 0);
        assertEquals("works!", Math.sqrt(10), v.length(), 1e-10);

        v = new Vector(0, 4, 5);
        assertEquals("works!", Math.sqrt(41), v.length(), 1e-10);

        v = new Vector(2, 0, 7);
        assertEquals("works!", Math.sqrt(53), v.length(), 1e-10);
    }

    @Test
    public void crossProduct() {
        //sectors: 1 and 1
        v = new Vector(1, 1, 1);
        u = new Vector(1,1,1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,0)));


        //sectors: 1 and 2
        v = new Vector(1, 1, 1);
        u = new Vector(-1,1,1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,-2,2)));

        //sectors: 1 and 3
        v = new Vector(1, 1, 1);
        u = new Vector(1,-1,1);
        assertTrue( v.crossProduct(u).equals(new Vector(2,0,-2)));

        //sectors: 1 and 4
        v = new Vector(1, 1, 1);
        u = new Vector(-1,-1,1);
        assertTrue( v.crossProduct(u).equals(new Vector(2,-2,0)));

        //sectors: 1 and 5
        v = new Vector(1, 1, 1);
        u = new Vector(1,1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(-2,2,0)));

        //sectors: 1 and 6
        v = new Vector(1, 1, 1);
        u = new Vector(-1,1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(-2,0,2)));

        //sectors: 1 and 7
        v = new Vector(1, 1, 1);
        u = new Vector(1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,2,-2)));

        //sectors: 1 and 8
        v = new Vector(1, 1, 1);
        u = new Vector(-1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,0)));


        //sectors: 2 and 2
        v = new Vector(-1, 1, 1);
        u = new Vector(-1,1,1);
        assertTrue(  v.crossProduct(u).equals(new Vector(0,0,0)));

        //sectors: 2 and 3
        v = new Vector(-1, 1, 1);
        u = new Vector(1,-1,1);
        assertTrue( v.crossProduct(u).equals(new Vector(2,2,0)));

        //sectors: 2 and 4
        v = new Vector(-1, 1, 1);
        u = new Vector(-1,-1,1);
        assertTrue( v.crossProduct(u).equals(new Vector(2,0,2)));

        //sectors: 2 and 5
        v = new Vector(-1, 1, 1);
        u = new Vector(1,1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(-2,0,-2)));

        //sectors: 2 and 6
        v = new Vector(-1, 1, 1);
        u = new Vector(-1,1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(-2,-2,0)));

        //sectors: 2 and 7
        v = new Vector(-1, 1, 1);
        u = new Vector(1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,0)));

        //sectors: 2 and 8
        v = new Vector(-1, 1, 1);
        u = new Vector(-1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,-2,2)));

        //sectors: 3 and 3
        v = new Vector(1, -1, 1);
        u = new Vector(1,-1,1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,0)));

        //sectors: 3 and 4
        v = new Vector(1, -1, 1);
        u = new Vector(-1,-1,1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,-2,-2)));

        //sectors: 3 and 5
        v = new Vector(1, -1, 1);
        u = new Vector(1,1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,2,2)));

        //sectors: 3 and 6
        v = new Vector(1, -1, 1);
        u = new Vector(-1,1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,0)));

        //sectors: 3 and 7
        v = new Vector(1, -1, 1);
        u = new Vector(1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(2,2,0)));

        //sectors: 3 and 8
        v = new Vector(1, -1, 1);
        u = new Vector(-1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(2,0,-2)));

        //sectors: 4 and 4
        v = new Vector(-1, -1, 1);
        u = new Vector(-1,-1,1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,0)));

        //sectors: 4 and 5
        v = new Vector(-1, -1, 1);
        u = new Vector(1,1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,0)));

        //sectors: 4 and 6
        v = new Vector(-1, -1, 1);
        u = new Vector(-1,1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,-2,-2)));

        //sectors: 4 and 7
        v = new Vector(-1, -1, 1);
        u = new Vector(1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(2,0,2)));

        //sectors: 4 and 8
        v = new Vector(-1, -1, 1);
        u = new Vector(-1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(2,-2,0)));

        //sectors: 5 and 5
        v = new Vector(1, 1, -1);
        u = new Vector(1,1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,0)));

        //sectors: 5 and 6
        v = new Vector(1, 1, -1);
        u = new Vector(-1,1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,2,2)));

        //sectors: 5 and 7
        v = new Vector(1, 1, -1);
        u = new Vector(1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(-2,0,-2)));

        //sectors: 5 and 8
        v = new Vector(1, 1, -1);
        u = new Vector(-1,-1,-1);

        //sectors: 6 and 6
        v = new Vector(-1, 1, -1);
        u = new Vector(-1,1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,0)));

        //sectors: 6 and 7
        v = new Vector(-1, 1, -1);
        u = new Vector(1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(-2,-2,0)));

        //sectors: 6 and 8
        v = new Vector(-1, 1, -1);
        u = new Vector(-1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(-2,0,2)));

        //sectors: 7 and 7
        v = new Vector(1, -1, -1);
        u = new Vector(1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,0)));

        //sectors: 7 and 8
        v = new Vector(1, -1, -1);
        u = new Vector(-1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,2,-2)));

        //sectors: 8 and 8
        v = new Vector(-1, -1, -1);
        u = new Vector(-1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,0)));

       // crossProduct with (0,0,0)
        v = new Vector(1, 0, 0);
        u = new Vector(0,0,0);
        assertTrue(  v.crossProduct(u).equals(new Vector(0,0,0)));

    }

    @Test
    public void normalize() {
        v = new Vector(3.5, -5, 10);
        v.normalize();
        assertEquals("", 1, v.length(), 1e-10);

        v = new Vector(3.5, -5, 10);
        v.normalize();
        assertEquals("", 1, v.length(), 1e-10);


        v = new Vector(0, 0, 0);
        try {
            v.normalize();
            fail("Didn't throw divide by zero exception!");
        } catch (ArithmeticException e) {
            assertTrue(true);
        }
    }

    @Test
    public void getNormal() {
    }

    @Test
    public void scale() {
        v= new Vector(0,0,0);
        assertTrue(v.scale(1).equals(new Vector(0,0,0)));

        v=new Vector(1,0,0);
        assertTrue(v.scale(2).equals(new Vector(2,0,0)));

        v=new Vector(1,1,1);
        assertTrue(v.scale(-3).equals(new Vector(-3,-3,-3)));

        v=new Vector(0,1,1);
        assertTrue(v.scale(0.5).equals(new Vector(0,0.5,0.5)));

    }

    @Test
    public void equals() {
        v = new Vector(1,2,3);
        assertTrue(v.equals(new Vector(1,2,3)));
        assertFalse(v.equals(new Vector(2,2,3)));
    }

    @Test
    public void add() {
        v = new Vector(2,0,0);
        u = new Vector(1,0,0);
        assertTrue(v.add(u).equals(new Vector(3,0,0)));

        v = new Vector(1,2,3);
        u = new Vector(3,2,1);
        assertTrue(v.add(u).equals(new Vector(4,4,4)));

    }

    @Test
    public void subtract() {
        v = new Vector(2,0,0);
        u = new Vector(1,0,0);
        assertTrue(v.subtract(u).equals(new Vector(1,0,0)));

        v = new Vector(1,2,3);
        u = new Vector(3,2,1);
        assertTrue(v.subtract(u).equals(new Vector(-2,0,2)));

    }

    @Test
    public void dotProduct() {
        //sectors: 1 and 1
        v = new Vector(1, 0.5, 1);
        u = new Vector(1,1,1);
         assertEquals("works!", 3, v.dotProduct(u), 1e-10);


        //sectors: 1 and 2
        v = new Vector(7, 5, 3);
        u = new Vector(-5,1,3);
           assertEquals("works!", 39, v.dotProduct(u), 1e-10);

        //sectors: 1 and 3
        v = new Vector(3, 2, 2);
        u = new Vector(4,-2,8);
          assertEquals("works!", 24, v.dotProduct(u), 1e-10);

        //sectors: 1 and 4
        v = new Vector(1, 1, 1);
        u = new Vector(-1,-1,1);
         assertEquals("works!", 24, v.dotProduct(u), 1e-10);

        //sectors: 1 and 5
        v = new Vector(1, 1, 1);
        u = new Vector(1,1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(-2,2,0)));

        //sectors: 1 and 6
        v = new Vector(1, 1, 1);
        u = new Vector(-1,1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(-2,0,2)));

        //sectors: 1 and 7
        v = new Vector(1, 1, 1);
        u = new Vector(1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,2,-2)));

        //sectors: 1 and 8
        v = new Vector(1, 1, 1);
        u = new Vector(-1,-1,-1);
        assertTrue(v.crossProduct(u).get_head().get_x().get_coordinate() == 0 &&
                v.crossProduct(u).get_head().get_y().get_coordinate() == 0 &&
                v.crossProduct(u).get_head().get_z().get_coordinate() == 0);


        //sectors: 2 and 2
        v = new Vector(-1, 1, 1);
        u = new Vector(-1,1,1);
        assertTrue( v.crossProduct(u).get_head().get_x().get_coordinate() == 0 &&
                v.crossProduct(u).get_head().get_y().get_coordinate() == 0 &&
                v.crossProduct(u).get_head().get_z().get_coordinate() == 0);

        //sectors: 2 and 3
        v = new Vector(-1, 1, 1);
        u = new Vector(1,-1,1);
        assertTrue( v.crossProduct(u).equals(new Vector(2,2,0)));

        //sectors: 2 and 4
        v = new Vector(-1, 1, 1);
        u = new Vector(-1,-1,1);
        assertTrue( v.crossProduct(u).equals(new Vector(2,0,2)));

        //sectors: 2 and 5
        v = new Vector(-1, 1, 1);
        u = new Vector(1,1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(-2,0,-2)));

        //sectors: 2 and 6
        v = new Vector(-1, 1, 1);
        u = new Vector(-1,1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,1)));

        //sectors: 2 and 7
        v = new Vector(-1, 1, 1);
        u = new Vector(1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,1)));

        //sectors: 2 and 8
        v = new Vector(-1, 1, 1);
        u = new Vector(-1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,1)));

        //sectors: 3 and 3
        v = new Vector(1, -1, 1);
        u = new Vector(1,-1,1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,1)));

        //sectors: 3 and 4
        v = new Vector(1, -1, 1);
        u = new Vector(-1,-1,1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,1)));

        //sectors: 3 and 5
        v = new Vector(1, -1, 1);
        u = new Vector(1,1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,1)));

        //sectors: 3 and 6
        v = new Vector(1, -1, 1);
        u = new Vector(-1,1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,1)));

        //sectors: 3 and 7
        v = new Vector(1, -1, 1);
        u = new Vector(1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,1)));

        //sectors: 3 and 8
        v = new Vector(1, -1, 1);
        u = new Vector(-1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,1)));

        //sectors: 4 and 4
        v = new Vector(-1, -1, 1);
        u = new Vector(-1,-1,1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,1)));

        //sectors: 4 and 5
        v = new Vector(-1, -1, 1);
        u = new Vector(1,1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,1)));

        //sectors: 4 and 6
        v = new Vector(-1, -1, 1);
        u = new Vector(-1,1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,1)));

        //sectors: 4 and 7
        v = new Vector(-1, -1, 1);
        u = new Vector(1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,1)));

        //sectors: 4 and 8
        v = new Vector(-1, -1, 1);
        u = new Vector(-1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,1)));

        //sectors: 5 and 5
        v = new Vector(1, 1, -1);
        u = new Vector(1,1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,1)));

        //sectors: 5 and 6
        v = new Vector(1, 1, -1);
        u = new Vector(-1,1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,1)));

        //sectors: 5 and 7
        v = new Vector(1, 1, -1);
        u = new Vector(1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,1)));

        //sectors: 5 and 8
        v = new Vector(1, 1, -1);
        u = new Vector(-1,-1,-1);

        //sectors: 6 and 6
        v = new Vector(-1, 1, -1);
        u = new Vector(-1,1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,1)));

        //sectors: 6 and 7
        v = new Vector(-1, 1, -1);
        u = new Vector(1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,1)));

        //sectors: 6 and 8
        v = new Vector(-1, 1, -1);
        u = new Vector(-1,-1,-1);

        //sectors: 7 and 7
        v = new Vector(1, -1, -1);
        u = new Vector(1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,1)));

        //sectors: 7 and 8
        v = new Vector(1, -1, -1);
        u = new Vector(-1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,1)));

        //sectors: 8 and 8
        v = new Vector(-1, -1, -1);
        u = new Vector(-1,-1,-1);
        assertTrue( v.crossProduct(u).equals(new Vector(0,0,1)));

        // crossProduct with (0,0,0)
        v = new Vector(1, 0, 0);
        u = new Vector(0,0,0);
        assertTrue( v.crossProduct(u).get_head().get_x().get_coordinate() == 0 &&
                v.crossProduct(u).get_head().get_y().get_coordinate() == 0 &&
                v.crossProduct(u).get_head().get_z().get_coordinate() == 0);


    }
}
