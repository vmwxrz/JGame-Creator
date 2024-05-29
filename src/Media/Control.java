/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Media;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author willi
 */
public class Control implements KeyListener{

    private static int[] btns;
    private static boolean [] btnsBool;
    private static final int a = 0,b = 1,c = 2,d = 3,iz = 4,ar = 5,de = 6,ab = 7;
    public Control() {
        this(65, 66, 67, 68, 37, 38, 39, 40);
    }

    public Control(int a, int b, int c, int d, int iz, int ar, int de, int ab) {
        btns = new int[8];
        btnsBool = new boolean[8];
        btns[this.a] = a;
        btns[this.b] = b;
        btns[this.c] = c;
        btns[this.d] = d;
        btns[this.iz] = iz;
        btns[this.ar] = ar;
        btns[this.de] = de;
        btns[this.ab] = ab;
        for (int i = 0; i < btnsBool.length; i++) {
            btnsBool[i] = false;
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        for (int i = 0; i < btns.length; i++) {
            if (!btnsBool[i] && btns[i] == e.getKeyCode()) {
                btnsBool[i] = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        for (int i = 0; i < btns.length; i++) {
            if (btnsBool[i] && btns[i] == e.getKeyCode()) {
                btnsBool[i] = false;
            }
        }
    }
    
   public static boolean isPressed(int btn){   
     return btnsBool[btn];
   }
   
   public static boolean isPressedA(){
       return isPressed(a);
   }
   public static boolean isPressedB(){
       return isPressed(b);
   }
   public static boolean isPressedC(){
       return isPressed(c);
   }
   public static boolean isPressedD(){
       return isPressed(d);
   }
   
   public static boolean  isPrssedIz(){
    return isPressed(iz);
   }
   public static boolean  isPrssedAr(){
       return isPressed(ar);
   }
   public static boolean  isPrssedDe(){
       return isPressed(de);
   }
   public static boolean  isPrssedAb(){
       return isPressed(ab);
   }
    
}
