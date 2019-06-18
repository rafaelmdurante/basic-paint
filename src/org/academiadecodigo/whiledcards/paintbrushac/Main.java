package org.academiadecodigo.whiledcards.paintbrushac;

public class Main {
    public static void main(String[] args) {

        Grid g = new Grid(20, 20, 15);
        Brush b = new Brush(0, 0);
        KeyboardController k = new KeyboardController(g, b);

    }
}
