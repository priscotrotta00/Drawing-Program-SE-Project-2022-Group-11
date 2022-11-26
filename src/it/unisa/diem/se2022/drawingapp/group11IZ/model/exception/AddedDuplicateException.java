/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.model.exception;

/**
 *
 * @author saram
 */
public class AddedDuplicateException extends DrawingException{

    /**
     * Creates a new instance of <code>AddedDuplicateException</code> without
     * detail message.
     */
    public AddedDuplicateException() {
    }

    /**
     * Constructs an instance of <code>AddedDuplicateException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AddedDuplicateException(String msg) {
        super(msg);
    }
}
