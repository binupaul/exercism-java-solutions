import java.util.Arrays;
import java.util.List;

public class DiamondPrinter {
    
    public List<String> printToList(char ch) {
        int dim = 2 * (ch - 'A') + 1;
        String[] arr = new String[dim];
        int i = 0;
        
        // top to middle
        while(i < (dim - 1) / 2) {
            int prefixSpace = (dim - 1) / 2 - i;
            char printchar = (char) ('A' + i);
            int middle = (dim - 2 * prefixSpace);
            arr[i] = constructLine(prefixSpace, printchar, middle);
            i++;
        }
        
        // middle line
        arr[i] = constructLine(0, (char) ('A' + i), dim);
        
        // reflect top to middle
        for (int index = i + 1, j = (dim - 1) / 2 - 1; index < dim; index++, j--) {
            arr[index] = arr[j];
        }
        
        return Arrays.asList(arr);
    }
    
    private String constructLine(int prefixSpace, char printchar, int middle) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prefixSpace; i++) {
            sb.append(' ');
        }
        
        sb.append(printchar);
        
        if (middle-2 > 0) {
            for (int i = 0; i < middle - 2; i++) {
                sb.append(' ');
            }
            sb.append(printchar);
        } 
        
        for (int i = 0; i < prefixSpace; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}