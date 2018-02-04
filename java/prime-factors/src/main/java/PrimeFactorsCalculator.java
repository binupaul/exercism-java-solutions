import java.util.ArrayList;
import java.util.List;

public class PrimeFactorsCalculator {
    
    public List<Long> calculatePrimeFactorsOf(long input) {
        List<Long> list = new ArrayList<>();
        long i = 2;
        while (i <= input) {
            if (input % i == 0) {
                list.add(i);
                input = input / i;
            } else {
                i++;
            }
        }
        return list;
    }
    
}