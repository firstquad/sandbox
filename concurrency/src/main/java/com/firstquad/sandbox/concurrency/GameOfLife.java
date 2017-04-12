package com.firstquad.sandbox.concurrency;

/**
 * Created by dmitriy on 04.04.17.
 */
public class GameOfLife {

    public static void main(String[] args) {
        Thread thread = new Thread(new World());
        thread.start();

    }

    private static class World implements Runnable {

        @Override
        public void run() {
            Cell[][] cells = new Cell[10][10];

            fillWorld(cells);

            cells[6][4].makeAlive();
            cells[4][5].makeAlive();
            cells[6][5].makeAlive();
            cells[5][6].makeAlive();
            cells[6][6].makeAlive();


            for (int n = 0; n < 10; n++) {
                for (int i = 0; i < cells.length; i++) {
                    for (int j = 0; j < cells.length; j++) {
                        System.out.print(cells[j][i].isAlive ? "* " : "' ");
//                        System.out.print(cells[i][j].isAlive ? "* " : i +"" + j);
                    }
                    System.out.println();
                }
                System.out.println("\n\n");


                synchronized (this) {
                    try {
                        this.wait(800);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                countAliveNeighbour(cells);

                Cell[][] tmpCells = new Cell[10][10];

                for (int i = 0; i < cells.length; i++) {
                    for (int j = 0; j < cells.length; j++) {
                        tmpCells[i][j] = new Cell(cells[i][j]);
                    }
                }

                for (int i = 0; i < cells.length; i++) {
                    for (int j = 0; j < cells.length; j++) {
                        Cell cell = cells[i][j];
                        Cell tmpCell = tmpCells[i][j];
                        int aliveNeighbour = tmpCell.getCountAliveNeighbour();
                        if (tmpCell.isAlive()) {
                            if (aliveNeighbour < 2)
                                cell.makeDeath();
                            else if (aliveNeighbour == 2 || aliveNeighbour == 3)
                                continue;
                            else if (aliveNeighbour > 3) {
                                cell.makeDeath();
                            }
                        } else {
                            if (aliveNeighbour == 3) {
                                cell.makeAlive();
                            }
                        }
                    }
                }
            }


        }

        private void fillWorld(Cell[][] cells) {
            int maxIndex = cells.length - 1;
            for (int i = 0; i <= maxIndex; i++) {
                for (int j = 0; j <= maxIndex; j++) {
                    Cell cell = new Cell();
                    cells[i][j] = cell;
                }
            }
        }

        private void countAliveNeighbour(Cell[][] cells) {
            int maxIndex = cells.length - 1;
            for (int i = 0; i <= maxIndex; i++) {
                for (int j = 0; j <= maxIndex; j++) {
                    int countAliveNeighbour = 0;
                    if (i != 0) {
                        countAliveNeighbour = addAliveNeighbour(cells[i - 1][j], countAliveNeighbour);
                        if (j != 0)
                            countAliveNeighbour = addAliveNeighbour(cells[i - 1][j - 1], countAliveNeighbour);
                        if (j < maxIndex)
                            countAliveNeighbour = addAliveNeighbour(cells[i - 1][j + 1], countAliveNeighbour);
                    }
                    if (i < maxIndex) {
                        countAliveNeighbour = addAliveNeighbour(cells[i + 1][j], countAliveNeighbour);
                        if (j != 0) {
                            countAliveNeighbour = addAliveNeighbour(cells[i + 1][j - 1], countAliveNeighbour);
                        }
                        if (j < maxIndex) {
                            countAliveNeighbour = addAliveNeighbour(cells[i + 1][j + 1], countAliveNeighbour);
                        }

                    }
                    if (j != 0)
                        countAliveNeighbour = addAliveNeighbour(cells[i][j - 1], countAliveNeighbour);
                    if (j < maxIndex)
                        countAliveNeighbour = addAliveNeighbour(cells[i][j + 1], countAliveNeighbour);
                    cells[i][j].setCountAliveNeighbour(countAliveNeighbour);
                }
            }
        }

        private Integer addAliveNeighbour(Cell cell, Integer countAliveNeighbour) {
            if (cell.isAlive())
                countAliveNeighbour++;
            return countAliveNeighbour;
        }
    }

    private static class Cell {
        boolean isAlive;
        int countAliveNeighbour;

        public Cell() {
        }

        public Cell(boolean isAlive) {
            this.isAlive = isAlive;
        }

        void makeAlive() {
            isAlive = true;
        }

        void makeDeath() {
            isAlive = false;
        }

        public boolean isAlive() {
            return isAlive;
        }

        public Cell(Cell cell) {
            this.isAlive = cell.isAlive();
            this.countAliveNeighbour = cell.getCountAliveNeighbour();
        }

        public int getCountAliveNeighbour() {
            return countAliveNeighbour;
        }

        public void setCountAliveNeighbour(int countAliveNeighbour) {
            this.countAliveNeighbour = countAliveNeighbour;
        }
    }


}
