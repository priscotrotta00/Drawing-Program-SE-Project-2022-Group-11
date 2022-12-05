/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.selection;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author utente
 */
public class SelectionLineHelperTest {
    private SelectionLineHelper helper;
    private MyLine line;
    
    @Before
    public void setUp(){
        this.helper = new SelectionLineHelper();
        this.line = new MyEnhancedLine();
    }
    
    @Test
    public void testCreateBoundingBoxEdge(){
        MyLine edge;
        
        this.line.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(line);
        edge = (MyLine) this.helper.getBoundingBoxEdge();
        
        Assert.assertEquals(10, edge.myGetStartX(), 0);
        Assert.assertEquals(10, edge.myGetStartY(), 0);
        Assert.assertEquals(30, edge.myGetEndX(), 0);
        Assert.assertEquals(20, edge.myGetEndY(), 0);
    }
    
    @Test
    public void testCreateBoundingBoxEdgeMoveShape(){
        MyLine edge;
        
        this.line.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(line);
        edge = (MyLine) this.helper.getBoundingBoxEdge();
        
        Assert.assertEquals(10, edge.myGetStartX(), 0);
        Assert.assertEquals(10, edge.myGetStartY(), 0);
        Assert.assertEquals(30, edge.myGetEndX(), 0);
        Assert.assertEquals(20, edge.myGetEndY(), 0);
        
        this.line.modifyShape(50, 50, 80, 70);
        Assert.assertEquals(50, edge.myGetStartX(), 0);
        Assert.assertEquals(50, edge.myGetStartY(), 0);
        Assert.assertEquals(80, edge.myGetEndX(), 0);
        Assert.assertEquals(70, edge.myGetEndY(), 0);
        
        this.line.modifyShape(-30, 40, -10, 50);
        Assert.assertEquals(-30, edge.myGetStartX(), 0);
        Assert.assertEquals(40, edge.myGetStartY(), 0);
        Assert.assertEquals(-10, edge.myGetEndX(), 0);
        Assert.assertEquals(50, edge.myGetEndY(), 0);
    }
    
    @Test
    public void testCreateBoundingBoxEdgeResizeShape(){
        MyLine edge;
        
        this.line.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(line);
        edge = (MyLine) this.helper.getBoundingBoxEdge();
        
        Assert.assertEquals(10, edge.myGetStartX(), 0);
        Assert.assertEquals(10, edge.myGetStartY(), 0);
        Assert.assertEquals(30, edge.myGetEndX(), 0);
        Assert.assertEquals(20, edge.myGetEndY(), 0);
        
        this.line.modifyShape(10, 50, 80, 30);
        Assert.assertEquals(10, edge.myGetStartX(), 0);
        Assert.assertEquals(50, edge.myGetStartY(), 0);
        Assert.assertEquals(80, edge.myGetEndX(), 0);
        Assert.assertEquals(30, edge.myGetEndY(), 0);
        
        this.line.modifyShape(-10, -50, 45, -30);
        Assert.assertEquals(-10, edge.myGetStartX(), 0);
        Assert.assertEquals(-50, edge.myGetStartY(), 0);
        Assert.assertEquals(45, edge.myGetEndX(), 0);
        Assert.assertEquals(-30, edge.myGetEndY(), 0);
    }
    
    @Test
    public void testUpdateVertices(){
        MyRectangle vertex1;
        MyRectangle vertex2;
        double widthVertex;
        double heightVertex;
        
        this.line.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(line);
        vertex1 = this.helper.getVertex1();
        vertex2 = this.helper.getVertex2();
        widthVertex = vertex1.myGetWidth();
        heightVertex = vertex1.myGetHeight();
        
        Assert.assertEquals(10 - widthVertex/2, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(10 - heightVertex/2, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(30 - widthVertex/2, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(20 - heightVertex/2, vertex2.getTopLeftY(), 0);
        
    }
    
    @Test
    public void testUpdateVerticesMoveShape(){
        MyRectangle vertex1;
        MyRectangle vertex2;
        double widthVertex;
        double heightVertex;
        
        this.line.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(line);
        vertex1 = this.helper.getVertex1();
        vertex2 = this.helper.getVertex2();
        widthVertex = vertex1.myGetWidth();
        heightVertex = vertex1.myGetHeight();
        
        Assert.assertEquals(10 - widthVertex/2, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(10 - heightVertex/2, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(30 - widthVertex/2, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(20 - heightVertex/2, vertex2.getTopLeftY(), 0);
        
        this.line.modifyShape(50, 50, 80, 70);
        Assert.assertEquals(50 - widthVertex/2, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(50 - heightVertex/2, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(80 - widthVertex/2, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(70 - heightVertex/2, vertex2.getTopLeftY(), 0);
        
        this.line.modifyShape(-30, 40, -10, 50);
        Assert.assertEquals(-30 - widthVertex/2, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(40 - heightVertex/2, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(-10 - widthVertex/2, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(50 - heightVertex/2, vertex2.getTopLeftY(), 0);
    }
    
    @Test
    public void testUpdateVerticesResizeShape(){
        MyRectangle vertex1;
        MyRectangle vertex2;
        double widthVertex;
        double heightVertex;
        
        this.line.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(line);
        vertex1 = this.helper.getVertex1();
        vertex2 = this.helper.getVertex2();
        widthVertex = vertex1.myGetWidth();
        heightVertex = vertex1.myGetHeight();
        
        Assert.assertEquals(10 - widthVertex/2, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(10 - heightVertex/2, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(30 - widthVertex/2, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(20 - heightVertex/2, vertex2.getTopLeftY(), 0);
        
        this.line.modifyShape(10, 50, 80, 30);
        Assert.assertEquals(10 - widthVertex/2, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(50 - heightVertex/2, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(80 - widthVertex/2, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(30 - heightVertex/2, vertex2.getTopLeftY(), 0);
        
        this.line.modifyShape(-10, -50, 45, -30);
        Assert.assertEquals(-10 - widthVertex/2, vertex1.getTopLeftX(), 0);
        Assert.assertEquals(-50 - heightVertex/2, vertex1.getTopLeftY(), 0);
        Assert.assertEquals(45 - widthVertex/2, vertex2.getTopLeftX(), 0);
        Assert.assertEquals(-30 - heightVertex/2, vertex2.getTopLeftY(), 0);
    }
    
    @Test
    public void testOnMouseDragVertex1Action(){
        this.line.modifyShape(10, 10, 30, 40);
        this.helper.createBoundingBox(line);
        
        this.helper.onMouseDragVertex1Action(0, 0);
        Assert.assertEquals(0, this.line.myGetStartX(), 0);
        Assert.assertEquals(0, this.line.myGetStartY(), 0);
        Assert.assertEquals(30, this.line.myGetEndX(), 0);
        Assert.assertEquals(40, this.line.myGetEndY(), 0);
        
        this.helper.onMouseDragVertex1Action(50, 60);
        Assert.assertEquals(50, this.line.myGetStartX(), 0);
        Assert.assertEquals(60, this.line.myGetStartY(), 0);
        Assert.assertEquals(30, this.line.myGetEndX(), 0);
        Assert.assertEquals(40, this.line.myGetEndY(), 0);
        
        this.helper.onMouseDragVertex1Action(-10, 40);
        Assert.assertEquals(-10, this.line.myGetStartX(), 0);
        Assert.assertEquals(40, this.line.myGetStartY(), 0);
        Assert.assertEquals(30, this.line.myGetEndX(), 0);
        Assert.assertEquals(40, this.line.myGetEndY(), 0);
        
        this.helper.onMouseDragVertex1Action(-40, -70);
        Assert.assertEquals(-40, this.line.myGetStartX(), 0);
        Assert.assertEquals(-70, this.line.myGetStartY(), 0);
        Assert.assertEquals(30, this.line.myGetEndX(), 0);
        Assert.assertEquals(40, this.line.myGetEndY(), 0);
        
        this.helper.onMouseDragVertex1Action(30, 40);
        Assert.assertEquals(30, this.line.myGetStartX(), 0);
        Assert.assertEquals(40, this.line.myGetStartY(), 0);
        Assert.assertEquals(30, this.line.myGetEndX(), 0);
        Assert.assertEquals(40, this.line.myGetEndY(), 0);
    }
    
    @Test
    public void testOnMouseDragVertex2Action(){
        this.line.modifyShape(10, 10, 30, 20);
        this.helper.createBoundingBox(line);
        
        this.helper.onMouseDragVertex2Action(10, 50);
        Assert.assertEquals(10, this.line.myGetStartX(), 0);
        Assert.assertEquals(10, this.line.myGetStartY(), 0);
        Assert.assertEquals(10, this.line.myGetEndX(), 0);
        Assert.assertEquals(50, this.line.myGetEndY(), 0);
        
        this.helper.onMouseDragVertex2Action(60, 90);
        Assert.assertEquals(10, this.line.myGetStartX(), 0);
        Assert.assertEquals(10, this.line.myGetStartY(), 0);
        Assert.assertEquals(60, this.line.myGetEndX(), 0);
        Assert.assertEquals(90, this.line.myGetEndY(), 0);
        
        this.helper.onMouseDragVertex2Action(-100, -50);
        Assert.assertEquals(10, this.line.myGetStartX(), 0);
        Assert.assertEquals(10, this.line.myGetStartY(), 0);
        Assert.assertEquals(-100, this.line.myGetEndX(), 0);
        Assert.assertEquals(-50, this.line.myGetEndY(), 0);
        
        this.helper.onMouseDragVertex2Action(10, 10);
        Assert.assertEquals(10, this.line.myGetStartX(), 0);
        Assert.assertEquals(10, this.line.myGetStartY(), 0);
        Assert.assertEquals(10, this.line.myGetEndX(), 0);
        Assert.assertEquals(10, this.line.myGetEndY(), 0);
        
        this.helper.onMouseDragVertex2Action(40, -40);
        Assert.assertEquals(10, this.line.myGetStartX(), 0);
        Assert.assertEquals(10, this.line.myGetStartY(), 0);
        Assert.assertEquals(40, this.line.myGetEndX(), 0);
        Assert.assertEquals(-40, this.line.myGetEndY(), 0);
    }
}
