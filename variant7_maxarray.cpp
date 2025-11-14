#include <iostream>
#include <vector>
using namespace std;

// Рекурсивная функция поиска максимума в массиве
int findMax(const vector<int>& arr, int index) {
    // Базовый случай:
    // если мы дошли до последнего элемента — он сам является максимумом
    if (index == arr.size() - 1) {
        return arr[index];
    }

    // Рекурсивный вызов:
    // ищем максимум в оставшейся части массива
    int maxInRest = findMax(arr, index + 1);

    // Возвращаем максимум между текущим элементом и максимумом "хвоста"
    return max(arr[index], maxInRest);
}

int main() {
    int n;
    cout << "Введите количество элементов массива: ";
    cin >> n;

    vector<int> arr(n);
    cout << "Введите элементы массива: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    cout << "Максимальный элемент = " << findMax(arr, 0) << endl;

    return 0;
}
