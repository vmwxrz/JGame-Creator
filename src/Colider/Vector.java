/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colider;

import GameObject.GameObject;

/**
 *
 * @author willi
 */
public class Vector{
    public final Point p[];
    
    public Vector(Point p1, Point p2) {
        p = new Point[2];
        p[0] = p1;
        p[1] = p2;
    }
    
   public Vector(final double x1, final double y1, final double x2, final double y2) {
       this(new Point(x1,y1), new Point(x2,y2));
   }
    public Vector() {
        this(new Point(), new Point());
    }

    public Point getP1() {
        return p[0];
    }

    public Point getP2() {
        return p[1];
    }

    public void setP1(Point p1) {
        this.p[0] = p1;
    }

    public void setP2(Point p2) {
        this.p[1] = p2;
    }

    public boolean intersets(final Vector v){
        
        final Point a = Point.Restar(p[0], v.p[0]);
        final Point b = Point.Restar(p[0], v.p[1]);
        final Point c = Point.Restar(p[1], v.p[1]);
        final Point d = Point.Restar(p[1], v.p[0]);
        
        final double area1 = AreaTriangulo(a, b, c) * 2;
        final double subArea1 = AreaTriangulo(a, b);
        final double subArea2 = AreaTriangulo(b, c);
        final double subArea3 = AreaTriangulo(c, d);
        final double subArea4 = AreaTriangulo(d, a);
        
        final double sum = (subArea1 + subArea2 + subArea3 + subArea4);
        
        return sum == area1;
    }
    private static double AreaTriangulo(Point p1, Point p2, Point p3){
        return  Math.abs( (p1.x.v * (p2.y.v - p3.y.v)) + (p2.x.v * (p3.y.v - p1.y.v)) + (p3.x.v * (p1.y.v - p2.y.v))) ;// /2;
    }
    
    private static double AreaTriangulo(Point p1, Point p2){
        return  Math.abs( (p1.x.v * p2.y.v) - (p2.x.v *  p1.y.v)  ) ;// /2;
    }

    
}
