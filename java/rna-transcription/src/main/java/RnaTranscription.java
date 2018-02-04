class RnaTranscription {

    String transcribe(String dnaStrand) {
        
        StringBuffer sb = new StringBuffer();
        char transcribed = ' ';
        
        for (int i = 0; i < dnaStrand.length(); i++) {
            char ch = dnaStrand.charAt(i);
            switch (ch) {
            case 'A':
                transcribed = 'U';
                break;
            case 'C':
                transcribed = 'G';
                break;
            case 'T':
                transcribed = 'A';
                break;
            case 'G':
                transcribed = 'C';
                break;
            default:
                throw new IllegalArgumentException("Invalid input");
            }
            sb.append(transcribed);
        }
        return sb.toString();
    }

}
