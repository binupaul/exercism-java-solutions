import java.util.ArrayList;
import java.util.List;

public class Allergies {
    private int score;
    
    public Allergies(int score) {
        this.score = score;
    }
    
    public boolean isAllergicTo(Allergen allergen) {
        return (allergen.getScore() & score) != 0;
    }
    
    public List<Allergen> getList() {
        List<Allergen> list = new ArrayList<>();
        for (Allergen allergen : Allergen.values()) {
            if (isAllergicTo(allergen)) {
                list.add(allergen);
            }
        }
        return list;
    }
}