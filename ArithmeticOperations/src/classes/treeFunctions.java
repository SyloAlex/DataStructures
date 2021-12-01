package classes;

public class treeFunctions {
    
    public treeFunctions(){
    }
    
    public BinaryTree calculate(String polish, HashTable hs){
        TreeStack ts = this.getTreeStack(polish);
        BinaryTree tree = ts.getTop();
        if (hs.getNodeCount() > 0){
            this.varsToNums(tree.getRoot(), hs);
        }
        if (hs.getSignCount() > 0){
            this.varsToNums(tree.getRoot(), hs);
        }
        return tree;
    }
    
    public TreeStack getTreeStack(String polish){
        TreeStack ts = new TreeStack();
        for (int i = 0; i < polish.length(); i++){
            if (Character.isAlphabetic(polish.charAt(i)) 
                    || Character.isDigit(polish.charAt(i))){
                ts.stackNode(new BinaryTree(polish.charAt(i)));
            } else{
                BinaryTree second = ts.unstackNodeReturn();
                BinaryTree first = ts.unstackNodeReturn();
                BinaryTree newTree = new BinaryTree(polish.charAt(i));
                newTree.getRoot().setLeftChild(first.getRoot());
                newTree.getRoot().setRightChild(second.getRoot());
                ts.stackNode(newTree);
            }
        }
        
        return ts;
    }
    
    public void varsToNums(TreeNode root, HashTable hs){
        if (root != null){
            this.varsToNums(root.getLeftChild(), hs);
            if (Character.isAlphabetic(root.getElement().charAt(0))){
                HashNode aux = hs.searchLetter(root.getElement());
                if (aux != null){
                    root.setElement(aux.getNumber());
                }
            } else if (root.getElement().length() == 2 && (root.getElement().charAt(0) == '-' || 
                    root.getElement().charAt(0) == '+')){
                HashNode aux = hs.searchLetter(
                        String.valueOf(root.getElement().charAt(1)));
                if (aux != null){
                    root.setElement(root.getElement().charAt(0) + 
                            aux.getNumber());
                }
            }
            this.varsToNums(root.getRightChild(), hs);
        }
    }
    
}
