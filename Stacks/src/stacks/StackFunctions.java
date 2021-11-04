package stacks;

public class StackFunctions {
    
    public StackFunctions(){
    }
    
    public void writeStack(Stack fStack){
        if (!fStack.isEmpty()){
            int data = fStack.getTop().getElement();
            fStack.unstackNode();
            System.out.println(data);
            writeStack(fStack);
            fStack.stackNode(data);
        }
    }
    
    public void copyStack(Stack origin, Stack copy){
        if (!origin.isEmpty()){
            int data = origin.getTop().getElement();
            origin.unstackNode();
            copyStack(origin, copy);
            origin.stackNode(data);
            copy.stackNode(data);
        }
    }
    
    public void reverseStack(Stack origin, Stack copy){
        if (!origin.isEmpty()){
            int data = origin.getTop().getElement();
            origin.unstackNode();
            copy.stackNode(data);
            reverseStack(origin, copy);
            origin.stackNode(data);
        }
    }
    
    public void reverseStack2(Stack origin){
        if (!origin.isEmpty()){
            int data = origin.getTop().getElement();
            origin.unstackNode();
            reverseStack2(origin);
            addNodeBottom(origin, data);
        }
    }
    
    public void addNodeBottom(Stack origin, int element){
        if (!origin.isEmpty()){
            int data = origin.getTop().getElement();
            origin.unstackNode();
            addNodeBottom(origin, element);
            origin.stackNode(data);
        }else{
            origin.stackNode(element);
        }
    }
    
    public Stack sumNodes(Stack first, Stack second, Stack result, int count){
        if (!first.isEmpty() && !second.isEmpty()){
            SimpleNode aux = first.getTop();
            SimpleNode aux2 = second.getTop();
            int data = aux.getElement() + aux2.getElement() + count;
            count = 0;
            if (data > 9){
                count = Character.getNumericValue(String.valueOf(data).charAt(0));
                data = Character.getNumericValue(String.valueOf(data).charAt(1));
            }
            first.unstackNode();
            second.unstackNode();
            sumNodes(first, second, result, count);
            first.stackNode(aux.getElement());
            second.stackNode(aux2.getElement());
            result.stackNode(data);
        }else if (count != 0){
            result.stackNode(count);
        }
        
        return result;
    }
    
    public void palindromeStack(Stack newStack, String str, String rev){
        if (!newStack.isEmpty()){
            SimpleNode aux = newStack.getTop();
            newStack.unstackNode();
            str = str + String.valueOf(aux.getElement());
            rev = String.valueOf(aux.getElement()) + rev;
            palindromeStack(newStack, str, rev);
            newStack.stackNode(aux.getElement());
        }else{
            if (str.equals(rev)){
                System.out.println("Es un palindromo");
            }else{
                System.out.println("No es un palindromo");
            }
        }
    }
    
    public void printNNum(Stack newStack, int num, int result){
        if (newStack.getSize() > num){
            SimpleNode aux = newStack.getTop();
            newStack.unstackNode();
            printNNum(newStack, num, result);
            newStack.stackNode(aux.getElement());
        }else if (!newStack.isEmpty()){
            SimpleNode aux = newStack.getTop();
            newStack.unstackNode();
            result = result + aux.getElement();
            printNNum(newStack, num, result);
            newStack.stackNode(aux.getElement());
        }else{
            System.out.println(result);
        }
    }
    
    public void stackAVG(Stack newStack, Stack avgStack){
        if (!newStack.isEmpty()){
            SimpleNode aux = newStack.getTop();
            newStack.unstackNode();
            if (avgStack.isEmpty()){
                avgStack.stackNode(aux.getElement());
            }else{
                avgStack.getTop().setElement(avgStack.getTop().getElement() + aux.getElement());
            }
            stackAVG(newStack, avgStack);
            newStack.stackNode(aux.getElement());
        }
    }
    
    public void evenStackSum(Stack newStack){
        if (!newStack.isEmpty()){
            SimpleNode aux = newStack.getTop();
            newStack.unstackNode();
            int sum = aux.getElement();
            if (!newStack.isEmpty()){
                SimpleNode aux2 = newStack.getTop();
                newStack.unstackNode();
                sum = sum + aux2.getElement();
            }
            evenStackSum(newStack);
            newStack.stackNode(sum);
        }
    }
    
    public Stack mergeOrderStacks(Stack newStack, Stack newStack2){
        Stack result = new Stack();
        if (!newStack.isEmpty() && !newStack.isEmpty()){
            SimpleNode aux = newStack.getTop();
            SimpleNode aux2 = newStack2.getTop();
            newStack.unstackNode();
            newStack2.unstackNode();
            result = mergeOrderStacks(newStack, newStack2);
            result.addNodeOrdered(aux.getElement());
            result.addNodeOrdered(aux2.getElement());
            newStack.stackNode(aux.getElement());
            newStack2.stackNode(aux2.getElement());
        }else if(!newStack.isEmpty()){
            SimpleNode aux = newStack.getTop();
            newStack.unstackNode();
            result = mergeOrderStacks(newStack, newStack2);
            result.addNodeOrdered(aux.getElement());
            newStack.stackNode(aux.getElement());
        }else if (!newStack2.isEmpty()){
            SimpleNode aux2 = newStack2.getTop();
            newStack2.unstackNode();
            result = mergeOrderStacks(newStack, newStack2);
            result.addNodeOrdered(aux2.getElement());
            newStack2.stackNode(aux2.getElement());
        }else{
            return result;
        }
        
        return result;
    }
}