/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colider;

/**
 *
 * @author willi
 */
public class Point {
    public static Point point0 = new Point();
    public NumDouble x, y;
    public Point(NumDouble x, NumDouble y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(new NumDouble(), new NumDouble());
    }
    
    public Point(final double x, final double y) {
        this(new NumDouble(x), new NumDouble(y));
    }

    public NumDouble getX() {
        return x;
    }

    public NumDouble getY() {
        return y;
    }

    public void setX(NumDouble x) {
        this.x = x;
    }

    public void setY(NumDouble y) {
        this.y = y;
    }
    
    public void moveX(final double x){
        this.x.v+=x;
    }
    public void moveY(final double y){
        this.y.v+=y;
    }
    
    public static Point Restar(final Point p1, final Point p2){
        return new Point(p1.x.v - p2.x.v,p1.y.v - p2.y.v);
    }
    
    @Override
    public String toString(){
        return "("+x.v+", "+y.v+")";
    }
    
    
}
