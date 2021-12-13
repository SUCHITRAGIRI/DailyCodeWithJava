//

package com.example.test;

import java.util.Stack;

public class InfixToPrefix {
    public static void main(String[] args) {
        String exp = "A+B*C^D";
        System.out.println(infixToPrefixExp(exp));
        //System.out.println(reverse(exp));
    }

    static String infixToPrefixExp(String exp){
    //initializing the empty string
    String res = "";

    //initializing the empty stack
    Stack<Character> stack = new Stack<>();

       exp = reverse(exp);

        for (int i = 0; i < exp.length(); i++) {
        char ch = exp.charAt(i);

        //if scanned character is an operand add to the output

        if (Character.isLetterOrDigit(ch))
            res += ch;
            //if scanned character is '(', push it to the stack
        else if (ch == '(') {
            stack.push(ch);
        }
        //if the scanned character is ')', pop the ele from the stack until it encounters '('
        else if (ch == ')') {
            while (!stack.isEmpty() && stack.peek() != '(') {
                res += stack.pop();
            }
            stack.pop();
        }

        //if scanned character is operator
        else {

            while (!stack.isEmpty() && Prec(ch) < Prec(stack.peek()))
                res += stack.pop();

            stack.push(ch);
        }
    }
    // pop all the operators from the stack
        while (!stack.isEmpty()) {
        if (stack.peek() == '(')
            return "Invalid Expression";
        res += stack.pop();
    }
        res = reverse(res);

        return res;
}
    // A utility function to return
    // precedence of a given operator
    // Higher returned value means
    // higher precedence
    static int Prec(char ch)
    {
        switch (ch)
        {
            case '|':
                return 1;
            case '&':
                return 2;
            case '-':
                return 3;
            case '+':
                return 4;

            case '/':
                return 5;
            case '*':
                return 6;

            case '^':
                return 7;
        }
        return -1;
    }
    static String reverse(String exp){
        StringBuilder str = new StringBuilder();
        for(int i = exp.length() - 1; i >= 0; i--){
            char ch = exp.charAt(i);
            if(ch == '(')ch = ')';
            else if(ch == ')')ch = '(';
            str.append(ch);
        }
        return str.toString();
    }
}
