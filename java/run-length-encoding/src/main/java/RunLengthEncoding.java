public class RunLengthEncoding {
    
    public String encode(String input) {
        
        if (input.equals("")) {
            return "";
        }
        
        int count = 1;
        char lastChar = input.charAt(0);
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == lastChar) {
                count++;
            } else {
                if (count > 1) {
                    sb.append(Integer.toString(count));
                }
                sb.append(lastChar);
                lastChar = currentChar;
                count = 1;
            }
        }
        
        if (count > 1) {
            sb.append(Integer.toString(count));
        }
        sb.append(lastChar);
        
        return sb.toString();
    }
    
    public String decode(String input) {
        int runlength = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                runlength = runlength * 10 + Character.getNumericValue(ch);
            } else {
                if (runlength == 0) {
                    sb.append(ch);
                } else {
                    for (int j = 0; j < runlength; j++) {
                        sb.append(ch);
                    }
                    runlength = 0;
                }
            }
        }
        return sb.toString();
    }
}

