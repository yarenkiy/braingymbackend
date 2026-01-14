package com.example.gamebackend.controller;

import com.example.gamebackend.model.SudokuBoard;
import com.example.gamebackend.service.SudokuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/sudoku")
@CrossOrigin(origins = "http://localhost:3000")
public class SudokuController {

    @Autowired
    private SudokuService sudokuService;

    @GetMapping("/generate/{difficulty}")
    public SudokuBoard generateSudoku(@PathVariable String difficulty) {
        return sudokuService.generateSudoku(difficulty);
    }

    @PostMapping("/validate")
    public Map<String, Boolean> validateSudoku(@RequestBody int[][] board) {
        boolean isValid = sudokuService.validateSudoku(board);
        return Map.of("valid", isValid);
    }
}