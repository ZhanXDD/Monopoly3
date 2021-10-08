package edu.ncsu.monopoly;

public class GoCell extends Cell {
	public GoCell() {
		super.setName("Go");
		setAvailable(false);
	}

	public void playAction() {
		throw new UnsupportedOperationException();
	}
	@Override
	void setName(String name) {
		throw new UnsupportedOperationException();
	}
}
