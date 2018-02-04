import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Etl {
    public Map<String, Integer> transform(Map<Integer, List<String>> old) {
        Map<String, Integer> map = new HashMap<>();
        for (Entry<Integer, List<String>> entry : old.entrySet()) {
            Integer score = entry.getKey();
            List<String> letters = entry.getValue();
            for (String letter : letters) {
                map.put(letter.toLowerCase(), score);
            }
        }
        return map;
    }
}
