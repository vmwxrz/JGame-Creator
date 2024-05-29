/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colider;

/**
 *
 * @author willi
 */
public class Capsula extends Form{

    public Capsula( double x, double y, double ancho, double alto) {
        super(new Point[22], x, y, ancho, alto);
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
ps[11] = new Point(-0.5,0.0);
ps[12] = new Point(-0.4755282581474,-0.1545084971874);
ps[13] = new Point(-0.404508497081,-0.2938926260689);
ps[14] = new Point(-0.2938926250834,-0.4045084957246);
ps[15] = new Point(-0.1545084968965,-0.4755282572521);
ps[16] = new Point(0.0,-0.5);
ps[17] = new Point(0.1545084968965,-0.4755282572521);
ps[18] = new Point(0.2938926250834,-0.4045084957246);
ps[19] = new Point(0.404508497081,-0.2938926260689);
ps[20] = new Point(0.4755282581474,-0.1545084971874);
ps[21] = new Point(0.5,0.0);
    }

    @Override
    public void setAncho(double ancho) {
        super.setAncho(ancho);
        if (ancho > super.getAlto()) {
            setAlto(ancho);
        }
 
    }

    

    @Override
    public void setAlto(double alto) {
            super.setAlto(alto);
            revalidateY();
        
    }

    @Override
    public void revalidateX() {
        super.revalidateX();
        revalidateY();
    }
    
    @Override
    public void revalidateY() {
            for (int i = 0; i < ps.length; i++) {
                pst[i].y.v = (ps[i].y.v * super.getAncho())  + super.getY();
            }  
            
            if (super.getAlto() > super.getAncho()) {
                final double dif = (super.getAlto() - super.getAncho())/2f;
            for (int i = 0; i < 11; i++) {
                pst[i].y.v += dif;
            }
            for (int i = 11; i < 22; i++) {
                pst[i].y.v -= dif;
            }
        }
            
    }
    
   
    
}
