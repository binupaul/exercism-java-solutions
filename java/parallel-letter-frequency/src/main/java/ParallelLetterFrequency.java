import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

public class ParallelLetterFrequency extends RecursiveTask<Map<Integer, Integer>> {
    private static final long serialVersionUID = 1L;
    private String input;
    private final int threshold = 1_000_000;
    private int start, end;
    
    public ParallelLetterFrequency(String input) {
        this.input = input;
        this.start = 0;
        this.end = input.length();
    }
    
    public ParallelLetterFrequency(String input, int start, int end) {
        this.input = input;
        this.start = start;
        this.end = end;
    }
    
    public Map<Integer, Integer> letterCounts() {
        return compute();
    }
    
    @Override
    public Map<Integer, Integer> compute() {
        if (end - start > threshold) {
            ParallelLetterFrequency t1 = new ParallelLetterFrequency(input, start, start + threshold);
            t1.fork();
            ParallelLetterFrequency t2 = new ParallelLetterFrequency(input, start + threshold, end);
            return merge(t2.compute(), t1.join());
        } else {
            Map<Integer, Integer>  map = new HashMap<>();
            for (int i = start; i < end; i++) {
                char ch = input.charAt(i);
                if (Character.isLetter(ch)) {
                    Integer key = Integer.valueOf((int) Character.toLowerCase(ch));
                    if (map.containsKey(key)) {
                        map.put(key, map.get(key) + 1);
                    } else {
                        map.put(key, 1);
                    }
                }
            }
            return map;
        }
    }
    
    private Map<Integer, Integer> merge(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
        for(Map.Entry<Integer, Integer> entry : map2.entrySet())  {
            Integer key = entry.getKey();
            Integer val = entry.getValue();
            
            if (map1.containsKey(key)) {
                map1.put(key, map1.get(key) + val);
            } else {
                map1.put(key, val);
            }
        }
        return map1;
    }
}
