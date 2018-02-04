import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class School {
    
    private Map<Integer, List<String>> roster;
    
    public School() {
        roster = new HashMap<>();
    }
    
    public int numberOfStudents() {
        int count = 0;
        for (Entry<Integer, List<String>> entry: roster.entrySet()) {
            count += entry.getValue().size();
        }
        return count;
    }
    
    public void add(String student, int grade) {
        List<String> students = roster.get(grade);
        if (students == null) {
            students = new ArrayList<String>();
            roster.put(grade, students);
        }
        students.add(student);
    }
    
    public List<String> grade(int grade) {
        List<String> list = new ArrayList<>();
        List<String> students = roster.get(grade);
        if (students != null) {
            for (String student : students) {
                list.add(student);
            }
        }
        Collections.sort(list);
        return list;
    }
    
    public Map<Integer, List<String>> studentsByGradeAlphabetical() {
        Map<Integer, List<String>> map = new HashMap<>();
        for (Entry<Integer, List<String>> entry: roster.entrySet()) {
            List<String> list = new ArrayList<>();
            map.put(entry.getKey(), list);
            list.addAll(entry.getValue());
            Collections.sort(list);
        }
        return map;
    }
}
