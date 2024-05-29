/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Media;

import GameObject.Ecena;
import Interfaces.Paintable;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;

/**
 *
 * @author willi
 */
public class Camara extends Canvas{
    
    private double xt,  yt;
//    private Paintable painter;
    private Ecena ecena;
//    private Ecena ecena;
    public Camara(Ecena ecena) {
        setVisible(true);  
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getParent().requestFocus();
            }
        });
        this.ecena = ecena;
    }

    @Override
    public void repaint() {
        repaint(0, 0, getWidth(), getHeight());
    }
    

    @Override
    public void repaint(int x, int y, int width, int height) {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.clearRect(x,y, width, height);
//        g.translate(-(int)xt, (int)(getHeight() - yt));
        g.translate(-(int)xt, (int)( - yt));
        paint(g);
        g.dispose();
        bs.show();
    }

    @Override
    public void paint(Graphics g) {
        if (ecena != null) {
            ecena.GraphicsUpdate(g);
        }
    }

    public void setEcena(Ecena ecena) {
        this.ecena = ecena;
    }

    
    
    public void Focus(double x, double y){
        this.xt = x;
        this.yt = y;
    }
    
    public void FocusX(double x){
        xt = x;
    }
    public void FocusY(double y){
        yt = y;
    }
    

}
