/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.scene.paint.Color;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author prisc
 */
public class ChangeColorCommandTest {
    
    @Test
    public void testSetOldColor(){
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.RED);
        ChangeColorCommand ccc = new ChangeFillColorCommand(myRectangle, Color.BLUEVIOLET);
        ccc.setOldColor(Color.YELLOW);
        Color oldColor = ccc.getOldColor();
        assertEquals(oldColor.toString(), Color.YELLOW.toString());
    }
    
    @Test
    public void testSetNewColor(){
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.RED);
        ChangeColorCommand ccc = new ChangeFillColorCommand(myRectangle, Color.BLUEVIOLET);
        ccc.setNewColor(Color.YELLOW);
        Color newColor = ccc.getNewColor();
        assertEquals(newColor.toString(), Color.YELLOW.toString());
    }
    
    @Test
    public void testSetMyShape(){
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.RED);
        ChangeColorCommand ccc = new ChangeFillColorCommand(myRectangle, Color.BLUEVIOLET);
        MyShape myLine = new MyEnhancedLine();
        ccc.setMyShape(myLine);
        MyShape testShape = ccc.getMyShape();
        assertEquals(testShape.toString(), myLine.toString());
    }
    
    @Test (expected = NullPointerException.class)
    public void testChangeFillColorCommandNullShape(){
        MyShape myShape = null;
        ChangeColorCommand ccc = new ChangeFillColorCommand(myShape, Color.BLUEVIOLET);
    }
    
    @Test (expected = NullPointerException.class)
    public void testChangeFillColorCommandNullColor(){
        MyShape myRectangle = new MyEnhancedRectangle();
        ChangeColorCommand ccc = new ChangeFillColorCommand(myRectangle, null);
    }
    
    @Test (expected = NullPointerException.class)
    public void testChangeStrokeColorCommandNullShape(){
        MyShape myShape = null;
        ChangeColorCommand ccc = new ChangeStrokeColorCommand(myShape, Color.BLUEVIOLET);
    }
    
    @Test (expected = NullPointerException.class)
    public void testChangeStrokeColorCommandNullColor(){
        MyShape myRectangle = new MyEnhancedRectangle();
        ChangeColorCommand ccc = new ChangeStrokeColorCommand(myRectangle, null);
    }
    
    @Test
    public void testGetOldColor(){
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.RED);
        ChangeColorCommand ccc = new ChangeFillColorCommand(myRectangle, Color.BLUEVIOLET);
        Color oldColor = ccc.getOldColor();
        assertEquals(oldColor.toString(),Color.RED.toString());
    }
    
    @Test
    public void testGetNewColor(){
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.RED);
        ChangeColorCommand ccc = new ChangeFillColorCommand(myRectangle, Color.BLUEVIOLET);
        Color oldColor = ccc.getNewColor();
        assertEquals(oldColor.toString(),Color.BLUEVIOLET.toString());
    }
    
    @Test
    public void testGetMyShape(){
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.RED);
        ChangeColorCommand ccc = new ChangeFillColorCommand(myRectangle, Color.BLUEVIOLET);
        MyShape testShape = ccc.getMyShape();
        assertEquals(testShape.toString(), myRectangle.toString());
    }
    
    @Test
    public void testChangeFillColor1(){
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.RED);
        
        ChangeColorCommand ccc = new ChangeFillColorCommand(myRectangle, Color.BLUEVIOLET);
        ccc.changeColor(ccc.getNewColor()); 
        assertEquals("Fill color is not changed correctly!",myRectangle.myGetFill().toString(), Color.BLUEVIOLET.toString());
    }
    
    @Test
    public void testChangeFillColor2(){
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.RED);
        
        ChangeColorCommand ccc = new ChangeFillColorCommand(myRectangle, Color.BLUEVIOLET);
        ccc.execute(); 
        assertEquals("Fill color is not changed correctly!",myRectangle.myGetFill().toString(), Color.BLUEVIOLET.toString());
    }
    
    @Test
    public void testChangeFillColorUndo(){
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.RED);
        
        ChangeColorCommand ccc = new ChangeFillColorCommand(myRectangle, Color.BLUEVIOLET);
        ccc.execute(); 
        assertEquals("Fill color is not changed correctly!",myRectangle.myGetFill().toString(), Color.BLUEVIOLET.toString());
        
        ccc.undo();
        assertEquals("Fill color is not reverted correctly!",myRectangle.myGetFill().toString(), Color.RED.toString());
    }
    
    @Test
    public void testChangeFillColorUndo2(){
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetFill(Color.ANTIQUEWHITE);
        
        ChangeColorCommand ccc = new ChangeFillColorCommand(myRectangle, Color.BLUEVIOLET);
        ccc.execute(); 
        ChangeColorCommand ccc2 = new ChangeFillColorCommand(myRectangle, Color.BROWN);
        ccc2.execute(); 
        
        ccc2.undo();
        assertEquals("Fill color is not reverted correctly!",myRectangle.myGetFill().toString(), Color.BLUEVIOLET.toString());
    }
    
    @Test
    public void testChangeStrokeColor1(){
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetStroke(Color.RED);
        
        ChangeColorCommand ccc = new ChangeStrokeColorCommand(myRectangle, Color.BLACK);
        ccc.changeColor(ccc.getNewColor()); 
        assertEquals("Stroke color is not changed correctly!",myRectangle.myGetStroke().toString(), Color.BLACK.toString());
    }
       
    @Test
    public void testChangeStrokeColor2(){
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetStroke(Color.RED);
        
        ChangeColorCommand ccc = new ChangeStrokeColorCommand(myRectangle, Color.BLUEVIOLET);
        ccc.execute(); 
        assertEquals("Stroke color is not changed correctly!",myRectangle.myGetStroke().toString(), Color.BLUEVIOLET.toString());
    }
    
    @Test
    public void testChangeStrokeColorUndo(){
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetStroke(Color.RED);
        
        ChangeColorCommand ccc = new ChangeStrokeColorCommand(myRectangle, Color.BLUEVIOLET);
        ccc.execute(); 
        assertEquals("Stroke color is not changed correctly!",myRectangle.myGetStroke().toString(), Color.BLUEVIOLET.toString());
    
        ccc.undo();
        assertEquals("Stroke color is not reverted correctly!",myRectangle.myGetStroke().toString(), Color.RED.toString());
    }
    
    @Test
    public void testChangeStrokeColorUndo2(){
        MyShape myRectangle = new MyEnhancedRectangle();
        myRectangle.mySetStroke(Color.ANTIQUEWHITE);
        
        ChangeColorCommand ccc = new ChangeStrokeColorCommand(myRectangle, Color.BLUEVIOLET);
        ccc.execute(); 
        ChangeColorCommand ccc2 = new ChangeStrokeColorCommand(myRectangle, Color.BROWN);
        ccc2.execute(); 
        
        ccc2.undo();
        assertEquals("Stroke color is not reverted correctly!",myRectangle.myGetStroke().toString(), Color.BLUEVIOLET.toString());
    }
    
}