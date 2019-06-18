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

    public int getCol() {
        return col;
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
    public int rowToPixel(int row) {
        return (Grid.getPadding() + (row * size));
    }

    public int colToPixel(int col) {
        return (Grid.getPadding() + (col * size));
    }

    public void paintCell() {
        cellRect.setColor(Color.BLACK);
        cellRect.fill();
        setPainted(true);
    }

    public void eraseCell() {
        cellRect.setColor(Color.WHITE);
        cellRect.fill();
        setPainted(false);
    }

}
