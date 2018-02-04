import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class KindergartenGarden {

    private String garden;
    private String[] students;
    
    private String[] defaultStudents = {
            "Alice", "Bob", "Charlie", "David",
            "Eve", "Fred", "Ginny", "Harriet",
            "Ileana", "Joseph", "Kincaid", "Larry"
    };
    
    KindergartenGarden(String garden, String[] students) {
        this.garden = garden;
        Arrays.sort(students);
        this.students = students;
    }

    KindergartenGarden(String garden) {
        this.garden = garden;
        this.students = defaultStudents;
    }

    List<Plant> getPlantsOfStudent(String student) {
        List<Plant> list = new ArrayList<>();
        int index = getIndex(student);
        String[] rows = garden.split("\\n");
        list.add(Plant.getPlant(rows[0].charAt(2 * index)));
        list.add(Plant.getPlant(rows[0].charAt(2 * index + 1)));
        list.add(Plant.getPlant(rows[1].charAt(2 * index)));
        list.add(Plant.getPlant(rows[1].charAt(2 * index + 1)));
        return list; 
    }
    
    private int getIndex(String student) {
        int i = 0;
        for (String str : students) {
            if (str.equals(student)) {
                return i;
            }
            i++;
        }
        return -1;
    }

}
