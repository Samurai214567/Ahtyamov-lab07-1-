#include <iostream>
#include <string>
using namespace std;

// Рекурсивная функция для генерации бинарных строк
// s      — текущая строка (мы её изменяем по ходу рекурсии)
// index  — текущая позиция, которую заполняем (от 0 до n-1)
void generateBinaryStrings(string& s, int index) {
    int n = s.length();

    // Базовый случай:
    // если index == n, значит все позиции уже заполнены
    // можно выводить готовую бинарную строку
    if (index == n) {
        cout << s << endl;
        return;
    }

    // Рекурсивный случай:
    // 1. Ставим '0' на текущую позицию и идём рекурсивно дальше
    s[index] = '0';
    generateBinaryStrings(s, index + 1);

    // 2. Ставим '1' на текущую позицию и снова идём дальше
    s[index] = '1';
    generateBinaryStrings(s, index + 1);
}

int main() {
    int n;
    cout << "Введите длину бинарных строк n: ";
    cin >> n;

    // Создаём строку длины n (по умолчанию, например, из нулей)
    string s(n, '0');

    cout << "Все бинарные строки длины " << n << ":" << endl;
    generateBinaryStrings(s, 0);

    return 0;
}
