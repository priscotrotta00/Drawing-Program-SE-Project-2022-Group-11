/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.Selection;
import java.lang.reflect.Field;
import javafx.beans.property.BooleanProperty;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author daddy
 */
public class MoveShapeCommandTest {
    
    private Selection selection;
    private Pane pane;
    private MyEnhancedLine myEnhancedLine;
    private MyEnhancedRectangle myEnhancedRectangle;
    private MyEnhancedEllipse myEnhancedEllipse;
    private MoveShapeCommand msc;
    private Field oldXField, oldYField, newXField, newYField, selectedItemField;
    
    @Before
    public void setUp() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException{
        selection = Selection.getInstance();
        pane = new Pane();
        myEnhancedRectangle = new MyEnhancedRectangle();
        
        myEnhancedRectangle.mySetX(10);
        myEnhancedRectangle.mySetY(10);
        myEnhancedRectangle.mySetWidth(20);
        myEnhancedRectangle.mySetHeight(10);
        
        pane.getChildren().add(myEnhancedRectangle);
        
        selection.select(myEnhancedRectangle);
        
        msc = new MoveShapeCommand(myEnhancedRectangle);
        
        oldXField = MoveShapeCommand.class.getDeclaredField("oldX");
        oldYField = MoveShapeCommand.class.getDeclaredField("oldY");
        newXField = MoveShapeCommand.class.getDeclaredField("newX");
        newYField = MoveShapeCommand.class.getDeclaredField("newY");
        selectedItemField = Selection.class.getDeclaredField("selectedItem");
        
        oldXField.setAccessible(true);
        oldYField.setAccessible(true);
        newXField.setAccessible(true);
        newYField.setAccessible(true);
        selectedItemField.setAccessible(true);
    }
    
    @Test
    public void initializeMoveShapeCommandTest() throws IllegalArgumentException, IllegalAccessException{
        Assert.assertEquals("If oldX is 0.0", oldXField.get(msc), 0.0);
        Assert.assertEquals("If oldX is 0.0", oldYField.get(msc), 0.0);
        
        MyShape shape = (MyShape)selectedItemField.get(selection);
        Assert.assertEquals("If newX is equal to selectedShape minX coordinate", newXField.get(msc), shape.myGetLayoutBounds().getMinX());
        Assert.assertEquals("If newY is equal to selectedShape minY coordinate", newYField.get(msc), shape.myGetLayoutBounds().getMinY());
    }
    
    @Test
    public void moveShapeTest() throws IllegalArgumentException, IllegalAccessException{
        double x = (Double)newXField.get(msc);
        double y = (Double)newYField.get(msc);
        
        MyShape shape = (MyShape)selectedItemField.get(selection);
        shape.moveShape(50.0, 50.0);
        
        msc.execute();
        
        Assert.assertEquals("If oldX is equal to the old value of newX",oldXField.get(msc), x);
        Assert.assertEquals("If oldY is equal to the old value of newY",oldYField.get(msc), y);
        Assert.assertEquals("If newX is equal to the new top-left X coordinate of the shape",newXField.get(msc), shape.myGetLayoutBounds().getMinX());
        Assert.assertEquals("If newY is equal to the new top-left Y coordinate of the shape",newYField.get(msc), shape.myGetLayoutBounds().getMinY());
        
    }
    
}
