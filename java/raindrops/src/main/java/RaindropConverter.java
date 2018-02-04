class RaindropConverter {

    String convert(int number) {
        boolean factor = false;
        String output = "";
        
        if (number % 3 == 0) {
            factor = true;
            output += "Pling";
        } 
        
        if (number % 5 == 0) {
            factor = true;
            output += "Plang";
        }
        
        if (number % 7 == 0) {
            factor = true;
            output += "Plong";
        }
        
        if (!factor) {
            output = Integer.toString(number);
        }
        return output;
    }

} 
