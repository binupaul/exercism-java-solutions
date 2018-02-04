import java.util.HashSet;
import java.util.Set;

public class IsogramChecker {
    
    public boolean isIsogram(String str) {
        Set<Character>  set = new HashSet<>();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (ch == '-' || ch == ' ') {
                continue;
            }
            
            ch = Character.toUpperCase(ch);
            if (set.contains(ch)) {
                return false;
            } else {
                set.add(ch);
            }
        }
        return true;
    }
}
