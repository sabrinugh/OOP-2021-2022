package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet {

    // Implies all data within the arraylist is of class Stars ; this is known as a generic
    ArrayList<Star> stars = new ArrayList<Star>(); // java.util.arraylist

    float border;
    void drawGrid() {
        stroke(255, 0, 255); // Set line strokes to purple
        textAlign(CENTER, CENTER);
        textSize(20);
        for (int i=-5; i<=5; i++) {
            float x = map(i, -5, 5, border, width - border);
            line(x, border, x, height - border);
            line(border, x, width - border, x);
            fill(255);
        
            text(i, x, border *0.5f);
            text(i, border *0.5f, x);
        }
    }

    void printStars() {
        for (Star s:stars) {
            System.out.println(s);
        }
    }


    void loadStars() { // Load cvs file into program 
        Table table = loadTable("HabHYG15ly.csv", "header");
        // Enhanced for loop - used for iterating over collections
        for (TableRow r:table.rows()) { // Iterate through all the rows available in the cvs file
            Star s = new Star(r); // Create new instance of star class - uses constructors within Star.java
            stars.add(s);
        }
    }

    public void settings() {
        size(800, 800);
    }


    public void mouseClicked() {
        
    }

    public void setup() {
        border = width * 0.1f;
        colorMode(RGB);
        loadStars();
        printStars();
    }

    public void drawStars() {
    }

    public void draw() {
        background(0);
        drawGrid();
    }
}