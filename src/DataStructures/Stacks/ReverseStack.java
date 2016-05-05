package DataStructures.Stacks;

/**
 * Created by astik on 06-05-2016.
 * Reverse stack using recursion.
 * Idea is to hold every element in the recursive calls and then print it.
 */
public class ReverseStack {
    private Stacks stack;
    private String string;

    public ReverseStack(String str){
        string = str;
        stack = new Stacks(str.length());
    }

    public void makeStack(){
        for(int i=0; i<string.length(); i++){
            stack.push(string.charAt(i));
        }
    }

    public void printReverseString(){
        if (stack.isEmpty())
            return;
        else{
            char temp = stack.pop();
            printReverseString();
            System.out.print(temp);
        }
    }

    public static void main(String[] args) {
        ReverseStack rs = new ReverseStack("astik");
        rs.makeStack();
        rs.printReverseString();
    }
}
