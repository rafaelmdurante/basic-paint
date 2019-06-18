package org.academiadecodigo.whiledcards.paintbrushac;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private Rectangle outerRect;
    private Rectangle grid[][];
    private static final int PADDING = 10;
    private int rows;
    private int cols;
    private int cellSize;
    private int lastState;

    public Grid(int cols, int rows, int cellSize) {
        this.cols = cols;
        this.rows = rows;
        this.cellSize = cellSize;
        grid = new Rectangle[rows][cols];
        createOuterRect(cols, rows);
        createCells();
    }

    private void createOuterRect(int cols, int rows) {
        outerRect = new Rectangle(PADDING, PADDING, cols * cellSize, rows * cellSize);
        outerRect.draw();
    }

    private void createCells() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                grid[row][col] = new Cell()

                grid[row][col] = new Rectangle((PADDING + (col * cellSize)), (PADDING + (row * cellSize)), cellSize, cellSize);
                grid[row][col].draw();
            }
        }
    }

    public void save() {

    }

    public void clear() {

    }



}
