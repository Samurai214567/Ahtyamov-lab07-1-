# Рекурсивная функция поиска максимума в списке
def find_max(arr, index=0):
    # Базовый случай:
    # если индекс указывает на последний элемент — он максимум
    if index == len(arr) - 1:
        return arr[index]

    # Рекурсивно ищем максимум в оставшейся части массива
    max_rest = find_max(arr, index + 1)

    # Возвращаем большее между текущим элементом и максимумом хвоста
    return arr[index] if arr[index] > max_rest else max_rest


if __name__ == "__main__":
    n = int(input("Введите количество элементов: "))
    arr = list(map(int, input("Введите элементы массива: ").split()))

    print("Максимальный элемент =", find_max(arr))
