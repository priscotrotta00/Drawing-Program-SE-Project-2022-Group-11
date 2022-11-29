/**
 * The Class selection implements the selection and unselection of shapes
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.interfaces.Visitor;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.*;
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
     * @return the instance of Selection.
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
     * @param selectedItem 
     */
    public void setSelectedItem(MyShape selectedItem) {
        this.selectedItem = selectedItem;
    }
    
    /**
     * 
     * @return the BooleanProperty
     */
    public ObservableBooleanValue getSelected() {
        return selected;
    }
    
    /**
     * 
     * @param selected 
     */
    public void setSelected(Boolean selected) {
        this.selected.set(selected);
    }
    
    /**
     * This method highlight a rectangle creating a new rectangle, around the
     * already existing one, with a wider black stroke and a transparent fill.
     * 
     * @param myRectangle the selected rectangle
     */
    public void select(MyRectangle myRectangle){
        if(selectedProperty()) this.unSelect();
        
        MyRectangle highlightRectangle = new MyEnhancedRectangle();
        
        if(myRectangle.myGetFill() == Color.TRANSPARENT){
            MyShape shape = this.getSelectedItem();
            
            if(!(shape instanceof MyRectangle)) return;
            
            myRectangle = (MyRectangle) shape;
        }
        
        setSelectedItem(myRectangle);
        
        highlightRectangle.myXProperty().bind(myRectangle.myXProperty());
        highlightRectangle.myYProperty().bind(myRectangle.myYProperty());
        highlightRectangle.myHeightProperty().bind(myRectangle.myHeightProperty());
        highlightRectangle.myWidthProperty().bind(myRectangle.myWidthProperty());
        
        highlightRectangle.mySetFill(Color.TRANSPARENT);
        highlightRectangle.mySetStroke(Color.BLACK);
        
        highlightRectangle.mySetStrokeWidth(myRectangle.myGetStrokeWidth()+2);
        
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
        if(selectedProperty()) this.unSelect();
        
        MyLine highlightLine = new MyEnhancedLine();
        
        if(myLine.myGetFill() == Color.TRANSPARENT){
            MyShape shape = this.getSelectedItem();
            
            if(!(shape instanceof MyLine)) return;
            
            myLine = (MyLine) shape;
        }
        
        setSelectedItem(myLine);
        
        highlightLine.myStartXProperty().bind(myLine.myStartXProperty());
        highlightLine.myStartYProperty().bind(myLine.myStartYProperty());
        highlightLine.myEndXProperty().bind(myLine.myEndXProperty());
        highlightLine.myEndYProperty().bind(myLine.myEndYProperty());
        
        highlightLine.mySetFill(Color.TRANSPARENT);
        highlightLine.mySetStroke(Color.BLACK);
        
        highlightLine.mySetStrokeWidth(myLine.myGetStrokeWidth()+2);
        
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
        if(selectedProperty()) this.unSelect();
        
        MyEllipse highlightEllipse = new MyEnhancedEllipse();
        
        if(myEllipse.myGetFill() == Color.TRANSPARENT){
            MyShape shape = this.getSelectedItem();
            
            if(!(shape instanceof MyEllipse)) return;
            
            myEllipse = (MyEllipse) shape;
        }
        
        setSelectedItem(myEllipse);
        
        highlightEllipse.myCenterXProperty().bind(myEllipse.myCenterXProperty());
        highlightEllipse.myCenterYProperty().bind(myEllipse.myCenterYProperty());
        highlightEllipse.myRadiusXProperty().bind(myEllipse.myRadiusXProperty());
        highlightEllipse.myRadiusYProperty().bind(myEllipse.myRadiusYProperty());
        
        highlightEllipse.mySetFill(Color.TRANSPARENT);
        highlightEllipse.mySetStroke(Color.BLACK);
        
        highlightEllipse.mySetStrokeWidth(myEllipse.myGetStrokeWidth()+2);
        
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
        if(!selectedProperty()) return;
        
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
     * @return the BooleanProperty that explain if a figure is selected
     */
    public Boolean selectedProperty(){
        return getSelected().get();
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
