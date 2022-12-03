/**
 * The Class selection implements the selection and unselection of shapes
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.interfaces.Visitor;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.*;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.beans.value.ObservableBooleanValue;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 *
 * @author daddy
 */
public class Selection implements Visitor{
    private Group selectionBorder;
    private MyShape selectedItem;
    private BooleanProperty selected;
    private static Selection instance = null;

    /**
     * Class constructor.
     */
    private Selection() {
        this.selectionBorder = new Group();
        this.selectedItem = null;
        this.selected = new SimpleBooleanProperty(false);
    }
    
    /**
     * 
     * @return the instance of SelectTool.
     */
    public static Selection getInstance(){
        if (instance == null) instance = new Selection();
        return instance;
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
    private void setSelectionBorder(Group selectionBorder) {
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
     * @param selectedItem 
     */
    private void setSelectedItem(MyShape selectedItem) {
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
     * @param selected 
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
        if(getSelectedValue()) this.unSelect();
        
        MyRectangle highlightRectangle = new MyEnhancedRectangle();
        
        if(myRectangle.myGetFill() == Color.TRANSPARENT){
            MyShape shape = this.getSelectedItem();
            
            if(!(shape instanceof MyRectangle)) return;
            
            myRectangle = (MyRectangle) shape;
        }
        
        setSelectedItem(myRectangle);
        
        Bindings.bindBidirectional(highlightRectangle.myLayoutXProperty() ,myRectangle.myLayoutXProperty());
        Bindings.bindBidirectional(highlightRectangle.myLayoutYProperty() ,myRectangle.myLayoutYProperty());
        
        Bindings.bindBidirectional(highlightRectangle.myXProperty(), myRectangle.myXProperty());
        Bindings.bindBidirectional(highlightRectangle.myYProperty(), myRectangle.myYProperty());
        Bindings.bindBidirectional(highlightRectangle.myHeightProperty(), myRectangle.myHeightProperty());
        Bindings.bindBidirectional(highlightRectangle.myWidthProperty(), myRectangle.myWidthProperty());
        
        highlightRectangle.mySetFill(Color.TRANSPARENT);
        highlightRectangle.mySetStroke(Color.BLACK);
        
        highlightRectangle.mySetStrokeWidth(myRectangle.myGetStrokeWidth()+2);
        highlightRectangle.myGetStrokeDashArray().addAll(5.0,10.0,5.0,10.0);
        
        getSelectionBorder().getChildren().add((Shape)highlightRectangle);
        
        Parent parent = myRectangle.myGetParent();
        
        if(!(parent instanceof Pane)) return;
        
        Pane pane = (Pane) parent;
        
        pane.getChildren().add(getSelectionBorder());
        
        setSelected(true);
    }
    
    /**
     * This method highlight a line creating a new line, around the
     * already existing one, with a wider black stroke and a transparent fill.
     * 
     * @param myLine the selected line
     */
    public void select(MyLine myLine){
        if(getSelectedValue()) this.unSelect();
        
        MyLine highlightLine = new MyEnhancedLine();
        
        if(myLine.myGetFill() == Color.TRANSPARENT){
            MyShape shape = this.getSelectedItem();
            
            if(!(shape instanceof MyLine)) return;
            
            myLine = (MyLine) shape;
        }
        
        setSelectedItem(myLine);
        
        Bindings.bindBidirectional(highlightLine.myLayoutXProperty() ,myLine.myLayoutXProperty());
        Bindings.bindBidirectional(highlightLine.myLayoutYProperty() ,myLine.myLayoutYProperty());
        
        Bindings.bindBidirectional(highlightLine.myStartXProperty(), myLine.myStartXProperty());
        Bindings.bindBidirectional(highlightLine.myStartYProperty(), myLine.myStartYProperty());
        Bindings.bindBidirectional(highlightLine.myEndXProperty(), myLine.myEndXProperty());
        Bindings.bindBidirectional(highlightLine.myEndYProperty(), myLine.myEndYProperty());
        
        
        highlightLine.mySetFill(Color.TRANSPARENT);
        highlightLine.mySetStroke(Color.BLACK);
        
        highlightLine.mySetStrokeWidth(myLine.myGetStrokeWidth()+2);
        highlightLine.myGetStrokeDashArray().addAll(5.0,10.0,5.0,10.0);
        
        getSelectionBorder().getChildren().add((Shape)highlightLine);
        
        Parent parent = myLine.myGetParent();
        
        if(!(parent instanceof Pane)) return;
        
        Pane pane = (Pane) parent;
        
        pane.getChildren().add(getSelectionBorder());
        
        setSelected(true);
    }
    
    /**
     * This method highlight an ellipse creating a new ellipse, around the
     * already existing one, with a wider black stroke and a transparent fill.
     * 
     * @param myEllipse the selected ellipse
     */
    public void select(MyEllipse myEllipse){
        if(getSelectedValue()) this.unSelect();
        
        MyEllipse highlightEllipse = new MyEnhancedEllipse();
        
        if(myEllipse.myGetFill() == Color.TRANSPARENT){
            MyShape shape = this.getSelectedItem();
            
            if(!(shape instanceof MyEllipse)) return;
            
            myEllipse = (MyEllipse) shape;
        }
        
        setSelectedItem(myEllipse);
        
        Bindings.bindBidirectional(highlightEllipse.myLayoutXProperty() ,myEllipse.myLayoutXProperty());
        Bindings.bindBidirectional(highlightEllipse.myLayoutYProperty() ,myEllipse.myLayoutYProperty());
        
        Bindings.bindBidirectional(highlightEllipse.myCenterXProperty(), myEllipse.myCenterXProperty());
        Bindings.bindBidirectional(highlightEllipse.myCenterYProperty(), myEllipse.myCenterYProperty());
        Bindings.bindBidirectional(highlightEllipse.myRadiusXProperty(), myEllipse.myRadiusXProperty());
        Bindings.bindBidirectional(highlightEllipse.myRadiusYProperty(), myEllipse.myRadiusYProperty());
        
        highlightEllipse.mySetFill(Color.TRANSPARENT);
        highlightEllipse.mySetStroke(Color.BLACK);
        
        highlightEllipse.mySetStrokeWidth(myEllipse.myGetStrokeWidth()+2);
        highlightEllipse.myGetStrokeDashArray().addAll(5.0,10.0,5.0,10.0);
        
        getSelectionBorder().getChildren().add((Shape)highlightEllipse);
        
        Parent parent = myEllipse.myGetParent();
        
        if(!(parent instanceof Pane)) return;
        
        Pane pane = (Pane) parent;
        
        pane.getChildren().add(getSelectionBorder());
        
        setSelected(true);
    }

    /**
     * This method delete the shape that highlight the selected shape and
     * reset all the attributes
     */
    public void unSelect(){
        if(!getSelectedValue()) return;
        
        Node node = getSelectedItem().myGetParent(); 
        
        if(!(node instanceof Node)) return;
        
        Parent parent = (Parent) node;
        
        if(!(parent instanceof Pane)) return;
       
        Pane pane = (Pane) parent;
        
        pane.getChildren().removeAll(getSelectionBorder());
        
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
     * @param myRectangle 
     */
    @Override
    public void visitRectangle(MyRectangle myRectangle) {
        select(myRectangle);
    }
    
    /**
     * 
     * @param myEllipse 
     */
    @Override
    public void visitEllipse(MyEllipse myEllipse) {
        select(myEllipse);
    }
    
    /**
     * 
     * @param myLine 
     */
    @Override
    public void visitLine(MyLine myLine) {
        select(myLine);
    }
    
}
