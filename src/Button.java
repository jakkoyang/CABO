//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Button.java, modeling the buttons used in CaboGame
// Course:   CS 300 Fall 2024
//
// Author:   Jakko Yang
// Email:    jyang788@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
// 
// Partner Name:    Hannah Wang
// Partner Email:   jwang2766@wisc.edu
// Partner Lecturer's Name: Hobbes
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   X Write-up states that pair programming is allowed for this assignment.
//   X We have both read and understand the course Pair Programming Policy.
//   X We have registered our team prior to the team registration deadline.
//
//////////////////////// ASSISTANCE/HELP CITATIONS ////////////////////////////
//
// Persons:         Hobbe's Office Hours
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////
public class Button {
  // Private member variables
  private boolean active;
  private int height;
  private String label;
  protected static processing.core.PApplet processing;
  private int width;
  private int x;
  private int y;

  public Button(String label, int x, int y, int width, int height) { // constructor initializes the
                                                                     // Button object
    if (Button.processing == null) {
      throw new IllegalStateException();
    }
    this.label = label;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.active = false; // buttons are inactive by default
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

  public String getLabel() { // return button label
    return label;
  }

  public boolean isActive() { // returns whether the button is currently active
    return active;
  }

  public boolean isMouseOver() { // mouse is currently over this button?
    return processing.mouseX >= x && processing.mouseX <= x + width && processing.mouseY >= y
        && processing.mouseY <= y + height;
  }

  public void setActive(boolean active) { // sets the active state of the button
    this.active = active;
  }

  public void setLabel(String label) { // changes button label
    this.label = label;
  }

  public static void setProcessing(processing.core.PApplet processing) {
    Button.processing = processing; // Sets the Processing environment to be used by the Button
                                    // class
  }
}
