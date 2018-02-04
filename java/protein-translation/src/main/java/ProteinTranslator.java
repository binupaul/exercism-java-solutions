import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class ProteinTranslator {

    private Map<String, String> codonToProtein;
    
    ProteinTranslator() {
        codonToProtein = new HashMap<>();
        codonToProtein.put("AUG", "Methionine");
        codonToProtein.put("UUU", "Phenylalanine");
        codonToProtein.put("UUC", "Phenylalanine");
        codonToProtein.put("UUA", "Leucine");
        codonToProtein.put("UUG", "Leucine");
        codonToProtein.put("UCU", "Serine");
        codonToProtein.put("UCC", "Serine");
        codonToProtein.put("UCA", "Serine");
        codonToProtein.put("UCG", "Serine");
        codonToProtein.put("UAU", "Tyrosine");
        codonToProtein.put("UAC", "Tyrosine");
        codonToProtein.put("UGU", "Cysteine");
        codonToProtein.put("UGC", "Cysteine");
        codonToProtein.put("UGG", "Tryptophan");
        codonToProtein.put("UAA", "STOP");
        codonToProtein.put("UAG", "STOP");
        codonToProtein.put("UGA", "STOP");
        
    }
    
    List<String> translate(String rnaSequence) {
        CodonGenerator generator = new CodonGenerator(rnaSequence);
        List<String> list = new ArrayList<>();
        
        while (generator.hasNext()) {
            String codon = generator.next();
            String protein = codonToProtein.get(codon);
            if (protein.equals("STOP")) {
                break;
            } else {
                list.add(protein);
            }
        }
        return list;
    }
    
    
    class CodonGenerator implements Iterator<String> {
        private String rnaSequence;
        private int ptr;
        private StringBuilder sb;
        
        CodonGenerator(String rnaSequence) {
            this.rnaSequence = rnaSequence;
            sb = new StringBuilder();
        }

        @Override
        public boolean hasNext() {
            return (ptr + 3 <= rnaSequence.length());
        }

        @Override
        public String next() {
            sb.setLength(0);
            sb.append(rnaSequence.charAt(ptr));
            sb.append(rnaSequence.charAt(ptr + 1));
            sb.append(rnaSequence.charAt(ptr + 2));
            ptr += 3;
            return sb.toString();
        }
        
    }
    
    
}