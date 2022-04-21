package ie.tudublin;
import processing.core.PApplet;
public class BugZap extends PApplet {
    public void settings() {
        size(500,500);
    }
    
    float playerX = 150;
    float playerY = 150;
    float playerWidth = 250;

    /* Write a method called void void drawPlayer(float x, float y,
     loat w) that draws the player character, centered around the 
    parameters x, y. You can use the line method to do this. 
    You can pass variables as parameters to this method and also things 
    like x + 20, w * 0.5f etc. I made an extra variable in this method 
    called h for the height and set it to be half the w parameter. 
    Don't forget to set the stroke color!
    */
    public void drawPlayer (float x, float y, float w){
        stroke(0);
        line((width/2)-(playerX/2), (height-playerY), (width/2)+(playerX), (height-playerY));

    }

    public void setup() {
        background(255, 255, 255);
        draw();
    }

    public void draw() {
        drawPlayer(playerX, playerY, playerWidth);
    }
}
