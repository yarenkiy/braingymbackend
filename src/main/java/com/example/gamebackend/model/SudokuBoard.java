package com.example.gamebackend.model;

public class SudokuBoard {
    private int[][] puzzle;
    private int[][] solution;

    public SudokuBoard() {
    }

    public SudokuBoard(int[][] puzzle, int[][] solution) {
        this.puzzle = puzzle;
        this.solution = solution;
    }

    public int[][] getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(int[][] puzzle) {
        this.puzzle = puzzle;
    }

    public int[][] getSolution() {
        return solution;
    }

    public void setSolution(int[][] solution) {
        this.solution = solution;
    }
}