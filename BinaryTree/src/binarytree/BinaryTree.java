package binarytree;

public class BinaryTree {

    public static void main(String[] args) {
        BinaryTreeST tree = new BinaryTreeST();
        tree.setRoot(new TreeNode(3));
        tree.getRoot().setLeftChild(new TreeNode(2));
        tree.getRoot().setRightChild(new TreeNode(4));
        tree.insertNode(new TreeNode(2), new TreeNode(1));
        tree.insertNode(new TreeNode(2), new TreeNode(5));
        tree.insertNode(new TreeNode(4), new TreeNode(6));
        tree.insertNode(new TreeNode(4), new TreeNode(7));
        tree.insertNode(new TreeNode(7), new TreeNode(8));
        tree.traverseInorder(tree.getRoot());
    }
    
}
