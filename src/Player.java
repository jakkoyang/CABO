//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Player.java, simulates each player in CaboGame
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
public class Player {
  // setup
  private Hand hand;
  private boolean isComputer;
  private int label;
  private String name;

  // constructor initalizes player obj
  public Player(String name, int label, boolean isComputer) {
    this.name = name;
    this.label = label;
    this.isComputer = isComputer;
    this.hand = new Hand(); // initialize the hand for the player
  }

  public void addCardToHand(BaseCard card) {
    hand.addCard(card); // adds a card to this player's hand
  }

  public Hand getHand() {
    return hand; // accesses a shallow-copy reference of this player's hand
  }

  public int getLabel() {
    return label; // accesses a label (1-3)
  }

  public String getName() {
    return name; // gets the name of the player
  }

  public boolean isComputer() {
    return isComputer; // reports if computer
  }
}
