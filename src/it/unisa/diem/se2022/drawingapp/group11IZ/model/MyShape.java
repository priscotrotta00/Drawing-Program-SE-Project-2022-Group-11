package it.unisa.diem.se2022.drawingapp.group11IZ.model;

import it.unisa.diem.se2022.drawingapp.group11IZ.interfaces.Visitor;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;



/**
 * Interface that represents a shape
 * @author saram
 */
public interface MyShape extends Cloneable{
    /*Contains the most commonly used Shape methods*/
    
    public Paint myGetStroke();
    public Paint myGetFill();
    public void mySetStroke(Paint value);
    public void mySetFill(Paint value);
    public ObjectProperty<Paint> myStrokeProperty();
    public ObjectProperty<Paint> myFillProperty();
    public String myGetId();
    public Parent myGetParent();
    public double myGetStrokeWidth();
    public void mySetStrokeWidth(double value);
    public void mySetVisible(boolean value);
    public void modifyShape(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY);
    public void accept(Visitor v);
    public void mySetLayoutX(double value);
    public void mySetLayoutY(double value);
    public DoubleProperty myLayoutXProperty();
    public DoubleProperty myLayoutYProperty();;
    public ObservableList<Double> myGetStrokeDashArray();
    public Bounds myGetLayoutBounds();
    public void moveShape(double topLeftX, double topLeftY);
    public double myGetLayoutX();
    public double myGetLayoutY();
    
    /**
     * Create a new clone of the shape, according to the Prototype Pattern
     * @return A clone of the shape
     */
    public MyShape clone();
    
    /**
     * Get the associated JavaFX Shape Object, to be used inside the View 
     * components
     * @return A JavaFX Shape object
     */
    public Shape getView();
    
    /**
     * Get a snapshot of the current state of the shape, which can be used to
     * restore it later (according to the Memento pattern)
     * @return A snapshot of the current state
     */
    public Snapshot getSnapshot();
    
    /**
     * Interface that represents a snapshot of a shape's state
     */
    public interface Snapshot {
        /**
         * Restore the state memorized inside the snapshot on the shape it is
         * associated with
         */
        public void restore();
    }
}
