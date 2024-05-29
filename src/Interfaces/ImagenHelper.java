/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author willi
 */
public class ImagenHelper implements Sizeable, Escalable{
    private double ancho, alto, rx, ry;
    private BufferedImage img;

    public ImagenHelper(String img, double escala) throws IOException{
        this.img = ImageIO.read(new File(img));
        this.ancho = this.img.getWidth();
        this.alto = this.img.getHeight();
        rx = ancho / 2f;
        ry = alto / 2f;
        setEscala(escala);
    }
    
    public ImagenHelper(String img) throws IOException {
        this(img,1);
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(String img) throws IOException {
        this.img = ImageIO.read(new File(img));
    }
    
 

    @Override
    public void setEscala(double escala) {
        setAncho(escala * img.getWidth());
        setAlto(escala * img.getHeight());
    }

    @Override
    public void setEscalaX(double escala) {
        setAncho(escala * img.getWidth());
    }

    @Override
    public void setEscalaY(double escala) {
        setAlto(escala * img.getHeight());
    }

    @Override
    public void setAncho(double ancho) {
        this.ancho = ancho;
        rx = ancho/2f;
    }

    @Override
    public void setAlto(double alto) {
        this.alto = alto;
        ry = alto/2f;
    }

    @Override
    public double getAlto() {
        return alto;
    }

    @Override
    public double getAncho() {
        return ancho;
    }

    @Override
    public double getRadioX() {
        return rx;
    }

    @Override
    public double getRadioY() {
        return ry;
    }
    
    
    
}
