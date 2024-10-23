//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    ActionCard.java, a subclass card of BaseCard
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
public class ActionCard extends BaseCard {
  private String actionType;

  // change
  public ActionCard(int rank, String suit, String actionType) {
    super(rank, suit);
    if (!actionType.equals("peek") && !actionType.equals("spy") && !actionType.equals("switch")) {
      throw new IllegalArgumentException();
    }
    this.actionType = actionType;
  }

  public String getActionType() {
    return actionType;
  }

}
