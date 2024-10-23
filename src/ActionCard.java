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
