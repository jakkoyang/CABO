import java.util.ArrayList;
import java.util.Collections;
import processing.core.PApplet;

/**
 * The Deck class represents a deck of playing cards for the game Cabo. It manages a collection of
 * cards, including shuffling, drawing, and adding cards.
 */
public class Deck {
  
  // TODO: add everything else
	protected ArrayList<BaseCard> cardList;
	protected static processing.core.PApplet processing;
	Deck(ArrayList<BaseCard> deck){
		if(Deck.processing == null) {
			throw new IllegalStateException();
		}
		cardList = deck;
	}
	public static void setProcessing(processing.core.PApplet processing) {
		Deck.processing = processing;
	}
	public BaseCard drawCard() {
		if(cardList.size() == 0) {
			return null;
		}
		return cardList.get(cardList.size()-1);
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
	public void draw(int x, int y, boolean isDiscard) {
		
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
          cardList.add(new ActionCard(rank, suit, actionType));  // Add ActionCard to deck
        } else {
          cardList.add(new BaseCard(rank, suit));  // Add NumberCard to deck
        }
      }
    }
    Collections.shuffle(cardList);
    return cardList;
  }

}
