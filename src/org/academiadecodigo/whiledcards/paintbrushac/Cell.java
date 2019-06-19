package org.academiadecodigo.whiledcards.paintbrushac;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    // Attributes
    private int size;
    private int row;
    private int col;
    private Rectangle cellRect;

    // Constructor
    public Cell(int col, int row) {
        size = Grid.getCellSize();
        this.col = col;
        this.row = row;
        cellRect = new Rectangle( (Grid.getPadding() + (col * size)), (Grid.getPadding() + (row * size)), size, size);
        cellRect.draw();
    }

    // Getters and Setters
    public int getRow() {
        return row;
    }

    public void setRow(int newRow) {
        row = newRow;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int newCol) {
        col = newCol;
    }

    public boolean isPainted() {
        return cellRect.isFilled();
    }

    public Rectangle getCellRect() {
        return cellRect;
    }

    // Methods
    public void useBrush() {
        if (!getCellRect().isFilled()) {
            paintCell();
        } else {
            eraseCell();
        }
    }

    private void paintCell() {
        this.cellRect.setColor(Color.BLACK);
        this.cellRect.fill();
    }

    public void eraseCell() {
        cellRect.draw();
    }

}
