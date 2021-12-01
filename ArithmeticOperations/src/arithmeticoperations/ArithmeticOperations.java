package arithmeticoperations;

import classes.BinaryTree;
import classes.HashTable;
import classes.polishFunctions;
import classes.treeFunctions;

public class ArithmeticOperations {

    public static void main(String[] args) {
//        String original = "(a+b*c)+((d*e+f)*g)";
//        String original = "2+(-5)+6*1*1/9+((10*5+7)*(exp))*53";
//        String original = "2*5/4+(2+1)-6";
        String original = "(a+b)(c*(d+e))";
        HashTable hs = new HashTable(53);
        polishFunctions pf = new polishFunctions();
        treeFunctions tf = new treeFunctions();
        original = pf.adjustString(original, hs);
        System.out.println(original);
        String polish = pf.polishCoversion(original);
        System.out.println(polish);
        BinaryTree tree = tf.calculate(polish, hs);
        tree.traversePostorder(tree.getRoot());
    }
    
}
