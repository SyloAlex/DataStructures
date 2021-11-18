package binarytree;

public class TreeNode {
    
    private Object element;
    private TreeNode leftChild;
    private TreeNode rightChild;
    
    public TreeNode(){
        this.element = null;
        this.leftChild = null;
        this.rightChild = null;
    }
    
    public TreeNode(Object element){
        this.element = element;
        this.leftChild = null;
        this.rightChild = null;
    }
    
    public TreeNode(Object element, TreeNode leftChild, TreeNode rightChild){
        this.element = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
    
}
