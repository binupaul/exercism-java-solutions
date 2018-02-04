public class Proverb {

    private String[] words;
    
    public Proverb(String[] words) {
        this.words = words;
    }

    public String recite() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            sb.append("For want of a ");
            sb.append(words[i]);
            sb.append(" the ");
            sb.append(words[i + 1]);
            sb.append(" was lost.\n");
        }
        if (words.length > 0) {
            sb.append("And all for the want of a ");
            sb.append(words[0]);
            sb.append(".");
        }
        return sb.toString();
    }

}
