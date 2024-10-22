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

  public int indexOfMouseover() {
    for (int i = 0; i <= HAND_SIZE; i++) {
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
