package classes;

public class HashTable {
    
    private int size;
    private int nodeCount;
    private HashNode table[];
    
    public HashTable(int size){
        this.size = size;
        this.nodeCount = 0;
        this.table = new HashNode[this.size];
        for (int i = 0; i < this.size; i++){
            this.table[i] = null;
        }
    }
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(int nodeCount) {
        this.nodeCount = nodeCount;
    }

    public HashNode[] getTable() {
        return table;
    }

    public void setTable(HashNode[] table) {
        this.table = table;
    }
    
    public void emptyTable(){
        for (int i = 0; i < this.getSize(); i++){
            this.getTable()[i] = null;
        }
    }
    
    public int hashing(String letter){
        int value = 0;
        for (int i = 0; i < letter.length(); i++){
            if (letter.codePointAt(i) == 46){
                value += 0;
            } else if(letter.codePointAt(i) >= 65 && letter.codePointAt(i) <= 90){
                value += ((letter.codePointAt(i) - 64));
            } else if(letter.codePointAt(i) >= 97 && letter.codePointAt(i) <= 122){
                value += ((letter.codePointAt(i) - 70));
            }
        }
        
        return (value % this.getSize());
    }
    
    public HashNode hashFunction(String letter, String number){
        int position = this.hashing(letter);
        boolean exist = false;
        if (this.getTable()[position] != null){
            HashNode aux = this.getTable()[position];
            boolean flag = false;
            while (!flag){
                if (aux.getLetter().equals(letter)){
                    flag = true;
                    exist = true;
                } else{
                    if (aux.getNext() != null){
                        aux = aux.getNext();
                    } else{
                        flag = true;
                    }
                }
            }
            if (!exist){
                HashNode newWord = new HashNode(number, letter);
                aux.setNext(newWord);
                this.nodeCount += 1;
            }
            return aux;
        } else{
            HashNode newWord = new HashNode(number, letter);
            this.getTable()[position] = newWord;
            this.nodeCount += 1;
            return newWord;
        }
    }
    
    public HashNode searchLetter(String letter){
        int position = this.hashing(letter);
        HashNode aux = this.getTable()[position];
        if (aux != null){
            boolean flag = false;
            while (!flag){
                if (aux.getLetter().equals(letter)){
                    flag = true;
                } else{
                    if (aux.getNext() != null){
                        aux = aux.getNext();
                    } else{
                        flag = true;
                        aux = null;
                    }
                }
            }
        }
        return aux;
    }
    
}
