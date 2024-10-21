public class Button {
    // Private member variables
    private boolean active;
    private int height;
    private String label;
    protected static processing.core.PApplet processing;
    private int width;
    private int x;
    private int y;
    
    public Button(String label, int x, int y, int width, int height) {  // constructor initializes the Button object
        this.label = label;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.active = false;  // buttons are inactive by default
    }
    public void draw() {
        // Check if the button is active
        if (active) {
            // If mouse is over the button, use a darker fill (150)
            if (isMouseOver()) {
                processing.fill(150);
            } else {
                // Active but not hovered, use a lighter fill (200)
                processing.fill(200);
            }
        } else {
            // Inactive button has a red color fill
            processing.fill(255, 51, 51);
        }
        // Draw the button rectangle with rounded corners
        processing.rect(x, y, width, height, 5);
        // Set text properties (black fill, font size 14)
        processing.fill(0);
        processing.textSize(14);
        processing.textAlign(processing.CENTER, processing.CENTER);
        // Draw the label at the center of the button
        processing.text(label, x + width / 2, y + height / 2);
    }

    public String getLabel() { //return button label
        return label;
    }
    public boolean isActive() {  // returns whether the button is currently active
        return active;
    }
    public boolean isMouseOver() {  //mouse is currently over this button?
        return processing.mouseX >= x && processing.mouseX <= x + width &&
               processing.mouseY >= y && processing.mouseY <= y + height;
    }
    public void setActive(boolean active) { //sets the active state of the button
        this.active = active;
    }
    public void setLabel(String label) {  // changes button label
        this.label = label;
    }
    public static void setProcessing(processing.core.PApplet processing) {
        Button.processing = processing;  // Sets the Processing environment to be used by the Button class
    }
}