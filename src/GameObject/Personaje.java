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

import java.awt.Graphics;

/**
 *
 * @author willi
 */
public class Personaje extends GameObject implements Paintable, Escalable{
    private int index;
    private AnimacionHelper ah[];
    
    public Personaje(AnimacionHelper[] animaciones,int index, double x, double y) {
        super(x, y);
        this.index = index;
        this.ah = animaciones;
    }

    public void Select(int index){
        getAnimacion().setFotograma(0);
        this.index = index;
    }
    
    public AnimacionHelper getAnimacion(){
        return ah[index];
    }
    
    public AnimacionHelper getAnimacion(int index){
        return ah[index];
    }
    
    public void setAnimacion(int index, AnimacionHelper animacion){
        ah[index] = animacion;
    }
    
    @Override
    public void paint(Graphics g) {
        
        g.drawImage(ah[index].getFotograma().getImg(), (int)(getX() - (getAnimacion().getRadioX())), (int)(getY() - (getAnimacion().getRadioY())),(int)ah[index].getFotograma().getAncho() , (int)ah[index].getFotograma().getAlto(), null);
        ah[index].getDesplasamiento().desplasamiento();
        
    }
    
    @Override
    public void setEscala(double escala) {
        for (AnimacionHelper animacionHelper : ah) {
            animacionHelper.setEscala(escala);
        }
    }

    @Override
    public void setEscalaX(double escala) {
        for (AnimacionHelper animacionHelper : ah) {
            animacionHelper.setEscalaX(escala);
        }
    }

    @Override
    public void setEscalaY(double escala) {
        for (AnimacionHelper animacionHelper : ah) {
            animacionHelper.setEscalaY(escala);
        }
    }

    public void setAnimation(int index){
        getAnimacion().getFotograma(0);
        this.index = index;
    }
    
    public double getAlto() {
        return ah[index].getAlto();
    }

    
    public double getAncho() {
        return ah[index].getAncho();
    }

    public int getIndex() {
        return index;
    }

    
    public double getRadioX(){
        return getAnimacion().getRadioX();
    }
    
    public double getRadioY(){
        return getAnimacion().getRadioY();
    }
    
    
    
    
}
