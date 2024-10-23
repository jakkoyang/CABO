//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    BaseCard.java, the cards for the CaboGame
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
// Online Sources:  Processing Website
//					https://processing.org/reference/loadImage_.html
//
///////////////////////////////////////////////////////////////////////////////
import java.io.File;

public class BaseCard {
  protected boolean faceUp;
  private final int HEIGHT = 70;
  protected static processing.core.PApplet processing;
  protected int rank;
  protected String suit;
  private final int WIDTH = 50;
  private int x;
  private int y;
  private static processing.core.PImage cardBack;
  private processing.core.PImage cardImage;

  public BaseCard(int rank, String suit) {
    if (BaseCard.processing == null) {
      throw new IllegalStateException();
    }
    this.rank = rank;
    this.suit = suit;
    // change
    this.faceUp = false;
    if (BaseCard.cardBack == null) {
      BaseCard.cardBack = processing.loadImage("images" + File.separator + "back.png");
    }
    this.cardImage = processing
        .loadImage("images" + File.separator + rank + "_of_" + suit.toLowerCase() + ".png");
    if (this.cardImage == null || BaseCard.cardBack == null) {
      throw new RuntimeException();
    }

  }

  public static void setProcessing(processing.core.PApplet processing) {
    BaseCard.processing = processing; // Sets the Processing environment to be used by the BaseCard
                                      // class

  }

  public int getRank() {
    if (rank == 13 && suit.equals("Diamonds")) {
      return -1;
    }
    return rank;
  }

  public void setFaceUp(boolean faceUp) {
    this.faceUp = faceUp;
  }

  @Override
  public String toString() {
    return suit + " " + rank;
  }

  public void draw(int xPosition, int yPosition) {
    x = xPosition;
    y = yPosition;
    processing.fill(255);
    processing.rect(xPosition, yPosition, WIDTH, HEIGHT);
    if (faceUp) {
      processing.image(cardImage, xPosition, yPosition, WIDTH, HEIGHT);
    } else {
      processing.image(cardBack, xPosition, yPosition, WIDTH, HEIGHT);
    }
  }

  public boolean isMouseOver() {
    if (processing.mouseX >= x && processing.mouseX <= x + WIDTH && processing.mouseY >= y
        && processing.mouseY <= y + HEIGHT) {
      return true;
    }
    return false;
  }
}
