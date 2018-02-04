import java.util.List;

public class BinarySearch<T extends Comparable<T>>  {
    
    private List<T> list;
    
    public BinarySearch(List<T> list) {
        this.list = list;
    }
    
    public int indexOf(T item) {
        int start = 0;
        int end = list.size() - 1;
        
        while(start <= end) {
            int mid = (start + end) / 2 ;
            T listItem = list.get(mid);
            if (listItem.equals(item)) {
                return mid;
            }
            
            int comp = item.compareTo(listItem);
            if (comp < 0) {
                end = mid - 1;
            } else if (comp > 0) {
                start = mid + 1;
            }
        }
        return -1 ;
    }
}
