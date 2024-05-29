/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplo.Mario;

import Colider.Capsula;
import Colider.Cuadro;
import Colider.Form;
import GameObject.Imagen;
import Interfaces.Collicionable;
import java.awt.Graphics;
import java.io.IOException;

/**
 *
 * @author willi
 */
public class mEjemplo extends Imagen implements Collicionable{
    
    
    Capsula c[];
    public mEjemplo(String img, double x, double y, double escala) throws IOException {
        super(img, x, y, escala);
        c = new Capsula[1];
        c[0] = new Capsula(getX(), getY(), getAncho()-10, getAlto()-10);
    }

    @Override
    public void setX(double x) {
        c[0].setX(x);
        super.setX(x); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setY(double y) {
        c[0].setY(y);
        super.setY(y); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void paint(Graphics g) {
        c[0].paint(g);
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
    
    @Override
    public void onCollitionIn(Collicionable obj) {
        
    }

    @Override
    public void onCollitionOut(Collicionable obj) {
        
    }

    @Override
    public Form[] getColider() {
        return c;
    }
    
    
    
}
