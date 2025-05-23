package it.unisa.diem.se2022.drawingapp.group11IZ.model;

import it.unisa.diem.se2022.drawingapp.group11IZ.interfaces.Visitor;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.exception.InvalidCoordinatesException;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Parent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * Implementation of all methods defined in the interface MyRectangle
 * @author saram
 */
public class MyEnhancedRectangle extends Rectangle implements MyRectangle{
    private final SimpleDoubleProperty bottomRightX = new SimpleDoubleProperty();
    private final SimpleDoubleProperty bottomRightY = new SimpleDoubleProperty();
    
    public MyEnhancedRectangle(){
        super();
        bottomRightX.bind(this.myXProperty().add(this.myWidthProperty()));
        bottomRightY.bind(this.myYProperty().add(this.myHeightProperty()));
    }
    
    private MyEnhancedRectangle(MyEnhancedRectangle rectangle){
        this();
        this.mySetY(rectangle.myGetY());
        this.mySetX(rectangle.myGetX());
        this.mySetWidth(rectangle.myGetWidth());
        this.mySetHeight(rectangle.myGetHeight());
        this.mySetStroke(rectangle.myGetStroke());
        this.mySetFill(rectangle.myGetFill());
        this.mySetStrokeWidth(rectangle.myGetStrokeWidth());
    }
    
    @Override
    public double myGetHeight() {
        return super.getHeight();
    }

    @Override
    public double myGetWidth() {
        return super.getWidth();
    }

    @Override
    public double myGetX() {
        return super.getX();
    }

    @Override
    public double myGetY() {
        return super.getY();
    }

    @Override
    public void mySetHeight(double value) {
        super.setHeight(value);
    }

    @Override
    public void mySetWidth(double value) {
        super.setWidth(value);
    }

    @Override
    public void mySetX(double value) {
        super.setX(value);
    }

    @Override
    public void mySetY(double value) {
        super.setY(value);
    }

    @Override
    public DoubleProperty myWidthProperty() {
        return super.widthProperty();
    }

    @Override
    public DoubleProperty myHeightProperty() {
        return super.heightProperty();
    }

    @Override
    public DoubleProperty myXProperty() {
        return super.xProperty();
    }

    @Override
    public DoubleProperty myYProperty() {
        return super.yProperty();
    }

    @Override
    public Paint myGetStroke() {
        return super.getStroke();
    }

    @Override
    public Paint myGetFill() {
        return super.getFill();
    }

    @Override
    public void mySetStroke(Paint value) {
        super.setStroke(value);
    }

    @Override
    public void mySetFill(Paint value) {
        super.setFill(value);
    }

    @Override
    public ObjectProperty<Paint> myStrokeProperty() {
        return super.strokeProperty();
    }

    @Override
    public ObjectProperty<Paint> myFillProperty() {
        return super.fillProperty();
    }
    
    @Override
    public String myGetId() {
        return super.getId();
    }

    @Override
    public double myGetStrokeWidth() {
        return super.getStrokeWidth();
    }

    @Override
    public Parent myGetParent() {
        return super.getParent();
    }

    @Override
    public void mySetStrokeWidth(double value) {
        super.setStrokeWidth(value);
    }

    @Override
    public void mySetVisible(boolean value) {
        super.setVisible(value);
    }
        
    /**
     * Acceptance method according to the Visitor pattern. 
     * Redirects the call to the proper visitor’s method corresponding to the current element class. 
     * @param v Represents the Concrete Visitor
     */
    @Override
    public void accept(Visitor v) {
        v.visitRectangle(this);
    }

    @Override
    public double getTopLeftX() {
        return this.topLeftXProperty().get();
    }

    @Override
    public double getTopLeftY() {
        return this.topLeftYProperty().get();
    }

    @Override
    public double getBottomRightX() {
        return this.bottomRightXProperty().get();
    }

    @Override
    public double getBottomRightY() {
        return this.bottomRightYProperty().get();
    }
   
    /**
     * Method that returns the width of a rectangle gven its X coordinates
     * @param topLeftX X coordinate of the upper-left point
     * @param bottomRightX X coordinate of the bottom-right point
     * @return Width of rectangle
     */
    private double computeRectangleWidth(double topLeftX, double bottomRightX){
        return bottomRightX - topLeftX;
    }
    
    /**
     * Method that returns the height of a rectangle gven its X coordinates
     * @param topLeftY Y coordinate of the upper-left point
     * @param bottomRightY Y coordinate of the bottom-right point
     * @return Height
     */
    private double computeRectangleHeight(double topLeftY, double bottomRightY){
        return bottomRightY - topLeftY;
    }
    
    /**
     * Method that modify the previously created Rectangel using the passed coordinates
     * to calculate width and height.
     * @param topLeftX
     * @param topLeftY
     * @param bottomRightX
     * @param bottomRightY 
     * @author Felice Scala
     */
    @Override
    public void modifyShape(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
        double width;
        double height;
        
        if (topLeftX > bottomRightX || topLeftY > bottomRightY) throw new InvalidCoordinatesException();
        
        width = this.computeRectangleWidth(topLeftX, bottomRightX);
        height = this.computeRectangleHeight(topLeftY, bottomRightY);
        
        this.mySetX(topLeftX);
        this.mySetY(topLeftY);
        this.mySetWidth(width);
        this.mySetHeight(height);
    }

    @Override
    public ReadOnlyDoubleProperty topLeftXProperty() {
        return this.myXProperty();
    }

    @Override
    public ReadOnlyDoubleProperty topLeftYProperty() {
        return this.myYProperty();
    }

    @Override
    public ReadOnlyDoubleProperty bottomRightXProperty() {
        return bottomRightX;
    }

    @Override
    public ReadOnlyDoubleProperty bottomRightYProperty() {
        return bottomRightY;
    }
    
    @Override
    public void mySetLayoutX(double value) {
        super.setLayoutX(value);
    }

    @Override
    public void mySetLayoutY(double value) {
        super.setLayoutY(value);
    }
    
    @Override
    public DoubleProperty myLayoutXProperty() {
        return super.layoutXProperty();
    }

    @Override
    public DoubleProperty myLayoutYProperty() {
        return super.layoutYProperty();
    }

    @Override
    public ObservableList<Double> myGetStrokeDashArray() {
        return super.getStrokeDashArray();
    }

    @Override
    public Bounds myGetLayoutBounds() {
        return super.getLayoutBounds();
    }
    
    /**
     * Change the position of a rectangle changing
     * its top-left coordinates
     * @param topLeftX
     * @param topLeftY 
     */
    @Override
    public void moveShape(double topLeftX, double topLeftY) {
        double diffX = this.myGetLayoutBounds().getMaxX()-this.myGetLayoutBounds().getMinX(); 
        double diffY = this.myGetLayoutBounds().getMaxY()-this.myGetLayoutBounds().getMinY(); 
        
        this.mySetX(topLeftX-(diffX/2));
        this.mySetY(topLeftY-(diffY/2));
    }

    /**
     * Create a new clone of the rectangle, according to the Prototype Pattern
     * @return A clone of the shape
     */
    @Override
    public MyShape clone() {
        return new MyEnhancedRectangle(this);
    }
    
    @Override
    public double myGetLayoutX() {
        return super.getLayoutX();
    }

    @Override
    public double myGetLayoutY() {
        return super.getLayoutY();
    }
    
    @Override
    public Rectangle getView(){
        return (Rectangle) this;
    }
    
    /**
     * Get a snapshot of the current state of the rectangle, which can be used to
     * restore it later (according to the Memento pattern)
     * @return A snapshot of the current state
     */
    @Override
    public Snapshot getSnapshot(){
        return new Snapshot(this);
    }
    
    /**
     * Class that represents a snapshot of the current rectangle's state.
     */
    public class Snapshot implements MyShape.Snapshot{
        private final MyEnhancedRectangle rectangle;
        private final double x;
        private final double y;
        private final double width;
        private final double height;
        private final Paint stroke;
        private final Paint fill;
        private final double strokeWidth;

        /**
         * Create a new snapshot of the given rectangle.
         * @param rectangle 
         */
        private Snapshot(MyEnhancedRectangle rectangle){
            this.rectangle = rectangle;
            this.x = rectangle.myGetX();
            this.y = rectangle.myGetY();
            this.width = rectangle.myGetWidth();
            this.height = rectangle.myGetHeight();
            this.fill = rectangle.myGetFill();
            this.stroke = rectangle.myGetStroke();
            this.strokeWidth = rectangle.myGetStrokeWidth();
        }
        
        /**
         * Restore the state of the rectangle that is saved inside the snapshot.
         */
        @Override
        public void restore() {
            this.rectangle.mySetX(x);
            this.rectangle.mySetY(y);
            this.rectangle.mySetWidth(width);
            this.rectangle.mySetHeight(height);
            this.rectangle.mySetFill(fill);
            this.rectangle.mySetStroke(stroke);
            this.rectangle.mySetStrokeWidth(strokeWidth);
        }
        
    }
}
