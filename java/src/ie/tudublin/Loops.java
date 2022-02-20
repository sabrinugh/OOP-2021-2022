package ie.tudublin;

import processing.core.PApplet;

<<<<<<< HEAD
public class Loops extends PApplet
{
=======
public class Loops extends PApplet {

>>>>>>> master
	int mode = 0;

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);

	}

	public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		println(mode);
	}

	float magicMap(float a, float b, float c, float d, float e) {
		float output;
		a -= b;
		c -= b;
		e -= d;

		output = ((a / c) * e) + d;

		return output;
	}

	float magicMap1(float a, float b, float c, float d, float e) {
		float r1 = c - b;
		float r2 = e - d;
		float howFar = a - b;

		return d + ((howFar / r1) * r2);
	}

<<<<<<< HEAD
	float offset =0;
	
	public void draw()
	{
		
		switch(mode)	
		{
=======
	float offset = 0;

	public void draw() {
		switch (mode) {
>>>>>>> master
			case 0:
			{
				background(0);
				int bars = (int) (mouseX / 20.0f);
				float w = width / (float) bars;
				for (int i = 0; i < bars; i++) {
					noStroke();
					fill(map(i, 0, bars, 0, 255), 255, 255);
					rect(map(i, 0, bars, 0, 500), 0, w, height);
				}
				break;
<<<<<<< HEAD
			}

			case 1:
			{
				background(0);
				int squares = (int) (mouseX / 20.0f); // Mouse position determines size of squares
				float h = width / (float) squares; // Number of squares going across
				for (int i=0; i<squares; i++) {
					noStroke();
					fill(map(i, 0, squares, 0, 255), 255, 255);
					float x = map(i, 0, squares, 0, width); // Height
					rect(x, x, h, h);
					rect((width-h), -x, x, h, h);
				}
			} // Gives it scope; making all variables localised

=======
			case 1: {
				background(0);
				int squares = (int) (mouseX / 20.0f);
				float h = width / (float) squares;
				for (int i = 0; i < squares; i++) {
					noStroke();
					fill(map(i, 0, squares, 0, 255), 255, 255);
					float x = map(i, 0, squares, 0, width);
					rect(x, x, h, h);
					rect((width - h) - x, x, h, h);
				}
			}
>>>>>>> master
				break;
			case 2:
				background(255);
				int circles = (int) (mouseX / 20.0f);
				offset += (mouseY / 100.0f);
				float d = width / (float) circles;
				for (int j = 0; j < circles; j++) {
					for (int i = 0; i < circles; i++) {
						noStroke();
						float c = map((i + j + offset), 0, circles * 2, 0, 255) % 256;
						fill(c, 255, 255);
						float x = map(i, 0, circles - 1, d / 2.0f, width - (d / 2.0f)); 
						float y = map(j, 0, circles - 1, d / 2.0f, width - (d / 2.0f)); 
						circle(x, y, d);
					}
				}

				// map(a,b,c,d,e);
				// a = inputvalue
				// b - c - start and end of the first range
				// d, e 0 - start and and of the end range

				// map(-2, 10, 90, 200, 233);

			case 2: // Row of circles
			{
				// background(); Set white background
				int circles = (int) (mouseX/20.0f);
				float d = width / (float) circles; // Diameter

				for (int i=0; i<circles; i++) {
					noStroke();
					fill(map(i, 0, circles, 0, 255), 255, 255);
					circle(map(i, 0, circles-1, d/2, width-(d-2.0f)),height/2, d);
				}
			} // Scope; localises variables

			case 3: // Rows of circles
			{
				background(255); // Set white background
				int circles = (int) (mouseX/20.0f);
				offset += mouseY; // Changes colour as mouse move up and down the screen
				float d = width / (float) circles; // Diameter

				for (int j=0; j<circles; j++) {
					for (int i=0; i<circles; i++) {
						noStroke();
						float c = map((i+j+offset), 0, circles*2, 0, 255)%256; // Cycle throughout the 255 range
						fill(c, 255, 255);
						float x = map(i, 0, circles-1, d/2.0f, width-(d/2.0f));
						fill(map(i, 0, circles, 0, 255), 255, 255);
						float y = map(i, 0, circles-1, d/2.0f, width-(d/2.0f));
						circle(x, y, d);
					}
				}
			} // Scope; localises variables


		}
	}
}
