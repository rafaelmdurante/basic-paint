package org.academiadecodigo.whiledcards.paintbrushac;

import org.academiadecodigo.simplegraphics.graphics.*;

public class Brush extends Cell {

    public Brush(int col, int row) {
       super(10,10);
       paintCell();
    }

    @Override
    public void paintCell() {
        getCellRect().setColor(Color.GREEN);
        getCellRect().fill();
    }
}
