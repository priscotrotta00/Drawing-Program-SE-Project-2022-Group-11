package it.unisa.diem.se2022.drawingapp.group11IZ.selection;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.interfaces.Visitor;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.*;
import javafx.beans.property.*;
import javafx.beans.value.ObservableBooleanValue;
import javafx.scene.Group;
import javafx.scene.paint.Color;

/**
 * The Class selection implements the selection and unselection of shapes.
 * @author daddy
 */
public class Selection implements Visitor{
    private Group selectionBorder;
    private MyShape selectedItem;
    private final Canvas canvas;
    
    private final BooleanProperty selected = new SimpleBooleanProperty(false);
    private SelectionHelper helper;

    /**
     * Class constructor. Creates a new Group, initialize the selected item to
     * null and inizitialize the canvas
     * @param canvas where shapes bolongs
     */
    public Selection(Canvas canvas) {
        this.selectionBorder = new Group();
        this.selectedItem = null;
        this.canvas = canvas;
    }
    
    /**
     * 
     * @return the group of shapes that rapresent the selection
     */
    public Group getSelectionBorder() {
        return selectionBorder;
    }
    
    /**
     * 
     * @param selectionBorder 
     */
    public void setSelectionBorder(Group selectionBorder) {
        this.selectionBorder = selectionBorder;
    }
    
    /**
     * 
     * @return the selected shape
     */
    public MyShape getSelectedItem() {
        return selectedItem;
    }
    
    /**
     * 
     * @return the preview
     */
    public MyShape getSelectedItemPreview() {
        return this.helper.getPreview();
    }
    
    /**
     * 
     * @param selectedItem is the shape selected
     */
    public void setSelectedItem(MyShape selectedItem) {
        this.selectedItem = selectedItem;
    }
    
    /**
     * 
     * @return the BooleanProperty
     */
    public ObservableBooleanValue getSelectedProperty() {
        return selected;
    }
    
    /**
     * 
     * @param selected sais if is selected a shape
     */
    private void setSelected(Boolean selected) {
        this.selected.set(selected);
    }
    
    /**
     * This method highlight a rectangle creating a new rectangle, around the
     * already existing one, with a wider black stroke and a transparent fill.
     * 
     * @param myRectangle the selected rectangle
     */
    public void select(MyRectangle myRectangle){
        // Unselect the already selected shape
        if(getSelectedValue()) this.unSelect();
        
        // Check if the clicked shape is the bounding box edge itself
        if(myRectangle.myGetFill() == Color.TRANSPARENT){
            MyShape shape = this.getSelectedItem();
            
            if(!(shape instanceof MyRectangle)) return;
            
            myRectangle = (MyRectangle) shape;
        }
        
        // Select the shape
        setSelectedItem(myRectangle);
        
        // Create the bounding box around the shape and add it to the canvas
        helper = new SelectionRectangleHelper(canvas, myRectangle);
        setSelectionBorder(helper.createBoundingBox());
        this.canvas.addBoundingBox(getSelectionBorder());
        
        setSelected(true);
    }
    
    /**
     * This method highlight a line creating a new line, around the
     * already existing one, with a wider black stroke and a transparent fill.
     * 
     * @param myLine the selected line
     */
    public void select(MyLine myLine){
        // Unselect the already selected shape
        if(getSelectedValue()) this.unSelect();
        
        // Check if the clicked shape is the bounding box edge itself
        if(myLine.myGetFill() == Color.TRANSPARENT){
            MyShape shape = this.getSelectedItem();
            
            if(!(shape instanceof MyLine)) return;
            
            myLine = (MyLine) shape;
        }
        
        // Select the shape
        setSelectedItem(myLine);
        
        // Create the bounding box around the shape and add it to the canvas
        helper = new SelectionLineHelper(canvas, myLine);
        setSelectionBorder(helper.createBoundingBox());
        this.canvas.addBoundingBox(getSelectionBorder());
        
        setSelected(true);
    }
    
    /**
     * This method highlight an ellipse creating a new ellipse, around the
     * already existing one, with a wider black stroke and a transparent fill.
     * 
     * @param myEllipse the selected ellipse
     */
    public void select(MyEllipse myEllipse){
        // Unselect the already selected shape
        if(getSelectedValue()) this.unSelect();
        
        // Check if the clicked shape is the bounding box edge itself
        if(myEllipse.myGetFill() == Color.TRANSPARENT){
            MyShape shape = this.getSelectedItem();
            
            if(!(shape instanceof MyEllipse)) return;
            
            myEllipse = (MyEllipse) shape;
        }
        
        // Select the shape
        setSelectedItem(myEllipse);
        
        // Create the bounding box around the shape and add it to the canvas
        helper = new SelectionEllipseHelper(canvas, myEllipse);
        setSelectionBorder(helper.createBoundingBox());
        this.canvas.addBoundingBox(getSelectionBorder());
        
        setSelected(true);
    }

    /**
     * This method delete the shape that highlight the selected shape and
     * reset all the attributes.
     */
    public void unSelect(){
        // Return if no shape is selected
        if(!getSelectedValue()) return;
        
        // Remove the bounding box from the Canvas
        this.canvas.removeBoundingBox(getSelectionBorder());
        this.helper.destroyBoundingBox();
        
        setSelectedItem(null);
        setSelected(false);
        setSelectionBorder(new Group()); 
    }
    
    /**
     * 
     * @return the Boolean that explain if a figure is selected
     */
    public Boolean getSelectedValue(){
        return getSelectedProperty().get();
    }
    
    /**
     * 
     * @param myRectangle clicked rectangle
     */
    @Override
    public void visitRectangle(MyRectangle myRectangle) {
        select(myRectangle);
    }
    
    /**
     * 
     * @param myEllipse clicked ellipse
     */
    @Override
    public void visitEllipse(MyEllipse myEllipse) {
        select(myEllipse);
    }
    
    /**
     * 
     * @param myLine clicked line
     */
    @Override
    public void visitLine(MyLine myLine) {
        select(myLine);
    }
    
}
