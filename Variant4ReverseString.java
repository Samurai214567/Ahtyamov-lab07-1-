import java.util.Scanner;

public class Variant4ReverseString {

    // Рекурсивный метод для переворота строки
    public static String reverseString(String s) {
        // Базовый случай:
        // строка состоит из 0 или 1 символа — переворачивать нечего
        if (s.length() <= 1) {
            return s;
        }

        // Рекурсивный случай:
        // 1. Переворачиваем подстроку, начиная со 2-го символа
        // 2. Добавляем первый символ в конец строки
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ввод строки
        System.out.print("Введите строку: ");
        String s = sc.nextLine();

        // Вывод результата
        System.out.println("Перевёрнутая строка: " + reverseString(s));

        sc.close();
    }
}
