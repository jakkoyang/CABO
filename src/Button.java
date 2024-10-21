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
    public void draw() {  // draws the button on the Processing canvas
        if (active) {       // Set button appearance based on active state
            processing.fill(100, 200, 100);  // Active
        } else {
            processing.fill(200);  // Inactive 
        }
        processing.rect(x, y, width, height);  // Draw button rectangle
        // Set text color and alignment
        processing.fill(0);  // Black text
        processing.textAlign(processing.CENTER, processing.CENTER);
        processing.text(label, x + width / 2, y + height / 2);  // Draw button label
    }
    public String getLabel() { //return button label
        return label;
    }
    public boolean isActive() {  // returns whether the button is currently active
        return active;
    }
    public boolean isMouseOver() {  //muse is currently over this button?
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