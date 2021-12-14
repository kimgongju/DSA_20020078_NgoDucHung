import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Integer> before = new Stack();
        Stack<Integer> after = new Stack();
        int n = input.nextInt();
        
        for (int i = 0; i < n; ++i) {
            int type = input.nextInt();
            
            if (type < 2) {
                int number = input.nextInt();
                
                before.push(number);
            } else {
                if (after.empty()) {
                    while (!before.empty()) {
                        after.push(before.pop());
                    }
                }
                if (type < 3){
                    after.pop();
                } else {
                    System.out.println(after.peek());
                }
            }
        }
    }
}
