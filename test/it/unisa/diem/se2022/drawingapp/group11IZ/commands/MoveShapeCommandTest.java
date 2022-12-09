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
import it.unisa.diem.se2022.drawingapp.group11IZ.selection.Selection;
import java.lang.reflect.Field;
import javafx.scene.layout.Pane;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author daddy
 */
public class MoveShapeCommandTest {
    private MyShape shape;
    private Selection selection;
    private Pane pane;
    private MyEnhancedLine myEnhancedLine;
    private MyEnhancedRectangle myEnhancedRectangle;
    private MyEnhancedEllipse myEnhancedEllipse;
    private MoveShapeCommand msc;
    private Field oldXField, oldYField, newXField, newYField, selectedItemField;

    @Before
    public void setUp() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
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
        
        
        shape = (MyShape) selectedItemField.get(selection);
    }

    @Test
    public void initializeMoveShapeCommandTest() throws IllegalArgumentException, IllegalAccessException {

        double diffX = shape.myGetLayoutBounds().getMaxX() - shape.myGetLayoutBounds().getMinX();
        double diffY = shape.myGetLayoutBounds().getMaxY() - shape.myGetLayoutBounds().getMinY();

        Assert.assertEquals("If oldX is equal to selectedShape minX coordinate", oldXField.get(msc), shape.myGetLayoutBounds().getMinX() + diffX / 2);
        Assert.assertEquals("If oldY is equal to selectedShape minY coordinate", oldYField.get(msc), shape.myGetLayoutBounds().getMinY() + diffY / 2);
    }

    @Test
    public void executeMoveShapeTest() throws IllegalArgumentException, IllegalAccessException {
        double x = 50.0;
        double y = 50.0;
        msc.setNewCoordinates(x, y);

        Assert.assertEquals("If oldX is equal to setted coordinates", x, newXField.get(msc));
        Assert.assertEquals("If oldY is equal to setted coordinates", y, newYField.get(msc));

        msc.execute();
        
        double diffX = shape.myGetLayoutBounds().getMaxX() - shape.myGetLayoutBounds().getMinX();
        double diffY = shape.myGetLayoutBounds().getMaxY() - shape.myGetLayoutBounds().getMinY();
        
        Assert.assertTrue("If correctly moved", x == (shape.myGetLayoutBounds().getMinX() + diffX / 2));
        Assert.assertTrue("If correctly moved", y == (shape.myGetLayoutBounds().getMinY() + diffY / 2));
    }

    @Test
    public void undoMoveShapeTest() throws IllegalArgumentException, IllegalAccessException {
        double x = 50.0;
        double y = 50.0;
        msc.setNewCoordinates(x, y);

        msc.execute();

        msc.undo();
        
        double diffX = shape.myGetLayoutBounds().getMaxX() - shape.myGetLayoutBounds().getMinX();
        double diffY = shape.myGetLayoutBounds().getMaxY() - shape.myGetLayoutBounds().getMinY();
        
        Assert.assertFalse("If correctly done the undo", x == (shape.myGetLayoutBounds().getMinX() + diffX / 2));
        Assert.assertFalse("If correctly done the undo", y == (shape.myGetLayoutBounds().getMinY() + diffY / 2));
        
        Assert.assertTrue("If coordinates are correct", ((double)oldXField.get(msc)) == (shape.myGetLayoutBounds().getMinX() + diffX / 2));
        Assert.assertTrue("If coordinates are correct", ((double)oldYField.get(msc)) == (shape.myGetLayoutBounds().getMinY() + diffY / 2));
    }

}
