import java.util.HashMap;
import java.util.Map;

public class NucleotideCounter {
    private Map<Character, Integer> map;
    
    public NucleotideCounter(String str) {
        map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 0);
        map.put('T', 0);
        map.put('G', 0);
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int val = map.get(ch);
            map.put(ch,  ++val);
        }
    }
    
    public Map<Character, Integer> nucleotideCounts() {
        return map;
    }
    
    public int count(char ch) {
        if (ch != 'A' && ch != 'C' && ch !='T' && ch !='G') {
            throw new IllegalArgumentException();
        }
        Integer count = map.get(ch);
        return (count == null) ? 0 : count.intValue();
    }
}
