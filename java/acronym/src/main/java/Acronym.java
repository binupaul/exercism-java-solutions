
class Acronym {

    private String phrase;
    
    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        String acronym = "";
        String words[] = phrase.split(" |-");
        for (String str : words) {
            acronym += str.charAt(0);
        }
        return acronym.toUpperCase();
    }
}
