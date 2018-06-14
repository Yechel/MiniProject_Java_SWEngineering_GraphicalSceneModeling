package Elements;

import Primitives.Color;
import Primitives.Point3D;
import Primitives.Vector;

public interface LightSource {
    public Color getIntensity(Point3D point);
    public Vector getL(Point3D point);
}
