import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Variant13NQueens {

    // Проверка, можно ли поставить ферзя в (row, col)
    // queens[i] = c означает: в строке i ферзь в столбце c
    public static boolean isSafe(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            // 1) Проверка по столбцу
            if (queens[i] == col) {
                return false;
            }
            // 2) Проверка по диагоналям
            if (Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    // Рекурсивный метод для расстановки ферзей
    public static void solveNQueens(int row, int n, int[] queens, List<int[]> solutions) {
        // Базовый случай: все строки обработаны, решение найдено
        if (row == n) {
            solutions.add(queens.clone()); // добавляем копию расстановки
            return;
        }

        // Перебор всех столбцов в текущей строке
        for (int col = 0; col < n; col++) {
            if (isSafe(queens, row, col)) {
                // Ставим ферзя
                queens[row] = col;

                // Рекурсивно переходим к следующей строке
                solveNQueens(row + 1, n, queens, solutions);

                // Backtracking:
                // Опционально можно сбросить позицию
                // queens[row] = -1;
            }
        }
    }

    // Красивый вывод одной доски
    public static void printSolution(int[] queens) {
        int n = queens.length;
        for (int row = 0; row < n; row++) {
            StringBuilder line = new StringBuilder();
            for (int col = 0; col < n; col++) {
                if (queens[row] == col) {
                    line.append("Q ");
                } else {
                    line.append(". ");
                }
            }
            System.out.println(line);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 8; // размер доски

        // queens[row] = col — ферзь в строке row стоит в столбце col
        int[] queens = new int[n];
        Arrays.fill(queens, -1);

        // Список для хранения всех решений
        List<int[]> solutions = new ArrayList<>();

        // Запускаем backtracking
        solveNQueens(0, n, queens, solutions);

        System.out.println("Найдено решений: " + solutions.size() + "\n");

        // Вывод всех решений
        for (int[] solution : solutions) {
            printSolution(solution);
        }
    }
}
