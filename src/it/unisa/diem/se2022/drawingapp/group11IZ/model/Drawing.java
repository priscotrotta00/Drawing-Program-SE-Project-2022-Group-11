package it.unisa.diem.se2022.drawingapp.group11IZ.model;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.exception.AddedDuplicateException;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.exception.ShapeNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class that represents the Drawing model. It contains all the shapes that 
 * compose the Drawing itself.
 * @author saram
 */
public class Drawing implements Iterable<MyShape>{

    private final List<MyShape> figures;

    /**
     * Create a new Drawing.
     */
    public Drawing() {
        this.figures = new ArrayList<>(); //O(n) for insert, O(1) for search
    }

    /**
     * Change the position of Shape in figures, so change the layer of shape.
     *
     * @param myShape
     * @param i
     */
    public void moveToLayer(MyShape myShape, int i) {
        //add myShape in position i 
       
        figures.remove(myShape);
        figures.add(i, myShape);//Inserts the specified element at the specified position in this list. 
        //Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
    }

    /**
     * Return the position of the Shape in figures.
     *
     * @param myShape
     * @return
     * @throws ShapeNotFoundException
     */
    public int getShapeLayer(MyShape myShape) throws ShapeNotFoundException {
        int i;
        i = figures.indexOf(myShape);
        if (i == -1) {
            throw new ShapeNotFoundException();
        } else {
            return i;
        }
    }

    /**
     * Add the Shape in figures. Throw exception if you try to add the
     * same figure twice
     *
     * @param myShape
     * @throws AddedDuplicateException
     */
    public void addShape(MyShape myShape) throws AddedDuplicateException {
        //check if the shape is already in the list
        boolean b;
        b = figures.contains(myShape);
        if (b) {
            throw new AddedDuplicateException();
        } else {
            //add in figures
            figures.add(myShape);
        }
    }

    /**
     * Remove the Shape form figures.Throw Exception if the removal fails.
     *
     * @param myShape
     */
    public void removeShape(MyShape myShape) {
        //search in figures the shape to delete
        //two shapes are equal if they have the same id
        int pos = getShapeLayer(myShape);
        boolean b = figures.remove(myShape);

        //shift
        for (int t = pos; t > figures.size(); t++) {
            //figures[i]=figures[i+1];
            MyShape s = figures.set(t, figures.get(t + 1));
        }

    }

    /**
     * Delete myShape from from its old position, move myShape in last position
     * in figures.
     *
     * @param myShape
     */
    public void moveToForeground(MyShape myShape) {
        //delete myshape 
        int i = getShapeLayer(myShape);
        figures.remove(i);
        moveToLayer(myShape, figures.size());
    }

    /**
     * Delete myShape from from its old position, move myShape in first position
     *
     * @param myShape
     */
    public void moveToBackground(MyShape myShape) {
        int i = getShapeLayer(myShape);
        figures.remove(i);
        moveToLayer(myShape, 0);
    }

    /**
     * Return an Iterator to MyShapes inside the drawing
     * @return an Iterator
     */
    @Override
    public Iterator<MyShape> iterator() {
        return this.figures.iterator();
    }
    
}
