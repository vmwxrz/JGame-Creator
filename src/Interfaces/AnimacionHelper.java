/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Colider.NumDouble;
import Media.View;
import java.io.IOException;

/**
 *
 * @author willi
 */
public class AnimacionHelper implements Sizeable, Escalable{
    private ImagenHelper f[];
    public double index;
    private NumDouble time, timep;
    private int velocidad;
    private Desplasamiento des;
    public static int Lineal = 0, Lineal0 = 1, ZigZig = 2;
    public AnimacionHelper(ImagenHelper[] imgs, double escala, int velocidad, int des) {
        this.f = imgs;
        this.index = 0;
        this.velocidad = velocidad;
        setDesplasamiento(des);
        setEscala(escala);
    }

    public AnimacionHelper(String imgs[], double escala, int velocidad, int des) throws IOException {
        this.f = new  ImagenHelper[imgs.length];
        this.index = 0;
        this.velocidad = velocidad;
        setDesplasamiento(des);
        for (int i = 0; i < imgs.length; i++) {
            f[i] = new ImagenHelper(imgs[i], escala);
        }
        setEscala(escala);
    }
    
  
    
    
    @Override
    public double getAncho() {
        return f[(int)index].getAncho();
    }

    
    @Override
    public double getAlto() {
        return f[(int)index].getAlto();
    }
    
    public void setFotograma(int index){
        this.index = index;
    }

    public double getIndex() {
        return index;
    }
    
    public ImagenHelper getFotograma(int index){
        return f[index];
    }
    
    public ImagenHelper getFotograma(){
        return f[(int)index];
    }

    public ImagenHelper[] getFotogramas() {
        return f;
    }
    
    

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setDesplasamiento(int des) {
        switch (des) {
            case 0: this.des = new Lineal() ;break;
            case 1: this.des = new Lineal0() ;break;
            case 2: this.des = new ZigZag() ;break;
        }
        this.des.a = this;
    }

    public Desplasamiento getDesplasamiento() {
        return des;
    }

    @Override
    public void setEscala(double escala) {
        for (ImagenHelper imagen : f) {
            imagen.setEscala(escala);
        }
    }

    @Override
    public void setEscalaX(double escala) {
        for (ImagenHelper imagen : f) {
            imagen.setEscalaX(escala);
        }
    }

    @Override
    public void setEscalaY(double escala) {
        for (ImagenHelper imagen : f) {
            imagen.setEscalaY(escala);
        }
    }

    @Override
    public void setAncho(double ancho) {
        for (ImagenHelper imagen : f) {
            imagen.setAncho(ancho);
        }
    }

    @Override
    public void setAlto(double alto) {
        for (ImagenHelper imagen : f) {
            imagen.setAlto(alto);
        }
    }

    @Override
    public double getRadioX() {
        return getFotograma().getRadioX();
    }

    @Override
    public double getRadioY() {
        return getFotograma().getRadioY();
    }

  
    
    
    public abstract class Desplasamiento{
        public AnimacionHelper a;
        public double t=0;
        abstract public void desplasamiento();
        public void reset(){
            this.a.index = 0;
        }
    }

    public class Lineal extends Desplasamiento{
        
        @Override
        public void desplasamiento() {
            a.index = t;
            t += View.millis / a.getVelocidad();
            t = t % a.getFotogramas().length;
            
        }

    }

    public class ZigZag extends Desplasamiento{
        private int s = 1;

        @Override
        public void desplasamiento() {
            a.index = t;
            t +=  s*(((t + View.millis) / a.getVelocidad()) % a.getFotogramas().length);
            if (a.index <= 0) {
                s = 1;
            }else if (a.index > a.getFotogramas().length) {
                s = -1;
            }
        }
    }

    public class Lineal0 extends Desplasamiento{

        @Override
        public void desplasamiento() {
            if (a.index < a.getFotogramas().length) {
                t +=  ((t + View.millis) / a.getVelocidad()) % a.getFotogramas().length;
            }
        }
    }

}


