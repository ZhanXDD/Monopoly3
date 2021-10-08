package edu.ncsu.monopoly;

public class JailCell extends Cell {
	public static final int BAIL = 50;
	
	public JailCell() {
		setName("Jail");
	}
	
	public void playAction() {
		throw new UnsupportedOperationException();
	}
}
