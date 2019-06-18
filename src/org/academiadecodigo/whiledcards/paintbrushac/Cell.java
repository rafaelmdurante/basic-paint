package org.academiadecodigo.whiledcards.paintbrushac;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    // Attributes
    private int size;
    private boolean painted;
    private int row;
    private int col;
    private Rectangle cellRect;

    // Constructor
    public Cell(int col, int row) {
        size = Grid.getCellSize();
        this.col = col;
        this.row = row;
        painted = false;
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
        return painted;
    }

    public void setPainted(boolean value) {
        painted = value;
    }

    public Rectangle getCellRect() {
        return cellRect;
    }

    // Methods
    public void useBrush() {
        if (!isPainted()) {
            paintCell();
        } else {
            eraseCell();
        }
    }

    private void paintCell() {
        this.cellRect.setColor(Color.BLACK);
        this.cellRect.fill();
        setPainted(true);
    }

    public void eraseCell() {
        cellRect.draw();
        setPainted(false);
    }

}
