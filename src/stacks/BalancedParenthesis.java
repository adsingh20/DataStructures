package stacks;

import java.util.Stack;

public class BalancedParenthesis {

    boolean isBalanced(String str) {
        Stack<Character> parethesis = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                parethesis.push(str.charAt(i));
            } else {
                if (parethesis.isEmpty()) {
                    return false;
                } else if (isMatching(str.charAt(i), parethesis.peek())) {
                    parethesis.pop();
                } else {
                    return false;
                }
            }
        }
        return parethesis.isEmpty();
    }

    private boolean isMatching(char one, char two) {
        switch (one) {
            case '(':
                if (two == ')')
                    return true;
            case '{':
                if (two == '}')
                    return true;
            case '[':
                if (two == ']')
                    return true;
            default:
                return false;
        }
    }
}
