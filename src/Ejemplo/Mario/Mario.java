/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplo.Mario;

import Colider.Capsula;
import Colider.Form;
import GameObject.Personaje;
import Interfaces.AnimacionHelper;
import Interfaces.Collicionable;
import Interfaces.Logicable;
import Media.Camara;
import java.awt.Graphics;
import java.io.IOException;
import static Media.Control.*;
import static Media.View.*;


/**
 *
 * @author willi
 */
public class Mario extends Personaje implements Logicable, Collicionable{
    
    

    final AnimacionHelper de_pie, de_pie_iz, caminar_derecha, caminar_izquierda;
    Capsula c[];
    Camara cc;
    public Mario() throws IOException {
        super(new AnimacionHelper[4], 0, 0, 0);
        final double escala = 3;
        de_pie = new AnimacionHelper(new String[]{
        "C:\\Users\\willi\\OneDrive\\Documentos\\Mario\\Imgs\\mario\\depieDe.png"
        }, escala, 0, AnimacionHelper.Lineal);
        de_pie_iz = new AnimacionHelper(new String[]{
        "C:\\Users\\willi\\OneDrive\\Documentos\\Mario\\Imgs\\mario\\depieIz.png"
        }, escala, 0, AnimacionHelper.Lineal);
        caminar_derecha = new AnimacionHelper(new String[]{
            "C:\\Users\\willi\\OneDrive\\Documentos\\Mario\\Imgs\\mario\\depieDe.png",
            "C:\\Users\\willi\\OneDrive\\Documentos\\Mario\\Imgs\\mario\\caminarDe1.png",
            "C:\\Users\\willi\\OneDrive\\Documentos\\Mario\\Imgs\\mario\\caminarDe2.png"
        }, escala, 100, AnimacionHelper.Lineal);
        caminar_izquierda = new AnimacionHelper(new String[]{
            "C:\\Users\\willi\\OneDrive\\Documentos\\Mario\\Imgs\\mario\\depieIz.png",
            "C:\\Users\\willi\\OneDrive\\Documentos\\Mario\\Imgs\\mario\\camIz1.png",
            "C:\\Users\\willi\\OneDrive\\Documentos\\Mario\\Imgs\\mario\\camIz2.png"
        }, escala, 100, AnimacionHelper.Lineal);
        
        
        
        
        setAnimacion(0,de_pie);
        setAnimacion(1,caminar_derecha);
        setAnimacion(2,caminar_izquierda);
        setAnimacion(3,de_pie_iz);
        c = new Capsula[1];
        c[0] = new Capsula(getX(), getY(), getAncho()-10, getAlto()-5);
        cc = getCamara(0);
    }

    int v = 0;
    @Override
    public void Logica() {
        animate();
        
        if (isPrssedDe()) {
            if (isPressedA()) {
                moveX(300 * secound);
            }else{
                moveX(200 * secound);
            }
        } if (isPrssedIz()) {
            if (isPressedA()) {
                moveX(-300 * secound);
            }else{
                moveX(-200 * secound);
            }
        } if (isPrssedAr()) {
            moveY(-200 * secound);
        } if (isPrssedAb()) {
            moveY(200 * secound);
        }
    }

    @Override
    public void setX(double x) {
    
        if (x >= 300) {
                getCamara(0).FocusX(x-300);
            }
        if (getX() - getRadioX() > 0) {
            c[0].setX(x);
            super.setX(x); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        }else{
            c[0].setX(getRadioX());
            super.setX(getRadioX()); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        }
    }

    @Override
    public void setY(double y) {
            if (y >= 200) {
                getCamara(0).FocusY(y-200);
            }
            if (getY() - getRadioY() < 0) {
                c[0].setY(getRadioY());
                super.setY(getRadioY()); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }else{
                c[0].setY(y);
                super.setY(y); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }
    }
    
    
    
    
    private void animate(){
        
        if(isPrssedDe() || isPrssedIz()) {
            if (isPrssedDe()) {
                setAnimation(1);
                v = 0;
            } else if (isPrssedIz()) {
                setAnimation(2);
                v = 3;
            }
            
            if (isPressedA()) {
                getAnimacion().setVelocidad(50);
            }else{
                getAnimacion().setVelocidad(100);
            }
        }else {
            setAnimation(v);
        }
    }

    @Override
    public void paint(Graphics g) {
        c[0].paint(g);
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    

    @Override
    public void onCollitionIn(Collicionable obj) {
        if (obj instanceof mEjemplo m) {
            if (isPrssedDe()) {
                setX(m.getX() - getRadioX() );
            }
            if (isPrssedIz()) {
                setX(m.getX() + m.getRadioX()+10);
            }
            if (isPrssedAb()) {
                
            }
        }
        
    }

    @Override
    public void onCollitionOut(Collicionable obj) {
        
    }

    @Override
    public Form[] getColider() {
        return c;
    }
    
    
    
  
}
