/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.selection;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

/**
 *
 * @author utente
 */
public class SelectionRectangleHelperTest {
    private SelectionRectangleHelper helper;
    private MyRectangle rectangle;
    
    @Before
    public void setUp(){
        this.helper = new SelectionRectangleHelper();
        this.rectangle = new MyEnhancedRectangle();
    }
    
    @Test
    public void testCreateBoundingBoxEdge(){
        MyRectangle edge;
        
        this.rectangle.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(this.rectangle);
        edge = (MyRectangle) this.helper.getBoundingBoxEdge();
        
        Assert.assertEquals(10, edge.getTopLeftX(), 0);
        Assert.assertEquals(10, edge.getTopLeftY(), 0);
        Assert.assertEquals(30, edge.getBottomRightX(), 0);
        Assert.assertEquals(20, edge.getBottomRightY(), 0);
        Assert.assertEquals(20, edge.myGetWidth(), 0);
        Assert.assertEquals(10, edge.myGetHeight(), 0);
    }
    
    @Test
    public void testCreateBoundingBoxEdgeMoveShape(){
        MyRectangle edge;
        
        this.rectangle.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(this.rectangle);
        edge = (MyRectangle) this.helper.getBoundingBoxEdge();
        
        Assert.assertEquals(10, edge.getTopLeftX(), 0);
        Assert.assertEquals(10, edge.getTopLeftY(), 0);
        Assert.assertEquals(30, edge.getBottomRightX(), 0);
        Assert.assertEquals(20, edge.getBottomRightY(), 0);
        Assert.assertEquals(20, edge.myGetWidth(), 0);
        Assert.assertEquals(10, edge.myGetHeight(), 0);
        
        this.rectangle.modifyShape(30, 30, 50, 40);
        Assert.assertEquals(30, edge.getTopLeftX(), 0);
        Assert.assertEquals(30, edge.getTopLeftY(), 0);
        Assert.assertEquals(50, edge.getBottomRightX(), 0);
        Assert.assertEquals(40, edge.getBottomRightY(), 0);
        Assert.assertEquals(20, edge.myGetWidth(), 0);
        Assert.assertEquals(10, edge.myGetHeight(), 0);
        
        this.rectangle.modifyShape(-10, -10, 10, 0);
        Assert.assertEquals(-10, edge.getTopLeftX(), 0);
        Assert.assertEquals(-10, edge.getTopLeftY(), 0);
        Assert.assertEquals(10, edge.getBottomRightX(), 0);
        Assert.assertEquals(0, edge.getBottomRightY(), 0);
        Assert.assertEquals(20, edge.myGetWidth(), 0);
        Assert.assertEquals(10, edge.myGetHeight(), 0);
    }
    
    @Test
    public void testCreateBoundingBoxEdgeResizeShape(){
        MyRectangle edge;
        
        this.rectangle.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(this.rectangle);
        edge = (MyRectangle) this.helper.getBoundingBoxEdge();
        
        Assert.assertEquals(10, edge.getTopLeftX(), 0);
        Assert.assertEquals(10, edge.getTopLeftY(), 0);
        Assert.assertEquals(30, edge.getBottomRightX(), 0);
        Assert.assertEquals(20, edge.getBottomRightY(), 0);
        Assert.assertEquals(20, edge.myGetWidth(), 0);
        Assert.assertEquals(10, edge.myGetHeight(), 0);
        
        this.rectangle.modifyShape(10, 10, 50, 40);
        Assert.assertEquals(10, edge.getTopLeftX(), 0);
        Assert.assertEquals(10, edge.getTopLeftY(), 0);
        Assert.assertEquals(50, edge.getBottomRightX(), 0);
        Assert.assertEquals(40, edge.getBottomRightY(), 0);
        Assert.assertEquals(40, edge.myGetWidth(), 0);
        Assert.assertEquals(30, edge.myGetHeight(), 0);
        
        this.rectangle.modifyShape(-10, 10, 50, 50);
        Assert.assertEquals(-10, edge.getTopLeftX(), 0);
        Assert.assertEquals(10, edge.getTopLeftY(), 0);
        Assert.assertEquals(50, edge.getBottomRightX(), 0);
        Assert.assertEquals(50, edge.getBottomRightY(), 0);
        Assert.assertEquals(60, edge.myGetWidth(), 0);
        Assert.assertEquals(40, edge.myGetHeight(), 0);
        
        this.rectangle.modifyShape(-20, -10, 50, 50);
        Assert.assertEquals(-20, edge.getTopLeftX(), 0);
        Assert.assertEquals(-10, edge.getTopLeftY(), 0);
        Assert.assertEquals(50, edge.getBottomRightX(), 0);
        Assert.assertEquals(50, edge.getBottomRightY(), 0);
        Assert.assertEquals(70, edge.myGetWidth(), 0);
        Assert.assertEquals(60, edge.myGetHeight(), 0);
        
        this.rectangle.modifyShape(-20, 20, 30, 50);
        Assert.assertEquals(-20, edge.getTopLeftX(), 0);
        Assert.assertEquals(20, edge.getTopLeftY(), 0);
        Assert.assertEquals(30, edge.getBottomRightX(), 0);
        Assert.assertEquals(50, edge.getBottomRightY(), 0);
        Assert.assertEquals(50, edge.myGetWidth(), 0);
        Assert.assertEquals(30, edge.myGetHeight(), 0);
    }
    
    @Test
    public void testUpdateVertices(){
        MyRectangle vertex1;
        MyRectangle vertex2;
        MyRectangle vertex3;
        MyRectangle vertex4;
        double widthVertex;
        double heightVertex;
        
        this.rectangle.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(this.rectangle);
        vertex1 = this.helper.getVertex1();
        vertex2 = this.helper.getVertex2();
        vertex3 = this.helper.getVertex3();
        vertex4 = this.helper.getVertex4();
        widthVertex = vertex1.myGetWidth();
        heightVertex = vertex1.myGetHeight();
        
        Assert.assertEquals(10, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(10, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(30 - widthVertex, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(10, vertex2.getTopLeftY(), 0);
        Assert.assertEquals(30 - widthVertex, vertex3.getTopLeftX(), 0);
        Assert.assertEquals(20 - heightVertex, vertex3.getTopLeftY(), 0);
        Assert.assertEquals(10, vertex4.getTopLeftX(), 0);
        Assert.assertEquals(20 - heightVertex, vertex4.getTopLeftY(), 0);
    }
    
    @Test
    public void testUpdateVerticesMoveShape(){
        MyRectangle vertex1;
        MyRectangle vertex2;
        MyRectangle vertex3;
        MyRectangle vertex4;
        double widthVertex;
        double heightVertex;
        
        this.rectangle.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(this.rectangle);
        vertex1 = this.helper.getVertex1();
        vertex2 = this.helper.getVertex2();
        vertex3 = this.helper.getVertex3();
        vertex4 = this.helper.getVertex4();
        widthVertex = vertex1.myGetWidth();
        heightVertex = vertex1.myGetHeight();
        
        Assert.assertEquals(10, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(10, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(30 - widthVertex, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(10, vertex2.getTopLeftY(), 0);
        Assert.assertEquals(30 - widthVertex, vertex3.getTopLeftX(), 0);
        Assert.assertEquals(20 - heightVertex, vertex3.getTopLeftY(), 0);
        Assert.assertEquals(10, vertex4.getTopLeftX(), 0);
        Assert.assertEquals(20 - heightVertex, vertex4.getTopLeftY(), 0);
        
        this.rectangle.modifyShape(10, 10, 50, 40);
        Assert.assertEquals(10, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(10, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(50 - widthVertex, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(10, vertex2.getTopLeftY(), 0);
        Assert.assertEquals(50 - widthVertex, vertex3.getTopLeftX(), 0);
        Assert.assertEquals(40 - heightVertex, vertex3.getTopLeftY(), 0);
        Assert.assertEquals(10, vertex4.getTopLeftX(), 0);
        Assert.assertEquals(40 - heightVertex, vertex4.getTopLeftY(), 0);
        
        this.rectangle.modifyShape(-10, 10, 50, 50);
        Assert.assertEquals(-10, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(10, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(50 - widthVertex, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(10, vertex2.getTopLeftY(), 0);
        Assert.assertEquals(50 - widthVertex, vertex3.getTopLeftX(), 0);
        Assert.assertEquals(50 - heightVertex, vertex3.getTopLeftY(), 0);
        Assert.assertEquals(-10, vertex4.getTopLeftX(), 0);
        Assert.assertEquals(50 - heightVertex, vertex4.getTopLeftY(), 0);
        
        this.rectangle.modifyShape(-20, -10, 50, 50);
        Assert.assertEquals(-20, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(-10, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(50 - widthVertex, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(-10, vertex2.getTopLeftY(), 0);
        Assert.assertEquals(50 - widthVertex, vertex3.getTopLeftX(), 0);
        Assert.assertEquals(50 - heightVertex, vertex3.getTopLeftY(), 0);
        Assert.assertEquals(-20, vertex4.getTopLeftX(), 0);
        Assert.assertEquals(50 - heightVertex, vertex4.getTopLeftY(), 0);
        
        this.rectangle.modifyShape(-20, 20, 30, 50);
        Assert.assertEquals(-20, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(20, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(30 - widthVertex, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(20, vertex2.getTopLeftY(), 0);
        Assert.assertEquals(30 - widthVertex, vertex3.getTopLeftX(), 0);
        Assert.assertEquals(50 - heightVertex, vertex3.getTopLeftY(), 0);
        Assert.assertEquals(-20, vertex4.getTopLeftX(), 0);
        Assert.assertEquals(50 - heightVertex, vertex4.getTopLeftY(), 0);
    }
    
    @Test
    public void testUpdateVerticesResizeShape(){
        MyRectangle vertex1;
        MyRectangle vertex2;
        MyRectangle vertex3;
        MyRectangle vertex4;
        double widthVertex;
        double heightVertex;
        
        this.rectangle.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(this.rectangle);
        vertex1 = this.helper.getVertex1();
        vertex2 = this.helper.getVertex2();
        vertex3 = this.helper.getVertex3();
        vertex4 = this.helper.getVertex4();
        widthVertex = vertex1.myGetWidth();
        heightVertex = vertex1.myGetHeight();
        
        Assert.assertEquals(10, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(10, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(30 - widthVertex, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(10, vertex2.getTopLeftY(), 0);
        Assert.assertEquals(30 - widthVertex, vertex3.getTopLeftX(), 0);
        Assert.assertEquals(20 - heightVertex, vertex3.getTopLeftY(), 0);
        Assert.assertEquals(10, vertex4.getTopLeftX(), 0);
        Assert.assertEquals(20 - heightVertex, vertex4.getTopLeftY(), 0);
        
        this.rectangle.modifyShape(10, 10, 50, 40);
        Assert.assertEquals(10, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(10, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(50 - widthVertex, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(10, vertex2.getTopLeftY(), 0);
        Assert.assertEquals(50 - widthVertex, vertex3.getTopLeftX(), 0);
        Assert.assertEquals(40 - heightVertex, vertex3.getTopLeftY(), 0);
        Assert.assertEquals(10, vertex4.getTopLeftX(), 0);
        Assert.assertEquals(40 - heightVertex, vertex4.getTopLeftY(), 0);
        
        this.rectangle.modifyShape(-10, 10, 50, 50);
        Assert.assertEquals(-10, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(10, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(50 - widthVertex, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(10, vertex2.getTopLeftY(), 0);
        Assert.assertEquals(50 - widthVertex, vertex3.getTopLeftX(), 0);
        Assert.assertEquals(50 - heightVertex, vertex3.getTopLeftY(), 0);
        Assert.assertEquals(-10, vertex4.getTopLeftX(), 0);
        Assert.assertEquals(50 - heightVertex, vertex4.getTopLeftY(), 0);
        
        this.rectangle.modifyShape(-20, -10, 50, 50);
        Assert.assertEquals(-20, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(-10, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(50 - widthVertex, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(-10, vertex2.getTopLeftY(), 0);
        Assert.assertEquals(50 - widthVertex, vertex3.getTopLeftX(), 0);
        Assert.assertEquals(50 - heightVertex, vertex3.getTopLeftY(), 0);
        Assert.assertEquals(-20, vertex4.getTopLeftX(), 0);
        Assert.assertEquals(50 - heightVertex, vertex4.getTopLeftY(), 0);
        
        this.rectangle.modifyShape(-20, 20, 30, 50);
        Assert.assertEquals(-20, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(20, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(30 - widthVertex, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(20, vertex2.getTopLeftY(), 0);
        Assert.assertEquals(30 - widthVertex, vertex3.getTopLeftX(), 0);
        Assert.assertEquals(50 - heightVertex, vertex3.getTopLeftY(), 0);
        Assert.assertEquals(-20, vertex4.getTopLeftX(), 0);
        Assert.assertEquals(50 - heightVertex, vertex4.getTopLeftY(), 0);
        
    }
    
    @Test
    public void testOnMouseDragVertex1ConditionTrue(){
        this.rectangle.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(this.rectangle);
        Assert.assertTrue(this.helper.onMouseDragVertex1Condition(0, 0));
        Assert.assertTrue(this.helper.onMouseDragVertex1Condition(10, 15));
        Assert.assertTrue(this.helper.onMouseDragVertex1Condition(25, 10));
        Assert.assertTrue(this.helper.onMouseDragVertex1Condition(30, 20));
        Assert.assertTrue(this.helper.onMouseDragVertex1Condition(-25, -50));
    }
    
    @Test
    public void testOnMouseDragVertex1ConditionFalse(){
        this.rectangle.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(this.rectangle);
        Assert.assertFalse(this.helper.onMouseDragVertex1Condition(50, 20));
        Assert.assertFalse(this.helper.onMouseDragVertex1Condition(50, 30));
        Assert.assertFalse(this.helper.onMouseDragVertex1Condition(40, -10));
        Assert.assertFalse(this.helper.onMouseDragVertex1Condition(-50, 40));
    }
    
    @Test
    public void testOnMouseDragVertex1Action(){
        this.rectangle.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(this.rectangle);
        
        this.helper.onMouseDragVertex1Action(0, 0);
        Assert.assertEquals(0, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(0, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(20, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex1Action(10, 15);
        Assert.assertEquals(10, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(15, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(20, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex1Action(25, 10);
        Assert.assertEquals(25, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(20, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex1Action(30, 20);
        Assert.assertEquals(30, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(20, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(20, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex1Action(-25, -50);
        Assert.assertEquals(-25, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(-50, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(20, this.rectangle.getBottomRightY(), 0);
    }
    
    @Test
    public void testOnMouseDragVertex2ConditionTrue(){
        this.rectangle.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(this.rectangle);
        Assert.assertTrue(this.helper.onMouseDragVertex2Condition(50, 0));
        Assert.assertTrue(this.helper.onMouseDragVertex2Condition(15, 10));
        Assert.assertTrue(this.helper.onMouseDragVertex2Condition(30, 18));
        Assert.assertTrue(this.helper.onMouseDragVertex2Condition(10, 20));
        Assert.assertTrue(this.helper.onMouseDragVertex2Condition(60, -20));
    }
    
    @Test
    public void testOnMouseDragVertex2ConditionFalse(){
        this.rectangle.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(this.rectangle);
        Assert.assertFalse(this.helper.onMouseDragVertex2Condition(30, 40));
        Assert.assertFalse(this.helper.onMouseDragVertex2Condition(-10, 20));
        Assert.assertFalse(this.helper.onMouseDragVertex2Condition(-20, 40));
    }
    
    @Test
    public void testOnMouseDragVertex2Action(){
        this.rectangle.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(this.rectangle);
        
        this.helper.onMouseDragVertex2Action(50, 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(0, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(50, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(20, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex2Action(15, 10);
        Assert.assertEquals(10, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(15, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(20, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex2Action(30, 18);
        Assert.assertEquals(10, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(18, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(20, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex2Action(10, 20);
        Assert.assertEquals(10, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(20, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(10, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(20, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex2Action(60, -20);
        Assert.assertEquals(10, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(-20, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(60, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(20, this.rectangle.getBottomRightY(), 0);
    }
    
    @Test
    public void testOnMouseDragVertex3ConditionTrue(){
        this.rectangle.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(this.rectangle);
        Assert.assertTrue(this.helper.onMouseDragVertex3Condition(40, 60));
        Assert.assertTrue(this.helper.onMouseDragVertex3Condition(15, 15));
        Assert.assertTrue(this.helper.onMouseDragVertex3Condition(30, 12));
        Assert.assertTrue(this.helper.onMouseDragVertex3Condition(20, 20));
        Assert.assertTrue(this.helper.onMouseDragVertex3Condition(30, 50));
        Assert.assertTrue(this.helper.onMouseDragVertex3Condition(50, 20));
        Assert.assertTrue(this.helper.onMouseDragVertex3Condition(40, 15));
        Assert.assertTrue(this.helper.onMouseDragVertex3Condition(15, 50));
    }
    
    @Test
    public void testOnMouseDragVertex3ConditionFalse(){
        this.rectangle.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(this.rectangle);
        Assert.assertFalse(this.helper.onMouseDragVertex3Condition(30, -10));
        Assert.assertFalse(this.helper.onMouseDragVertex3Condition(-10, 20));
        Assert.assertFalse(this.helper.onMouseDragVertex3Condition(-20, -40));
    }
    
    @Test
    public void testOnMouseDragVertex3Action(){
        this.rectangle.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(this.rectangle);
        
        this.helper.onMouseDragVertex3Action(40, 60);
        Assert.assertEquals(10, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(40, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(60, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex3Action(15, 15);
        Assert.assertEquals(10, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(15, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(15, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex3Action(30, 12);
        Assert.assertEquals(10, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(12, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex3Action(20, 20);
        Assert.assertEquals(10, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(20, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(20, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex3Action(30, 50);
        Assert.assertEquals(10, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(50, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex3Action(50, 20);
        Assert.assertEquals(10, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(50, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(20, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex3Action(40, 15);
        Assert.assertEquals(10, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(40, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(15, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex3Action(15, 50);
        Assert.assertEquals(10, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(15, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(50, this.rectangle.getBottomRightY(), 0);
    }
    
    @Test
    public void testOnMouseDragVertex4ConditionTrue(){
        this.rectangle.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(this.rectangle);
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(30, 10));
        
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(0, 30));
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(20, 12));
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(10, 15));
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(2, 12));
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(-10, 20));
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(10, 40));
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(20, 40));
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(15,20));
        
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(30, 12));
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(30, 20));
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(30, 25));
        
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(-10, 10));
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(10, 10));
        Assert.assertTrue(this.helper.onMouseDragVertex4Condition(15, 10));
    }
    
    @Test
    public void testOnMouseDragVertex4ConditionFalse(){
        this.rectangle.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(this.rectangle);
        Assert.assertFalse(this.helper.onMouseDragVertex4Condition(5, -10));
        Assert.assertFalse(this.helper.onMouseDragVertex4Condition(40, 25));
        Assert.assertFalse(this.helper.onMouseDragVertex4Condition(50, -40));
    }
    
    @Test
    public void testOnMouseDragVertex4Action(){
        this.rectangle.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(this.rectangle);
        
        this.helper.onMouseDragVertex4Action(30, 10);
        Assert.assertEquals(30, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(10, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(0, 30);
        Assert.assertEquals(0, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(20, 12);
        Assert.assertEquals(20, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(12, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(10, 15);
        Assert.assertEquals(10, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(15, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(2, 12);
        Assert.assertEquals(2, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(12, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(-10, 20);
        Assert.assertEquals(-10, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(20, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(10, 40);
        Assert.assertEquals(10, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(40, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(20, 40);
        Assert.assertEquals(20, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(40, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(15, 20);
        Assert.assertEquals(15, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(20, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(30, 12);
        Assert.assertEquals(30, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(12, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(30, 20);
        Assert.assertEquals(30, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(20, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(30, 25);
        Assert.assertEquals(30, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(25, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(-10, 10);
        Assert.assertEquals(-10, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(10, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(10, 10);
        Assert.assertEquals(10, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(10, this.rectangle.getBottomRightY(), 0);
        
        this.helper.onMouseDragVertex4Action(15, 10);
        Assert.assertEquals(15, this.rectangle.getTopLeftX(), 0);
        Assert.assertEquals(10, this.rectangle.getTopLeftY(), 0);
        Assert.assertEquals(30, this.rectangle.getBottomRightX(), 0);
        Assert.assertEquals(10, this.rectangle.getBottomRightY(), 0);
    }
    
}
