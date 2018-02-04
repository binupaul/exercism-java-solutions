import java.util.ArrayList;
import java.util.List;

class Sieve {
    private int maxPrime;
    private boolean[] flags;
    
    Sieve(int maxPrime) {
        this.maxPrime = maxPrime;
        flags = new boolean[maxPrime - 1];
    }

    List<Integer> getPrimes() {
        List<Integer> list = new ArrayList<>();
        int maxCheck = (int) Math.sqrt(maxPrime);
        int nextNum = 2;
        
        while (nextNum <= maxCheck && nextNum != 0) {
            for (int i = nextNum*2; i <= maxPrime; i += nextNum) {
                flags[indexOf(i)] = true;
            }
            nextNum = getNextNum(nextNum);
        }
        
        for (int i = 0; i < flags.length; i++) {
            if (!flags[i]) {
                list.add(numberAt(i));
            }
        }
        return list;
    }
    
    private int indexOf(int number) {
        return number - 2;
    }
    
    private int numberAt(int index) {
        return index + 2;
    }
    
    private int getNextNum(int prevNum) {
        int index = indexOf(prevNum + 1);
        for (int i = index; i < flags.length; i++) {
            if (!flags[i]) {
                return numberAt(i);
            }
        }
        return 0;
    }
}
