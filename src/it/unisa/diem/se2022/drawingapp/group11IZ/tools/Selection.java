/**
 * The Class selection implements the selection and unselection of shapes
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.interfaces.Visitor;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.*;
import javafx.beans.property.*;
import javafx.beans.value.ObservableBooleanValue;
import javafx.collections.ObservableList;
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

    /**
     * Class constructor.
     */
    public Selection() {
        this.selectionBorder = new Group();
        this.selectedItem = null;
        this.selected = new SimpleBooleanProperty(false);
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
        if(getSelected().get()) return;
        
        MyRectangle newRectangle = new MyEnhancedRectangle();
        
        setSelectedItem(myRectangle);
        
        newRectangle.myXProperty().bind(myRectangle.myXProperty());
        newRectangle.myYProperty().bind(myRectangle.myYProperty());
        newRectangle.myHeightProperty().bind(myRectangle.myHeightProperty());
        newRectangle.myWidthProperty().bind(myRectangle.myWidthProperty());
        
        newRectangle.mySetFill(Color.TRANSPARENT);
        newRectangle.mySetStroke(Color.BLACK);
        
        newRectangle.mySetStrokeWidth(myRectangle.myGetStrokeWidth()+2);
        
        getSelectionBorder().getChildren().add((Shape)newRectangle);
        
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
        if(getSelected().get()) return;
        
        MyLine newLine = new MyEnhancedLine();;
        
        setSelectedItem(myLine);
        
        newLine.myStartXProperty().bind(myLine.myStartXProperty());
        newLine.myStartYProperty().bind(myLine.myStartYProperty());
        newLine.myEndXProperty().bind(myLine.myEndXProperty());
        newLine.myEndYProperty().bind(myLine.myEndYProperty());
        
        newLine.mySetFill(Color.TRANSPARENT);
        newLine.mySetStroke(Color.BLACK);
        
        newLine.mySetStrokeWidth(myLine.myGetStrokeWidth()+2);
        
        getSelectionBorder().getChildren().add((Shape)newLine);
        
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
        if(getSelected().get()) return;
        
        MyEllipse newEllipse = new MyEnhancedEllipse();
        
        setSelectedItem(myEllipse);
        
        newEllipse.myCenterXProperty().bind(myEllipse.myCenterXProperty());
        newEllipse.myCenterYProperty().bind(myEllipse.myCenterYProperty());
        newEllipse.myRadiusXProperty().bind(myEllipse.myRadiusXProperty());
        newEllipse.myRadiusYProperty().bind(myEllipse.myRadiusYProperty());
        
        newEllipse.mySetFill(Color.TRANSPARENT);
        newEllipse.mySetStroke(Color.BLACK);
        
        newEllipse.mySetStrokeWidth(myEllipse.myGetStrokeWidth()+2);
        
        getSelectionBorder().getChildren().add((Shape)newEllipse);
        
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
        if(!getSelected().get()) return;
        
        Node node = getSelectedItem().myGetParent(); 
        
        if(!(node instanceof Node)) return;
        
        Parent parent = (Parent) node;
        
        if(!(parent instanceof Pane)) return;
       
        Pane pane = (Pane) parent;
        
        Node delShapeFromPane = getSelectionBorder();
        pane.getChildren().removeAll(delShapeFromPane);
        
        setSelectedItem(null);
        setSelected(false);
        setSelectionBorder(new Group());       
    }
    
    /**
     * 
     * @return the BooleanProperty that explain if a figure is selected
     */
    public ObservableBooleanValue selectedProperty(){
        return getSelected();
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
