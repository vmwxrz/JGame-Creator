/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Colider.Point;

/**
 *
 * @author willi
 */
public interface Pointables {
    
//    public Point getPoint();
//    public void setPoint(Point point);
//    public double getMaxX();
//    public double getMaxY();
//    public void setMaxY(double y);
//    public void setMaxX(double x);
    
    public double getX();
    public void setX(double x);
    public double getY();
    public void setY(double x);
    public void moveX(double x);
    public void moveY(double y);
}
