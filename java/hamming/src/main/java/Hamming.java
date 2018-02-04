public class Hamming {
    private String leftStrand, rightStrand;
    
    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int count = 0;
        for (int i = 0; i < leftStrand.length(); i++) {
            char chleft = leftStrand.charAt(i);
            char chright = rightStrand.charAt(i);
            if (chleft != chright) {
                count++;
            }
        }
        return count;
    }

}
