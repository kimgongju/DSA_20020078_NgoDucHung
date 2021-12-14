import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Set<String> set = new HashSet<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        input.nextLine();
        while (n-- > 0) {
            set.add(input.next() + " " + input.next());
            System.out.println(set.size());        
        }
    }
}
