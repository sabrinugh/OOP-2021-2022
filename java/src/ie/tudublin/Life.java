package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {

	LifeBoard board;
	// 1. Only 2 cells and it will die of loneliness
	// 2. 3 or 2 neighbour cells and it will survive.
	// 3. More than 3 neighbours and it will die of overcrowding
	// 4. 3 neighbours together create a new cell

	public void settings() {
		size(500, 500);
		board = new LifeBoard(100, this);
		
		board.randomise();
		println(board.countCellsAround(1, 1));
	}

	public void setup() {
		colorMode(HSB); // Setting up rgb colour  for any later methods.

	}

	
	public void draw() {
		// board.randomise(); // Makes it look really squiggly but unnecessary
		board.render();
		board.update();
	}
}
