package DataStructures.Stacks;

/**
 * Created by astik on 06-05-2016.
 */
public class ReverseString {
    Stacks stack;
    String string;
    int length;
    public ReverseString (String str){
        string = str;
        length = str.length();
        stack = new Stacks(length);
    }

    public void reverseStringUsingStack(){
        for(int i=0; i< length; i++)
            stack.push(string.charAt(i));
        for (int i=0; i< length; i++)
            System.out.print(stack.pop());
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString("astik");
        rs.reverseStringUsingStack();
    }
}
