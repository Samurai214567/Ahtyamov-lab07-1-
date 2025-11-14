# Задача о N ферзях для N = 8
# Используем backtracking (обратный ход)

def is_safe(queens, row, col):
    """
    Проверяет, можно ли поставить ферзя в позицию (row, col).

    queens[i] = c  означает, что в строке i стоит ферзь в столбце c.
    """
    for i in range(row):
        # 1) Проверка по столбцу: ферзь уже в этом столбце
        if queens[i] == col:
            return False

        # 2) Проверка по диагоналям:
        # если разница по строке равна разнице по столбцу — одна диагональ
        if abs(queens[i] - col) == abs(i - row):
            return False

    return True


def solve_n_queens(row, n, queens, solutions):
    """
    Рекурсивная функция для расстановки ферзей.

    row       — текущая строка, куда пытаемся поставить ферзя
    n         — размер доски
    queens    — список, где queens[row] = col
    solutions — список всех найденных решений
    """
    # Базовый случай:
    # если row == n, значит ферзи успешно расставлены во всех строках
    if row == n:
        solutions.append(queens[:])  # добавляем копию текущей расстановки
        return

    # Перебираем все возможные столбцы в текущей строке
    for col in range(n):
        if is_safe(queens, row, col):
            # Ставим ферзя
            queens[row] = col

            # Рекурсивный переход к следующей строке
            solve_n_queens(row + 1, n, queens, solutions)

            # Backtracking:
            # убираем ферзя (по сути, отметка, что в этой строке пока ничего нет)
            queens[row] = -1


def print_solution(queens):
    """
    Красивый вывод одной расстановки ферзей в виде доски.
    """
    n = len(queens)
    for row in range(n):
        line = []
        for col in range(n):
            if queens[row] == col:
                line.append("Q")
            else:
                line.append(".")
        print(" ".join(line))
    print()


if __name__ == "__main__":
    n = 8  # размер доски 8x8

    # queens[row] = col — в какой колонке стоит ферзь в строке row
    queens = [-1] * n

    # список для хранения всех решений
    solutions = []

    # Запуск рекурсивного решения
    solve_n_queens(0, n, queens, solutions)

    print(f"Найдено решений: {len(solutions)}\n")

    # Вывод всех решений
    for solution in solutions:
        print_solution(solution)
