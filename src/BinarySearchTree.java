import java.util.ArrayList;

public class BinarySearchTree {

    TreeNode root;

    BinarySearchTree() {
        root = null;
    }

    // обойти всё дерево по порядку
    public void inorder() {
        inorderRecursion(this.root);
    }

    // Рекурсивнивный метод обхода дерева по порядку
    private void inorderRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderRecursion(node.left);
        System.out.print(node.data + " ");
        inorderRecursion(node.right);
    }

    // Сохранить все узлы дерева по порядку в ArrayList
    public ArrayList<Integer> saveInorder(TreeNode node) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = saveInorderRecursion(node, list1);

        return list2;
    }

    // Рекурсивный метода для сохранения всех узлов дерева по порядку в ArrayList
    private ArrayList<Integer> saveInorderRecursion(TreeNode node, ArrayList<Integer> list) {
        if (node == null)
            return list;

        saveInorderRecursion(node.left, list);
        list.add(node.data);
        saveInorderRecursion(node.right, list);

        return list;
    }


}