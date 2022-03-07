package ie.tudublin;
import processing.core.PApplet;

public class LifeBoard {
    boolean[][] board; // 2D array to create the board
    int size;
    float cellSize;
    PApplet pa;

    public LifeBoard(int size, PApplet pa) {
        board = new boolean[size][size];
        this.size = size;
        this.pa = pa;
        cellSize = pa.width / (float) size;
    }

    // Sets 50% of the board as true and 50% false
    public void randomise() {
        for (int row=0; row<size; row++) {
            for (int col=0; col<size; col++) {
                /*
                float dice = pa.random(1.0f); // Gives random value between 0 and 1
                if (dice<0.5f) {
                    board[row][col];
                } // end if
                */
                board[row][col] = pa.random(1.0f)>0.5f;
            } //end inner for
        } // end outer for
    } // ebd randomise()s

    public void render() {
        pa.background(0);
        
        for (int row=0; row<size; row++) {
            for (int col=0; col<size; col++) {
                float x = PApplet.map(col, 0, size, 0, pa.width);
                float y = PApplet.map(row, 0, size, 0, pa.height);

                // Or x = cellSize * col;
                // y = cellSize * row;
                if (board[row][col]) {
                    pa.fill(100,200,150);
                } else {
                    pa.noFill();
                }

                pa.rect(x, y, cellSize, cellSize);
            }
        }
    } // end render()
    
} // end LifeBoard()
