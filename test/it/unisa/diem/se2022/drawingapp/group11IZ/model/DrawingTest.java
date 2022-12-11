/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.model;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.exception.AddedDuplicateException;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.exception.ShapeNotFoundException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

/**
 *
 * @author saram
 */
public class DrawingTest {
    /*test of methods in Drawing*/
    
    @Test
    public void testAdd1() throws NoSuchFieldException, IllegalAccessException, Exception{
        Drawing d=new Drawing();
        //test add ellipse
        MyEnhancedEllipse ellipse=new MyEnhancedEllipse();
        d.addShape(ellipse);
        MyEnhancedRectangle rectangle=new MyEnhancedRectangle();
        d.addShape(rectangle);
        MyEnhancedLine line=new MyEnhancedLine();
        d.addShape(line);
        
        Iterator<MyShape> iter=d.iterator();
        
        //check if ellipse is in figures. If ellipse is in figures, add went well, else throws exception.
        assertEquals("Ellipse is not in figures",iter.next(),ellipse);
        
        //check if rectangle is in figures. If rectangle is in figures, add went well, else throws exception.
        assertEquals("Rectangle is not in figures",iter.next(),rectangle);
        
        //check if line is in figures. If line is in figures, add went well, else throws exception.
        assertEquals("Line is not in figures",iter.next(),line);
      
    } 
    
    @Test (expected=AddedDuplicateException.class)
    public void testAdd2() throws NoSuchFieldException, IllegalAccessException, Exception{
        Drawing d=new Drawing();
        //insert line
        MyEnhancedLine line=new MyEnhancedLine();
        d.addShape(line);
        //insert line again
        d.addShape(line);
        
    }
    
    
    @Test (expected=ShapeNotFoundException.class)
    public void testRemove1() throws NoSuchFieldException, IllegalAccessException, Exception{
        Drawing d=new Drawing();
        //try to delete an line that is not in the list
        MyEnhancedLine line=new MyEnhancedLine();
        d.removeShape(line);
        
    }
    
    @Test (expected=ShapeNotFoundException.class)
    public void testRemove2() throws NoSuchFieldException, IllegalAccessException, Exception{
        Drawing d=new Drawing();
        //try to delete an rectangle that is not in the list
        MyEnhancedRectangle rectangle=new MyEnhancedRectangle();
        d.removeShape(rectangle);
        
    }
 
    @Test (expected=ShapeNotFoundException.class)
    public void testRemove3() throws NoSuchFieldException, IllegalAccessException, Exception{
        Drawing d=new Drawing();
        //try to delete an ellipse that is not in the list
        MyEnhancedEllipse ellipse=new MyEnhancedEllipse();
        d.removeShape(ellipse);        
    }
    
    @Test 
    public void testRemove4() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        //add element and after delete it
        
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
        Iterator<MyShape> iter=d.iterator();
        
        //check if ellipse is delete from figures
        MyEnhancedLine l=(MyEnhancedLine) iter.next();
        assertNotEquals("Ellipse is not delete from figures",l,ellipse);
        //check if in pos0 i have line and in pos1 i have rectangle
        assertEquals("Error in remove",l.myGetId(), line.getId());  
        assertEquals("Error in remove",iter.next(), rectangle);  
        
    }
    @Test
    public void testMoveToForeground() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
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
        Iterator<MyShape> iter=d.iterator();
        //check if ellipse is in last positiona and if first position is not null (test switch)
        assertEquals("Error in remove",iter.next(), line);  
        assertEquals("Error in remove",iter.next(), rectangle);  
        assertEquals("Error in remove",iter.next(), ellipse2);  
        assertEquals("Error in remove",iter.next(), line2);  
        assertEquals("Error in remove",iter.next(), rectangle2);  
        assertEquals("Error in remove",iter.next(), ellipse);  
        
        
        //move rectangle in last position
        d.moveToForeground(rectangle);
        Iterator<MyShape> iter2=d.iterator();
        assertEquals("Error in remove",iter2.next(), line);   
        assertEquals("Error in remove",iter2.next(), ellipse2);  
        assertEquals("Error in remove",iter2.next(), line2);  
        assertEquals("Error in remove",iter2.next(), rectangle2);  
        assertEquals("Error in remove",iter2.next(), ellipse);  
        assertEquals("Error in remove",iter2.next(),rectangle);
       
    }
    
    @Test
    public void testMoveToBackground() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
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
        Iterator<MyShape> iter=d.iterator();
        //check if in pos 0 i have rectangle2 and in pos1 i have ellipse
        assertEquals("Error in remove",iter.next(), rectangle2);  
        assertEquals("Error in remove",iter.next(), ellipse);  
        assertEquals("Error in remove",iter.next(), line);  
        assertEquals("Error in remove",iter.next(), rectangle);  
        assertEquals("Error in remove",iter.next(), ellipse2);  
        assertEquals("Error in remove",iter.next(), line2);  
        
        //line2 goes in pos0
        d.moveToBackground(line2);
        Iterator<MyShape> iter2=d.iterator();
        assertEquals("Error in remove",iter2.next(), line2);  
        assertEquals("Error in remove",iter2.next(), rectangle2);  
        assertEquals("Error in remove",iter2.next(), ellipse);  
        assertEquals("Error in remove",iter2.next(), line);  
        assertEquals("Error in remove",iter2.next(), rectangle);  
        assertEquals("Error in remove",iter2.next(), ellipse2);  
        
    } 
}
