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
        this.hand = new Hand();  //initialize the hand for the player
    }
    public void addCardToHand(BaseCard card) {
        hand.addCard(card); //adds a card to this player's hand
    }
    public Hand getHand() {
        return hand; // accesses a shallow-copy reference of this player's hand
    }
    public int getLabel() {
        return label; //accesses a label (1-3)
    }
    public String getName() {
        return name; //gets the name of the player
    }
    public boolean isComputer() {
        return isComputer; //reports if computer
    }
}