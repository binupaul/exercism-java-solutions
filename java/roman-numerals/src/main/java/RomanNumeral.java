import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeral {
    private int arabicNumeral;
    private Map<Integer, String> map;
    
    public RomanNumeral(int arabicNumeral) {
        this.arabicNumeral = arabicNumeral;
        map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900,  "CM");
        map.put(500,  "D");
        map.put(400,  "CD");
        map.put(100,  "C");
        
        map.put(90,   "XC");
        map.put(50,   "L");
        map.put(40,   "XL");
        map.put(10,   "X");
        
        map.put(9,    "IX");
        map.put(5,    "V");
        map.put(4,    "IV");
        map.put(1,    "I");
    }
    
    public String getRomanNumeral() {
        StringBuilder sb = new StringBuilder();
        for (Integer i : map.keySet()) {
            int count = arabicNumeral / i;
            if (count > 0) {
                mult(sb, map.get(i), count);
            }
            arabicNumeral = arabicNumeral - count * i;
            if (arabicNumeral == 0) {
                break;
            }
        }
        return sb.toString();
    }
    
    private void mult(StringBuilder sb, String str, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
    }
}
