public class PigLatinTranslator {
    
    public String translate(String input) {
        String translatedPhrase = "";
        String[] words = input.split("\\s");
        for (String word : words) {
            translatedPhrase +=  translateSingleWord(word) + " ";
        }
        return translatedPhrase.trim();
    }
    
    private String translateSingleWord(String input) {
        Rule startsWithVowel = new RuleStartsWithVowel();
        Rule firstTwoCharsLikeSingleVowel = new RuleTreatFirstTwoCharsLikeSingleVowel();
        Rule firstThreeCharsLikeSingleConsonant = new RuleTreatFirstThreeCharsLikeSingleConsonant();
        Rule firstTwoCharsLikeSingleConsonant = new RuleTreatFirstTwoCharsLikeSingleConsonant();
        Rule startsWithConsonant = new RuleStartsWithConsonant();
        
        startsWithVowel.setSuccessor(firstTwoCharsLikeSingleVowel);
        firstTwoCharsLikeSingleVowel.setSuccessor(firstThreeCharsLikeSingleConsonant);
        firstThreeCharsLikeSingleConsonant.setSuccessor(firstTwoCharsLikeSingleConsonant);
        firstTwoCharsLikeSingleConsonant.setSuccessor(startsWithConsonant);
        
        return startsWithVowel.process(input);
    }
    
    private abstract class Rule {
        private Rule successor;
        public abstract boolean canApplyRule(String input);
        public abstract String applyRule(String input);
        
        public String process(String input) {
            if (canApplyRule(input)) {
                return applyRule(input);
            } else if (successor != null) {
                return successor.process(input);
            } else {
                return input;
            }
        }
        
        public void setSuccessor(Rule successor) {
            this.successor = successor;
        }
    }
    
    private class RuleStartsWithVowel extends Rule {
        @Override
        public boolean canApplyRule(String input) {
            char firstCh = input.charAt(0);
            return (firstCh == 'a' || (firstCh == 'e') || firstCh == 'i' ||
                    firstCh == 'o' || firstCh == 'u') ;
        }

        @Override
        public String applyRule(String input) {
            return input + "ay";
        }
    }
    
    private class RuleTreatFirstTwoCharsLikeSingleVowel extends Rule {
        @Override
        public boolean canApplyRule(String input) {
            if (input.length() > 2) {
                String str = input.substring(0, 2);
                return (str.equals("yt") || str.equals("xr")); 
            }
            return false;
        }

        @Override
        public String applyRule(String input) {
            return input + "ay";
        }
    }
    
    private class RuleTreatFirstThreeCharsLikeSingleConsonant extends Rule {
        @Override
        public boolean canApplyRule(String input) {
            if (input.length() > 3) {
                String str = input.substring(0, 3);
                return (str.equals("thr") || str.equals("sch") || str.endsWith("qu"));
            }
            return false;
        }

        @Override
        public String applyRule(String input) {
            return input.substring(3) + input.substring(0, 3) + "ay";
        }
    }
    
    private class RuleTreatFirstTwoCharsLikeSingleConsonant extends Rule {
        @Override
        public boolean canApplyRule(String input) {
            if (input.length() > 2) {
                String str = input.substring(0, 2);
                return (str.equals("ch") || str.equals("qu") || str.equals("th")); 
            }
            return false;
        }

        @Override
        public String applyRule(String input) {
            return input.substring(2) + input.substring(0, 2) + "ay";
        }
    }
    
    private class RuleStartsWithConsonant extends Rule {
        @Override
        public boolean canApplyRule(String input) {
            return input.length() > 1;
        }

        @Override
        public String applyRule(String input) {
            return input.substring(1) + input.substring(0, 1) + "ay";
        }
    }
}
