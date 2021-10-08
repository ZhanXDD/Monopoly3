package edu.ncsu.monopoly;

import junit.framework.TestCase;

public class CardsTest extends TestCase {
    Card ccCard;
    Card chanceCard;
    
    GameMaster gameMaster;
    
    @Override
    protected void setUp() {
        gameMaster = GameMaster.instance();
        gameMaster.setGameBoard(new GameBoardCCGainMoney());
        gameMaster.setNumberOfPlayers(1);
        gameMaster.reset();
        gameMaster.setGUI(new MockGUI());
        ccCard = new MoneyCard("Get 50 dollars", 50, Card.TYPE_CC);
        chanceCard = new MoneyCard("Lose 50 dollars", -50, Card.TYPE_CHANCE);
        gameMaster.getGameBoard().addCard(ccCard);
    }
    
    public void testCardType() {
        assertEquals(Card.TYPE_CC, ccCard.getCardType());
        assertEquals(Card.TYPE_CHANCE, chanceCard.getCardType());
    }
}
