package HashMapsAndSets;

import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.isNull;

public class VerifySudokuBoard {

    public static void main(String[] args) {
        int[][] sudoku = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        System.out.println("Result: " + isValidSudoku(sudoku));

    }

    private static boolean isValidSudoku(int[][] sudoku) {
        int row = sudoku.length;
        int col = sudoku[0].length;
        Set[] rowSet = new HashSet[row];
        Set[] colSet = new HashSet[col];
        Set[][] gridSet = new HashSet[row / 3][col / 3];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int currentValue = sudoku[i][j];
                if (currentValue == 0) {
                    continue;
                }
                if (isNull(rowSet[i])) {
                    rowSet[i] = new HashSet<>();
                }
                if (isNull(colSet[j])) {
                    colSet[j] = new HashSet<>();
                }
                if (isNull(gridSet[i / 3][j / 3])) {
                    gridSet[i / 3][j / 3] = new HashSet<>();
                }
                if (rowSet[i].contains(currentValue) ||
                        colSet[j].contains(currentValue) ||
                        gridSet[i / 3][j / 3].contains(currentValue)
                ) {
                    return false;
                }
                rowSet[i].add(currentValue);
                colSet[j].add(currentValue);
                gridSet[i / 3][j / 3].add(currentValue);
            }
        }

        return true;
    }
}
