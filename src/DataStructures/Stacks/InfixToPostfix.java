package DataStructures.Stacks;

/**
 * Created by astik on 05-05-2016.
 */

public class InfixToPostfix {

    private Stacks stack;

    public InfixToPostfix(int size){
        stack = new Stacks(size);
    }

    private int precedence(char c){
        if (c == '+' || c == '-')
                return 1;
        if (c == '*' || c == '/')
                return 2;
        else return 0;
    }

    private void convertToPostfix(String expr) {
        for (int i = 0; i < expr.length(); i++) {
            if (Character.isLetter(expr.charAt(i)))
                System.out.print(expr.charAt(i));
            else {
                if (stack.isEmpty()) {
                    stack.push(expr.charAt(i));
                } else {
                    while (!stack.isEmpty() && precedence(expr.charAt(i)) < precedence(stack.top())) {
                        System.out.print(stack.pop());
                    }
                        stack.push(expr.charAt(i));


                }
            }
        }

        while (!stack.isEmpty())
            System.out.print(stack.pop());
    }
    public static void main(String[] args) {
        String expr = "a+b*c/d+e";
        String pattern = "[a-zA-z]*";
        String operatorString = expr.replaceAll(pattern, "");
        int operatorCount = operatorString.length();
        InfixToPostfix ItoP = new InfixToPostfix(operatorCount);
        ItoP.convertToPostfix(expr);
    }


}
