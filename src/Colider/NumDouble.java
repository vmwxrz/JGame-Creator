/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colider;

/**
 *
 * @author willi
 */
public class NumDouble {
    public double v;
    public NumDouble() {
        v = 0;
    }
    public NumDouble(double v) {
        this.v = v;
    }
    
    public double getValue(){
        return v;
    }
    
    public void setValue(final double v){
        this.v = v;
    }
    
    public static NumDouble min(final NumDouble v1, final NumDouble v2){
        return v1.v < v2.v ? v1 : v2;
    }
    
    public static NumDouble max(final NumDouble v1, final NumDouble v2){
        return v1.v > v2.v ? v1 : v2;
    }
}
