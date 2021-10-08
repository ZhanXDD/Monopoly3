package edu.ncsu.monopoly.gui;

import javax.swing.JOptionPane;

import edu.ncsu.monopoly.*;

public class Main {

	private static int inputNumberOfPlayers(MainWindow window) {
		int numPlayers = 0;
		while(numPlayers <= 0 || numPlayers > GameMaster.MAX_PLAYER) {
			String numberOfPlayers = JOptionPane.showInputDialog(window, "How many players");
			if(numberOfPlayers == null) {
				System.exit(0);
			}
			try {
				numPlayers = Integer.parseInt(numberOfPlayers);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(window, "Please input a number");
			}
			if (numPlayers <= 0 || numPlayers > GameMaster.MAX_PLAYER) {
				JOptionPane.showMessageDialog(window, "Please input a number between one and eight");
			} else {
				GameMaster.instance().setNumberOfPlayers(numPlayers);
			}
		}
		return numPlayers;
	}

	public static void main(String[] args) {
		GameMaster master = GameMaster.instance();
		MainWindow window = new MainWindow();
		GameBoard gameBoard = null;
		if(args.length > 0) {
			if(args[0].equals("test")) {
				master.setTestMode(true);
			}
			gameBoard = new GameBoard();
		}
		else {
			gameBoard = new GameBoardFull();
		}

		master.setGameBoard(gameBoard);
		int numPlayers = inputNumberOfPlayers(window);
		for(int i = 0; i < numPlayers; i++) {
			String name = 
					JOptionPane.showInputDialog(window, "Please input name for Player " + (i+1));
			GameMaster.instance().getPlayer(i).setName(name);
		}
		window.setupGameBoard(gameBoard);
		master.setGUI(window);
		master.startGame();
	}
}
