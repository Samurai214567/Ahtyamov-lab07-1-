#include <iostream>
#include <string>
using namespace std;

// Рекурсивная функция для переворота строки
string reverseString(const string& s) {
    // Базовый случай:
    // строка пустая или из одного символа — больше нечего переворачивать
    if (s.length() <= 1) {
        return s;
    }

    // Рекурсивный случай:
    // 1. Берём подстроку без первого символа: s.substr(1)
    // 2. Переворачиваем её рекурсивно
    // 3. Добавляем в конец первый символ s[0]
    return reverseString(s.substr(1)) + s[0];
}

int main() {
    string s;

    // Ввод строки
    cout << "Введите строку: ";
    getline(cin, s);

    // Вывод результата
    cout << "Перевёрнутая строка: " << reverseString(s) << endl;

    return 0;
}
