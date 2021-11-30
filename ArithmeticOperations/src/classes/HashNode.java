package classes;

public class HashNode {
    
    private HashNode next;
    private String number;
    private String letter;
    
    public HashNode(){
        this.next = null;
        this.number = "";
        this.letter = "";
    }
    
    public HashNode(String number){
        this.next = null;
        this.number = number;
        this.letter = "";
    }
    
    public HashNode(String number, String letter){
        this.next = null;
        this.number = number;
        this.letter = letter;
    }

    public HashNode getNext() {
        return next;
    }

    public void setNext(HashNode next) {
        this.next = next;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
    
}
