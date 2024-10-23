//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Deck.java, used by each player and the deck/discards
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
import java.util.Collections;

/**
 * The Deck class represents a deck of playing cards for the game Cabo. It manages a collection of
 * cards, including shuffling, drawing, and adding cards.
 */
public class Deck {
  protected ArrayList<BaseCard> cardList;
  protected static processing.core.PApplet processing;

  public Deck(ArrayList<BaseCard> deck) {
    if (Deck.processing == null) {
      throw new IllegalStateException();
    }
    this.cardList = deck;
  }

  public static void setProcessing(processing.core.PApplet processing) {
    Deck.processing = processing; // Sets the Processing environment to be used by the Deck class
  }

  public BaseCard drawCard() {
    if (isEmpty()) {
      return null;
    }
    BaseCard top = cardList.get(size() - 1);
    cardList.remove(size() - 1);
    return top;
  }

  public void addCard(BaseCard card) {
    cardList.add(card);
  }

  public int size() {
    return cardList.size();
  }

  public boolean isEmpty() {
    return cardList.size() == 0;
  }

  // change
  public void draw(int x, int y, boolean isDiscard) {
    if (isEmpty()) {
      processing.stroke(0);
      processing.fill(0);
      processing.rect(x, y, 50, 70, 7);
      processing.fill(255);
      processing.textSize(12);
      processing.textAlign(processing.CENTER, processing.CENTER);
      processing.text("Empty", x + 25, y + 35);
      return;
    }
    BaseCard topCard = cardList.get(cardList.size() - 1);
    topCard.setFaceUp(isDiscard);
    topCard.draw(x, y);
  }

  /**
   * Sets up the deck with CABO cards, including action cards. Initializes the deck with all
   * necessary cards and shuffles them.
   *
   * @return the completed ArrayList of CABO cards
   */
  public static ArrayList<BaseCard> createDeck() {
    ArrayList<BaseCard> cardList = new ArrayList<>();

    // Define the suits
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

    // Cards from 1 (Ace) to 13 (King)
    for (int rank = 1; rank <= 13; ++rank) {
      // Loop through each suit
      for (String suit : suits) {
        if (rank >= 7 && rank <= 12) {
          // Special action cards
          String actionType = "";
          if (rank == 7 || rank == 8) {
            actionType = "peek";
          } else if (rank == 9 || rank == 10) {
            actionType = "spy";
          } else {
            actionType = "switch";
          }
          cardList.add(new ActionCard(rank, suit, actionType)); // Add ActionCard to deck
        } else {
          cardList.add(new BaseCard(rank, suit)); // Add NumberCard to deck
        }
      }
    }
    Collections.shuffle(cardList);
    return cardList;
  }

}
