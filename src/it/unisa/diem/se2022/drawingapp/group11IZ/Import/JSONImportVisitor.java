package it.unisa.diem.se2022.drawingapp.group11IZ.Import;

import it.unisa.diem.se2022.drawingapp.group11IZ.Import.exceptions.ImportException;
import it.unisa.diem.se2022.drawingapp.group11IZ.interfaces.Visitor;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.Drawing;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEllipse;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyRectangle;
import javafx.scene.paint.Color;
import org.json.simple.JSONObject;

/**
 * 
 * @author prisc
 */
public class JSONImportVisitor implements Visitor{

    private JSONObject jsonObject;
    private Drawing draw;

    public JSONImportVisitor(JSONObject jsonObject, Drawing draw) {
        if(jsonObject == null || draw == null) throw new NullPointerException();
        this.jsonObject = jsonObject;
        this.draw = draw;
    }

    @Override
    public void visitRectangle(MyRectangle myRectangle) {
        if(myRectangle == null) throw new ImportException();
        if(!jsonObject.containsKey("type")) throw new ImportException();
        if(!jsonObject.get("type").equals("rectangle")) throw new ImportException();
        myRectangle.mySetFill(jsonObject.get("fill") == null ? null: Color.valueOf(jsonObject.get("fill").toString()));
        myRectangle.mySetStroke(jsonObject.get("stroke") == null ? null: Color.valueOf(jsonObject.get("stroke").toString()));
        myRectangle.mySetHeight((double) jsonObject.get("height"));
        myRectangle.mySetWidth((double) jsonObject.get("width"));
        myRectangle.mySetX((double) jsonObject.get("x"));
        myRectangle.mySetY((double) jsonObject.get("y"));
        myRectangle.mySetStrokeWidth((double) jsonObject.get("stroke-width"));
        draw.addShape(myRectangle);
    }

    @Override
    public void visitEllipse(MyEllipse myEllipse) {
        if(myEllipse == null) throw new ImportException();
        if(!jsonObject.containsKey("type")) throw new ImportException();
        if(!jsonObject.get("type").equals("ellipse")) throw new ImportException();
        myEllipse.mySetFill(jsonObject.get("fill") == null ? null: Color.valueOf(jsonObject.get("fill").toString()));
        myEllipse.mySetStroke(jsonObject.get("stroke") == null ? null: Color.valueOf(jsonObject.get("stroke").toString()));
        myEllipse.mySetCenterX((double) jsonObject.get("centerX"));
        myEllipse.mySetCenterY((double) jsonObject.get("centerY"));
        myEllipse.mySetRadiusX((double) jsonObject.get("radiusX"));
        myEllipse.mySetRadiusY((double) jsonObject.get("radiusY"));
        myEllipse.mySetStrokeWidth((double) jsonObject.get("stroke-width"));
        draw.addShape(myEllipse);
    }

    @Override
    public void visitLine(MyLine myLine) {
        if(myLine == null) throw new ImportException();
        if(!jsonObject.containsKey("type")) throw new ImportException();
        if(!jsonObject.get("type").equals("line")) throw new ImportException();
        myLine.mySetFill(jsonObject.get("fill") == null ? null: Color.valueOf(jsonObject.get("fill").toString()));
        myLine.mySetStroke(jsonObject.get("stroke") == null ? null: Color.valueOf(jsonObject.get("stroke").toString()));
        myLine.mySetEndX((double) jsonObject.get("endX"));
        myLine.mySetEndY((double) jsonObject.get("endY"));
        myLine.mySetStartX((double) jsonObject.get("startX"));
        myLine.mySetStartY((double) jsonObject.get("startY"));
        myLine.mySetStrokeWidth((double) jsonObject.get("stroke-width"));
        draw.addShape(myLine);
    } 
    
}
