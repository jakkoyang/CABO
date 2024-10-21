public class ActionCard extends BaseCard {
	private String actionType;
	ActionCard(int rank, String suit, String actionType){
		super(rank, suit);
		this.actionType = actionType;
	}
	public String getActionType() {
		return actionType;
	}
	
}
