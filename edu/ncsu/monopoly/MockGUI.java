package edu.ncsu.monopoly;

public class MockGUI implements MonopolyGUI {
    private boolean btnDrawCardState; 
    private boolean btnEndTurnState;
    private boolean btnGetOutOfJailState;
    private boolean[] btnTradeState = new boolean[2];

    public void enableEndTurnBtn(int playerIndex) {
    	throw new UnsupportedOperationException();
    }

    public void enablePlayerTurn(int playerIndex) {
    	throw new UnsupportedOperationException();
    }

    public void enablePurchaseBtn(int playerIndex) {
    	throw new UnsupportedOperationException();
    }
	public int[] getDiceRoll() {
		int[] roll = new int[2];
		roll[0] = 2;
		roll[1] = 3;
		return roll;
	}

    public boolean isDrawCardButtonEnabled() {
        return btnDrawCardState;
    }

    public boolean isEndTurnButtonEnabled() {
        return btnEndTurnState;
    }
	
	public boolean isGetOutOfJailButtonEnabled() {
		return btnGetOutOfJailState;
	}

    public boolean isTradeButtonEnabled(int i) {
        return btnTradeState[i];
    }

    public void movePlayer(int index, int from, int to) {
    	throw new UnsupportedOperationException();
    }

    public RespondDialog openRespondDialog(TradeDeal deal) {
        return new MockRespondDialog(deal);
    }

    public TradeDialog openTradeDialog() {
        return new MockTradeDialog();
    }

    public void setBuyHouseEnabled(boolean b) {
    	throw new UnsupportedOperationException();
    }

    public void setDrawCardEnabled(boolean b) {
        btnDrawCardState = b;
    }

    public void setEndTurnEnabled(boolean enabled) {
        btnEndTurnState = enabled;
    }

    public void setGetOutOfJailEnabled(boolean b) {
    	this.btnGetOutOfJailState = b;
    }

    public void setPurchasePropertyEnabled(boolean enabled) {
    	throw new UnsupportedOperationException();
    }

    public void setRollDiceEnabled(boolean b) {
    	throw new UnsupportedOperationException();
    }

    public void setTradeEnabled(int index, boolean b) {
        this.btnTradeState[index] = b;
    }

    public void showBuyHouseDialog(Player currentPlayer) {
    	throw new UnsupportedOperationException();
    }

    public void showMessage(String string) {
    	throw new UnsupportedOperationException();
    }

	public int showUtilDiceRoll() {
		return 10;
	}

    public void startGame() {
    	throw new UnsupportedOperationException();
    }

	public void update() {
		throw new UnsupportedOperationException();
	}
}
