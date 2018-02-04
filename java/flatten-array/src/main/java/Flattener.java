import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Flattener {
    
    public List<Object> flatten(List<Object> initialList) {
        List<Object> returnList = new ArrayList<>();
        Deque<Object> deque = new LinkedList<Object>();
        
        deque.add(initialList);
        
        while (!deque.isEmpty()) {
            Object item = deque.removeFirst();
            if (item != null) {
                if (item instanceof List<?>) {
                    List<?>  list = (List<?>) item;
                    ListIterator<?> li = list.listIterator(list.size());
                    while(li.hasPrevious()) {
                        deque.addFirst(li.previous());
                    }
                } else {
                    returnList.add(item);
                }
            }
        }
        
        return returnList;
    }
}
