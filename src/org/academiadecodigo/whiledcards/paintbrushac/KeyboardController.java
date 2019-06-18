package org.academiadecodigo.whiledcards.paintbrushac;

import org.academiadecodigo.simplegraphics.keyboard.*;

public class KeyboardController implements KeyboardHandler {

    private Brush brush;
    private Cell cell;
    private Cell[][] gridCells;
    private Keyboard keyboard;

    // Constructor
    public KeyboardController(Cell[][] gridCells, Brush brush) {
        this.gridCells = gridCells;
        this.brush = brush;
        assemble();
    }

    public void assemble() {

        keyboard = new Keyboard(this);

        int[] keys = {
                KeyboardEvent.KEY_UP,
                KeyboardEvent.KEY_DOWN,
                KeyboardEvent.KEY_RIGHT,
                KeyboardEvent.KEY_LEFT,
                KeyboardEvent.KEY_SPACE
        };

        for (int key : keys){

            KeyboardEvent event = new KeyboardEvent();
            event.setKey(key);
            event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(event);

        }

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        /**
         * Movement Methods
         */
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            brush.setRow(brush.getRow() - 1);
            brush.move(Direction.UP);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            brush.setRow(brush.getRow() + 1);
            brush.move(Direction.DOWN);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            brush.setCol(brush.getCol() + 1);
            brush.move(Direction.RIGHT);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            brush.setCol(brush.getCol() - 1);
            brush.move(Direction.LEFT);
        }

        /**
         * Paint Commands
         */
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            brush.paintCell();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
