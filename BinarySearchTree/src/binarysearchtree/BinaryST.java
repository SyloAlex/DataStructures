package binarysearchtree;

public class BinaryST {
    
    private TreeNode root;
    
    public BinaryST(){
        this.root = null;
    }
    
    public BinaryST(TreeNode root){
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public TreeNode getLeftChild(TreeNode node){
        return node.getLeftChild();
    }
    
    public TreeNode getRightChild(TreeNode node){
        return node.getRightChild();
    }
    
    public boolean isTerminal(TreeNode node){
        if (node.getLeftChild() == null && node.getRightChild() == null){
            return true;
        }else{
            return false;
        }
    }
    
    public void readElement(TreeNode node){
        if (node != null){
            System.out.println(node.getElement());
        }
    }
    
    public void traversePreorder(TreeNode root){
        this.readElement(root);
        if (root != null){
            this.traversePreorder(root.getLeftChild());
            this.traversePreorder(root.getRightChild());
        }
    }
    
    public void traverseInorder(TreeNode root){
        if (root != null){
            this.traverseInorder(root.getLeftChild());
            this.readElement(root);
            this.traverseInorder(root.getRightChild());
        }
    }
    
    public void traversePostorder(TreeNode root){
        if (root != null){
            this.traversePostorder(root.getLeftChild());
            this.traversePostorder(root.getRightChild());
            this.readElement(root);
        }
    }
    
}
