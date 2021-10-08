package edu.ncsu.monopoly;

public class RailRoadCell extends Cell {
	public static final String COLOR_GROUP = "RAILROAD";
	private static int baseRent;
	private static int railRoadPrice;

	public static void setBaseRent(int baseRent) {
		RailRoadCell.baseRent = baseRent;
	}

	public static void setPrice(int railRoadPrice) {
		RailRoadCell.railRoadPrice = railRoadPrice;
	}
	
	public int getPrice() {
		return RailRoadCell.railRoadPrice;
	}

	public int getRent() {
		return RailRoadCell.baseRent * (int)Math.pow(2, owner.numberOfRR() - (double)1);
	}
	
	public void playAction() {
		Player currentPlayer = null;
		if(!isAvailable()) {
			currentPlayer = GameMaster.instance().getCurrentPlayer();
			if(owner != currentPlayer) {
				currentPlayer.payRentTo(owner, getRent());
			}
		}
	}
}
