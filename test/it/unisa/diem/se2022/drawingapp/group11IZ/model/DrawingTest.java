/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import java.lang.Exception;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 *
 * @author saram
 */
public class DrawingTest {
    /*test of methods in Drawing*/
    
    @Test
    public void testAdd1() throws NoSuchFieldException, IllegalAccessException, Exception{
        System.out.println("add");
        
        Field listField = Drawing.class.getDeclaredField("figures");
        listField.setAccessible(true);
        Drawing d=new Drawing();
        List<MyShape> figures = (List<MyShape>)listField.get(d);
        
        //test add ellipse
        MyEnhancedEllipse ellipse=new MyEnhancedEllipse();
        d.addShape(ellipse);
        //check if ellipse is in figures. If ellipse is in figures, add went well, else throws exception.
        assertTrue("Ellipse is not in figures",figures.contains(ellipse));
        
        //test add rectangle
        MyEnhancedRectangle rectangle=new MyEnhancedRectangle();
        d.addShape(rectangle);
        //check if rectangle is in figures. If rectangle is in figures, add went well, else throws exception.
        assertTrue("Rectangle is not in figures",figures.contains(rectangle));
        
        
        //test add line
        MyEnhancedLine line=new MyEnhancedLine();
        d.addShape(line);
        //check if line is in figures. If line is in figures, add went well, else throws exception.
        assertTrue("Line is not in figures",figures.contains(line));
      
    } 
    
    @Test (expected=Exception.class)
    public void testAdd2() throws NoSuchFieldException, IllegalAccessException, Exception{
        System.out.println("add");
        
        Field listField = Drawing.class.getDeclaredField("figures");
        listField.setAccessible(true);
        Drawing d=new Drawing();
        List<MyShape> figures = (List<MyShape>)listField.get(d);
        
        //insert line
        MyEnhancedLine line=new MyEnhancedLine();
        d.addShape(line);
        //insert line again
        d.addShape(line);
        
    }
    
    
    @Test (expected=Exception.class)
    public void testRemove1() throws NoSuchFieldException, IllegalAccessException, Exception{
        System.out.println("remove");
        
        Field listField = Drawing.class.getDeclaredField("figures");
        listField.setAccessible(true);
        Drawing d=new Drawing();
        List<MyShape> figures = (List<MyShape>)listField.get(d);
        
        //try to delete an line that is not in the list
        MyEnhancedLine line=new MyEnhancedLine();
        d.removeShape(line);
        
    }
    
    @Test (expected=Exception.class)
    public void testRemove2() throws NoSuchFieldException, IllegalAccessException, Exception{
        System.out.println("remove");
        
        Field listField = Drawing.class.getDeclaredField("figures");
        listField.setAccessible(true);
        Drawing d=new Drawing();
        List<MyShape> figures = (List<MyShape>)listField.get(d);
        
        //try to delete an rectangle that is not in the list
        MyEnhancedRectangle rectangle=new MyEnhancedRectangle();
        d.removeShape(rectangle);
        
    }
 
    @Test (expected=Exception.class)
    public void testRemove3() throws NoSuchFieldException, IllegalAccessException, Exception{
        System.out.println("remove");
        
        Field listField = Drawing.class.getDeclaredField("figures");
        listField.setAccessible(true);
        Drawing d=new Drawing();
        List<MyShape> figures = (List<MyShape>)listField.get(d);
        
        //try to delete an ellipse that is not in the list
        MyEnhancedEllipse ellipse=new MyEnhancedEllipse();
        d.removeShape(ellipse);        
    }
    
    @Test 
    public void testRemove4() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, Exception{
        //add element and after delete it
        System.out.println("remove");
        
        Field listField = Drawing.class.getDeclaredField("figures");
        listField.setAccessible(true);
        Drawing d=new Drawing();
        List<MyShape> figures = (List<MyShape>)listField.get(d);
        
        //add
        MyEnhancedEllipse ellipse=new MyEnhancedEllipse();
        MyEnhancedRectangle rectangle=new MyEnhancedRectangle();
        MyEnhancedLine line=new MyEnhancedLine();
        d.addShape(ellipse);
        d.addShape(line);
        d.addShape(rectangle);
        
        //test remove ellipse
        d.removeShape(ellipse);
        //check if ellipse is delete from figures
        assertFalse("Ellipse is not delete from figures",figures.contains(ellipse));
        //check if in pos0 i have line and in pos1 i have rectangle
        MyShape shapeFirstPos=figures.get(0);
        assertEquals("Error in remove",shapeFirstPos.myGetId(), line.getId());  
        MyShape shape1Pos=figures.get(1);
        assertEquals("Error in remove",shape1Pos.myGetId(), rectangle.getId());  
        
        
        //test remove rectangle
        d.removeShape(rectangle);
        //check if rectangle is delete from figures
        assertFalse("Rectangle is not delete from figures",figures.contains(rectangle));
        
        
        //test remove line
        d.removeShape(line);
        //check if line is delete from figures
        assertFalse("Line is not delete from figures",figures.contains(line));
        
    }
    @Test
    public void testMoveToForeground() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, Exception{
        System.out.println("move to foreground");
        
        Field listField = Drawing.class.getDeclaredField("figures");
        listField.setAccessible(true);
        Drawing d=new Drawing();
        List<MyShape> figures = (List<MyShape>)listField.get(d);
        
        MyEnhancedEllipse ellipse=new MyEnhancedEllipse();
        MyEnhancedRectangle rectangle=new MyEnhancedRectangle();
        MyEnhancedLine line=new MyEnhancedLine();
        MyEnhancedEllipse ellipse2=new MyEnhancedEllipse();
        MyEnhancedRectangle rectangle2=new MyEnhancedRectangle();
        MyEnhancedLine line2=new MyEnhancedLine();
        d.addShape(ellipse);//0
        d.addShape(line);//1
        d.addShape(rectangle);//2
        d.addShape(ellipse2);//3
        d.addShape(line2);//4
        d.addShape(rectangle2);//5
        
        //move first shape in last position
        d.moveToForeground(ellipse);
        //check if ellipse is in last positiona and if first position is not null (test switch)
        MyShape shapeLastPos=figures.get(figures.size()-1);
        //check in shapeLastPos==ellipse
        assertEquals("Error in moveToForeground",shapeLastPos.myGetId(), ellipse.getId());
        
        //check if in pos 0 i have line
        MyShape shapeFirstPos=figures.get(0);
        assertEquals("Error in moveToForeground",shapeFirstPos.myGetId(), line.getId());  
    
        //move rectangle in last position
        d.moveToForeground(rectangle);
        shapeLastPos=figures.get(figures.size()-1);
        assertEquals("Error in moveToForeground",shapeLastPos.myGetId(), rectangle.getId());
        MyShape shapePos2=figures.get(2);
        assertEquals("Error in moveToForeground",shapePos2.myGetId(), ellipse2.getId());  

    }
    
    @Test
    public void testMoveToBackground() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, Exception{
        System.out.println("move to background");
        
        Field listField = Drawing.class.getDeclaredField("figures");
        listField.setAccessible(true);
        Drawing d=new Drawing();
        List<MyShape> figures = (List<MyShape>)listField.get(d);
        
        MyEnhancedEllipse ellipse=new MyEnhancedEllipse();
        MyEnhancedRectangle rectangle=new MyEnhancedRectangle();
        MyEnhancedLine line=new MyEnhancedLine();
        MyEnhancedEllipse ellipse2=new MyEnhancedEllipse();
        MyEnhancedRectangle rectangle2=new MyEnhancedRectangle();
        MyEnhancedLine line2=new MyEnhancedLine();
        d.addShape(ellipse);//0
        d.addShape(line);//1
        d.addShape(rectangle);//2
        d.addShape(ellipse2);//3
        d.addShape(line2);//4
        d.addShape(rectangle2);//5
        
        //r4ectangle2 goes in pos 0
        d.moveToBackground(rectangle2);
        //check if in pos 0 i have rectangle2 and in pos1 i have ellipse
        MyShape shapeFirstPos=figures.get(0);
        assertEquals("Error in moveToBackground",shapeFirstPos.myGetId(), rectangle2.getId());  
        MyShape shape1Pos=figures.get(1);
        assertEquals("Error in moveToBackground",shape1Pos.myGetId(), ellipse.getId());  
        
        //line2 goes in pos0
        d.moveToBackground(line2);
        shapeFirstPos=figures.get(0);
        assertEquals("Error in moveToBackground",shapeFirstPos.myGetId(), line2.getId());  
        //check if rectangle2 is in pos1
        shape1Pos=figures.get(1);
        assertEquals("Error in moveToBackground",shape1Pos.myGetId(), rectangle2.getId());  
        
    }
    
    @Test
    public void testExportEmptyDrawing(){
        Drawing draw = new Drawing();
        File file = new File("test.json");
        draw.exportDrawing(file);
        String JSONFileString = new String();
               
        try(Scanner in = new Scanner(file)){
            JSONFileString = in.nextLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DrawingTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String myString = "[]";
        assertEquals("Failed with an empty drawing",myString, JSONFileString);
    }
    
    @Test 
    public void testExportDrawing() throws Exception{
        File file = new File("test2.json");
        Drawing draw = new Drawing();
        
        MyShape line = new MyEnhancedLine();
        draw.addShape(line);

        MyShape rectangle = new MyEnhancedRectangle();
        draw.addShape(rectangle);

        MyShape ellipse = new MyEnhancedEllipse();
        draw.addShape(ellipse);

        draw.exportDrawing(file);
        
        String JSONFileString = new String();
               
        try(Scanner in = new Scanner(file)){
            JSONFileString = in.nextLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DrawingTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String myString = "[{\"endY\":0.0,\"endX\":0.0,\"startY\":0.0,\"startX\":0.0,\"type\":\"line\",\"fill\":null,\"stroke\":\"0x000000ff\"},"
                + "{\"width\":0.0,\"x\":0.0,\"y\":0.0,\"type\":\"rectangle\",\"fill\":\"0x000000ff\",\"stroke\":null,\"height\":0.0},"
                + "{\"centerY\":0.0,\"centerX\":0.0,\"radiusY\":0.0,\"radiusX\":0.0,\"type\":\"ellipse\",\"fill\":\"0x000000ff\",\"stroke\":null}]";
        assertEquals("Failed export drawing",myString, JSONFileString);
    }
    
    @Test (expected = NullPointerException.class)
    public void testExportDrawingToNullFile(){
        Drawing draw = new Drawing();
        File file = null;
        draw.exportDrawing(file);
    }
    
    @Test 
    public void testImportEmptyDrawing() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, ParseException, Exception{
        Drawing draw = new Drawing();
        File file = new File("test3.json");
        draw.exportDrawing(file);
        Drawing loadedDrawing = Drawing.importDrawing(file);
        Field listField = Drawing.class.getDeclaredField("figures");
        listField.setAccessible(true);
        List<MyShape> figures = (List<MyShape>)listField.get(loadedDrawing);
        assertTrue("An empty drawing contains elements",figures.isEmpty());
    }
    
    @Test 
    public void testImportDrawing() throws Exception{
        File file = new File("test4.json");
        Drawing draw = new Drawing();
        
        MyShape line = new MyEnhancedLine();
        draw.addShape(line);

        MyShape rectangle = new MyEnhancedRectangle();
        draw.addShape(rectangle);

        MyShape ellipse = new MyEnhancedEllipse();
        draw.addShape(ellipse);

        draw.exportDrawing(file);
        Drawing loadedDrawing = Drawing.importDrawing(file);
        Field listField = Drawing.class.getDeclaredField("figures");
        listField.setAccessible(true);
        List<MyShape> figures = (List<MyShape>)listField.get(loadedDrawing);
        assertEquals("The Drawing doesn't contain all the figures stored in the file",figures.get(0).toString(),line.toString());
        assertEquals("The Drawing doesn't contain all the figures stored in the file",figures.get(1).toString(),rectangle.toString());
        assertEquals("The Drawing doesn't contain all the figures stored in the file",figures.get(2).toString(),ellipse.toString());
    }
    
    @Test (expected = NullPointerException.class)
    public void testImportDrawingFromNullFile() throws ParseException, Exception{
        File file = null;
        Drawing loadedDrawing = Drawing.importDrawing(file);
    }
    
}
