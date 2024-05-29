/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplo.Mario;

import GameObject.Ecena;
import Interfaces.Paintable;
import Media.Camara;
import Media.View;

import java.awt.Graphics;

import java.io.IOException;


/**
 *
 * @author willi
 */
public class Ventana extends View{
    
    Camara c;
    Mario m;
    public Ventana() throws IOException {
        setBounds(0,0, 800,500);
        
        final Ecena ecena = new Ecena();
        c = new Camara(ecena);
        c.setBounds(getBounds());
        addCamara(c);
        setEcena(ecena);
        
         m = new Mario();
         mEjemplo e= new mEjemplo("C:\\Users\\willi\\OneDrive\\Documentos\\Mario\\Imgs\\mario\\depieDe.png", 300, 50, 2);
         
        ecena.addGameObject(m);
        ecena.addGameObject(e);
        
        
        init(30);
        
        
    }

    
    
    public static void main(String[] args) throws IOException {
        new Ventana();
    }
    
}
