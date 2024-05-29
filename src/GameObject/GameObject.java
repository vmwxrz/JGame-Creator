/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package GameObject;

import Interfaces.Pointables;
/**
 *
 * @author willi
 */
public abstract class GameObject implements Pointables{
    private double x, y;
    
    
    public GameObject(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    
    @Override
    public void setX(double x) {
//        System.out.println(x);
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void moveX(double x) {
        
        setX(this.x+x);
    }

    @Override
    public void moveY(double y) {
        setY(this.y+y);
    }
    
    
    
    
    
    
    

}
