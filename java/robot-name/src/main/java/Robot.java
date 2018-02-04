import java.util.Random;

public class Robot {
    private String name;
    
    public Robot() {
        name = generateNewName();
    }
    
    public void reset() {
        name = generateNewName();
    }
    
    public String getName() {
        return name;
    }
    
    private String generateNewName() {
        String newName = "";
        
        do {
            Random rand = new Random();
            char ch1 = (char) (rand.nextInt(26) + 'A');
            char ch2 = (char) (rand.nextInt(26) + 'A');
            int i = rand.nextInt(1000);
            newName = "" + ch1 + ch2 + String.format("%03d", i);
        } while (newName.equals(name));
        
        return newName;
    }
}

