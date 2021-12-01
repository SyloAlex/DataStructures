package classes;

public class polishFunctions {
    
    public polishFunctions(){
    }
    
    public String adjustString(String original, HashTable hs){
        original = original.replaceAll(" ", "");
        original = original.replaceAll("\\)\\(", ")*(");
        original = this.numsToVars(original, hs);
        original = this.substituteSigns(original, hs);
        return original;
    }
    
    public boolean checkNumbers(String original){
        boolean flag = true;
        for (int i = 0; i < original.length(); i++){
            if (Character.isDigit(original.charAt(i))){
                flag = false;
                break;
            }
        }
        return flag;
    }
    
    public boolean checkLetters(String original){
        boolean flag = true;
        for (int i = 0; i < original.length(); i++){
            if (original.charAt(i) == 'e' && 
                        original.charAt(i + 1) == 'x' && 
                        original.charAt(i + 2) == 'p'){
                flag = false;
                break;
            }
        }
        return flag;
    }
    
    public boolean checkSigns(String original){
        boolean flag = true;
        for (int i = 0; i < original.length(); i++){
            if (i > 0){
                if ((original.charAt(i) == '+' || original.charAt(i) == '-') && 
                        original.charAt(i - 1) == '('){
                    flag = false;
                    break;
                }
            } else{
                if ((original.charAt(i) == '+' || original.charAt(i) == '-')){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
    
    public String substituteSigns(String original, HashTable hs){
        while(!this.checkSigns(original)){
            String num = "";
            char letter;
            for (int i = 0; i < original.length(); i++){
                if (i > 0){
                    if ((original.charAt(i) == '+' || original.charAt(i) == '-') && 
                            !Character.isAlphabetic(original.charAt(i - 1))){
                        num += original.charAt(i);
                        num += original.charAt(i + 1);
                        break;
                    }
                } else{
                    if ((original.charAt(i) == '+' || original.charAt(i) == '-')){
                        num += original.charAt(i);
                        num += original.charAt(i + 1);
                        break;
                    }
                }
            }
            if (hs.getNodeCount() >= 0 || hs.getNodeCount() < 27){
                letter = (char) (65 + hs.getNodeCount());
            }else{
                letter = (char) (97 + hs.getNodeCount());
            }
            hs.hashFunctionSign(String.valueOf(letter), num);
            original = original.replaceFirst(num, String.valueOf(letter));
        }
        return original;
    }
    
    public String numsToVars(String original, HashTable hs){
        while(!this.checkLetters(original) || !this.checkNumbers(original)){
            String num = "";
            char letter;
            for (int i = 0; i < original.length(); i++){
                if (Character.isDigit(original.charAt(i)) || 
                        original.charAt(i) == ',' || original.charAt(i) == '.'){
                    num += original.charAt(i);
                } else if(original.charAt(i) == 'e' && 
                        original.charAt(i + 1) == 'x' && 
                        original.charAt(i + 2) == 'p'){
                    num += "exp";
                }else{
                    if (num.length() > 0){
                        break;
                    }
                }
            }
            if (hs.getNodeCount() >= 0 || hs.getNodeCount() < 27){
                letter = (char) (65 + hs.getNodeCount());
            }else{
                letter = (char) (97 + hs.getNodeCount());
            }
            hs.hashFunction(String.valueOf(letter), num);
            original = original.replaceFirst(num, String.valueOf(letter));
        }
        return original;
    }
    
    public String polishCoversion(String original){
        Stack polishStack = new Stack();
        String polish = this.convertString(original, polishStack);
        
        return polish;
    }
    
    public String convertString(String original, Stack pStack){
        String polish = "";
        for (int i = 0; i < original.length(); i++){
            char pChar = original.charAt(i);
            if (Character.isDigit(pChar) || Character.isAlphabetic(pChar)){
                polish += original.charAt(i);
                if ((i < original.length() - 1) && 
                        original.charAt(i + 1) == '('){
                    polish = this.checkStack(original, polish, '*', pStack);
                }
            }else{
                polish = this.checkStack(original, polish, pChar, pStack);
            }
        }
        if (!pStack.isEmpty()){
            polish = this.emptyStack(polish, pStack);
        }
        return polish;
    }
    
    public String checkStack(String original, String polish, char pChar, 
            Stack pStack){
        if (pStack.isEmpty()){
            pStack.stackNode(String.valueOf(pChar));
        }else{
            String top = pStack.getTop().getElement();
            if (pChar == '('){
                pStack.stackNode(String.valueOf(pChar));
            } else if (pChar == ')' && !top.equals("(")){
                polish = this.unstackParenthesis(polish, pStack);
            } else if(pChar == ')' && top.equals("(")){
                pStack.unstackNode();
            } else if(pChar == '^' && (top.equals("^") || top.equals("*") 
                    || top.equals("/") || top.equals("+") || top.equals("-"))){
                pStack.stackNode(String.valueOf(pChar));
            } else if((pChar == '*' || pChar == '/') && top.equals("^")){
                polish = this.unstackSigns(polish, pStack, pChar);
            } else if ((pChar == '*' || pChar == '/') && 
                    (top.equals("+") || top.equals("-") || top.equals("*") || 
                    top.equals("/"))){
                pStack.stackNode(String.valueOf(pChar));
            } else if ((pChar == '+' || pChar == '-') && 
                    (top.equals("+") || top.equals("-"))){
                pStack.stackNode(String.valueOf(pChar));
            } else if ((pChar == '+' || pChar == '-') && 
                    (top.equals("*") || top.equals("/") || top.equals("^"))){
                polish = this.unstackSigns(polish, pStack, pChar);
            } else if ((pChar == '+' || pChar == '-' || pChar == '*' || 
                    pChar == '/' || pChar == '^') && top.equals("(")){
                pStack.stackNode(String.valueOf(pChar));
            }
        }
        return polish;
    }
    
    public String unstackSigns(String polish, Stack pStack, char pChar){
        if (!pStack.isEmpty()){
            if (pChar == '+' || pChar == '-'){
                String sign = pStack.getTop().getElement();
                switch (sign) {
                    case "*":
                    case "/":
                    case "^":
                        pStack.unstackNode();
                        polish += sign;
                        polish = this.unstackSigns(polish, pStack, pChar);
                        break;
                    case "+":
                    case "-":
                        pStack.unstackNode();
                        polish += sign;
                        pStack.stackNode(String.valueOf(pChar));
                        break;
                    default:
                        pStack.stackNode(String.valueOf(pChar));
                        break;
                }
            } else if (pChar == '*' || pChar == '/'){
                String sign = pStack.getTop().getElement();
                if (sign.equals("^")){
                    pStack.unstackNode();
                    polish += sign;
                    polish = this.unstackSigns(polish, pStack, pChar);
                } else if ((sign.equals("*") || sign.equals("/") 
                        || sign.equals("+") || sign.equals("-"))){
                    pStack.unstackNode();
                    polish += sign;
                    pStack.stackNode(String.valueOf(pChar));
                }
            }
        } else{
            pStack.stackNode(String.valueOf(pChar));
        }
        
        
        return polish;
    }
    
    public String unstackParenthesis(String polish, Stack pStack){
        if (!pStack.getTop().getElement().equals("(")){
            String sign = pStack.getTop().getElement();
            pStack.unstackNode();
            polish += sign;
            polish = this.unstackParenthesis(polish, pStack);
        } else{
            pStack.unstackNode();
        }
        return polish;
    }
    
    public String emptyStack(String polish, Stack pStack){
        if (!pStack.isEmpty()){
            String sign = pStack.getTop().getElement();
            pStack.unstackNode();
            polish += sign;
            polish = this.emptyStack(polish, pStack);
        }
        
        return polish;
    }
    
}
