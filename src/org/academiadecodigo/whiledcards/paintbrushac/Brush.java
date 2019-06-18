package org.academiadecodigo.whiledcards.paintbrushac;

import org.academiadecodigo.simplegraphics.graphics.*;

public class Brush extends Cell {

    public Brush(int col, int row) {
       super(col,row);
       highlightBrush();
    }

    public void move(Direction direction) {

        int x;
        int y;

        switch (direction) {
            case UP:
                x = 0;
                y = - (1 * Grid.getCellSize());
                break;
            case DOWN:
                x = 0;
                y = + (1 * Grid.getCellSize());
                break;
            case RIGHT:
                x = + (1 * Grid.getCellSize());
                y = 0;
                break;
            case LEFT:
                x = - (1 * Grid.getCellSize());
                y = 0;
                break;
            default:
                x = 0;
                y = 0;
        }

        getCellRect().translate(x, y);

    }

    public void highlightBrush() {
        getCellRect().setColor(Color.GREEN);
        getCellRect().draw();
        getCellRect().fill();
        getCellRect().grow(0.5,0.5);
    }

}
