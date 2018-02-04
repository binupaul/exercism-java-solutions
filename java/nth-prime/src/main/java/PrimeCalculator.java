import java.util.ArrayList;
import java.util.List;

class PrimeCalculator {

    private List<Integer> factors;
    
    int nth(int nth) {
        if (nth == 0) {
            throw new IllegalArgumentException();
        }
        
        if (nth == 1) {
            return 2;
        }
        
        int primeCount = 1;
        int i = 3;
        factors = new ArrayList<>();
        
        while (primeCount != nth) {
            if (isPrime(i)) {
                primeCount++;
                factors.add(i);
            }
            i += 2;
        }
        
        return factors.get(factors.size() - 1);
    }
    
    private boolean isPrime(int num) {
        int limit = (int) Math.sqrt(num);
        int i = 0;
        while (factors.size() > i && factors.get(i) <= limit) {
            if (num % factors.get(i) == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
}
