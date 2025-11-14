#include <iostream>
using namespace std;

// Структура узла бинарного дерева
struct TreeNode {
    int data;
    TreeNode* left;
    TreeNode* right;

    TreeNode(int val) : data(val), left(nullptr), right(nullptr) {}
};

// Рекурсивная функция для подсчёта листьев
int countLeaves(TreeNode* root) {
    // Базовый случай 1:
    // пустое дерево не содержит листьев
    if (root == nullptr) {
        return 0;
    }

    // Базовый случай 2:
    // если оба потомка отсутствуют — это лист
    if (root->left == nullptr && root->right == nullptr) {
        return 1;
    }

    // Рекурсивный случай:
    // считаем листья в правом и левом поддереве
    return countLeaves(root->left) + countLeaves(root->right);
}

int main() {


    TreeNode* root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);
    root->left->left = new TreeNode(4);
    root->right->left = new TreeNode(5);
    root->right->right = new TreeNode(6);

    cout << "Количество листьев: " << countLeaves(root) << endl;

    return 0;
}
