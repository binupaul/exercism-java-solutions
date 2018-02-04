class NaturalNumber {

    private int n;
    public NaturalNumber(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.n = n;
    }

    public Classification getClassification() {
        int aliquotSum = getAliquotSum();
        if (aliquotSum == n) {
            return Classification.PERFECT;
        } else if (aliquotSum > n) {
            return Classification.ABUNDANT;
        } else {
            return Classification.DEFICIENT;
        }
    }
    
    private int getAliquotSum() {
        if (n == 1) {
            return 0;
        }
        int sum = 1;
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0) {
                sum += i;
                int factor = n / i;
                if (i != factor) {
                    sum += factor;
                }
            }
        }
        return sum;
    }
}
