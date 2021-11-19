package general.tree;

public class TreeST {
    
    private GTNode root;
    
    public TreeST(GTNode root){
        this.root = root;
    }

    public GTNode getRoot() {
        return root;
    }

    public void setRoot(GTNode root) {
        this.root = root;
    }
    
    public boolean isEmpty(){
        return this.root == null;
    }
    
    public void emptyTree(){
        this.root = null;
    }
    
    public GTNode getLastBrother(GTNode child){
        if (child.getBrother() == null){
            return child;
        }else{
            child = this.getLastBrother(child.getBrother());
        }
        return child;
    }
    
    public GTNode checkBrothers(GTNode brother, GTNode deleter){
        GTNode result = null;
        if (brother != null){
            if (brother.getBrother().getElement() == deleter.getElement()){
                return brother;
            }else{
                result = this.checkBrothers(brother.getBrother(), deleter);
            }
        }
        return result;
    }
    
    public void insertNode(GTNode father, GTNode newNode, GTNode root){
        if(root != null){
            if (root.getElement() == father.getElement()){
                if (root.getChild() == null){
                    root.setChild(newNode);
                } else{
                    GTNode brother = this.getLastBrother(root.getChild());
                    brother.setBrother(newNode);
                }
            } else{
                if (root.getChild() != null){
                    this.insertNode(father, newNode, root.getChild());
                }
                if (root.getBrother() != null){
                    this.insertNode(father, newNode, root.getBrother());
                }
            }
        }else{
            System.out.println("El arbol esta vacio");
        }
    }
    
    public void traverseInorder(GTNode root){
        if (root != null){
            System.out.println(root.getElement());
            this.traverseInorder(root.getChild());
            this.traverseInorder(root.getBrother());
        }
    }
    
    public void traversePreorder(GTNode root){
        if (root != null){
            this.traversePreorder(root.getChild());
            System.out.println(root.getElement());
            this.traversePreorder(root.getBrother());
        }
    }
    
    public void traversePostorder(GTNode root){
        if (root != null){
            this.traversePostorder(root.getChild());
            this.traversePostorder(root.getBrother());
            System.out.println(root.getElement());
        }
    }
    
    public void deleteNode(GTNode deleter, GTNode root){
        if(root != null){
            if (root.getElement() == deleter.getElement()){
                if (root.getElement() == this.root.getElement()){
                    this.emptyTree();
                }
            } else if (root.getChild() != null && root.getChild().getElement() 
                    == deleter.getElement()){
                if (root.getChild().getBrother() == null){
                    root.setChild(null);
                    System.out.println("NODO ELIMINADO");
                } else{
                    root.setChild(root.getChild().getBrother());
                    System.out.println("NODO ELIMINADO");
                }
            } else if (root.getBrother() != null && root.getBrother().getElement() 
                        == deleter.getElement()){
                if (root.getBrother().getBrother() != null){
                    root.setBrother(root.getBrother().getBrother());
                    System.out.println("NODO ELIMINADO");
                } else{
                    root.setBrother(null);
                    System.out.println("NODO ELIMINADO");
                }
            } else{
                if (root.getChild() != null){
                    this.deleteNode(deleter, root.getChild());
                }
                if (root.getBrother() != null){
                    this.deleteNode(deleter, root.getBrother());
                }
            }
        }else{
            System.out.println("El arbol esta vacio");
        }
    }
    
}
