package edu.ncsu.monopoly;

import java.util.Random;

public class Die {
	Random r = new Random();
	
	public int getRoll() {
		return r.nextInt(6);
	}
}
