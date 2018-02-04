
public class BeerSong {
    
    public String verse(int count) {
        StringBuilder sb = new StringBuilder();
        sb.append(bottleCount(count, " on the wall, ", true ));
        sb.append(bottleCount(count, ".", false));
        sb.append("\n");
        
        if (count != 0) {
            sb.append("Take ");
            if (count == 1) {
                sb.append("it");
            } else {
                sb.append("one");
            }
            
            sb.append(" down and pass it around, ");
            sb.append(bottleCount(count - 1, " on the wall.", false));
        } else {
            sb.append("Go to the store and buy some more, ");
            sb.append(bottleCount(99, " on the wall.", false));
        }
        sb.append("\n\n");
        return sb.toString();
    }
    
    private String bottleCount(int numBottles, String str, boolean caps) {
        StringBuilder sb  = new StringBuilder();
        if (numBottles == 1) {
            sb.append(numBottles);
            sb.append(" bottle");
        } else if (numBottles == 0) {
            if (caps) {
                sb.append("No");
            } else {
                sb.append("no");
            }
            sb.append(" more bottles");
        } else {
            sb.append(numBottles);
            sb.append(" bottles");
        }
        sb.append(" of beer");
        sb.append(str);
        return sb.toString();
    }
    
    public String sing(int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i >= end; i--) {
            sb.append(verse(i));
        }
        return sb.toString();
    }
    
    public String singSong() {
        return sing(99, 0);
    }
}
