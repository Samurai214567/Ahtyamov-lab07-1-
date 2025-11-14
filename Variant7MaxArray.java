import java.util.Scanner;

public class Variant7MaxArray {

    // Рекурсивный метод поиска максимума
    public static int findMax(int[] arr, int index) {
        // Базовый случай:
        // если мы на последнем элементе — он максимум
        if (index == arr.length - 1) {
            return arr[index];
        }

        // Рекурсивный вызов: ищем максимум в хвосте массива
        int maxRest = findMax(arr, index + 1);

        // Возвращаем большее из текущего элемента и рекурсивного максимума
        return (arr[index] > maxRest) ? arr[index] : maxRest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ввод массива
        System.out.print("Введите количество элементов: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Запуск рекурсивного поиска
        System.out.println("Максимальный элемент = " + findMax(arr, 0));

        sc.close();
    }
}
