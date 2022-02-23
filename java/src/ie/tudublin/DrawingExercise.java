package ie.tudublin;

import processing.core.PApplet;

public class DrawingExercise extends PApplet {

    Star[] stars = new Star[500];

    float speed;

    class Star {
        float x, y, z;
        float pz; // previous z

        Star() {
            x = random(-width, width);
            y = random(-height, height);
            //using z to divide by some value so they get bigger a smove to edge
            z = random(width); //3d to create illusion of stars moving fast
        
            //making more variable to help create streak from their initial location
            //to their current location
            pz = z; 
        }

        void update() {
            //speed is global so that it can be controlled by the mouse
            z = z - speed;
            if (z < speed){
                z = width;
                x = random(-width, width);
                y = random(-height, height);
                pz = z;
            }

        }

        void show() {
            fill(255);
            noStroke();

            //we want them to start
            float sx = map(x / z, 0, 1, 0, width);
            float sy = map(y / z, 0, 1, 0, height);

            //as the stars get closer they get bigger
            float r = map(z, 0, width, 16, 0);
            //ellipse(sx, sy, r, r);

            float px = map(x / pz, 0, 1, 0, width);
            float py = map(y / pz, 0, 1, 0, height);

            pz = z;

            stroke(255);
            line(px, py, sx, sy);
        }

    }

	public void settings() {
        size(500, 500);

	}

	public void setup() {

        for(int i = 0; i < stars.length; i++){
            stars[i] = new Star();
        }

	}

    public void draw() {

        //mouse can determin the speed
        speed = map(mouseX, 0, width, 0, 50);
        background(0);
        translate(width/2, height/2); //we want to be translating to the centre not the top left
        for(int i = 0; i < stars.length; i++){
            stars[i].update();
            stars[i].show();
        }
    }
}