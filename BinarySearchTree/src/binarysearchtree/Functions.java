package binarysearchtree;

public class Functions {
    
    public Functions(){
    }
    
    public class TwoLists {
        
        private SimpleList listMinor;
        private SimpleList listMayor;
        
        public TwoLists(){
            this.listMinor = null;
            this.listMayor = null;
        }
        
        public TwoLists(SimpleList listMinor, SimpleList listMayor){
            this.listMinor = listMinor;
            this.listMayor = listMayor;
        }

        public SimpleList getlistMinor() {
            return listMinor;
        }

        public void setlistMinor(SimpleList listMinor) {
            this.listMinor = listMinor;
        }

        public SimpleList getlistMayor() {
            return listMayor;
        }

        public void setlistMayor(SimpleList listMayor) {
            this.listMayor = listMayor;
        }
        
    }
    
    public SimpleNode findRoot(SimpleList numList){
        int half = (numList.getSize()/2) + 1;
        SimpleNode aux = numList.getFirst();
        for (int i = 0; i < half; i++){
            if (i == half - 1){
                break;
            }
            aux = aux.getNext();
        }
        return aux;
    }
    
    public void deleteRoot(SimpleList numList){
        int half = (numList.getSize()/2) + 1;
        SimpleNode aux = numList.getFirst();
        for (int i = 0; i < half; i++){
            if (i == half - 1){
                numList.deleteNode(i);
            }
        }
    }
    
    public TwoLists getNewLists(SimpleList numList){
        int half = (numList.getSize()/2) + 1;
        SimpleList list1 = new SimpleList();
        SimpleList list2 = new SimpleList();
        SimpleNode halfNode = this.findRoot(numList);
        SimpleNode aux = numList.getFirst();
        if (numList.getSize() > 2){
            for (int i = 0; i < numList.getSize(); i++){
                if (i < half - 1){
                    list1.addLast(aux.getElement());
                }else if (i > half - 1){
                    list2.addLast(aux.getElement());
                }
                aux = aux.getNext();
            }
        }else if (numList.getSize() == 2){
            list1.addLast(aux.getElement());
        }
        return new TwoLists(list1, list2);
    }
    
    public TreeNode fillTree(SimpleList minorList, SimpleList mayorList, 
            TreeNode root){
        if (!minorList.isEmpty()){
            SimpleNode leftChildNode = this.findRoot(minorList);
            TreeNode leftChild = new TreeNode(leftChildNode.getElement());
            root.setLeftChild(leftChild);
            TwoLists lists = this.getNewLists(minorList);
            root.setLeftChild(this.fillTree(lists.getlistMinor(), lists.getlistMayor(), 
                    root.getLeftChild()));
        }
        if (!mayorList.isEmpty()){
            SimpleNode rightChildNode = this.findRoot(mayorList);
            TreeNode rightChild = new TreeNode(rightChildNode.getElement());
            root.setRightChild(rightChild);
            TwoLists lists = this.getNewLists(mayorList);
            root.setRightChild(this.fillTree(lists.getlistMinor(), lists.getlistMayor(), 
                    root.getRightChild()));
        }
        
        return root;
    }
    
    public BinaryST createTree(SimpleList numList){
        BinaryST SBT = new BinaryST();
        SimpleNode root = this.findRoot(numList);
        TwoLists lists = this.getNewLists(numList);
        TreeNode treeRoot = new TreeNode(root.getElement());
        treeRoot = this.fillTree(lists.getlistMinor(), 
                lists.getlistMayor(), treeRoot);
        SBT.setRoot(treeRoot);
        
        return SBT;
    }
    
}
