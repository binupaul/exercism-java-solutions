public class ArmstrongNumbers {

	public boolean isArmstrongNumber(int numberToCheck) {
	    int numDigits = getNumberOfDigits(numberToCheck);
	    int sum = 0;
	    int currentNum = numberToCheck;
	    while (currentNum != 0) {
	        int digit = currentNum % 10;
	        currentNum = (currentNum - digit) / 10;
	        sum += Math.pow(digit, numDigits);
	    }
	    return (sum == numberToCheck);
	}
	
	private int getNumberOfDigits(int n) {
	    int i = 10;
	    int count = 1;
	    while (count <= 10) {
    	    if (n < i) {
    	        return count;
    	    } else {
    	        count++;
    	        i *= 10;
    	    }
	    }
	    return count;
	}
}
