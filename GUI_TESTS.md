# Test to perform on the GUI
## GUI Interface
1. When you open the application, verify that all the components are correctly rendered according to the protoype
## Load Tests
1. When I click on the Load Button, a file chooser appears and allows me to open the file to upload
2. The file chooser does not allow me to select files with extension other than .json
3. If I try to load a file without the .json extension, no drawing appears
4. When I try to load a drawing while I'm drawing, the old drawing is deleted and the selected drawing is opened
## Save Tests
1. When I click on the Save Button, a file chooser appears and allows me to choose the name file where to save th drawing
2. If I try to choose an extension other than .json, an Alert appears and inform me to choose a .json file
## DrawShapeTool Tests
1. When a draw shape tool is chosen, verify that it creates a point when you click on the Pane
2. When a draw shape tool is chosen, verify that it creates a shape when you perform a drag operation on the pane. Verify that it works in every direction, even outside the window. The shape must have the colors you have chosen on the color pickers
3. When a draw shape tool is chosen, verify it creates a line when you move the mouse only horizontally or vertically
4. When you click on a draw shape tool, verify that the button remains pressed
5. When you click twice on the same shape tool, verify that the button remains pressed
## Selection Tests
1. When selected a shape, trying to select an other shape and in this case is not removed the highlight to the first 
2. When selected a shape, click on empyt space (Pane) and the highlight is removed
3. When selected a shape the border of the shape that highlight the selected shape is in front of all the other shapes
## Resize Shape Tests
### Resize Rectangle Tests
1. When a rectangle is selected, verify that four verices appears on the rectagle vertices
2. When you move a vertex, verify that the shape changes its size according to the mouse coordinates
3. When you move a vertex, verify that you can't go over the opposite vertex
### Resize Ellipse Tests
1. When an ellipse is selected, verify that four verices appears at the end of the ellipse's diameters
2. When you move a vertex, verify that the shape changes its size according to the mouse coordinates
3. When you move a vertex, verify that you can't go over the opposite vertex
### Resize Line Tests
1. When a line is selected, verify that two vertices appears at the line's extremes
2. When you move a vertex, verify that the shape changes its size according to the mouse coordinates