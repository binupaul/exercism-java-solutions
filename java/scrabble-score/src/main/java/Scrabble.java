class Scrabble {

    private String word;
    private int[] scores;
    
    Scrabble(String word) {
        this.word = word;
        constructScores();
    }

    int getScore() {
        int score = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            score += scores[getIndex(ch)];
        }
        return score;
    }
    
    private int getIndex(char ch) {
        int index = ch - 'a';
        if (index < 0) {
            index += 32;
        }
        return index;
    }

    private void constructScores() {
        scores = new int[26];
        scores[getIndex('A')] = 1;
        scores[getIndex('E')] = 1;
        scores[getIndex('I')] = 1;
        scores[getIndex('O')] = 1;
        scores[getIndex('U')] = 1;
        scores[getIndex('L')] = 1;
        scores[getIndex('N')] = 1;
        scores[getIndex('R')] = 1;
        scores[getIndex('S')] = 1;
        scores[getIndex('T')] = 1;
        
        scores[getIndex('D')] = 2;
        scores[getIndex('G')] = 2;
        
        scores[getIndex('B')] = 3;
        scores[getIndex('C')] = 3;
        scores[getIndex('M')] = 3;
        scores[getIndex('P')] = 3;
        
        scores[getIndex('F')] = 4;
        scores[getIndex('H')] = 4;
        scores[getIndex('V')] = 4;
        scores[getIndex('W')] = 4;
        scores[getIndex('Y')] = 4;
        
        scores[getIndex('K')] = 5;
        
        scores[getIndex('J')] = 8;
        scores[getIndex('X')] = 8;
        
        scores[getIndex('Q')] = 10;
        scores[getIndex('Z')] = 10;
    }
}
