class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class Variant17CountLeaves {

    // Рекурсивный метод подсчёта количества листьев
    public static int countLeaves(TreeNode root) {
        // Базовый случай 1: пустой узел — нет листьев
        if (root == null) {
            return 0;
        }

        // Базовый случай 2: если нет детей — это лист
        if (root.left == null && root.right == null) {
            return 1;
        }

        // Рекурсивный случай:
        return countLeaves(root.left) + countLeaves(root.right);
    }

    public static void main(String[] args) {
      

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("Количество листьев: " + countLeaves(root));
    }
}
