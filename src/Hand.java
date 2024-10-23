//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Hand.java, a subclass of Deck and encapulated by Player (has-a)
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
import java.util.ArrayList;

public class Hand extends Deck {
  private final int HAND_SIZE = 4;

  public Hand() {
    super(new ArrayList<BaseCard>());
  }

  @Override
  public void addCard(BaseCard card) {
    if (cardList.size() == 4) {
      throw new IllegalStateException();
    }
    cardList.add(card);
  }

  public BaseCard swap(BaseCard newCard, int index) {
    BaseCard old = cardList.get(index);
    cardList.set(index, newCard);
    return old;
  }

  public void switchCards(int myIndex, Hand otherHand, int otherIndex) {
    BaseCard myCard = this.cardList.get(myIndex);
    BaseCard otherCard = otherHand.cardList.get(otherIndex);
    this.cardList.set(myIndex, otherCard);
    otherHand.cardList.set(otherIndex, myCard);
  }

  public void setFaceUp(int index, boolean faceUp) {
    cardList.get(index).setFaceUp(faceUp);
  }

  public void draw(int y) {
    for (int i = 0; i < cardList.size(); i++) {
      int x = 50 + 60 * i; // calculate x
      BaseCard card = cardList.get(i);
      card.draw(x, y); // draw at pos
    }
  }

  public int indexOfMouseOver() {
    for (int i = 0; i < HAND_SIZE; i++) {
      if (cardList.get(i).isMouseOver()) {
        return i;
      }
    }
    return -1;
  }

  public int getRankAtIndex(int index) {
    return cardList.get(index).getRank();
  }

  public int calcHand() {
    int total = 0;
    for (BaseCard c : cardList) {
      total += c.getRank();
    }
    return total;
  }
}
