/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.export;

import it.unisa.diem.se2022.drawingapp.group11IZ.interfaces.Visitor;
import it.unisa.diem.se2022.drawingapp.group11IZ.export.exceptions.ExportException;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONObject;

/**
 *
 * @author prisc
 */
public class JSONExportVisitor implements Visitor{

    private JSONArray jsonArray;

    public JSONExportVisitor(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }
    
    @Override
    public void visitRectangle(MyRectangle myRectangle) {
        if(myRectangle == null) throw new ExportException();
        JSONObject jsonRectangleObject = new JSONObject();
        jsonRectangleObject.put("type", "rectangle");
        jsonRectangleObject.put("fill", myRectangle.myGetFill());
        jsonRectangleObject.put("stroke", myRectangle.myGetStroke());
        jsonRectangleObject.put("height", myRectangle.myGetHeight());
        jsonRectangleObject.put("width", myRectangle.myGetWidth());
        jsonRectangleObject.put("x", myRectangle.myGetX());
        jsonRectangleObject.put("y", myRectangle.myGetY());
        jsonArray.add(jsonRectangleObject);
    }

    @Override
    public void visitEllipse(MyEllipse myEllipse) {
        if(myEllipse == null) throw new ExportException();
        JSONObject jsonEllipseObject = new JSONObject();
        jsonEllipseObject.put("type", "ellipse");
        jsonEllipseObject.put("fill", myEllipse.myGetFill().toString());
        jsonEllipseObject.put("stroke", myEllipse.myGetStroke());
        jsonEllipseObject.put("centerX", myEllipse.myGetCenterX());
        jsonEllipseObject.put("centerY", myEllipse.myGetCenterY());
        jsonEllipseObject.put("radiusX", myEllipse.myGetRadiusX());
        jsonEllipseObject.put("radiusY", myEllipse.myGetRadiusY());
        jsonArray.add(jsonEllipseObject);
    }

    @Override
    public void visitLine(MyLine myLine) {
        if(myLine == null) throw new ExportException();
        JSONObject jsonLineObject = new JSONObject();
        jsonLineObject.put("type", "line");
        jsonLineObject.put("fill", myLine.myGetFill());
        jsonLineObject.put("stroke", myLine.myGetStroke());
        jsonLineObject.put("endX", myLine.myGetEndX());
        jsonLineObject.put("endY", myLine.myGetEndY());
        jsonLineObject.put("startX", myLine.myGetStartX());
        jsonLineObject.put("startY", myLine.myGetStartY());        
        jsonArray.add(jsonLineObject);
    }
    
}
