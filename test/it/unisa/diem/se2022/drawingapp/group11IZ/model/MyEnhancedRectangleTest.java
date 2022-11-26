/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.model;
import javafx.scene.paint.Color;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author saram
 */
public class MyEnhancedRectangleTest {
    @Test
    public void testMyGetHeight(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        assertTrue("Error in myGetHeight", r.myGetHeight()==r.getHeight()); 
    }
    
    @Test
    public void testMyGetWidth(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        assertTrue("Error in myGetWidth", r.myGetWidth()==r.getWidth()); 
    }
    
    @Test
    public void testMyGetX(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        assertTrue("Error in myGetX", r.myGetX()==r.getX()); 
    
    }
    
    @Test
    public void testMyGetX1(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        r.mySetX(5.0);
        //check if get center x!=get center y after modified only center y
        assertFalse("Error in myGetX", r.myGetY()==r.myGetX()); 
    }
    
    @Test
    public void testMyGetY(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        assertTrue("Error in myGetY", r.myGetY()==r.getY()); 
    
    }
    
    @Test
    public void testMyGetY1(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        r.mySetY(5.0);
        //check if get center x!=get center y after modified only center y
        assertFalse("Error in myGetX", r.myGetY()==r.myGetX()); 
    }
    
    @Test 
    public void testMySetWidth(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        r.mySetWidth(5.0);
        assertTrue("Error in mySetWidth", r.myGetWidth()==5.0); 
    }
    
    @Test 
    public void testMySetHeight(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        r.mySetHeight(5.0);
        assertTrue("Error in mySetHeight", r.myGetHeight()==5.0); 
    }
    
    @Test 
    public void testMySetY(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        r.mySetY(6.0);
        assertTrue("Error in mySetY", r.myGetY()==6.0); 
    
    }
    
    @Test 
    public void testMySetX(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        r.mySetX(6.0);
        assertTrue("Error in mySetX", r.myGetX()==6.0); 
    
    }
    
    @Test 
    public void testMyWidthProperty(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        assertTrue("Error in myWidthProperty()", r.myWidthProperty()==r.widthProperty()); 
    }
     
    @Test 
    public void testMyHeightProperty(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        assertTrue("Error in myHeightProperty()", r.myHeightProperty()==r.heightProperty()); 
    }
    
    @Test 
    public void testMyXProperty(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        assertTrue("Error in myXProperty()", r.myXProperty()==r.xProperty()); 
    }
    
    @Test 
    public void testMyYProperty(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        assertTrue("Error in myYProperty()", r.myYProperty()==r.yProperty()); 
    }
    
    @Test
    public void testMySetStroke(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        Color c= Color.BLACK;
        r.mySetStroke(c);
        assertTrue("Error in mySetStroke", r.myGetStroke()==c); 
    }
    
    @Test
    public void testMySetFill(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        Color c= Color.BLACK;
        r.mySetFill(c);
        assertTrue("Error in mySetFill", r.myGetFill()==c); 
    }
    
    @Test 
    public void testMyGetStroke(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        assertTrue("Error in myGetStroke", r.myGetStroke()==r.getStroke()); 
    }
    
    @Test 
    public void testMyGetFill(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        assertTrue("Error in myGetFill", r.myGetFill()==r.getFill()); 
    }
    
    @Test 
    public void testMyGetId(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        assertTrue("Error in myGetId", (r.myGetId() == null ? r.getId() == null : r.myGetId().equals(r.getId()))); 
    }
    
    @Test 
    public void testMyStrokeProperty(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        assertTrue("Error in myStrokeProperty", r.myStrokeProperty()==r.strokeProperty()); 
    }
    
    @Test 
    public void testMyFillProperty(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        assertTrue("Error in myFillProperty", r.myFillProperty()==r.fillProperty()); 
    }
    
    @Test
    public void testMySetStrokeWidth(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        r.mySetStrokeWidth(8.0);
        assertTrue("Error in mySetStrokeWidth", r.myGetStrokeWidth()==8.0); 
    
    }
    
    @Test
    public void testMyGetStrokeWidth(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        r.mySetStrokeWidth(8.0);
        assertTrue("Error in myGetStrokeWidth", r.myGetStrokeWidth()==r.getStrokeWidth()); 
    
    }
    
    @Test
    public void testMyGetParent(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        assertTrue("Error in myGetPartent", r.myGetParent()==r.getParent()); 
    
    }
    
}