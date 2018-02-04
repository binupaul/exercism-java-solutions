
public class FoodChain {
    
    private static final String[] OBJECTS = {
            "fly",
            "spider",
            "bird",
            "cat",
            "dog",
            "goat",
            "cow",
            "horse"
    };
    
    private static final String[] EXCLAMATIONS = {
            null,
            "It wriggled and jiggled and tickled inside her.",
            "How absurd to swallow a bird!",
            "Imagine that, to swallow a cat!",
            "What a hog, to swallow a dog!",
            "Just opened her throat and swallowed a goat!",
            "I don't know how she swallowed a cow!",
            "She's dead, of course!"
    };
    
    private static final String DIE = "I don't know why she swallowed the fly. Perhaps she'll die.";
    
    public String verse(int n) {
        StringBuilder sb = new StringBuilder();
        constructFirstLine(sb, n);
        constructSecondLine(sb, n);
        constructMiddleLines(sb, n);
        constructLastLine(sb, n);
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
    
    private void constructFirstLine(StringBuilder sb, int n) {
        sb.append("I know an old lady who swallowed a ");
        sb.append(OBJECTS[n - 1]);
        sb.append(".\n");
    }
    
    private void constructSecondLine(StringBuilder sb, int n) {
        String exclaim = EXCLAMATIONS[n - 1];
        if (exclaim != null) {
            sb.append(exclaim);
            if (n != 8) {
                sb.append("\n");
            }
        }
    }
    
    private void constructLastLine(StringBuilder sb, int n) {
        if (n != 8) {
            sb.append(DIE);
        }
    }
    
    private void constructMiddleLines(StringBuilder sb, int n) {
        if (n == 1 || n == 8) {
            return;
        }
        for (int i = n - 1; i >= 1; i--) {
            sb.append("She swallowed the ");
            sb.append(OBJECTS[i]);
            sb.append(" to catch the ");
            sb.append(getDecoratedObject(i - 1));
            sb.append(".\n");
        }
    }
    
    private String getDecoratedObject(int i) {
        if (i == 1) {
            return OBJECTS[i] + " that wriggled and jiggled and tickled inside her";
        } else {
            return OBJECTS[i];
        }
    }
}
