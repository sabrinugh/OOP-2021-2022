package ie.tudublin;
import processing.core.PApplet;

public class LifeBoard {
    boolean[][] board; // 2D array to create the board
    boolean[][] next;
    int size;
    float cellSize;
    PApplet pa;

    public LifeBoard(int size, PApplet pa) {
        board = new boolean[size][size];
        next = new boolean[size][size];
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
    } // end randomise()s

    // Iterates through the board as we move along the board
    public void update() {
        // if alive cell has 2-3 neighbours - survives
        // if a dead cell has 3 neighbours - comes to life
        // if alive cell hs <2 or >3 neighbours - dies

        for (int row=0; row<size; row++) {
            for (int col=0; col<size; col++) {
                int count = countCellsAround(row, col);
                
                if (isAlive(row, col)) {
                    if (count==2 || count==3) {
                        next[row][col] = true;
                    } else {
                        next[row][col] = false;
                    } // end inner else
                } else { // If the cell is dead
                    if (count==3) { // If there are neighbours, brings cell to life
                        next[row][col] = true;
                    } else { 
                        next[row][col] = false;
                    }
                }
            }
        }


        // Make a copy of the board and swap the boards
        boolean[][] temp;
        temp = board;
        board = next;
        next = temp;
    }

    public int countCellsAround(int row, int col) {
        int count = 0; 

        // The bit goes here
        for (int x=row-1; x<=row+1; x++) {
            for(int y=col-1; y<= col+1; y++) {
                if (!(x==row && y==col)) {
                    if (isAlive(x, y)) {
                        count++;
                    } // end inner if
                } //end outer if
            } // end inner for
        } // end outer for

        return count;
    }

    // Bounce check the array to make sure the row and col are in teh bounds of the array
    public boolean isAlive(int row, int col) {
        // Checking if the cell is in the array
        if (row>=0 && row<size && col >=0 && col<size) {
            return board[row][col];
        } else { // If dead/not part of the array
            return false;
        }
    }

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
