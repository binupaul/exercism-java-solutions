
public class Atbash {
    
    public String encode(String plainText) {
        StringBuilder sb = new StringBuilder();
        String str = plainText.toLowerCase();
        int spacerCount = 0;
        
        for (int i =  0; i < str.length(); i++) {
            char ch = str.charAt(i);
            boolean added = false;
            
            if (ch >= 'a' && ch <= 'z') {
                char encoded = (char) ('z' - (ch - 'a'));
                sb.append(encoded);
                added = true;
            } else if (Character.isDigit(ch)) {
                sb.append(ch);
                added = true;
            }
            
            if (added) {
                spacerCount++;
                if (spacerCount == 5) {
                    sb.append(' ');
                    spacerCount = 0;
                }
            }
        }
        
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
    
    public String decode(String cipherText) {
        StringBuilder sb = new StringBuilder();
        for (int i =  0; i < cipherText.length(); i++) {
            char ch = cipherText.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                char encoded = (char) ('z' - (ch - 'a'));
                sb.append(encoded);
            } else if (ch != ' ') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}

