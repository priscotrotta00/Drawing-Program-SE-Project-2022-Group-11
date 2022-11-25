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

    //layer=index in array 
    public void moveToLayer(MyShape myShape, int i) {
        //add myShape in position i 
        figures.add(i, myShape);//Inserts the specified element at the specified position in this list. 
        //Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
    }

    public int getShapeLayer(MyShape myShape) throws Exception {
        int i;
        i = figures.indexOf(myShape);
        if (i == -1) {
            throw new Exception();
        } else {
            return i;
        }
    }

    public void addShape(MyShape myShape) {
        //add in figures
        figures.add(myShape);
    }

    public void removeFigure(MyShape myShape) throws Exception {
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

    public void moveToForeground(MyShape myShape) {
        try {
            //myShape goes in last position
            //delete the myshape element from its position
            int i = getShapeLayer(myShape);
            figures.remove(i);
            moveToLayer(myShape,(figures.size()-1));
            //shift
            for (int t = 0; t > figures.size(); t++) {
                //figures[i]=figures[i+1];
                MyShape s=figures.set(t,figures.get(t+1));
            }

            
        } catch (Exception ex) {
            Logger.getLogger(Drawing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void moveToBackground(MyShape myShape) {
        try {
            //myShape goes in 0 position
            //the shape stay in figures, so i delete the shape in position i and insert it in 0 position
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
