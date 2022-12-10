/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.Canvas;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import java.lang.reflect.Field;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

/**
 *
 * @author prisc
 */
public class ChangeColorCommandTest {
    private Canvas canvas;
    private Field drawField;
    private Field drawPaneField;
    private Pane pane;
    private Drawing draw;

    @Before
    public void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        this.canvas = new Canvas();
        this.pane = new Pane();

        drawPaneField = Canvas.class.getDeclaredField("drawPane");
        drawField = Canvas.class.getDeclaredField("draw");
        
        drawPaneField.setAccessible(true);
        drawField.setAccessible(true);
        
        drawPaneField.set(canvas, pane);
        canvas.initialize(null, null);
        draw = canvas.getDraw();
        
    }
    
    /*@Test
    public void testSetOldColor() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.RED);
        ChangeColorCommand ccc = new ChangeFillColorCommand(myRectangle, Color.BLUEVIOLET);
        ccc.setOldColor(Color.YELLOW);
        Field oldColorField = ChangeColorCommand.class.getDeclaredField("oldColor");
        oldColorField.setAccessible(true);
        assertEquals("Error in setOldColor", oldColorField.get(ccc).toString(), Color.YELLOW.toString());
    }*/
    
    @Test
    public void testSetNewColor() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.RED);
        ChangeColorCommand ccc = new ChangeFillColorCommand(canvas, myRectangle, Color.BLUEVIOLET);
        ccc.setNewColor(Color.YELLOW);
        Field newColorField = ChangeColorCommand.class.getDeclaredField("newColor");
        newColorField.setAccessible(true);
        assertEquals("Error in setOldColor", Color.YELLOW.toString(), newColorField.get(ccc).toString());
    }
    
    @Test
    public void testSetMyShape() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.RED);
        ChangeColorCommand ccc = new ChangeFillColorCommand(canvas, myRectangle, Color.BLUEVIOLET);
        MyShape myLine = new MyEnhancedLine();
        ccc.setMyShape(myLine);
        Field myShapeField = ChangeColorCommand.class.getDeclaredField("myShape");
        myShapeField.setAccessible(true);
        assertEquals("Error in setOldColor", myLine.toString(), myShapeField.get(ccc).toString());
    }
    
    @Test (expected = NullPointerException.class)   //Test with a null object Shape
    public void testChangeFillColorCommandNullShape(){
        MyShape myShape = null;
        ChangeColorCommand ccc = new ChangeFillColorCommand(canvas, myShape, Color.BLUEVIOLET);
    }
    
    @Test (expected = NullPointerException.class)   //Test with a null object Fill Color
    public void testChangeFillColorCommandNullColor(){
        MyShape myRectangle = new MyEnhancedRectangle();
        ChangeColorCommand ccc = new ChangeFillColorCommand(canvas, myRectangle, null);
    }
    
    @Test (expected = NullPointerException.class)   //Test with a null object Shape
    public void testChangeStrokeColorCommandNullShape(){
        MyShape myShape = null;
        ChangeColorCommand ccc = new ChangeStrokeColorCommand(canvas, myShape, Color.BLUEVIOLET);
    }
    
    @Test (expected = NullPointerException.class)   //Test with a null object Stroke Color
    public void testChangeStrokeColorCommandNullColor(){
        MyShape myRectangle = new MyEnhancedRectangle();
        ChangeColorCommand ccc = new ChangeStrokeColorCommand(canvas, myRectangle, null);
    }
    
    /*@Test
    public void testGetOldColor(){
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.RED);
        ChangeColorCommand ccc = new ChangeFillColorCommand(myRectangle, Color.BLUEVIOLET);
        Color oldColor = ccc.getOldColor();
        assertEquals("Error in getOldColor", oldColor.toString(),Color.RED.toString());
    }*/
    
    @Test
    public void testGetNewColor(){
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.RED);
        ChangeColorCommand ccc = new ChangeFillColorCommand(canvas, myRectangle, Color.BLUEVIOLET);
        Color oldColor = ccc.getNewColor();
        assertEquals("Error in getNewColor", Color.BLUEVIOLET.toString(), oldColor.toString());
    }
    
    @Test
    public void testGetMyShape(){
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.RED);
        ChangeColorCommand ccc = new ChangeFillColorCommand(canvas, myRectangle, Color.BLUEVIOLET);
        MyShape testShape = ccc.getMyShape();
        assertEquals("Error in getMyShape", myRectangle.toString(), testShape.toString());
    }
    
    @Test
    public void testChangeFillColor1(){ //Create a new shape and I change its fill color with changeColor method
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.RED);
        
        ChangeColorCommand ccc = new ChangeFillColorCommand(canvas, myRectangle, Color.BLUEVIOLET);
        ccc.changeColor(ccc.getNewColor()); 
        assertEquals("Fill color is not changed correctly!", Color.BLUEVIOLET.toString(), myRectangle.myGetFill().toString());
    }
    
    @Test
    public void testChangeFillColor2(){ //Create a new shape and I change its fill color with execute method
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.RED);
        
        ChangeColorCommand ccc = new ChangeFillColorCommand(canvas, myRectangle, Color.BLUEVIOLET);
        ccc.execute(); 
        assertEquals("Fill color is not changed correctly!", Color.BLUEVIOLET.toString(), myRectangle.myGetFill().toString());
    }
    
    @Test
    public void testChangeFillColorUndo(){  //Create a new shape and I change its fill color and I try to undo the operation
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.RED);
        
        ChangeColorCommand ccc = new ChangeFillColorCommand(canvas, myRectangle, Color.BLUEVIOLET);
        ccc.execute(); 
        assertEquals("Fill color is not changed correctly!", Color.BLUEVIOLET.toString(), myRectangle.myGetFill().toString());
        
        ccc.undo();
        assertEquals("Fill color is not reverted correctly!", Color.RED.toString(), myRectangle.myGetFill().toString());
    }
    
    @Test
    public void testChangeFillColorUndo2(){ //Create a new shape and I change its fill color more times and I try to undo the operation
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.ANTIQUEWHITE);
        
        ChangeColorCommand ccc = new ChangeFillColorCommand(canvas, myRectangle, Color.BLUEVIOLET);
        ccc.execute(); 
        ChangeColorCommand ccc2 = new ChangeFillColorCommand(canvas, myRectangle, Color.BROWN);
        ccc2.execute(); 
        
        ccc2.undo();
        assertEquals("Fill color is not reverted correctly!", Color.BLUEVIOLET.toString(), myRectangle.myGetFill().toString());
    }
    
    @Test
    public void testChangeStrokeColor1(){   //Create a new shape and I change its stroke color with changeColor method
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetStroke(Color.RED);
        
        ChangeColorCommand ccc = new ChangeStrokeColorCommand(canvas, myRectangle, Color.BLACK);
        ccc.changeColor(ccc.getNewColor()); 
        assertEquals("Stroke color is not changed correctly!", Color.BLACK.toString(), myRectangle.myGetStroke().toString());
    }
       
    @Test
    public void testChangeStrokeColor2(){   //Create a new shape and I change its stroke color with execute method
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetStroke(Color.RED);
        
        ChangeColorCommand ccc = new ChangeStrokeColorCommand(canvas, myRectangle, Color.BLUEVIOLET);
        ccc.execute(); 
        assertEquals("Stroke color is not changed correctly!", Color.BLUEVIOLET.toString(), myRectangle.myGetStroke().toString());
    }
    
    @Test
    public void testChangeStrokeColorUndo(){    //Create a new shape and I change its stroke color and I try to undo the operation
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetStroke(Color.RED);
        
        ChangeColorCommand ccc = new ChangeStrokeColorCommand(canvas, myRectangle, Color.BLUEVIOLET);
        ccc.execute(); 
        assertEquals("Stroke color is not changed correctly!", Color.BLUEVIOLET.toString(), myRectangle.myGetStroke().toString());
    
        ccc.undo();
        assertEquals("Stroke color is not reverted correctly!", Color.RED.toString(), myRectangle.myGetStroke().toString());
    }
    
    @Test
    public void testChangeStrokeColorUndo2(){   //Create a new shape and I change its stroke color more times and I try to undo the operation
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetStroke(Color.ANTIQUEWHITE);
        
        ChangeColorCommand ccc = new ChangeStrokeColorCommand(canvas, myRectangle, Color.BLUEVIOLET);
        ccc.execute(); 
        ChangeColorCommand ccc2 = new ChangeStrokeColorCommand(canvas, myRectangle, Color.BROWN);
        ccc2.execute(); 
        
        ccc2.undo();
        assertEquals("Stroke color is not reverted correctly!", Color.BLUEVIOLET.toString(), myRectangle.myGetStroke().toString());
    }
    
}
