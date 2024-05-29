/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameObject;

import Colider.NumDouble;
import Colider.Point;
import Interfaces.AnimacionHelper;
import Interfaces.Escalable;
import Interfaces.ImagenHelper;
import Interfaces.Paintable;
import Interfaces.Sizeable;
//import Interfaces.Timeable;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author willi
 */
public class Animacion extends GameObject implements Paintable, Escalable{
    
    private AnimacionHelper ah;

    public Animacion(AnimacionHelper ah, double x, double y) {
        super(x, y);
        this.ah = ah;
    }
    
    public Animacion(ImagenHelper[] imgs, double x, double y, double escala, int velocidad, int des) {
        this(new AnimacionHelper(imgs, escala, velocidad, des), x, y);
        
    }

    public Animacion(String imgs[], double x, double y, double escala, int velocidad, int des) throws IOException {
        this(new AnimacionHelper(imgs, escala, velocidad, des), x, y);
    }

    
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(getFotograma().getImg(), (int)(getX() - (ah.getRadioX())), (int)(getY() - (ah.getRadioX())), (int)getFotograma().getAncho(), (int)getFotograma().getAlto(), null);
        ah.getDesplasamiento().desplasamiento();
    }

    
    public double getAncho() {
        return ah.getFotograma().getAncho();
    }

    
    public double getAlto() {
        return ah.getFotograma().getAlto();
    }
    
    public void setFotograma(int index){
        ah.setFotograma(index);
    }

    public double getIndex() {
        return ah.getIndex();
    }
    
    public ImagenHelper getFotograma(int index){
        return  ah.getFotograma(index);
    }
    
    public ImagenHelper getFotograma(){
        return  ah.getFotograma();
    }

    public ImagenHelper[] getFotogramas() {
        return ah.getFotogramas();
    }
    
//    @Override
//    public void millis(NumDouble time) {
//        ah.millis(time);
//    }
//
//    @Override
//    public double millis() {
//        return ah.millis();
//    }

    public int getVelocidad() {
        return ah.getVelocidad();
    }

    public void setVelocidad(int velocidad) {
        this.ah.setVelocidad(velocidad);
    }

    public void setDesplasamiento(int des) {
        ah.setDesplasamiento(des);
    }

    public AnimacionHelper.Desplasamiento getDesplasamiento() {
        return ah.getDesplasamiento();
    }

    @Override
    public void setEscala(double escala) {
        ah.setEscala(escala);
    }

    @Override
    public void setEscalaX(double escala) {
        ah.setEscalaX(escala);
    }

    @Override
    public void setEscalaY(double escala) {
        ah.setEscalaY(escala);
    }



   
    
}


    
