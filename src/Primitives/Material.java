package Primitives;

public class Material {
private double _Kd,_Ks;
    private int _nShininess;


    public Material(double kd, double ks, int nShininess) {
        set_Kd(kd);
        set_Ks(ks);
        set_nShininess(nShininess);
    }

    public Material(Material material) {
        set_Kd(material.get_Kd());
        set_Ks(material.get_Ks());
        set_nShininess(material.get_nShininess());
    }

    public Material() {
        set_Kd(1);
    set_Ks(1);
    set_nShininess(1);
    }

    public double get_Kd() {
        return _Kd;
    }

    public void set_Kd(double _Kd) {
        this._Kd = _Kd;
    }

    public double get_Ks() {
        return _Ks;
    }

    public void set_Ks(double _Ks) {
        this._Ks = _Ks;
    }

    public int get_nShininess() {
        return _nShininess;
    }

    public void set_nShininess(int _nShininess) {
        this._nShininess = _nShininess;
    }
}
