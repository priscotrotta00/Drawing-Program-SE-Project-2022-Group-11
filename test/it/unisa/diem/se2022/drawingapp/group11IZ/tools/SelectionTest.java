/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.tools;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.*;
import java.lang.reflect.Field;
import javafx.beans.property.BooleanProperty;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

/**
 *
 * @author daddy
 */
public class SelectionTest {
    
    @Test
    public void selectLineTest() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        
        MyEnhancedLine myEnhancedLine = new MyEnhancedLine();
        Selection selection = new Selection();
        MyEnhancedLine selectedBorderLine;
        
        myEnhancedLine.mySetStartX(10);
        myEnhancedLine.mySetStartY(10);
        myEnhancedLine.mySetEndX(50);
        myEnhancedLine.mySetEndY(10);
        
        selection.select(myEnhancedLine);
        
        Field selectionBorderField = Selection.class.getDeclaredField("selectionBorder");
        Field selectedField = Selection.class.getDeclaredField("selected");
        selectionBorderField.setAccessible(true);
        selectedField.setAccessible(true);
        Group group = (Group) selectionBorderField.get(selection);
        BooleanProperty boolProp = (BooleanProperty) selectedField.get(selection);
        selectedBorderLine = (MyEnhancedLine) group.getChildren().get(0);
        
        Assert.assertNotNull("If selectedBorder is not null", group.getChildren().get(0));        
        Assert.assertEquals("If selectedBorderLine is a myEnhancedLine", selectedBorderLine.getClass(), (new MyEnhancedLine()).getClass());
        Assert.assertEquals("If selectedBorderLine has black stroke", selectedBorderLine.myGetStroke(), Color.BLACK);
        Assert.assertEquals("If selectedBorderLine has transparent fill",selectedBorderLine.myGetFill(), Color.TRANSPARENT);
        Assert.assertTrue("If selectedBorderLine stroke > myEnhancedLine stroke", selectedBorderLine.getStrokeWidth() > myEnhancedLine.getStrokeWidth());
        Assert.assertTrue("If selected property is true", boolProp.get());
        
    }
    
    @Test
    public void selectRectangleTest() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        
        MyEnhancedRectangle myEnhancedRectangle = new MyEnhancedRectangle();
        Selection selection = new Selection();
        MyEnhancedRectangle selectedBorderRectangle;
        
        myEnhancedRectangle.mySetX(10);
        myEnhancedRectangle.mySetY(10);
        myEnhancedRectangle.mySetWidth(20);
        myEnhancedRectangle.mySetHeight(10);
        
        selection.select(myEnhancedRectangle);
        
        Field selectionBorderField = Selection.class.getDeclaredField("selectionBorder");
        Field selectedField = Selection.class.getDeclaredField("selected");
        selectionBorderField.setAccessible(true);
        selectedField.setAccessible(true);
        Group group = (Group) selectionBorderField.get(selection);        
        BooleanProperty boolProp = (BooleanProperty) selectedField.get(selection);
        selectedBorderRectangle = (MyEnhancedRectangle) group.getChildren().get(0);

        
        Assert.assertNotNull("If selectedBorder is not null", group.getChildren().get(0));   
        Assert.assertEquals("If selectedBorderRectangle is a myEnhancedRectangle", selectedBorderRectangle.getClass(), (new MyEnhancedRectangle()).getClass());
        Assert.assertEquals("If selectedBorderRectangle has black stroke", selectedBorderRectangle.myGetStroke(), Color.BLACK);
        Assert.assertEquals("If selectedBorderRectangle has transparent fill",selectedBorderRectangle.myGetFill(), Color.TRANSPARENT);
        Assert.assertTrue("If selectedBorderRectangle stroke > myEnhancedRectangle stroke", selectedBorderRectangle.getStrokeWidth() > myEnhancedRectangle.getStrokeWidth());
        Assert.assertTrue("If selected property is true", boolProp.get());
        
    }
    
    @Test
    public void selectEllipseTest() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        
        MyEnhancedEllipse myEnhancedEllipse = new MyEnhancedEllipse();
        Selection selection = new Selection();
        MyEnhancedEllipse selectedBorderEllipse;
        
        myEnhancedEllipse.mySetCenterX(50);
        myEnhancedEllipse.mySetCenterY(50);
        myEnhancedEllipse.mySetRadiusX(50);
        myEnhancedEllipse.mySetRadiusY(25);
        
        selection.select(myEnhancedEllipse);
        
        Field selectionBorderField = Selection.class.getDeclaredField("selectionBorder");
        Field selectedField = Selection.class.getDeclaredField("selected");
        selectionBorderField.setAccessible(true);
        selectedField.setAccessible(true);
        Group group = (Group) selectionBorderField.get(selection);        
        BooleanProperty boolProp = (BooleanProperty) selectedField.get(selection);        
        selectedBorderEllipse = (MyEnhancedEllipse) group.getChildren().get(0);

        
        Assert.assertNotNull("If selectedBorder is not null", group.getChildren().get(0));
        Assert.assertEquals("If selectedBorderEllipse is a myEnhancedEllipse", selectedBorderEllipse.getClass(), (new MyEnhancedEllipse()).getClass());
        Assert.assertEquals("If selectedBorderEllipse has black stroke", selectedBorderEllipse.myGetStroke(), Color.BLACK);
        Assert.assertEquals("If selectedBorderEllipse has transparent fill",selectedBorderEllipse.myGetFill(), Color.TRANSPARENT);
        Assert.assertTrue("If selectedBorderEllipse stroke > myEnhancedEllipse stroke", selectedBorderEllipse.getStrokeWidth() > myEnhancedEllipse.getStrokeWidth());
        Assert.assertTrue("If selected property is true", boolProp.get());
        
    }
    
    
}
