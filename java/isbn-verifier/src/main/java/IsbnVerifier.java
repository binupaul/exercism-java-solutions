class IsbnVerifier {

    boolean  isValid(String stringToVerify) {
        int count = 0;
        int sum = 0;
        int cksum = 0;
        char checkDigit = stringToVerify.charAt(stringToVerify.length() - 1);
        
        if ((checkDigit != 'X') && (!Character.isDigit(checkDigit))) {
            return false;
        }
        
        for (int i = 0; i < stringToVerify.length() - 1; i++) {
            char ch = stringToVerify.charAt(i);
            if (Character.isDigit(ch)) {
                sum += Character.getNumericValue(ch);
                cksum += sum;
                count++;
            } else if (ch != '-') {
                return false;
            }
        }
        
        if (count == 9) {
            cksum += (sum + (checkDigit == 'X' ? 10 : Character.getNumericValue(checkDigit)));
        } else {
            return false;
        }
        
        return (cksum % 11 == 0);
    }
}
