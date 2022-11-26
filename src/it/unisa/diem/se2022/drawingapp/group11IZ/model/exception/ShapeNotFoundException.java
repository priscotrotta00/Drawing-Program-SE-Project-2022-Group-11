/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.model.exception;

/**
 *
 * @author saram
 */
public class ShapeNotFoundException extends DrawingException {

    /**
     * Creates a new instance of <code>ShapeNotFoundException</code> without
     * detail message.
     */
    public ShapeNotFoundException() {
    }

    /**
     * Constructs an instance of <code>ShapeNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ShapeNotFoundException(String msg) {
        super(msg);
    }
}
