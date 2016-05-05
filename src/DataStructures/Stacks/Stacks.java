package DataStructures.Stacks;

import java.util.Random;

/**
 * Created by astik on 05-05-2016.
 * implimentation of stacks using arrays
 */

public class Stacks {
    private int count;
    private char[] stackArray;

    public Stacks(int size) {
        this.count = 0;
        this.stackArray = new char[size];
    }

    public void push(char data) {
        if (this.count < stackArray.length) {
            stackArray[this.count] = data;
            this.count++;
        } else System.out.println("Stack Full!");
    }

    public char pop() {
        char val;
        if (this.count != 0) {
            this.count--;
            val = this.stackArray[this.count];
        } else {
            val = '$';
            System.out.println("Stack is Empty");
        }

        return val;
    }

    public char top() {
        char val;
        if (this.count != 0) {
            val = this.stackArray[this.count-1];
        } else {
            val = '$';
            System.out.println("Stack is empty");
        }
        return val;
    }

    public void print() {
        for (int i = this.count - 1; i >= 0; i--)
            System.out.println(this.stackArray[i]);
        System.out.println();

    }

    public boolean isEmpty() {
        return (this.count == 0);
    }

    public static void main(String[] args) {
        Stacks stack = new Stacks(5);
        Random rand = new Random();
        for (int i = 65; i < 70; i++) {
            System.out.println("Pushing");
            stack.push((char) (i));
            stack.print();
        }
        for (int i = 0; i < 6; i++) {
            System.out.println("Popping");
            stack.pop();
            stack.print();
        }

    }
}

