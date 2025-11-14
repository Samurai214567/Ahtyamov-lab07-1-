#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

// Функция проверяет, можно ли поставить ферзя в (row, col)
// queens[row] = col означает, что в строке row ферзь стоит в столбце col
bool isSafe(const vector<int>& queens, int row, int col) {
    // Проверяем все предыдущие строки (0 .. row-1)
    for (int i = 0; i < row; i++) {
        // 1) Та же колонка
        if (queens[i] == col) {
            return false;
        }
        // 2) Та же диагональ:
        // если разница по строкам равна разнице по столбцам — значит на одной диагонали
        if (abs(queens[i] - col) == abs(i - row)) {
            return false;
        }
    }
    return true;
}

// Рекурсивная функция для расстановки ферзей
// row      — текущая строка, куда пытаемся поставить ферзя
// n        — размер доски (n x n)
// queens   — вектор, где queens[row] = col — позиция ферзя в строке row
// solutions — двумерный вектор для хранения всех найденных решений
void solveNQueens(int row, int n, vector<int>& queens, vector<vector<int>>& solutions) {
    // Базовый случай:
    // если row == n, то мы успешно расставили ферзей во всех строках
    if (row == n) {
        solutions.push_back(queens); // сохраняем найденное решение
        return;
    }

    // Перебираем все столбцы в текущей строке row
    for (int col = 0; col < n; col++) {
        // Проверяем, безопасно ли ставить ферзя в (row, col)
        if (isSafe(queens, row, col)) {
            // Ставим ферзя в эту позицию
            queens[row] = col;

            // Рекурсивно пытаемся расставить ферзей в следующей строке
            solveNQueens(row + 1, n, queens, solutions);

            // Backtracking:
            // можно явно вернуть queens[row] к -1, но не обязательно,
            // так как мы всё равно перезапишем его в следующей попытке
            // queens[row] = -1;
        }
    }
}

// Функция для красивого вывода одной расстановки
void printSolution(const vector<int>& queens) {
    int n = queens.size();
    for (int row = 0; row < n; row++) {
        for (int col = 0; col < n; col++) {
            // Если в этой клетке стоит ферзь — печатаем 'Q', иначе '.'
            if (queens[row] == col) {
                cout << "Q ";
            } else {
                cout << ". ";
            }
        }
        cout << endl;
    }
    cout << endl;
}

int main() {
    int n = 8; // по условию задачи N = 8

    // queens[row] = col — в какой колонке стоит ферзь в данной строке
    vector<int> queens(n, -1);

    // В этот вектор соберём все найденные решения
    vector<vector<int>> solutions;

    // Запускаем рекурсивный поиск
    solveNQueens(0, n, queens, solutions);

    // Вывод количества решений
    cout << "Найдено решений: " << solutions.size() << endl << endl;

    // Вывод всех расстановок
    for (const auto& sol : solutions) {
        printSolution(sol);
    }

    return 0;
}
