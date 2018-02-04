import java.util.regex.Pattern;

public class Bob {
    private final Pattern nothing;
    private final Pattern upperCase;
    private final Pattern genericQuestion;
    private final Pattern lowerCaseNoQuestion;
    private final Pattern lowerCaseQuestion;
    
    private static final String RESPONSE_EMPTY = "Fine. Be that way!";
    private static final String RESPONSE_SHOUT = "Whoa, chill out!";
    private static final String RESPONSE_QUESTION = "Sure.";
    private static final String RESPONSE_DEFAULT = "Whatever.";
    
    public Bob() {
        lowerCaseNoQuestion = Pattern.compile("[\\p{Ll}\\p{Punct}\\p{Digit}\\s]+[^\\?]"); 
        lowerCaseQuestion = Pattern.compile("[\\p{Ll}\\p{Punct}\\p{Digit}\\s]+\\?"); 
        upperCase = Pattern.compile("[\\p{Lu}\\p{Punct}\\p{Digit}\\s]+");   
        genericQuestion = Pattern.compile(".*\\?");
        nothing = Pattern.compile("\\s*");
    }
    
    String hey (String input) {
        
        if (nothing.matcher(input).matches()) {
            return RESPONSE_EMPTY;
        }
        
        if (lowerCaseNoQuestion.matcher(input).matches()) {
            return RESPONSE_DEFAULT;
        } 
        
        if (lowerCaseQuestion.matcher(input).matches()) {
            return RESPONSE_QUESTION;
        } 
        
        if (upperCase.matcher(input).matches()) {
            return RESPONSE_SHOUT;
        } 
        
        if (genericQuestion.matcher(input).matches()) {
            return RESPONSE_QUESTION;
        }
            
        return RESPONSE_DEFAULT;
    }
    
}