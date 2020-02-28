import java.util.ArrayList;

public class BinarySearchTree {

    TreeNode root;

    BinarySearchTree() {
        root = null;
    }

    // обойти всё дерево по порядку
    public void inorder() {
        inorderRecursion(this.root,"root");
    }

    /* Рекурсивнивный метод обхода дерева в глубину (LNR)
    Я добавил print стрелочек указывающих на то при каком вызове был отрисован узел, однако такой обход не
    точного представления о структуре дерева */

    private void inorderRecursion(TreeNode node, String direction) {
        if (node == null) {
            if (direction.equals("root")){
            }
            else if(direction.equals("left")){
                System.out.print("< ");
            }
            else if(direction.equals("right")){
                System.out.print("> ");
            }
            return;
        }
        inorderRecursion(node.left,"left");
        System.out.print(node.data + " ");
        inorderRecursion(node.right,"right");

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