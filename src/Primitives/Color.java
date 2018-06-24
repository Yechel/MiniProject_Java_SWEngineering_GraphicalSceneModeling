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

    public Color() {
        set_color(new java.awt.Color(255,255,255));
    }


    public java.awt.Color get_color() {
        return new java.awt.Color(_color.getRGB());
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
        set_color( new Color(fixNumOfAdd(get_color().getRed() + _red),
                fixNumOfAdd(get_color().getGreen() + _green),
                fixNumOfAdd(get_color().getBlue() + _blue)).get_color());
        return this;
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
    public Color    scale(double i) {
        return new Color(scale(get_color().getRed(), i),
                scale(get_color().getGreen(), i),
                scale(get_color().getBlue(), i));
    }


    private int scale(int color, double v) {
        int _newColor = (int) (color *  v);
        if (_newColor > 255) {
            return 255;
        } else if (_newColor < 0) {
            return 0;
        } else {
            return _newColor;
        }

    }


    public Color reduce(double i) {
        if (i < 0) {
            return scale(100);
        }
        if (i > 100) {
            return scale(0);
        }
        return scale(-i);
    }
}
