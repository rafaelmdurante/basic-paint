package org.academiadecodigo.whiledcards.paintbrushac;

import org.academiadecodigo.simplegraphics.keyboard.*;

public class KeyboardController implements KeyboardHandler {

    private Brush brush;
    private Grid grid;
    private Cell[][] gridCells;
    private Keyboard keyboard;

    // Constructor
    public KeyboardController(Grid grid, Brush brush) {
        this.grid = grid;
        this.brush = brush;
        gridCells = grid.getGrid();
        assemble();
    }

    public void assemble() {

        keyboard = new Keyboard(this);

        int[] keys = {
                KeyboardEvent.KEY_UP,
                KeyboardEvent.KEY_DOWN,
                KeyboardEvent.KEY_RIGHT,
                KeyboardEvent.KEY_LEFT,
                KeyboardEvent.KEY_SPACE,
                KeyboardEvent.KEY_C,
                KeyboardEvent.KEY_S,
                KeyboardEvent.KEY_L
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
            if (brush.getRow() - 1 < 0) {
                return;
            }
            brush.setRow(brush.getRow() - 1);
            brush.move(Direction.UP);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            if (brush.getRow() + 1 > grid.getRows() - 1) {
                return;
            }
            brush.setRow(brush.getRow() + 1);
            brush.move(Direction.DOWN);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            if (brush.getCol() + 1 > grid.getCols() - 1) {
                return;
            }
            brush.setCol(brush.getCol() + 1);
            brush.move(Direction.RIGHT);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            if (brush.getCol() - 1 < 0) {
                return;
            }
            brush.setCol(brush.getCol() - 1);
            brush.move(Direction.LEFT);
        }

        /**
         * Paint Commands
         */
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            gridCells[brush.getRow()][brush.getCol()].useBrush();
        }

        /**
         * Clear Grid
         */
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_C) {
            grid.clear();
        }

        /**
         * Save and Load methods
         */
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            System.out.println("Saving file...");
            grid.save();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_L) {
            grid.load();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
