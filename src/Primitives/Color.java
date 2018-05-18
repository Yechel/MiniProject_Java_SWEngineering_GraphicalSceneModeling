package Primitives;

public class Color {
    private java.awt.Color _color;


    public Color(java.awt.Color color) {
        set_color(color);
    }

    public Color(int r, int g, int b) {
        set_color(new java.awt.Color(r, g, b));
    }


    public Color(Color color) {
        set_color(color.get_color());
    }



    public java.awt.Color get_color() {
        return _color;
    }

    public void set_color(java.awt.Color _color) {
        this._color = _color;
    }

    @Override
    public boolean equals(Object obj) throws IllegalArgumentException {
        if (obj instanceof Color) {
            return obj.equals(get_color());
        }
        throw new IllegalArgumentException("the Argument is not a Color type");
    }

    @Override
    public String toString() {
        return get_color().toString();
    }

    public Color add(Color color) {
        return add(color.get_color().getRed(),
                color.get_color().getGreen(),
                color.get_color().getBlue());
    }

    public Color add(double _red, double _green, double _blue) {
        return new Color(get_color().getRed() + fixNumOfAdd(_red),
                get_color().getGreen() + fixNumOfAdd(_green),
                get_color().getBlue() + fixNumOfAdd(_blue));
    }

    private int fixNumOfAdd(double color) {
        if (color > 255) {
            return 255;
        }
        if (color < 0) {
            return 0;
        }
        return (int) color;
    }

    /**
     * @param i number between -100 to 100 to scale by precent
     * @return an update color.
     */
    public Color scale(double i) {
        return new Color(scale(get_color().getRed(), i),
                scale(get_color().getGreen(), i),
                scale(get_color().getBlue(), i));
    }


    private int scale(int color, double v) {
        if (Math.abs(v) < 1) {
            return (int) (color * (1 + v));
        }//no change
        if (v <= -1) {
            return 0;
        }
       // if (v >= 1)
        return (int) (color * 2);
    }


    public Color reduce(double i) {
        if (i < 0) { return scale(100);}
        if (i>100) {return  scale(0);}
        return scale(-i);
    }
}
