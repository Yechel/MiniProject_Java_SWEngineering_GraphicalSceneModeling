package Render;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageWriter {
    final String PROJECT_PATH = System.getProperty("user.dir");
    private String _imageName;
    private BufferedImage _image;
    private int _imageWidth;
    private int _imageHeight;
    private int _Ny;
    private int _Nx;

    public ImageWriter(String projectPath, String imageName, BufferedImage image, int imageWidth, int get_imageHeight, int ny, int nx) {

        set_imageName(imageName);
        set_image(image);
        set_imageWidth(imageWidth);
        set_imageHeight(get_imageHeight);
        set_Ny(ny);
        set_Nx(nx);
    }

    public ImageWriter(String imageName, int width, int height, int Ny, int Nx){

        set_Nx(Nx);
        set_Ny(Ny);

        set_imageWidth(width);
        set_imageHeight(height);

        set_imageName(imageName);

        set_image( new BufferedImage(
                get_imageWidth(), get_imageHeight(), BufferedImage.TYPE_INT_RGB));
    }

    public ImageWriter (ImageWriter imageWriter){
        set_Nx(imageWriter.get_Nx());
        set_Ny(imageWriter.get_Ny());

        set_imageWidth(imageWriter.get_imageWidth());
        set_imageHeight(get_imageHeight());

        set_imageName(imageWriter.get_imageName());

        _image = new BufferedImage(
                _imageWidth, _imageHeight, BufferedImage.TYPE_INT_RGB);;
    }



    //getters


    public String get_imageName() {
        return _imageName;
    }

    public BufferedImage get_image() {
        return _image;
    }

    public int get_imageWidth() {
        return _imageWidth;
    }

    public int get_imageHeight() {
        return _imageHeight;
    }

    public int get_Ny() {
        return _Ny;
    }

    public int get_Nx() {
        return _Nx;
    }

    //setters


    public void set_imageName(String _imageName) {
        this._imageName = _imageName;
    }

    public void set_image(BufferedImage _image) {
        this._image = _image;
    }

    public void set_imageWidth(int _imageWidth) {
        this._imageWidth = _imageWidth;
    }

    public void set_imageHeight(int _imageHeight) {
        this._imageHeight = _imageHeight;
    }

    public void set_Ny(int _Ny) {
        this._Ny = _Ny;
    }

    public void set_Nx(int _Nx) {
        this._Nx = _Nx;
    }
 //operations
 public void writeToimage(){

     File ouFile = new File(PROJECT_PATH + "/" + _imageName + ".jpg");

     try {
         ImageIO.write(_image, "jpg", ouFile);
     } catch (IOException e) {
         e.printStackTrace();
     }
 }

    public void writePixel(int xIndex, int yIndex, int r, int g, int b){

        int rgb = new Color(r, g, b).getRGB();
        _image.setRGB(xIndex, yIndex, rgb);

    }

    public void writePixel(int xIndex, int yIndex, int[] rgbArray){

        int rgb = new Color(rgbArray[0], rgbArray[1], rgbArray[2]).getRGB();
        _image.setRGB(xIndex, yIndex, rgb);

    }

    public void writePixel(int xIndex, int yIndex, Color color){

        _image.setRGB(xIndex, yIndex, color.getRGB());

    }
}
