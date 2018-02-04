
public class House {

    private static final String[] SUBJECTS = {
        "house that Jack built.",
        "malt",
        "rat",
        "cat",
        "dog",
        "cow with the crumpled horn",
        "maiden all forlorn",
        "man all tattered and torn",
        "priest all shaven and shorn",
        "rooster that crowed in the morn",
        "farmer sowing his corn",
        "horse and the hound and the horn"
    };
    
    private static final String[] ACTIONS = {
        "lay in",
        "ate",
        "killed",
        "worried",
        "tossed",
        "milked",
        "kissed",
        "married",
        "woke",
        "kept",
        "belonged to"
    };
    
    public String verse(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("This is the ");
        sb.append(SUBJECTS[n - 1]);
        
        if (n != 1) {
            sb.append("\n");
        }
        
        for (int i = n - 2; i >= 0; i--) {
            sb.append("that ");
            sb.append(ACTIONS[i]);
            sb.append(" the ");
            sb.append(SUBJECTS[i]);
            if (i != 0) {
                sb.append("\n");
            }
        }
        
        return sb.toString();
    }

    public String verses(int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(verse(i));
            if (i != end) {
                sb.append("\n\n");
            }
        }
        return sb.toString();
    }
    
    public String sing() {
        return verses(1, 12);
    }
}
