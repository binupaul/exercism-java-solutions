
public class Transpose {
    
    public String transpose(String input) {
        String[] lines = input.split("\\n");
        int[] strlens = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            strlens[i] = lines[i].length();
        }
        
        int indexOfMaxLenLine = getIndexOfLineWithMaxLength(strlens);
        int numNewLines = lines[indexOfMaxLenLine].length();
        
        StringBuilder content = new StringBuilder();
        StringBuilder newLine = new StringBuilder();
        
        for (int i = 0; i < numNewLines; i++) {
            newLine.setLength(0);
            for (int j = 0; j < lines.length; j++) {
                char ch = getChar(lines[j], i, j, indexOfMaxLenLine, strlens, numNewLines);
                if (ch != 0) newLine.append(ch);
            }
            
            if (i < numNewLines - 1 ) {
                newLine.append("\n");
            }
            content.append(newLine);
        }
        
        return content.toString();
    }
    
    private char getChar(String line, int charPosition, 
            int currLineNum, int maxLenLineNum, int[] strlens, int numNewLines) {
        if (charPosition >= line.length()) {
            if ((currLineNum < maxLenLineNum) || 
            ((charPosition != numNewLines - 1) && longerLineExists(currLineNum, strlens))) {
                return ' ';
            }
        } else {
            return line.charAt(charPosition);
        }
        return 0;
    }
    
    private boolean longerLineExists(int currLineNum, int[] strlens) {
        int currlen = strlens[currLineNum];
        for (int i = currLineNum + 1; i < strlens.length; i++) {
            if (strlens[i] > currlen) {
                return true;
            }
        } 
        return false;
    }
    
    private int getIndexOfLineWithMaxLength(int[] strlens) {
        int max = 0;
        int index = -1;
        for (int i = 0; i < strlens.length; i++) {
            if (strlens[i] >= max) {
                max = strlens[i];
                index = i;
            }
        }
        return index;
    }
}
