class LargestSeriesProductCalculator {
    private int[] input;
    
    LargestSeriesProductCalculator(String inputNumber) {
        validateInput(inputNumber);
        input = new int[inputNumber.length()];
        for (int i = 0; i < inputNumber.length(); i++) {
            input[i] = Character.getNumericValue(inputNumber.charAt(i));
        }
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        validateCalc(numberOfDigits);
        
        long maxSoFar = 0;
        int windowStart = 0;
        int windowEnd = numberOfDigits - 1;
        
        while (windowEnd < input.length) {
            
            // Calculate product by multiplying numberOfDigits digits
            // as initial value or when a zero is encountered.
            
            boolean reset = false;
            long product = 1;
            for (int i = windowStart; i <= windowEnd; i++) {
                if (input[i] == 0) {
                    windowStart = i + 1;
                    windowEnd = windowStart + numberOfDigits - 1;
                    reset = true;
                    break;
                } else {
                    product = product * input[i];
                }
                
            }
            
            if (reset) {
                continue;
            }

            if (product > maxSoFar) {
                maxSoFar = product;
            }
            
            windowStart = windowStart + 1;
            windowEnd = windowEnd + 1;
            
            // Optimize window slide by multiplying by the next digit and
            // dividing by the first digit of the last window. If a zero
            // is encountered, go back to calculating by multiplying numberOfDigits digits.
            
            while (windowEnd < input.length) {
                if (input[windowStart - 1] != 0) {
                    product = (product * input[windowEnd]) / input[windowStart - 1];
                    if (product > maxSoFar) {
                        maxSoFar = product;
                    }
                    windowStart = windowStart + 1;
                    windowEnd = windowEnd + 1;
                } else {
                    break;
                }
            }
        }
        
        return maxSoFar;
    }
    
    private void validateInput(String inputNumber) {
        if (inputNumber == null) {
            throw new IllegalArgumentException("String to search must be non-null.");
        }
        
        for (int i = 0; i < inputNumber.length(); i++) {
            if (!Character.isDigit(inputNumber.charAt(i))) {
                throw new IllegalArgumentException("String to search may only contain digits.");
            }
        }
    }
    
    private void validateCalc(int numberOfDigits) {
        if (numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }
        
        if (numberOfDigits > input.length) {
            throw new IllegalArgumentException("Series length must be less than or "
                    + "equal to the length of the string to search.");
        }
    }
}
