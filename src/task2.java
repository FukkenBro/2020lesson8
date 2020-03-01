import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class task2 {
    //    2*) Написать метод для обьединения 2 бинарных дерева:
//    https://www.dropbox.com/s/lrblb3vjfi1qkwm/tree.png?dl=0
//    В качестве параметра передается 2 ссылки на корневые узлы девева TreeNode, результат - корневой узел нового дерева TreeNode.

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
        tree1.root.left.left = new TreeNode(5);
        tree1.root.right = new TreeNode(2);
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
        tree2.root.left.right = new TreeNode(4);
        tree2.root.right = new TreeNode(3);
        tree2.root.right.right = new TreeNode(7);
        System.out.println("Обход по порядку дерева #2 : ");
        tree2.inorder();
        System.out.println();

        merge(tree1.root, tree2.root);
        System.out.println("Result : ");
        tree1.inorder();
    }

    static public TreeNode merge(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.data += t2.data;
        t1.left = merge(t1.left, t2.left);
        t1.right = merge(t1.right, t2.right);
        return t1;
    }


}
