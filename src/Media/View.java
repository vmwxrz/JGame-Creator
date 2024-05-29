/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Media;

import Colider.NumDouble;
import GameObject.Ecena;
import Interfaces.SubThread;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author willi
 */
public class View extends Frame{

    /**
     * Creates new form Ventana
     */
//    private NumDouble time, timep;
    public static double millis, secound;
    private static ArrayList<Camara> camaras;
    private Ecena ecena;
    private ArrayList<SubThread> st;
    private SubThread hilo;
    public View() throws IOException {
        setVisible(true);
        camaras = new ArrayList<>();
        st = new ArrayList<>();
//        time = new NumDouble();
//        timep = new NumDouble();
        hilo = new SubThread() {
            @Override
            public void run() {
                ecena.logicaUpdate();
            }
        };
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
            
        });
 
        addKeyListener(new Control());
    }

    @Override
    public Component add(Component comp) {
        final Component cc = super.add(comp);
        if (comp instanceof Camara c && isVisible()) {
            c.createBufferStrategy(2);
        }
        return  cc;// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    
    
    
    
    public void addCamara(Camara c){
        c.setVisible(true);
        add(c);
        camaras.add(c);
    }
    
    public void init(int fps){  
        final double ff = fps > 100 ? 100 : fps;
        
               new Thread(){
            @Override
            public void run() {
                
                double fpss = 1000000000/(double)ff;
                final double fpsb = fpss;
                double t = System.nanoTime()+fpsb;
                while (true) {
                     final double pass = System.nanoTime() - t;
                     
                    if (pass >= fpsb) {
                        millis =(pass / 1000000f);
                        secound = millis / 1000f;
                        setTitle("FPS: "+Math.round(1000 / millis));
                        for (SubThread subThread : st) {
                            subThread.start();
                        }
                        // sonido
                        hilo.start();
                        
                        for (Canvas camara : camaras) {
                            camara.repaint();
                        }
                        
                        
                        
//                        fpss -=  - fpsb; 
//                        System.out.println(1000/millis);
                        t+=fpsb;
                    }
                    
                 
                }
                
                    
                    //        while (true) {
//
//
//                    
//
////                    if (tt >= t) {
//                        
//                        for (SubThread subThread : st) {
//                            subThread.start();
//                        }
//                        // sonido
//                        hilo.start();
//                        
//                        for (Canvas camara : camaras) {
//                            camara.repaint();
//                        }
//                    
//                    try {
//                        Thread.sleep(Duration.ofNanos((long)(fpss)));
//                    } catch (InterruptedException ex) {}
//                    final double tt = System.nanoTime() - t;
//                    t = System.nanoTime();
//                    
//                    millis =(tt / 1000000f);
//                    secound = millis / 1000f;
//                    setTitle("FPS: "+(int)(1000 / millis));
//                    fpss -= tt - fpsb; 
//                    System.out.println(millis);
//
//                }
             
            }
            
        }.start();
    }

    public Ecena getEcena() {
        return ecena;

    }

    public void setEcena(Ecena ecena) {
        this.ecena = ecena;
//        ecena.view = this;
//        ecena.millis(time);
//        ecena.secound(timep);
    }
    
    public void addSubThread(SubThread st){
        this.st.add(st);
    }
    
    public void removeSubThread(SubThread st){
        this.st.remove(st);
    }

    public void Pausa(){
        hilo.suspend();
    }
    public void Continue(){
        hilo.join();
    }

    public static Camara getCamara(int index) {
        return camaras.get(index);
    }
}
