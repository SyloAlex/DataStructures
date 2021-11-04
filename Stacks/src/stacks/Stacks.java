package stacks;

public class Stacks {

    public static void main(String[] args) {
        StackFunctions f = new StackFunctions();
//        //Ejercicio 1
//        Stack exercise1 = new Stack();
//        exercise1.stackNode(9);
//        exercise1.stackNode(9);
//        exercise1.stackNode(9);
//        Stack exercise1a = new Stack();
//        exercise1a.stackNode(9);
//        exercise1a.stackNode(9);
//        exercise1a.stackNode(9);
//        Stack result = new Stack();
//        result = f.sumNodes(exercise1, exercise1a, result, 0);
//        
//        //Ejercicio 2
//        Stack exercise2 = new Stack();
//        exercise2.stackNode(7);
//        exercise2.stackNode(8);
//        exercise2.stackNode(9);
//        f.reverseStack2(exercise2);
//        
//        //Ejercicio 3
//        Stack exercise3 = new Stack();
//        exercise3.stackNode(7);
//        exercise3.stackNode(1);
//        exercise3.stackNode(9);
//        exercise3.stackNode(9);
//        exercise3.stackNode(1);
//        exercise3.stackNode(7);
//        f.palindromeStack(exercise3, "", "");
//        
//        //Ejercicio 4
//        Stack exercise4 = new Stack();
//        exercise4.stackNode(4);
//        exercise4.stackNode(6);
//        exercise4.stackNode(2);
//        exercise4.stackNode(1);
//        exercise4.stackNode(8);
//        exercise4.stackNode(4);
//        f.printNNum(exercise4, 3, 0);
//        
//        //Ejercicio 5
//        Stack exercise5 = new Stack();
//        exercise5.stackNode(5);
//        exercise5.stackNode(5);
//        exercise5.stackNode(5);
//        exercise5.stackNode(5);
//        exercise5.stackNode(5);
//        exercise5.stackNode(5);
//        Stack avgStack = new Stack();
//        f.stackAVG(exercise5, avgStack);
//        System.out.println(avgStack.getTop().getElement()/exercise5.getSize());
//        
//        //Ejercicio 6
//        Stack exercise6 = new Stack();
//        exercise6.stackNode(3);
//        exercise6.stackNode(5);
//        exercise6.stackNode(1);
//        exercise6.stackNode(5);
//        exercise6.stackNode(6);
//        exercise6.stackNode(6);
//        exercise6.printStack();
//        f.evenStackSum(exercise6);
//        exercise6.printStack();
//        
        //Ejercicio 8
        Stack exercise8 = new Stack();
        Stack exercise8a = new Stack();
        exercise8.stackNode(8);
        exercise8.stackNode(7);
        exercise8.stackNode(6);
        exercise8.stackNode(5);
        exercise8a.stackNode(1);
        exercise8a.stackNode(2);
        exercise8a.stackNode(4);
        exercise8a.stackNode(6);
        Stack result = f.mergeOrderStacks(exercise8, exercise8a);
        result.printStack();
    }
}
