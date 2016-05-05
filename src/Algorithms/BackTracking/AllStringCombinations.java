package Algorithms.BackTracking;

/**
 * Created by astik on 02-05-2016.
 */
public class AllStringCombinations {

    private String swapString(int i, int j, String str){

        char[] c = str.toCharArray();

        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;

        String swappedString = new String(c);

        return swappedString;
    }

    private void printStringCombinations(int startIndex, int endIndex, String str){
        if (startIndex == endIndex){
            System.out.println(str);
        }
        else{
            for(int i=startIndex; i<str.length(); i++){
                str = swapString(startIndex, i, str);
                printStringCombinations(startIndex+1, endIndex, str);
                str = swapString(startIndex, i, str);
            }
        }
    }

    public static void main(String[] args){
        AllStringCombinations obj = new AllStringCombinations();
        String str = "abc";
        int len = str.length();
        obj.printStringCombinations(0, len, str);
    }
}

