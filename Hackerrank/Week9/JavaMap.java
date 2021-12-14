import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Map<String, String> map = new HashMap<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        input.nextLine();
        while (n-- > 0) {
            String key = input.nextLine();
            String value = input.nextLine();
            
            map.put(key, value);
        }
        
        while (input.hasNext()) {
            String query = input.nextLine();
            
            if (map.containsKey(query)) {
                System.out.println(query + "=" + map.get(query));
            } else {
                System.out.println("Not found"); 
            }
        }
    }
}
