import java.util.HashMap;
import java.util.Map;

public class WordCount {
    
    public Map<String, Integer> phrase(String input) {
        Map<String, Integer> map = new HashMap<>();
        String[] strings = input.split("[\\p{Punct}\\p{Space}]+");
        
        for (String str : strings) {
            String key = str.toLowerCase();
            if (map.containsKey(key)) {
                int val = map.get(key);
                map.put(key, ++val);
            } else {
                map.put(key, 1);
            }
        }
        
        return map;
    }
    
}
