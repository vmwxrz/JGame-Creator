/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package GameObject;

import Interfaces.Escalable;

import Interfaces.ImagenHelper;
import Interfaces.Paintable;

import Interfaces.Sizeable;


import java.awt.Graphics;

import java.io.IOException;


/**
 *
 * @author willi
 */
public class Imagen extends GameObject implements Paintable, Escalable,Sizeable{

    private ImagenHelper img;

    public Imagen(String img, double x, double y, double escala) throws IOException {
        super(x,y);
        this.img = new ImagenHelper(img, escala);
    }
    
    public Imagen(String img, double x, double y) throws IOException {
        this(img, x, y, 1);
    }
    
    public ImagenHelper getImg() {
        return img;
    }

    public void setImg(ImagenHelper img) {
        this.img = img;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img.getImg(), (int)(getX()- (img.getRadioX())), (int)(getY() - (img.getRadioY())), (int)img.getAncho(), (int)img.getAlto(), null);
    }

    @Override
    public void setEscala(double escala) {
        setEscalaX(escala);
        setEscalaY(escala);
    }

    @Override
    public void setEscalaX(double escala) {
        img.setEscalaX(escala);
    }

    @Override
    public void setEscalaY(double escala) {
        img.setEscalaY(escala);
    }

    @Override
    public void setAncho(double ancho) {
        img.setAncho(ancho);
    }

    @Override
    public void setAlto(double alto) {
        img.setAlto(alto);
    }

    @Override
    public double getAlto() {
        return img.getAlto();
    }

    @Override
    public double getAncho() {
        return img.getAncho();
    }

    @Override
    public double getRadioX() {
        return img.getRadioX();
    }

    @Override
    public double getRadioY() {
        return img.getRadioY();
    }
    
}
