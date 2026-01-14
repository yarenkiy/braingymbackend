package com.example.gamebackend.service;

import com.example.gamebackend.model.SudokuBoard;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SudokuService {

    private final Random random = new Random();

    public SudokuBoard generateSudoku(String difficulty) {
        int[][] solution = generateCompleteSudoku();
        int[][] puzzle = createPuzzle(solution, difficulty);

        return new SudokuBoard(puzzle, solution);
    }

    private int[][] generateCompleteSudoku() {
        int[][] board = new int[9][9];
        fillBoard(board);
        return board;
    }

    private boolean fillBoard(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
                    shuffleArray(numbers);

                    for (int num : numbers) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (fillBoard(board)) {
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] createPuzzle(int[][] solution, String difficulty) {
        int[][] puzzle = new int[9][9];
        for (int i = 0; i < 9; i++) {
            puzzle[i] = solution[i].clone();
        }

        int cellsToRemove = switch (difficulty.toLowerCase()) {
            case "kolay" -> 30;
            case "orta" -> 40;
            case "zor" -> 50;
            case "cocuk" -> 20;
            default -> 35;
        };

        int removed = 0;
        while (removed < cellsToRemove) {
            int row = random.nextInt(9);
            int col = random.nextInt(9);
            if (puzzle[row][col] != 0) {
                puzzle[row][col] = 0;
                removed++;
            }
        }

        return puzzle;
    }

    private boolean isValid(int[][] board, int row, int col, int num) {
        // Satır kontrolü
        for (int x = 0; x < 9; x++) {
            if (board[row][x] == num) return false;
        }

        // Sütun kontrolü
        for (int x = 0; x < 9; x++) {
            if (board[x][col] == num) return false;
        }

        // 3x3 kutu kontrolü
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) return false;
            }
        }

        return true;
    }

    public boolean validateSudoku(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0) {
                    int num = board[i][j];
                    board[i][j] = 0;
                    if (!isValid(board, i, j, num)) {
                        board[i][j] = num;
                        return false;
                    }
                    board[i][j] = num;
                }
            }
        }
        return true;
    }

    private void shuffleArray(Integer[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            Integer temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}