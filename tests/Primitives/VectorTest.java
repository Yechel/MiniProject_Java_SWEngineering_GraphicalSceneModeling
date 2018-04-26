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

        v = new Vector(1, 0, 0);
        u = new Vector(0,1,0);
        assertEquals("works!", 1, v.length(), 1e-10);

        v = new Vector(0, 1, 0);
        assertEquals("works!", 1, v.length(), 1e-10);

        v = new Vector(0, 0, 1);
        assertEquals("works!", 1, v.length(), 1e-10);

    }

    @Test
    public void normalize() {
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
    }

    @Test
    public void equals() {
        v = new Vector(1,2,3);
        assertTrue(v.equals(new Vector(1,2,3)));
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
    }
}