# Структура узла бинарного дерева
class TreeNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

# Рекурсивная функция подсчёта количества листьев
def count_leaves(root):
    # Базовый случай 1:
    # пустой узел не содержит листьев
    if root is None:
        return 0

    # Базовый случай 2:
    # если нет детей — это лист
    if root.left is None and root.right is None:
        return 1

    # Рекурсивный случай:
    return count_leaves(root.left) + count_leaves(root.right)


if __name__ == "__main__":

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.right.left = TreeNode(5)
    root.right.right = TreeNode(6)

    print("Количество листьев:", count_leaves(root))
