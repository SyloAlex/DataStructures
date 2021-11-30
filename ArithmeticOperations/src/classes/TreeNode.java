package classes;

public class TreeNode {
    
    private String element;
    private TreeNode leftChild;
    private TreeNode rightChild;
    
    public TreeNode(){
        this.element = null;
        this.leftChild = null;
        this.rightChild = null;
    }
    
    public TreeNode(String element){
        this.element = element;
        this.leftChild = null;
        this.rightChild = null;
    }
    
    public TreeNode(String element, TreeNode leftChild, TreeNode rightChild){
        this.element = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
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
