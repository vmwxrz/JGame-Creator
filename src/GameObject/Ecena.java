/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameObject;

import Colider.NumDouble;
import Interfaces.Collicionable;
import Interfaces.Logicable;
import Interfaces.Paintable;
import Interfaces.Pointables;
import Interfaces.Sizeable;
//import Interfaces.Timeable;
import Media.View;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author willi
 */
public class Ecena {
    
    private ArrayList<GameObject> gameObjects; 
    private ArrayList<Collicionable> collicionables; 
    private ArrayList<Logicable> logicables; 
    private ArrayList<Paintable> paintables; 
    public View view;
//    private ArrayList<Timeable> timeables; 
    private NumDouble time, timep;    
    private double ancho, alto;

    public Ecena() {
        gameObjects = new ArrayList<>();
         collicionables = new ArrayList<>();
         logicables = new ArrayList<>();
         paintables = new ArrayList<>();
         paintables = new ArrayList<>();
//         timeables = new ArrayList<>();
         ancho = 0;
         alto =0;
    }
    
    public void addGameObject(GameObject obj){
        gameObjects.add(obj);
        
//        obj.setEcena(this);
        if (obj instanceof Collicionable c) {
            collicionables.add(c);   
            
            
        }
        if (obj instanceof Logicable l) {
            logicables.add(l);   
        }
        if (obj instanceof Paintable p) {
            paintables.add(p);   
        }
//        if (obj instanceof Timeable t) {
//            timeables.add(t);
//            t.millis(time);
//            t.secound(timep);
//        }
    }
    
    public void removeGameObject(GameObject obj){
        gameObjects.remove(obj);
        if (obj instanceof Collicionable c) {
            collicionables.remove(c);   
        }
        if (obj instanceof Logicable l) {
            logicables.remove(l);   
        }
        if (obj instanceof Paintable p) {
            paintables.remove(p);   
        }
//        if (obj instanceof Timeable t) {
//            timeables.remove(t);
//            t.millis(time);
//            t.secound(timep);
//        }
        if (obj instanceof Pointables && obj instanceof Sizeable s) {
            final Pointables p = (Pointables) obj;
            if (ancho < p.getX()+s.getAncho()) {
                ancho = p.getX()+s.getAncho();
            }
            if (alto < p.getY()+s.getAlto()) {
                alto = p.getY()+s.getAlto();
            }
            
        }
    }
    
    public void logicaUpdate(){
        for (Logicable logicable : logicables) {
                logicable.Logica();
            }
        logica();
        for (int i = 0; i < collicionables.size(); i++) {
            for (int j = i+1; j < collicionables.size(); j++) {
                
                if (collicionables.get(i).isCollition(collicionables.get(j))) {
                    collicionables.get(i).onCollitionIn(collicionables.get(j));
                    collicionables.get(j).onCollitionIn(collicionables.get(i));
                    
                }else{
                    collicionables.get(i).onCollitionOut(collicionables.get(j));
                    collicionables.get(j).onCollitionOut(collicionables.get(i));
                }
            }
        }
    }
    public void GraphicsUpdate(Graphics g){
        
        for (Paintable paintable : paintables) {
                    paintable.paint(g);
                    
            }
        paint(g);
    }
    
    public void paint(Graphics g){
        
    }
    public void logica(){}

//    @Override
//    public void millis(NumDouble time) {
//        this.time = time;
//    }
//
//    @Override
//    public double millis() {
//        return time.v;
//    }
//
//    @Override
//    public double secound() {
//        return timep.v;
//    }
//
//    @Override
//    public void secound(NumDouble time) {
//        timep = time;
//    }

    public double getAncho() {
        return ancho;
    }

    public double getAlto() {
        return alto;
    }

    
    
}
