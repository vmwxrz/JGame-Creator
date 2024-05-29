/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Colider.Form;
import GameObject.Imagen;

/**
 *
 * @author willi
 */
public interface Collicionable {
    
    default boolean isCollition(Collicionable collition){
        for (Form form : getColider()) {
            for (Form form1 : collition.getColider()) {
                if (form.intersects(form1)) {
                    return true;
                }
            }
        }
        return false;
        
    }
//    public void onCollition(Collicionable obj);
    public void onCollitionIn(Collicionable obj);
    public void onCollitionOut(Collicionable obj);
    public Form[] getColider();
}
