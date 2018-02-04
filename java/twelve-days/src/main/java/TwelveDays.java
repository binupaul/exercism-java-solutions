class TwelveDays {
    
    private String[] dayCount = {
            "first", "second", "third", "fourth", "fifth", "sixth",
            "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth"
    };
    
    private String[] phrases = {
            "a Partridge in a Pear Tree",
            "two Turtle Doves",
            "three French Hens",
            "four Calling Birds",
            "five Gold Rings",
            "six Geese-a-Laying",
            "seven Swans-a-Swimming",
            "eight Maids-a-Milking",
            "nine Ladies Dancing",
            "ten Lords-a-Leaping",
            "eleven Pipers Piping",
            "twelve Drummers Drumming"
    };
    
    private String mainPhrasePartOne = "On the ";
    private String mainPhrasePartTwo = " day of Christmas my true love gave to me, ";
    
    String verse(int verseNumber) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(mainPhrasePartOne);
        sb.append(dayCount[verseNumber - 1]);
        sb.append(mainPhrasePartTwo);
        
        for (int i = verseNumber; i > 0; i--) {
            sb.append(phrases[i - 1]);
            if (i != 1) {
                sb.append(", ");
            }
            if (i == 2) {
                sb.append("and ");
            }
        }
        
        sb.append(".\n");
        return sb.toString();
    }

    String verses(int startVerse, int endVerse) {
        StringBuilder sb = new StringBuilder();
        for (int i = startVerse; i <= endVerse; i++) {
            sb.append(verse(i));
            if (i != endVerse) sb.append("\n");
        }
        return sb.toString();
    }
    
    String sing() {
        return verses(1, 12);
    }
}
