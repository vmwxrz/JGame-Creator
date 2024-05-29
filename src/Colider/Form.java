/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colider;

import Interfaces.Escalable;
import GameObject.GameObject;
import Interfaces.Paintable;
import Interfaces.Sizeable;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;

/**
 *
 * @author willi
 */
public abstract class Form extends GameObject implements Paintable, Sizeable{
    public Point[] ps, pst;
    private double ancho, alto, xmax, ymax,rx,ry;
    

    public Form(Point[] ps, double x, double y, double ancho, double alto) {
        super( x,y);
        this.ps = ps;
        this. ancho = ancho; 
        this.alto = alto;
        xmax = x + ancho;
        ymax = y + alto;
        init(this.ps);
        pst = new Point[ps.length];
        for (int i = 0; i < ps.length; i++) {
            pst[i] = new Point(ps[i].x.v, ps[i].y.v);
        }
        revalidate();
    }
    
    
    abstract public void init(final Point[] ps);

    public void revalidateX(){
        for (int i = 0; i < ps.length; i++) {
            pst[i].x.v = (ps[i].x.v * ancho) + super.getX();
        }
    }
    
    public void revalidateY(){
        for (int i = 0; i < ps.length; i++) {
            pst[i].y.v = (ps[i].y.v * alto) + super.getY();
        }
    }
    
    public void revalidate(){
        revalidateX();
        revalidateY();
    }
    

    @Override
    public void setX(double x) {
       super.setX(x);
       revalidateX();
    }
    
    @Override
    public void setY(double y) {
       super.setY(y);
       revalidateY();
    }

    public double getXmax() {
        return xmax;
    }

    public double getYmax() {
        return ymax;
    }
    
    @Override
    public void setAncho(double ancho) {
        this.ancho = ancho;
        xmax = getX() + getAncho();
        revalidateX();
        rx = ancho / 2f;
        
    }

    @Override
    public void setAlto(double alto) {
        this.alto = alto;
        ymax = getY() + getAlto();
        revalidateY();
        ry = alto / 2f;
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
    
    

    @Override
    public void moveX(double x) {
        for (int i = 0; i < ps.length; i++) {
            pst[i].x.v += x;
        }
        super.moveX(x);
    }
    
    @Override
    public void moveY(double y) {
        for (int i = 0; i < ps.length; i++) {
            pst[i].y.v += y;
        }
        super.moveY(y);
    }

    public Point[] getPst() {
        return pst;
    }
    
    
    

    @Override
    public void paint(Graphics g){
        g.drawRect((int)(getX() - (getAncho()/2f)), (int)(getY() - (getAlto()/2f)), (int)getAncho(), (int)getAlto());
        for (int i = 1; i < pst.length; i++) {
            g.drawLine((int)(getPst()[i-1].x.v), (int)(getPst()[i-1].y.v ), (int)(getPst()[i].x.v ), (int)(getPst()[i].y.v));
        }
        g.drawLine((int)(getPst()[pst.length-1].x.v), (int)(getPst()[pst.length-1].y.v ), (int)(getPst()[0].x.v ), (int)(getPst()[0].y.v));
        
    }
    
    
    public boolean intersects(Form f){
        if (
                f.getX()-(f.getAncho()/2f) < getX()+(getAncho()/2f)&&
                getX()-(getAncho()/2f) < f.getX()+(f.getAncho() / 2f)&&
                f.getY()-(f.getAlto()/2f) < getY() + (getAlto()/2f) &&
                getY() - (getAlto()/2f) < f.getY() + (f.getAlto()/2f)
            ) 
        {
            return ps.length < f.ps.length ?  inte(f) || f.inte(this) :  f.inte(this) || inte(f);
        }
        
        return false;
    }
    
    private boolean inte(Form f){
        final Point a = pst[0];
        for (int i = 0; i < pst.length-2; i++) {
            final Point b = pst[i+1];
            final Point c = pst[i+2];
            for (int j = 0; j < f.pst.length; j++) {
                final Point p = f.pst[j];
                final double area1 = AreaTriangulo(p, a, b);
                final double area2 = AreaTriangulo(p, b, c);
                final double area3 = AreaTriangulo(p, c, a);
                if ((area1 > 1 && area2 > 1 && area3 > 1) || (area1 < 1 && area2 < 1 && area3 < 1)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static double AreaTriangulo(Point p1, Point p2, Point p3){
        return (p1.x.v * (p2.y.v - p3.y.v)) + (p2.x.v * (p3.y.v - p1.y.v)) + (p3.x.v * (p1.y.v - p2.y.v)) ;// /2;
    }
    
    
    
    
}
