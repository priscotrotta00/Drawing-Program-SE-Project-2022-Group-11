package it.unisa.diem.se2022.drawingapp.group11IZ.selection;

import it.unisa.diem.se2022.drawingapp.group11IZ.model.MyShape;
import javafx.scene.Group;

/**
 * Describe a helper class for the Selection class to manage the resize functionality.
 * It provides the bounding box that will surround the selected shape
 * @author Felice Scala
 */
interface SelectionHelper {
    
    /**
     * Create the bounding box that will surround the given shape
     * @return A bounding box bindend with the given shape
     */
    public Group createBoundingBox();
    
    /**
     * Destroy the bounding box and remove the preview from the Canvas.
     */
    public void destroyBoundingBox();
    
    /**
     * Get the preview associated to the shape the helper manages
     * @return The preview associated to the shape
     */
    MyShape getPreview();
}
