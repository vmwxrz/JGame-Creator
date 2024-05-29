/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colider;

/**
 *
 * @author willi
 */
public class Triangulo extends Form{

    public Triangulo( double x, double y, double ancho, double alto) {
        super(new Point[3], x, y, ancho, alto);
    }

    @Override
    public void init(Point[] ps) {
ps[0] = new Point(0.0,-0.5);
ps[1] = new Point(0.5,0.5);
ps[2] = new Point(-0.5,0.5);
    }

}
