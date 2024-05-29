/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

/**
 *
 * @author willi
 */
public abstract class SubThread {
    private boolean pausa = true;
    public void start(){
        if (pausa) {
            run();
        }
    }
    abstract public void run();
    public void suspend(){pausa = false;}
    public void join(){pausa = true;}
//    public void finish();
}
