/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.commands;

import it.unisa.diem.se2022.drawingapp.group11IZ.commands.*;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedLine;
import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyEnhancedRectangle;
import it.unisa.diem.se2022.drawingapp.group11IZ.tools.Selection;
import java.lang.reflect.Field;
import javafx.scene.layout.Pane;
import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

/**
 *
 * @author daddy
 */
public class MoveShapeCommandTest {
    
    private Selection selection;
    private MyEnhancedRectangle myEnhancedRectangle;
    private MoveShapeCommand moveCommand;
    
    @Before
    public void setUp(){
        selection = Selection.getInstance();
        myEnhancedRectangle = new MyEnhancedRectangle();
        
        myEnhancedRectangle.mySetX(10);
        myEnhancedRectangle.mySetY(10);
        myEnhancedRectangle.mySetWidth(20);
        myEnhancedRectangle.mySetHeight(10);
    }
    
}
