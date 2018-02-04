class RotationalCipher {
    private int shiftKey;
    
    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                sb.append( (char) ('A' + ((ch - 'A') + shiftKey) % 26) );
            } else if (ch >= 'a' && ch <= 'z') {
                sb.append( (char) ('a' + ((ch - 'a') + shiftKey) % 26) );
            } else {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }

}