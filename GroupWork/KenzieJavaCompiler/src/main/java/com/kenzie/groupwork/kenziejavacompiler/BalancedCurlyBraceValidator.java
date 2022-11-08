package com.kenzie.groupwork.kenziejavacompiler;

import java.util.List;
import java.util.Stack;

/**
 * Compiler check that ensures the curly braces in a file are evenly matched. The file must contain an even number of
 * opening and closing curly braces. This check does not perform any validation that the curly braces are in legal
 * locations in the file. [NOTE] Your implementation does not need to handle escaped curly braces within strings
 * literals.
 */
public class BalancedCurlyBraceValidator {

    private static final char OPEN = '{';
    private static final char CLOSE = '}';
    private boolean debug = false;

    /**
     * Validates that the curly braces in the list of provided file characters are balanced.
     * @param fileCharacters all characters in a java file
     * @return true if the braces are balanced, false otherwise
     */
    public boolean check(List<Character> fileCharacters) {
        // TODO: complete this method
        //stack push { open then push { close
        Stack<Character> stack = new Stack();
        for(int i = 0; i < fileCharacters.size(); i++) {
            char c = fileCharacters.get(i);
            if(c == '[' || c == '(' || c == '{' ) {
                stack.push(c);
            } else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }


    /**
     * Does the above and prints out debugging information. This can be combined into one method, but separating these
     * out so we can see both the basic solution and the extension solution.
     * @param fileCharacters all characters in a java file
     * @return true if the braces are balanced, false otherwise
     */
    public boolean checkExtension(List<Character> fileCharacters) {
        // TODO: complete this method
        int leftNum =0;
        int rightNum = 0;
        String string = "";
        Stack<Character> stack = new Stack();
        for(int i = 0; i < fileCharacters.size(); i++) {
            char c = fileCharacters.get(i);
            if(c == '[' || c == '(' || c == '{' ) {
                stack.push(c);
            } else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    leftNum++;
                    return false;
                }
            } else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    rightNum++;
                    return false;
                }
            } else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    string = stack.toString();
                    return false;
                }
            }

        }
        System.out.println("Maximum unbalanced braces encountered: " + leftNum+rightNum);
        System.out.println("Number of remaining unbalanced {: " + leftNum);
        System.out.println("Number of remaining unbalanced }: " + rightNum);
        System.out.println("Longest string between balanced braces: " + string);
        return stack.isEmpty();
    }

    /**
     * Use this to enable or disable additional debug messages.
     * @param debug the value to set the debug variable
     */
    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}
