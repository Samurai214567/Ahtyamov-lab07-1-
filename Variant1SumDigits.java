import java.util.Scanner;

public class Variant1SumDigits {

    // Рекурсивный метод для вычисления суммы цифр
    public static int sumDigits(int n) {
        // Если число отрицательное — делаем его положительным
        if (n < 0) {
            n = -n;
        }

        // Базовый случай рекурсии:
        // когда число стало 0 — больше цифр нет
        if (n == 0) {
            return 0;
        }

        // Рекурсивный случай:
        // n % 10 — последняя цифра
        // sumDigits(n / 10) — сумма остальных цифр
        return n % 10 + sumDigits(n / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ввод числа от пользователя
        System.out.print("Введите число: ");
        int n = sc.nextInt();

        // Вызов рекурсивной функции и вывод результата
        System.out.println("Сумма цифр = " + sumDigits(n));

        sc.close();
    }
}
