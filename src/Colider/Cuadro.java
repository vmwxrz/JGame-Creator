/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colider;

/**
 *
 * @author willi
 */
public class Cuadro extends Form{

    public Cuadro(double x, double y, double ancho, double alto) {
        super(new Point[4], x, y, ancho, alto);
    }

    @Override
    public void init(Point[] ps) {
ps[0] = new Point(0.5,0.5);
ps[1] = new Point(-0.5,0.5);
ps[2] = new Point(-0.5,-0.5);
ps[3] = new Point(0.5,-0.5);
    }

}
