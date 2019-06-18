package org.academiadecodigo.whiledcards.paintbrushac;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    // Attributes
    private Rectangle outerRect;
    private Cell grid[][];
    private int rows;
    private int cols;
    private static final int PADDING = 10;
    private static int cellSize;
    private int lastState;

    // Constructor
    public Grid(int cols, int rows, int cellSize) {
        this.cols = cols;
        this.rows = rows;
        this.cellSize = cellSize;
        createOuterRect();
        createGridLogic();
        createCells();
    }

    // Getters and Setters
    /**
     * Static method to allow other classes to have access to this data
     * @return
     */
    public static int getCellSize() {
        return cellSize;
    }

    public static int getPadding() {
        return PADDING;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    // Methods
    private void createOuterRect() {
        outerRect = new Rectangle(PADDING, PADDING, getCols() * cellSize, getRows() * cellSize);
        outerRect.draw();
    }

    private void createGridLogic() {
        grid = new Cell[getRows()][getCols()];
    }

    private void createCells() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                grid[row][col] = new Cell(col, row);
            }
        }
    }

    public void save() {

    }

    public void clear() {

    }



}
