/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.unisa.diem.se2022.drawingapp.group11IZ.selection;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.scene.Group;

/**
 * Describe a helper class for the Selection class to manage the resize functionality.
 * It provides the bounding box that will surround the selected shape
 * @author Felice Scala
 */
public interface SelectionHelper {
    
    /**
     * Create the bounding box that will surround the given shape
     * @param shape Shape around which the bounding box will be created
     * @return A bounding box bindend with the given shape
     */
    public Group createBoundingBox(MyShape shape, MyShape preview);
}
