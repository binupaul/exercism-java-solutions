import java.util.ArrayList;
import java.util.List;

public class Series {
    private List<Integer> input;
    
    public Series(String inputStr) {
        input = new ArrayList<>();
        for (int i = 0; i < inputStr.length(); i++) {
            input.add(Character.getNumericValue(inputStr.charAt(i)));
        }
    }
    
    public List<Integer> getDigits() {
        return input;
    }
    
    public List<List<Integer>> slices(int n) {
        if (n > input.size()) {
            throw new IllegalArgumentException("Not enough digits to slice.");
        }
        
        List<List<Integer>> lists = new ArrayList<>();
        int windowStart = 0;
        int windowEnd = n - 1;
        
        while (windowEnd < input.size()) {
            List<Integer> list = new ArrayList<>();
            for (int i = windowStart; i <= windowEnd; i++) {
                list.add(input.get(i));
            }
            lists.add(list);
            windowStart++;
            windowEnd++;
        }
        return lists;
    }
}
