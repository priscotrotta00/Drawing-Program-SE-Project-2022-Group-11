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
import javafx.scene.shape.Ellipse;

/**
 * Implementation of all methods defined in the interface MyEllipse
 * @author saram
 */
public class MyEnhancedEllipse extends Ellipse implements MyEllipse{
    private final DoubleProperty topLeftX = new SimpleDoubleProperty();
    private final DoubleProperty topLeftY = new SimpleDoubleProperty();
    private final DoubleProperty bottomRightX = new SimpleDoubleProperty();
    private final DoubleProperty bottomRightY = new SimpleDoubleProperty();
    
    public MyEnhancedEllipse(){
        super();
        this.topLeftX.bind(this.myCenterXProperty().subtract(this.myRadiusXProperty()));
        this.topLeftY.bind(this.myCenterYProperty().subtract(this.myRadiusYProperty()));
        this.bottomRightX.bind(this.myCenterXProperty().add(this.myRadiusXProperty()));
        this.bottomRightY.bind(this.myCenterYProperty().add(this.myRadiusYProperty()));
    }
    
    private MyEnhancedEllipse (MyEnhancedEllipse ellipse){
        this();
        this.mySetCenterX(ellipse.myGetCenterX());
        this.mySetCenterY(ellipse.myGetCenterY());
        this.mySetRadiusX(ellipse.myGetRadiusX());
        this.mySetRadiusY(ellipse.myGetRadiusY());
        this.mySetFill(ellipse.myGetFill());
        this.mySetStroke(ellipse.myGetStroke());
        this.mySetStrokeWidth(ellipse.myGetStrokeWidth());  
        
    }
    
    @Override
    public double myGetCenterX() {
        return super.getCenterX();
    }

    @Override
    public double myGetCenterY() {
        return super.getCenterY();
    }

    @Override
    public double myGetRadiusX() {
        return super.getRadiusX();
    }

    @Override
    public double myGetRadiusY() {
        return super.getRadiusY();
    }

    @Override
    public void mySetCenterX(double value) {
        super.setCenterX(value);
    }

    @Override
    public void mySetCenterY(double value) {
        super.setCenterY(value);
    }

    @Override
    public void mySetRadiusX(double value) {
        super.setRadiusX(value);
    }

    @Override
    public void mySetRadiusY(double value) {
        super.setRadiusY(value);
    }

    @Override
    public DoubleProperty myCenterXProperty() {
        return super.centerXProperty();
    }

    @Override
    public DoubleProperty myCenterYProperty() {
        return super.centerYProperty();
    }

    @Override
    public DoubleProperty myRadiusXProperty() {
        return super.radiusXProperty();
    }

    @Override
    public DoubleProperty myRadiusYProperty() {
        return super.radiusYProperty();
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
        v.visitEllipse(this);
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
    public double getTopLeftX() {
        return myGetCenterX() - myGetRadiusX();
    }

    @Override
    public double getTopLeftY() {
        return myGetCenterY() - myGetRadiusY();
    }

    @Override
    public double getBottomRightX() {
        return myGetCenterX() + myGetRadiusX();
    }

    @Override
    public double getBottomRightY() {
        return myGetCenterY() + myGetRadiusY();
    }

    /**
     * Methods that returns the RadiusX of a Ellipse given its X coordinates
     * @param topLeftX
     * @param bottomRightX
     * @return Radius X of an ellipse
     */
    private double computeEllipseRadiusX(double topLeftX, double bottomRightX) {
        return (bottomRightX - topLeftX)/2;
    }
    
    /**
     * Methods that returns the RadiusX of a Ellipse given its X coordinates
     * @param topLeftY
     * @param bottomRightY
     * @return Radius X of an ellipse
     */
    private double computeEllipseRadiusY(double topLeftY, double bottomRightY) {
        return (bottomRightY - topLeftY)/2;
    }
    
    /**
     * Methods that returns the X coordinate of an Ellipse's center 
     * given its X coordinates
     * @param radiusX
     * @param topLeftX
     * @return X cooridnate of an ellipse's center
     */
    private double computeEllipseCenterX(double radiusX, double topLeftX) {
        return radiusX + topLeftX;
    }
    
    /**
     * Methods that returns the Y coordinate of an Ellipse's center 
     * given its Y coordinates
     * @param radiusY
     * @param topLeftY
     * @return Y cooridnate of an ellipse's center
     */
    private double computeEllipseCenterY(double radiusY, double topLeftY) {
        return radiusY + topLeftY;
    }

    /**
     * Method that modify the previously created Ellipse using the passed 
     * coordinates to calculateradiusX, radiusY, centerX and centerY.
     * @param topLeftX
     * @param topLeftY
     * @param bottomRightX
     * @param bottomRightY 
     */
    @Override
    public void modifyShape(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
        double radiusX;
        double radiusY;
        double centerX;
        double centerY;
        
        if (topLeftX > bottomRightX || topLeftY > bottomRightY) throw new InvalidCoordinatesException();
        
        radiusX = this.computeEllipseRadiusX(topLeftX, bottomRightX);
        radiusY = this.computeEllipseRadiusY(topLeftY, bottomRightY);
        centerX = this.computeEllipseCenterX(radiusX, topLeftX);
        centerY = this.computeEllipseCenterY(radiusY, topLeftY);
        
        this.mySetCenterX(centerX);
        this.mySetCenterY(centerY);
        this.mySetRadiusX(radiusX);
        this.mySetRadiusY(radiusY);
    }

    @Override
    public ReadOnlyDoubleProperty topLeftXProperty() {
        return this.topLeftX;
    }

    @Override
    public ReadOnlyDoubleProperty topLeftYProperty() {
        return this.topLeftY;
    }

    @Override
    public ReadOnlyDoubleProperty bottomRightXProperty() {
        return this.bottomRightX;
    }

    @Override
    public ReadOnlyDoubleProperty bottomRightYProperty() {
        return this.bottomRightY;
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
     * Change the position of an ellipse 
     * changing its center coordinates
     * @param topLeftX
     * @param topLeftY 
     */
    @Override
    public void moveShape(double topLeftX, double topLeftY) {
        this.mySetCenterX(topLeftX);
        this.mySetCenterY(topLeftY);
    }

    /**
     * Create a new clone of the ellipse, according to the Prototype Pattern
     * @return A clone of the shape
     */
    @Override
    public MyShape clone() {
        return new MyEnhancedEllipse(this);        
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
    public Ellipse getView(){
        return (Ellipse) this;
    }
    
    /**
     * Get a snapshot of the current state of the ellipse, which can be used to
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
        private final MyEnhancedEllipse ellipse;
        private final double centerX;
        private final double centerY;
        private final double radiusX;
        private final double radiusY;
        private final Paint stroke;
        private final Paint fill;
        private final double strokeWidth;

        /**
         * Create a new snapshot of the given rectangle.
         * @param ellipse
         */
        private Snapshot(MyEnhancedEllipse ellipse){
            this.ellipse = ellipse;
            this.centerX = ellipse.myGetCenterX();
            this.centerY = ellipse.myGetCenterY();
            this.radiusX = ellipse.myGetRadiusX();
            this.radiusY = ellipse.myGetRadiusY();
            this.fill = ellipse.myGetFill();
            this.stroke = ellipse.myGetStroke();
            this.strokeWidth = ellipse.myGetStrokeWidth();
        }
        
        /**
         * Restore the state of the rectangle that is saved inside the snapshot.
         */
        @Override
        public void restore() {
            this.ellipse.mySetCenterX(centerX);
            this.ellipse.mySetCenterY(centerY);
            this.ellipse.mySetRadiusX(radiusX);
            this.ellipse.mySetRadiusY(radiusY);
            this.ellipse.mySetFill(fill);
            this.ellipse.mySetStroke(stroke);
            this.ellipse.mySetStrokeWidth(strokeWidth);
        }
        
    }
}

