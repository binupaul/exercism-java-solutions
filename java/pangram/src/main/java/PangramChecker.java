public class PangramChecker {

    public boolean isPangram(String input) {
        boolean[] flags = new boolean[26];
        for (int i = 0; i < input.length(); i++) {
            int index = getIndex(input.charAt(i));
            if (index >= 0 && index <= 26) {
                flags[index] = true;
            }
        }
        for (int i = 0; i < flags.length; i++) {
            if (!flags[i]) {
                return false;
            }
        }
        return true;
    }
    
    private int getIndex(char ch) {
        int index = ch - 'a';
        if (index < 0) {
            index += 32;
        }
        return index;
    }
    
}
