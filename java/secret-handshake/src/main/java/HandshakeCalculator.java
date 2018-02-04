import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {
    
    List<Signal> calculateHandshake(int number) {
        List<Signal> list = new ArrayList<>();
        Signal[] signals = Signal.values();
        
        int i = 0;
        while (number != 0) {
            int lastbit = number & 1;
            number = number >> 1;
            if (lastbit != 0) {
                if (i < 4) {
                    list.add(signals[i]);
                } else if (i == 4) {
                    Collections.reverse(list);
                }
            }
            i++;
        }
        return list;
    }
}
