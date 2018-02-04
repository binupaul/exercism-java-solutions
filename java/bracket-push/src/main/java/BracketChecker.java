import java.util.Deque;
import java.util.LinkedList;

public class BracketChecker {
    private String input;
    
    public BracketChecker(String input) {
        this.input = input;
    }
    
    public boolean areBracketsMatchedAndNestedCorrectly() {
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '}' || ch == ']' || ch == ')') {
                if (stack.isEmpty() || (stack.removeLast() != findMatch(ch))) {
                    return false;
                }
            } else if (ch == '{' || ch == '[' || ch == '(') {
                stack.addLast(ch);
            }
        }
        return stack.isEmpty();
    }
    
    private char findMatch(char ch) {
        if (ch == '}') return '{';
        else if (ch == ']') return '[';
        else if (ch == ')') return '(';
        else return ch;
    }
}
