/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.model.exception;

/**
 *
 * @author saram
 */
public class DrawingException extends RuntimeException {
   
    /**
     * Creates a new instance of <code>DrawingException</code> without
     * detail message.
     */
    public DrawingException(){
        
    }
    
    /**
     * Constructs an instance of <code>DrawingException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DrawingException (String msg){
        super(msg);
    } 
}
