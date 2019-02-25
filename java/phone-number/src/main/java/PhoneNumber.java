import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber{
    private String cleaned;
    
    private final static String wrongLengthExceptionMessage = "Number must be 10 or 11 digits";
    private final static String numberIs11DigitsButDoesNotStartWith1ExceptionMessage =
               "Can only have 11 digits if number starts with '1'";
    private final static String illegalCharacterExceptionMessage =
               "Illegal character in phone number. Only digits, spaces, parentheses, hyphens or dots accepted.";
    private final static String illegalAreaOrExchangeCodeMessage =
            "Illegal Area Or Exchange Code. Only 2-9 are valid digits";
    
    
    public PhoneNumber(String phoneNum) throws IllegalArgumentException{
        Pattern p = Pattern.compile("[^\\d\\s\\(\\)\\.\\-+]");
        Matcher m = p.matcher(phoneNum);
        
        int a;
        int b;
        
        if (m.find()) {
            throw new IllegalArgumentException(illegalCharacterExceptionMessage);
        }
        String cleaned = phoneNum.replaceAll("[\\s\\p{Punct}]+", "");
        
        if (cleaned.length() > 11 ||cleaned.length() < 10 ) {
            throw new IllegalArgumentException(wrongLengthExceptionMessage);
        } else if (cleaned.length() == 11) {
            if (cleaned.charAt(0) == '1') {
                cleaned = cleaned.substring(1);
            } else {
                throw new IllegalArgumentException(numberIs11DigitsButDoesNotStartWith1ExceptionMessage);
            }
        }
        a = Character.getNumericValue(cleaned.charAt(0));
        b = Character.getNumericValue(cleaned.charAt(3));
        if (a < 2 || b < 2){
          throw new IllegalArgumentException(illegalAreaOrExchangeCodeMessage);
        }
        
        this.cleaned = cleaned;
    }
    
    public String getNumber() {
        return cleaned;
    }
}
