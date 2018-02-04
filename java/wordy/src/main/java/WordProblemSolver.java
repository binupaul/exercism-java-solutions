import java.util.ArrayList;
import java.util.List;

public class WordProblemSolver {
    
    public int solve(String input) {
        int currentResult = 0;
        List<Token> tokens = getTokens(input);
        TokenType expected = TokenType.QUESTION;
        TokenType previous = null;
        
        for (int i = 0; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            if (token.type != expected) {
                doException();
            }
            
            switch (token.type) {
                case QUESTION:
                    expected = TokenType.OPERAND;
                    previous = TokenType.QUESTION;
                    break;
                case OPERATOR:
                    expected = TokenType.OPERAND;
                    previous = TokenType.OPERATOR;
                    break;
                case OPERAND:
                    if (previous == TokenType.QUESTION) {
                        currentResult = Integer.parseInt(token.value);
                    } else if (previous == TokenType.OPERATOR) {
                        currentResult = eval(token, tokens.get(i - 1), currentResult);
                    }
                    
                    if (i == tokens.size() - 2) {
                        expected = TokenType.END;
                    } else {
                        expected = TokenType.OPERATOR;
                    }
                    previous = TokenType.OPERAND;
                    break;
                case END:
                    break;
            }
        }
        return currentResult;
    }
    
    public class Token {
        public TokenType type;
        public String value;
        public int nextIndex;
    }
    
    public enum TokenType {
        QUESTION,
        OPERATOR,
        OPERAND,
        END
    }
    
    public List<Token> getTokens(String input) {
        List<Token> tokens = new ArrayList<>();
        
        String[] words = input.split("\\s+|\\?{1}$");
        int current = 0;
        while (current < words.length) {
            Token token = new Token();
            if (isQuestion(current, words, token) ||
                    isOperand(current, words, token) ||
                    isOperator(current, words, token)) {
                tokens.add(token);
                current = token.nextIndex;
            } else {
                doException();
            }
        }
        
        if (input.endsWith("?")) {
            Token token = new Token();
            token.type = TokenType.END;
            tokens.add(token);
        } else {
            doException();
        }
        return tokens;
    }
    
    private boolean isQuestion(int current, String[] words, Token token) {
       if ((current + 1 < words.length) &&
               (words[current].equalsIgnoreCase("What")) && 
               (words[current + 1].equals("is"))) {
           token.nextIndex = current + 2;
           token.type = TokenType.QUESTION;
           return true;
       }
       return false;
    }
    
    private boolean isOperand(int current, String[] words, Token token) {
        String word = words[current];
        boolean negative = false;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '-' && i == 0) {
                negative = true;
                continue;
            }
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        
        if (negative && word.length() == 1) {
            return false;
        }
        token.nextIndex = current + 1;
        token.type = TokenType.OPERAND;
        token.value = word;
        return true;
    }
    
    private boolean isOperator(int current, String[] words, Token token) {
        String word = words[current];
        if (word.equals("plus")) {
            token.nextIndex = current + 1;
            token.type = TokenType.OPERATOR;
            token.value = "+";
            return true;
        } else if (word.equals("minus")) {
            token.nextIndex = current + 1;
            token.type = TokenType.OPERATOR;
            token.value = "-";
            return true;
        } else if (current + 1 < words.length) {
            if (word.equals("multiplied") && 
                    words[current + 1].equals("by")) {
                token.nextIndex = current + 2;
                token.type = TokenType.OPERATOR;
                token.value = "*";
                return true;
            } else if (word.equals("divided") && 
                    words[current + 1].equals("by")) {
                token.nextIndex = current + 2;
                token.type = TokenType.OPERATOR;
                token.value = "/";
                return true;
            }
        } 
        return false;
    }
    
    private void doException() {
        throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
    }
    
    private int eval(Token current, Token previous, int currentResult) {
        String symbol = previous.value;
        int currentVal = Integer.parseInt(current.value);
        switch (symbol) {
            case "+": return currentResult + currentVal;
            case "-": return currentResult - currentVal;
            case "*": return currentResult * currentVal;
            case "/": return currentResult / currentVal;
        }
        return currentResult;
    }
}
