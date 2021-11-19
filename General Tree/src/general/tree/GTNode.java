package general.tree;

public class GTNode {
    
    private GTNode child;
    private GTNode brother;
    private Object element;
    
    public GTNode(Object element){
        this.child = null;
        this.brother = null;
        this.element = element;
    }

    public GTNode getChild() {
        return child;
    }

    public void setChild(GTNode child) {
        this.child = child;
    }

    public GTNode getBrother() {
        return brother;
    }

    public void setBrother(GTNode brother) {
        this.brother = brother;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }
    
}
