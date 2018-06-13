package Primitives;

public class Material {
    private double _Kd, _Ks, _Kr, _Kt;
    private int _nShininess;


    public Material(double kd, double ks, double kr, double kt, int nShininess) {
        set_Kd(kd);
        set_Ks(ks);
        set_Kr(kr);
        set_Kt(kt);
        set_nShininess(nShininess);
    }

    public Material(Material material) {
        set_Kd(material.get_Kd());
        set_Ks(material.get_Ks());
        set_Kr(material.get_Kr());
        set_Kt(material.get_Kt());
        set_nShininess(material.get_nShininess());
    }

    public Material() {
        set_Kd(1);
        set_Ks(1);
        set_Kr(1);
        set_Kt(1);
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

    public double get_Kt() {
        return _Kt;
    }

    public void set_Kt(double _Kt) {
        this._Kt = _Kt;
    }

    public double get_Kr() {
        return _Kr;
    }

    public void set_Kr(double _Kr) {
        this._Kr = _Kr;
    }
}
