import java.util.Scanner;

public class Variant10BinaryStrings {

    // Рекурсивный метод для генерации бинарных строк
    // current — уже построенная часть строки
    // n       — требуемая длина бинарной строки
    public static void generateBinaryStrings(String current, int n) {
        // Базовый случай:
        // строка уже нужной длины — выводим её
        if (current.length() == n) {
            System.out.println(current);
            return;
        }

        // Рекурсивный случай:
        // 1. Добавляем '0' и продолжаем строить строку
        generateBinaryStrings(current + "0", n);

        // 2. Добавляем '1' и продолжаем строить строку
        generateBinaryStrings(current + "1", n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ввод длины бинарных строк
        System.out.print("Введите длину бинарных строк n: ");
        int n = sc.nextInt();

        System.out.println("Все бинарные строки длины " + n + ":");
        // Начинаем с пустой строки
        generateBinaryStrings("", n);

        sc.close();
    }
}
