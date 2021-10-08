package edu.ncsu.monopoly;

import java.io.Serializable;

public abstract class Cell implements Serializable, IOwnable{

	private static final long serialVersionUID = 1L;
	private boolean available = true;
	private String name;
	protected Player owner;
	public static final int PRICE = 0;
	
	public String getName() {
		return name;
	}

	@Override
	public Player getOwner() {
		return owner;
	}

	public boolean isAvailable() {
		return available;
	}
	
	public abstract void playAction();

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	void setName(String name) {
		this.name = name;
	}

	@Override
	public void setOwner(Player owner) {
		this.owner = owner;
	}
    
    public String toString() {
        return name;
    }
}
