package org.academiadecodigo.whiledcards.paintbrushac;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;

public class Grid {

    // Attributes
    private Rectangle canvas;
    private Cell grid[][];
    private int rows;
    private int cols;
    private static final int PADDING = 10;
    private static int cellSize;
    private FileWriter fileWriter;
    private FileReader fileReader;
    private BufferedWriter bWriter;
    private BufferedReader bReader;

    // Constructor
    public Grid(int cols, int rows, int cellSize) {
        this.cols = cols;
        this.rows = rows;
        this.cellSize = cellSize;
        createOuterRect();
        createGrid();
        createCells();
        createFileWriter();
        createFileReader();
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
        canvas = new Rectangle(PADDING, PADDING, getCols() * cellSize, getRows() * cellSize);
        canvas.draw();
    }

    private void createGrid() {
        grid = new Cell[getRows()][getCols()];
    }

    private void createCells() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                grid[row][col] = new Cell(col, row);
            }
        }
    }

    private void createFileWriter() {
        try {
            fileWriter = new FileWriter("resources/savedCanvas.txt");
            bWriter = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }

    private void createFileReader() {
        try {
            fileReader = new FileReader("resources/savedCanvas.txt");
            bReader = new BufferedReader(fileReader);
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }

    public void clear() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                grid[row][col].eraseCell();
            }
        }
    }

    public void save() {

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                try {
                    fileWriter.write(String.valueOf( grid[col][row].isPainted()) + ",");
                } catch (IOException e) {
                    System.out.println("IO Exception");
                }
            }
            try {
                fileWriter.write(System.getProperty("line.separator"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }

    public void load() {

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                try {
                    fileReader.read()
                }
            }
        }
    }

}
