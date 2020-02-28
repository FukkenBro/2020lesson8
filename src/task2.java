import java.util.ArrayList;
import java.util.LinkedHashSet;

public class task2 {
    //    2*) Написать метод для обьединения 2 бинарных дерева:
//    https://www.dropbox.com/s/lrblb3vjfi1qkwm/tree.png?dl=0
//    В качестве параметра передается 2 ссылки на корневые узлы девева TreeNode, результат - корневой узел нового дерева TreeNode.

// Java program to Merge Two Balanced Binary Search Trees

    public static void main(String[] args) {

		/* Tree #1
			     1
				/ \
			   3   2
			  /
			 5
		*/

        BinarySearchTree tree1 = new BinarySearchTree();
        tree1.root = new TreeNode(1);
        tree1.root.left = new TreeNode(3);
        tree1.root.right = new TreeNode(2);
        tree1.root.left.left = new TreeNode(5);
        System.out.println("Обход по порядку дерева #1 : ");
        tree1.inorder();
        System.out.println();

		/* Tree #2
				 2
				/ \
			   1   3
			    \   \
			     4   7
		*/

        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.root = new TreeNode(2);
        tree2.root.left = new TreeNode(1);
        tree2.root.left.left = new TreeNode(4);
        tree2.root.right = new TreeNode(3);
        tree2.root.right.right = new TreeNode(7);
        System.out.println("Обход по порядку дерева #2 : ");
        tree2.inorder();
        System.out.println();

        BinarySearchTree resultTree = new BinarySearchTree();
        resultTree.root = mergeTrees(tree1, tree2);
        System.out.println("Обход по порядку дерева-result : ");
        resultTree.inorder();
        System.out.println();
    }

    //рекурсивная конвертация ArrayList >> BinarySearchTree
    static TreeNode ALtoBST(ArrayList<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        //Средний элемент становится корнем
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = ALtoBST(list, start, mid - 1);
        node.right = ALtoBST(list, mid + 1, end);
        return node;
    }

    static ArrayList<Integer> mergeArrays(ArrayList<Integer> list1, ArrayList<Integer> list2, int m, int n) {

        ArrayList<Integer> result = new ArrayList<>();

        //индекс обхода дерева #1
        int i = 0;
        //индекс обхода дерева #2
        int j = 0;

        //обход обоих дерьев
        while (i < m && j < n) {
            if (list1.get(i) < list2.get(j)) {
                result.add(list1.get(i));
                i++;
            } else {
                result.add(list2.get(j));
                j++;
            }
        }
        while (i < m) {
            result.add(list1.get(i));
            i++;
        }
        while (j < n) {
            result.add(list2.get(j));
            j++;
        }
        return result;
    }

    static TreeNode mergeTrees(BinarySearchTree tree1, BinarySearchTree tree2) {
        ArrayList<Integer> list1 = tree1.saveInorder(tree1.root);
        ArrayList<Integer> list2 = tree2.saveInorder(tree2.root);

        ArrayList<Integer> list3 = mergeArrays(list1, list2, list1.size(), list2.size());
        LinkedHashSet<Integer> set3 = new LinkedHashSet<>(list3);
        list3 = new ArrayList<>(set3);

        int n = list3.size() - 1;
        TreeNode node = ALtoBST(list3, 0, n);
        return node;
    }


}
