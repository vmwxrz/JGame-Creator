/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colider;

/**
 *
 * @author willi
 */
public class Circulo extends Form{

    public Circulo(double x, double y, double ancho, double alto) {
        super(new  Point[20], x, y, ancho, alto);
    }

    @Override
    public void init(Point[] ps) {
ps[0] = new Point(0.5,0.0);
ps[1] = new Point(0.4755282581474,0.1545084971874);
ps[2] = new Point(0.404508497081,0.2938926260689);
ps[3] = new Point(0.2938926250834,0.4045084957246);
ps[4] = new Point(0.1545084968965,0.4755282572521);
ps[5] = new Point(0.0,0.5);
ps[6] = new Point(-0.1545084968965,0.4755282572521);
ps[7] = new Point(-0.2938926250834,0.4045084957246);
ps[8] = new Point(-0.404508497081,0.2938926260689);
ps[9] = new Point(-0.4755282581474,0.1545084971874);
ps[10] = new Point(-0.5,0.0);
ps[11] = new Point(-0.4755282581474,-0.1545084971874);
ps[12] = new Point(-0.404508497081,-0.2938926260689);
ps[13] = new Point(-0.2938926250834,-0.4045084957246);
ps[14] = new Point(-0.1545084968965,-0.4755282572521);
ps[15] = new Point(0.0,-0.5);
ps[16] = new Point(0.1545084968965,-0.4755282572521);
ps[17] = new Point(0.2938926250834,-0.4045084957246);
ps[18] = new Point(0.404508497081,-0.2938926260689);
ps[19] = new Point(0.4755282581474,-0.1545084971874);
        
    }

}
