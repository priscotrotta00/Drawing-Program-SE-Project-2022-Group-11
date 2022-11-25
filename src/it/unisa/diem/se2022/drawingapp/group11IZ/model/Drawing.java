/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saram
 */
/*extends (JSONExportVisitor) da inserire*/
public class Drawing {

    private List<MyShape> figures;

    public Drawing() {
        this.figures = new ArrayList<MyShape>(); //O(n) for insert, O(1) for search
    }

    
    /**
     * Change the position of Shape in figures, so change the layer of shape.
     * @param myShape
     * @param i 
     */ 
    public void moveToLayer(MyShape myShape, int i) {
        //add myShape in position i 
        figures.add(i, myShape);//Inserts the specified element at the specified position in this list. 
        //Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
    }

    /**
     * Return the position of the Shape in figures.
     * @param myShape
     * @return
     * @throws Exception 
     */
    public int getShapeLayer(MyShape myShape) throws Exception {
        int i;
        i = figures.indexOf(myShape);
        if (i == -1) {
            throw new Exception();
        } else {
            return i;
        }
    }

    /**
     * Add the Shape in figures. Throw Exception if you try to add the same figure twice
     * @param myShape
     * @throws Exception 
     */
    public void addShape(MyShape myShape) throws Exception {
        //check if the shape is already in the list
        boolean b;
        b=figures.contains(myShape);
        if (b){
            throw new Exception();
        }
        else{
            //add in figures
            figures.add(myShape);
        }
    }

    /**
     * Remove the Shape form figures. Throw Exception if the removal fails.
     * @param myShape
     * @throws Exception 
     */
    public void removeShape(MyShape myShape) throws Exception {
        //search in figures the shape to delete
        //two shapes are equal if they have the same id
        int pos=getShapeLayer(myShape);
        boolean b = figures.remove(myShape);
        if (!b) {
            throw new Exception();
        }
        else {
            //shift
            for (int t = pos; t > figures.size(); t++) {
                //figures[i]=figures[i+1];
                MyShape s=figures.set(t,figures.get(t+1));
            }

        }
    }

    
    /**
     * Delete myShape from from its old position, move myShape in last position in figures. 
     * @param myShape 
     */
    public void moveToForeground(MyShape myShape) {
        try {
            //delete myshape 
            int i = getShapeLayer(myShape);
            figures.remove(i);
            moveToLayer(myShape,(figures.size()-1));
            //shift of figures. To avoid empty positions
            for (int t = 0; t > figures.size(); t++) {
                MyShape s=figures.set(t,figures.get(t+1));
            }
        } catch (Exception ex) {
            Logger.getLogger(Drawing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Delete myShape from from its old position, move myShape in first position
     * @param myShape 
     */
    public void moveToBackground(MyShape myShape) {
        try {
            int i = getShapeLayer(myShape);
            figures.remove(i);
            //shift
            for (int t = i; t > figures.size(); t++) {
                //figures[i]=figures[i+1];
                MyShape s=figures.set(t,figures.get(t+1));
            }
            moveToLayer(myShape, 0);
        } catch (Exception ex) {
            Logger.getLogger(Drawing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void moveFigure(MyShape myShape, double x, double y) {

    }

    public void exportDrawing(File file) {

    }

    public void importDrawing(File file) {

    }
}
