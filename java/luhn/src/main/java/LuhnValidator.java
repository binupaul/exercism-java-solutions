class LuhnValidator {

    boolean isValid(String candidate) {
        int sum = 0;
        boolean todouble = false;
        int digitCount = 0;
        
        for (int i = candidate.length() - 1; i >= 0; i--) {
            char ch = candidate.charAt(i);
            
            if (ch != ' ' && !Character.isDigit(ch)) {
                return false;
            }
            
            if (ch == ' ') {
                continue;
            }
            
            digitCount++;
            int digitVal = Character.getNumericValue(ch);
            if (todouble) {
                digitVal *=  2;
                if (digitVal > 9) {
                    digitVal = digitVal - 9;
                }
                
            }
            sum += digitVal;
            todouble = !todouble;
        }
        
        return (digitCount > 1 && sum % 10 == 0);
    }
}
