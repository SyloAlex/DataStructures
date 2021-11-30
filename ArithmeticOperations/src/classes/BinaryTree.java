package classes;

public class BinaryTree {
    
    private TreeNode root;
    private BinaryTree next;
    
    public BinaryTree(){
        this.root = null;
    }
    
    public BinaryTree(char element){
        TreeNode tn = new TreeNode(String.valueOf(element));
        this.root = tn;
    }
    
    public BinaryTree(TreeNode root){
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
    
    public BinaryTree getNext() {
        return next;
    }

    public void setNext(BinaryTree next) {
        this.next = next;
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
    
    public void insertInRoot(TreeNode child){
        if (this.getRoot().getLeftChild() == null){
            this.getRoot().setLeftChild(child);
        } else{
            this.getRoot().setRightChild(child);
        }
    }
    
//    public boolean searchNode(TreeNode root, TreeNode node){
//        if (root.getLeftChild().getElement().equals(node.getElement()) || 
//                root.getRightChild().getElement().equals(node.getElement())){
//            return true;
//        }else{
//            this.searchNode(root.getLeftChild(), node);
//            this.searchNode(root.getRightChild(), node);
//        }
//        
//        return false;
//    }
//    
//    public TreeNode getNode(TreeNode root, TreeNode node){
//        if (root != null && root.getElement().equals(node.getElement())){
//            return root;
//        }else if (root.getLeftChild() != null && 
//                root.getLeftChild().getElement().equals(node.getElement())){
//            return root.getLeftChild();
//        }else if(root.getRightChild() != null && 
//                root.getRightChild().getElement().equals(node.getElement())){
//            return root.getRightChild();
//        }else{
//            this.getNode(root.getLeftChild(), node);
//            this.getNode(root.getRightChild(), node);
//        }
//        
//        return null;
//    }
//    
//    public TreeNode findNode(TreeNode root, TreeNode node){
//        TreeNode result = null;
//        if (root != null){
//            if(root.getElement().equals(node.getElement())){
//                return root;
//            }
//            if (root.getLeftChild() != null){
//                result = this.findNode(root.getLeftChild(), node);
//            }
//            if (root.getRightChild() != null){
//                if (result == null){
//                    result = this.findNode(root.getRightChild(), node);
//                }
//            }
//            return result;
//        }else{
//            return result;
//        }
//    }
//    
//    public void insertNode(TreeNode father, TreeNode child){
//        TreeNode fatherNode = this.findNode(this.root, father);
//        if (fatherNode != null){
//            if (fatherNode.getLeftChild() == null){
//                fatherNode.setLeftChild(child);
//            }else if (fatherNode.getRightChild() == null){
//                fatherNode.setRightChild(child);
//            }else{
//                System.out.println("No se pudo agregar el nodo");
//            }
//        }else{
//            System.out.println("No se encontro el nodo");
//        }
//    }
//    
//    public TreeNode getFather(TreeNode root, TreeNode child){
//        TreeNode result = null;
//        if (root != null){
//            if(root.getLeftChild() != null && root.getLeftChild() == child){
//                return root;
//            }else if (root.getRightChild() != null && 
//                    root.getRightChild() == child){
//                return root;
//            }
//            if (root.getLeftChild() != null){
//                result = this.getFather(root.getLeftChild(), child);
//            }
//            if (root.getRightChild() != null){
//                if (result == null){
//                    result = this.getFather(root.getRightChild(), child);
//                }
//            }
//            return result;
//        }else{
//            return result;
//        }
//    }
    
}
