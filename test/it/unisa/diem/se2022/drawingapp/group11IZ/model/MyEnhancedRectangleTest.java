/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.model;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.exception.InvalidCoordinatesException;
import javafx.scene.paint.Color;
import static org.junit.Assert.*;
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
    
    @Test
    public void testMySetLayoutX(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        r.mySetLayoutX(5.0);
        assertTrue("Error in MySetLayoutX", r.myGetLayoutBounds().getMinX()==r.getLayoutBounds().getMinX()); 
    
    }
    
    @Test
    public void testMySetLayoutY(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        r.mySetLayoutY(5.0);
        assertTrue("Error in MySetLayoutY", r.myGetLayoutBounds().getMinY()==r.getLayoutBounds().getMinY());
    }
    
    @Test 
    public void testMyGetLayoutX(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        r.mySetLayoutX(8.0);
        assertTrue("Error in myGetLayoutX", r.myGetLayoutX()==r.getLayoutX()); 

    }
    
    @Test 
    public void testMyGetLayoutY(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        r.mySetLayoutY(8.0);
        assertTrue("Error in myGetLayoutY", r.myGetLayoutY()==r.getLayoutY()); 

    }
    
    
    @Test
    public void testMyLayoutXProperty(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        
        assertTrue("Error in MyLayoutXProperty", r.myLayoutXProperty()==r.layoutXProperty());
        
    }
    
    @Test
    public void testMyLayoutYProperty(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        
        assertTrue("Error in MyLayoutYProperty", r.myLayoutYProperty()==r.layoutYProperty()); 
    }
    
    @Test
    public void testMyGetStrokeDashArray(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        
        assertTrue("Error in MyGetStrokeDashArray", r.myGetStrokeDashArray()==r.getStrokeDashArray());        
    }
    
    @Test
    public void testMyGetLayoutBounds(){
        MyEnhancedRectangle r=new MyEnhancedRectangle();
        
        assertTrue("Error in MyGetLayoutBounds", r.myGetLayoutBounds()==r.getLayoutBounds());        
    }
    
    @Test
    public void testMoveShape(){
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        
        rectangle.mySetX(10);
        rectangle.mySetY(10);
        rectangle.mySetWidth(20);
        rectangle.mySetHeight(10);
        
        double diffX = rectangle.myGetLayoutBounds().getMaxX()-rectangle.myGetLayoutBounds().getMinX(); 
        double diffY = rectangle.myGetLayoutBounds().getMaxY()-rectangle.myGetLayoutBounds().getMinY(); 
        
        
        rectangle.moveShape(70.0, 70.0);
        
        assertTrue("Error in MoveShape", rectangle.myGetX()==(70.0-(diffX/2)));
        assertTrue("Error in MoveShape", rectangle.myGetY()==(70.0-(diffY/2)));
    }
    
    @Test
    public void testModifyShape1(){
        MyRectangle r;

        r = new MyEnhancedRectangle();
        r.modifyShape(10, 10, 50, 20);
        assertEquals(10, r.getTopLeftX(), 0);
        assertEquals(10, r.getTopLeftY(), 0);
        assertEquals(50, r.getBottomRightX(), 0);
        assertEquals(20, r.getBottomRightY(), 0);
        
        assertEquals(40, r.myGetWidth(), 0);
        assertEquals(10, r.myGetHeight(), 0);
    }
    
    @Test(expected=InvalidCoordinatesException.class)
    public void testModifyShape2(){
        MyRectangle r;
        
        r = new MyEnhancedRectangle();
        r.modifyShape(50, 20, 10, 10);
    }
    
    @Test(expected=InvalidCoordinatesException.class)
    public void testModifyShape3(){
        MyRectangle r;
        
        r = new MyEnhancedRectangle();
        r.modifyShape(50, 20, 70, 10);
    }
    
    @Test(expected=InvalidCoordinatesException.class)
    public void testModifyShape4(){
        MyRectangle r;
        
        r = new MyEnhancedRectangle();
        r.modifyShape(50, 20, 10, 70);
    }
    
    @Test
    public void testModifyShape5(){
        MyRectangle r;
        
        r = new MyEnhancedRectangle();
        r.modifyShape(-10, -20, 30, 60);
        
        assertEquals(-10, r.getTopLeftX(), 0);
        assertEquals(-20, r.getTopLeftY(), 0);
        assertEquals(30, r.getBottomRightX(), 0);
        assertEquals(60, r.getBottomRightY(), 0);
        
        assertEquals(40, r.myGetWidth(), 0);
        assertEquals(80, r.myGetHeight(), 0);
    }
    
    @Test
    public void testModifyShape6(){
        MyRectangle r;
        
        r = new MyEnhancedRectangle();
        r.modifyShape(10, -20, 30, 60);
        
        assertEquals(10, r.getTopLeftX(), 0);
        assertEquals(-20, r.getTopLeftY(), 0);
        assertEquals(30, r.getBottomRightX(), 0);
        assertEquals(60, r.getBottomRightY(), 0);
        
        assertEquals(20, r.myGetWidth(), 0);
        assertEquals(80, r.myGetHeight(), 0);
    }
    
    @Test
    public void testModifyShape7(){
        MyRectangle r;
        
        r = new MyEnhancedRectangle();
        r.modifyShape(-50, 20, 30, 60);
        
        assertEquals(-50, r.getTopLeftX(), 0);
        assertEquals(20, r.getTopLeftY(), 0);
        assertEquals(30, r.getBottomRightX(), 0);
        assertEquals(60, r.getBottomRightY(), 0);
        
        assertEquals(80, r.myGetWidth(), 0);
        assertEquals(40, r.myGetHeight(), 0);
    }
    
    @Test
    public void testModifyShape8(){
        MyRectangle r;
        
        r = new MyEnhancedRectangle();
        r.modifyShape(-30, -60, -20, -20);
        
        assertEquals(-30, r.getTopLeftX(), 0);
        assertEquals(-60, r.getTopLeftY(), 0);
        assertEquals(-20, r.getBottomRightX(), 0);
        assertEquals(-20, r.getBottomRightY(), 0);
        
        assertEquals(10, r.myGetWidth(), 0);
        assertEquals(40, r.myGetHeight(), 0);
    }
    
    @Test
    public void testModifyShape9(){
        MyRectangle r;
        
        r = new MyEnhancedRectangle();
        r.modifyShape(-50, 20, -30, 60);
        
        assertEquals(-50, r.getTopLeftX(), 0);
        assertEquals(20, r.getTopLeftY(), 0);
        assertEquals(-30, r.getBottomRightX(), 0);
        assertEquals(60, r.getBottomRightY(), 0);
        
        assertEquals(20, r.myGetWidth(), 0);
        assertEquals(40, r.myGetHeight(), 0);
    }
    
    @Test
    public void testModifyShape10(){
        MyRectangle r;
        
        r = new MyEnhancedRectangle();
        r.modifyShape(10, -60, 30, -20);
        
        assertEquals(10, r.getTopLeftX(), 0);
        assertEquals(-60, r.getTopLeftY(), 0);
        assertEquals(30, r.getBottomRightX(), 0);
        assertEquals(-20, r.getBottomRightY(), 0);
        
        assertEquals(20, r.myGetWidth(), 0);
        assertEquals(40, r.myGetHeight(), 0);
    }
    public void testClone(){
        //create shape ellipse
        MyEnhancedRectangle rectangle = new MyEnhancedRectangle();
        
        rectangle.mySetX(20.0);
        rectangle.mySetY(20.0);
        rectangle.mySetWidth(25.0);
        rectangle.mySetHeight(25.0);
        Color c= Color.BLACK;
        rectangle.mySetStroke(c);
        Color c1= Color.CADETBLUE;
        rectangle.mySetFill(c1);
        rectangle.mySetStrokeWidth(2.0);
        //create copy
        MyEnhancedRectangle rectangleCopy = (MyEnhancedRectangle) rectangle.clone();
        
        //check if ellipseCopy is equal to ellipse
        assertTrue("error in copy of  x", rectangleCopy.myGetX()==rectangle.myGetX());
        assertTrue("error in copy of y", rectangleCopy.myGetY()==rectangle.myGetY());
        assertTrue("error in copy of width", rectangleCopy.myGetWidth()==rectangle.myGetWidth());
        assertTrue("error in copy of height", rectangleCopy.myGetHeight()==rectangle.myGetHeight());
        assertTrue("error in copy of fill ", rectangleCopy.myGetFill()==rectangle.myGetFill());
        assertTrue("error in copy of stroke ",rectangleCopy.myGetStroke()==rectangle.myGetStroke());
        assertTrue("error in copy of strokeWidth ", rectangleCopy.myGetStrokeWidth()==rectangle.myGetStrokeWidth());
        
        
    }
    
}
