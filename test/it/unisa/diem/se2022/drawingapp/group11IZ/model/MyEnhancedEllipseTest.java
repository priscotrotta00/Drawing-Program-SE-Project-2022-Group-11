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
public class MyEnhancedEllipseTest {
    @Test
    public void testMyGetCenterX(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        assertTrue("Error in myGetCenterX", e.myGetCenterX()==e.getCenterX()); 
    } 
    
    @Test
    public void testMyGetCenterX1(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        e.mySetCenterX(5.0);
        //check if get center x!=get center y after modified only center x
        assertFalse("Error in myGetCenterX", e.myGetCenterX()==e.myGetCenterY()); 
    }
    
    @Test
    public void testMySetCenterX(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        e.mySetCenterX(5.0);
        assertTrue("Error in mySetCenterX", e.myGetCenterX()==5.0); 
    }
    
   @Test
   public void testMySetCenterY(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        e.mySetCenterY(5.0);
        assertTrue("Error in mySetCenterY", e.myGetCenterY()==5.0); 
    }
   
    @Test
    public void testMyGetCenterY(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        assertTrue("Error in myGetCenterY", e.myGetCenterY()==e.getCenterY());
    }
    
    @Test
    public void testMyGetCenterY1(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        e.mySetCenterY(5.0);
        //check if get center x!=get center y after modified only center y
        assertFalse("Error in myGetCenterY", e.myGetCenterY()==e.myGetCenterX()); 
    }
    
    @Test 
    public void testMySetRadiusX(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        e.mySetRadiusX(6.0);
        assertTrue("Error in mySetRadiusX", e.myGetRadiusX()==6.0); 
    
    }
    
    @Test 
    public void testMySetRadiusY(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        e.mySetRadiusY(6.0);
        assertTrue("Error in mySetRadiusY", e.myGetRadiusY()==6.0); 
    
    }
    
    @Test
    public void testMyGetRadiusY(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        assertTrue("Error in myGetRadiusY", e.myGetRadiusY()==e.getRadiusY());
    }
    
    @Test
    public void testMyGetRadiusY1(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        e.mySetRadiusY(6.0);
        //check if get center x!=get center y after modified only center y
        assertFalse("Error in myGetRadiusY", e.myGetRadiusX()==e.myGetRadiusY()); 
    }
    
    @Test
    public void testMyGetRadiusX(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        assertTrue("Error in myGetRadiusX", e.myGetRadiusX()==e.getRadiusX());
    }
    
    @Test
    public void testMyGetRadiusX1(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        e.mySetRadiusX(6.0);
        //check if get center x!=get center y after modified only center y
        assertFalse("Error in myGetRadiusX", e.myGetRadiusX()==e.myGetRadiusY()); 
    }
    
    @Test
    public void testMyCenterXProperty(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        assertTrue("Error in myCenterXProperty", e.myCenterXProperty()==e.centerXProperty()); 
    
    }
    
    @Test
    public void testMyCenterYProperty(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        assertTrue("Error in myCenterYProperty", e.myCenterYProperty()==e.centerYProperty()); 
        
    }
    
    @Test
    public void testMyRadiusXProperty(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        assertTrue("Error in myRadiusXProperty", e.myRadiusXProperty()==e.radiusXProperty()); 
    }
    
    @Test
    public void testMyRadiusYProperty(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        assertTrue("Error in myRadiusYProperty", e.myRadiusYProperty()==e.radiusYProperty()); 
    }
    
    @Test
    public void testMySetStroke(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        Color c= Color.BLACK;
        e.mySetStroke(c);
        assertTrue("Error in mySetStroke", e.myGetStroke()==c); 
    }
    
    @Test
    public void testMySetFill(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        Color c= Color.BLACK;
        e.mySetFill(c);
        assertTrue("Error in mySetFill", e.myGetFill()==c); 
    }
    
    
    @Test 
    public void testMyGetStroke(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        assertTrue("Error in myGetStroke", e.myGetStroke()==e.getStroke()); 
    }
    
    @Test 
    public void testMyGetFill(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        assertTrue("Error in myGetFill", e.myGetFill()==e.getFill()); 
    }
    
    @Test 
    public void testMyGetId(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        assertTrue("Error in myGetId", (e.myGetId() == null ? e.getId() == null : e.myGetId().equals(e.getId()))); 
    }
    
    @Test 
    public void testMyStrokeProperty(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        assertTrue("Error in myStrokeProperty", e.myStrokeProperty()==e.strokeProperty()); 
    }
    
    @Test 
    public void testMyFillProperty(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        assertTrue("Error in myFillProperty", e.myFillProperty()==e.fillProperty()); 
    }
    
    @Test
    public void testMySetStrokeWidth(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        e.mySetStrokeWidth(8.0);
        assertTrue("Error in mySetStrokeWidth", e.myGetStrokeWidth()==8.0); 
    
    }
    
    @Test
    public void testMyGetStrokeWidth(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        e.mySetStrokeWidth(8.0);
        assertTrue("Error in myGetStrokeWidth", e.myGetStrokeWidth()==e.getStrokeWidth()); 
    
    }
    
    @Test
    public void testMyGetParent(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        assertTrue("Error in myGetPartent", e.myGetParent()==e.getParent()); 
    
    }
    
    @Test
    public void testMySetLayoutX(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        e.mySetLayoutX(5.0);
        assertTrue("Error in MySetLayoutX", e.myGetLayoutBounds().getMinX()==e.getLayoutBounds().getMinX()); 
    
    }
    
    @Test
    public void testMySetLayoutY(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        e.mySetLayoutY(5.0);
        assertTrue("Error in MySetLayoutY", e.myGetLayoutBounds().getMinY()==e.getLayoutBounds().getMinY());
    }
    
    @Test 
    public void testMyGetLayoutX(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        e.mySetLayoutX(8.0);
        assertTrue("Error in myGetLayoutX", e.myGetLayoutX()==e.getLayoutX()); 

    }
    
    @Test 
    public void testMyGetLayoutY(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        e.mySetLayoutY(8.0);
        assertTrue("Error in myGetLayoutY", e.myGetLayoutY()==e.getLayoutY()); 
    }
    
    
    @Test
    public void testMyLayoutXProperty(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        
        assertTrue("Error in MyLayoutXProperty", e.myLayoutXProperty()==e.layoutXProperty());
        
    }
    
    @Test
    public void testMyLayoutYProperty(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        
        assertTrue("Error in MyLayoutYProperty", e.myLayoutYProperty()==e.layoutYProperty()); 
    }
    
    @Test
    public void testMyGetStrokeDashArray(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        
        assertTrue("Error in MyGetStrokeDashArray", e.myGetStrokeDashArray()==e.getStrokeDashArray());        
    }
    
    @Test
    public void testMyGetLayoutBounds(){
        MyEnhancedEllipse e=new MyEnhancedEllipse();
        
        assertTrue("Error in MyGetLayoutBounds", e.myGetLayoutBounds()==e.getLayoutBounds());        
    }
    
    @Test
    public void testMoveShape(){
        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        
        ellipse.mySetCenterX(50.0);
        ellipse.mySetCenterY(50.0);
        ellipse.mySetRadiusX(50.0);
        ellipse.mySetRadiusY(25.0);
        
        ellipse.moveShape(70.0, 70.0);
        
        assertTrue("Error in MoveShape", ellipse.myGetCenterX()==70.0);
        assertTrue("Error in MoveShape", ellipse.myGetCenterY()==70.0);
    }
    
    @Test
    public void testModifyShape1(){
        MyEllipse r;

        r = new MyEnhancedEllipse();
        r.modifyShape(10, 10, 50, 20);
        assertEquals(10, r.getTopLeftX(), 0);
        assertEquals(10, r.getTopLeftY(), 0);
        assertEquals(50, r.getBottomRightX(), 0);
        assertEquals(20, r.getBottomRightY(), 0);
        
        assertEquals(30, r.myGetCenterX(), 0);
        assertEquals(15, r.myGetCenterY(), 0);
        assertEquals(20, r.myGetRadiusX(), 0);
        assertEquals(5, r.myGetRadiusY(), 0);
    }
    
    @Test(expected=InvalidCoordinatesException.class)
    public void testModifyShape2(){
        MyEllipse r;
        
        r = new MyEnhancedEllipse();
        r.modifyShape(50, 20, 10, 10);
    }
    
    @Test(expected=InvalidCoordinatesException.class)
    public void testModifyShape3(){
        MyEllipse r;
        
        r = new MyEnhancedEllipse();
        r.modifyShape(50, 20, 70, 10);
    }
    
    @Test(expected=InvalidCoordinatesException.class)
    public void testModifyShape4(){
        MyEllipse r;
        
        r = new MyEnhancedEllipse();
        r.modifyShape(50, 20, 10, 70);
    }
    
    @Test
    public void testModifyShape5(){
        MyEllipse r;
        
        r = new MyEnhancedEllipse();
        r.modifyShape(-10, -20, 30, 60);
        
        assertEquals(-10, r.getTopLeftX(), 0);
        assertEquals(-20, r.getTopLeftY(), 0);
        assertEquals(30, r.getBottomRightX(), 0);
        assertEquals(60, r.getBottomRightY(), 0);
        
        assertEquals(10, r.myGetCenterX(), 0);
        assertEquals(20, r.myGetCenterY(), 0);
        assertEquals(20, r.myGetRadiusX(), 0);
        assertEquals(40, r.myGetRadiusY(), 0);
    }
    
    @Test
    public void testModifyShape6(){
        MyEllipse r;
        
        r = new MyEnhancedEllipse();
        r.modifyShape(10, -20, 30, 60);
        
        assertEquals(10, r.getTopLeftX(), 0);
        assertEquals(-20, r.getTopLeftY(), 0);
        assertEquals(30, r.getBottomRightX(), 0);
        assertEquals(60, r.getBottomRightY(), 0);
        
        assertEquals(20, r.myGetCenterX(), 0);
        assertEquals(20, r.myGetCenterY(), 0);
        assertEquals(10, r.myGetRadiusX(), 0);
        assertEquals(40, r.myGetRadiusY(), 0);
    }
    
    @Test
    public void testModifyShape7(){
        MyEllipse r;
        
        r = new MyEnhancedEllipse();
        r.modifyShape(-50, 20, 30, 60);
        
        assertEquals(-50, r.getTopLeftX(), 0);
        assertEquals(20, r.getTopLeftY(), 0);
        assertEquals(30, r.getBottomRightX(), 0);
        assertEquals(60, r.getBottomRightY(), 0);
        
        assertEquals(-10, r.myGetCenterX(), 0);
        assertEquals(40, r.myGetCenterY(), 0);
        assertEquals(40, r.myGetRadiusX(), 0);
        assertEquals(20, r.myGetRadiusY(), 0);
    }
    
    @Test
    public void testModifyShape8(){
        MyEllipse r;
        
        r = new MyEnhancedEllipse();
        r.modifyShape(-30, -60, -20, -20);
        
        assertEquals(-30, r.getTopLeftX(), 0);
        assertEquals(-60, r.getTopLeftY(), 0);
        assertEquals(-20, r.getBottomRightX(), 0);
        assertEquals(-20, r.getBottomRightY(), 0);
        
        assertEquals(-25, r.myGetCenterX(), 0);
        assertEquals(-40, r.myGetCenterY(), 0);
        assertEquals(5, r.myGetRadiusX(), 0);
        assertEquals(20, r.myGetRadiusY(), 0);
    }
    
    @Test
    public void testModifyShape9(){
        MyEllipse r;
        
        r = new MyEnhancedEllipse();
        r.modifyShape(-50, 20, -30, 60);
        
        assertEquals(-50, r.getTopLeftX(), 0);
        assertEquals(20, r.getTopLeftY(), 0);
        assertEquals(-30, r.getBottomRightX(), 0);
        assertEquals(60, r.getBottomRightY(), 0);
        
        assertEquals(-40, r.myGetCenterX(), 0);
        assertEquals(40, r.myGetCenterY(), 0);
        assertEquals(10, r.myGetRadiusX(), 0);
        assertEquals(20, r.myGetRadiusY(), 0);
    }
    
    @Test
    public void testModifyShape10(){
        MyEllipse r;
        
        r = new MyEnhancedEllipse();
        r.modifyShape(10, -60, 30, -20);
        
        assertEquals(10, r.getTopLeftX(), 0);
        assertEquals(-60, r.getTopLeftY(), 0);
        assertEquals(30, r.getBottomRightX(), 0);
        assertEquals(-20, r.getBottomRightY(), 0);
        
        assertEquals(20, r.myGetCenterX(), 0);
        assertEquals(-40, r.myGetCenterY(), 0);
        assertEquals(10, r.myGetRadiusX(), 0);
        assertEquals(20, r.myGetRadiusY(), 0);
    }
    
    @Test
    public void testClone(){
        //create shape ellipse
        MyEnhancedEllipse ellipse = new MyEnhancedEllipse();
        ellipse.mySetCenterX(20.0);
        ellipse.mySetCenterY(20.0);
        ellipse.mySetRadiusX(50.0);
        ellipse.mySetRadiusY(25.0);
        Color c= Color.BLACK;
        ellipse.mySetStroke(c);
        Color c1= Color.CADETBLUE;
        ellipse.mySetFill(c1);
        ellipse.mySetStrokeWidth(2.0);
        
        //create copy
        MyEnhancedEllipse ellipseCopy= (MyEnhancedEllipse) ellipse.clone();
        
        //check if ellipseCopy is equal to ellipse
        assertTrue("error in copy of center x", ellipseCopy.myGetCenterX()==ellipse.myGetCenterX());
        assertTrue("error in copy of center y", ellipseCopy.myGetCenterY()==ellipse.myGetCenterY());
        assertTrue("error in copy of radius x", ellipseCopy.myGetRadiusX()==ellipse.myGetRadiusX());
        assertTrue("error in copy of radius y", ellipseCopy.myGetRadiusY()==ellipse.myGetRadiusY());
        assertTrue("error in copy of fill ", ellipseCopy.myGetFill()==ellipse.myGetFill());
        assertTrue("error in copy of stroke ", ellipseCopy.myGetStroke()==ellipse.myGetStroke());
        assertTrue("error in copy of strokeWidth ", ellipseCopy.myGetStrokeWidth()==ellipse.myGetStrokeWidth());
        
        
    }
    
    @Test
    public void testSnapshot(){
        MyEnhancedEllipse ellipse;
        MyEnhancedEllipse.Snapshot snapshot;
        
        ellipse = new MyEnhancedEllipse();
        ellipse.modifyShape(10, 20, 50, 60);
        ellipse.mySetFill(Color.BLACK);
        ellipse.mySetStroke(Color.WHITE);
        
        snapshot = ellipse.getSnapshot();
        ellipse.modifyShape(100, -20, 180, 60);
        ellipse.mySetFill(Color.GREEN);
        ellipse.mySetStroke(Color.RED);
        
        snapshot.restore();
        assertEquals(Color.BLACK, ellipse.myGetFill());
        assertEquals(Color.WHITE, ellipse.myGetStroke());
        assertEquals(10, ellipse.getTopLeftX(), 0);
        assertEquals(20, ellipse.getTopLeftY(), 0);
        assertEquals(50, ellipse.getBottomRightX(), 0);
        assertEquals(60, ellipse.getBottomRightY(), 0);
        
    }
}
