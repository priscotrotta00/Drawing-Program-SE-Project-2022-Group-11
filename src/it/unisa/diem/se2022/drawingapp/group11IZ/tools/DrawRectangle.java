/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import javafx.scene.shape.Shape;

/**
 *
 * @author utente
 */
public class DrawRectangle extends DrawShape{
    
    private static DrawRectangle singleton = null;
    
    private DrawRectangle(){}
    
    public static DrawRectangle getInstance(){
        if (singleton == null) singleton = new DrawRectangle();
        return singleton;
    }

    @Override
    public Shape createShape(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
