import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try {
            InputStreamReader input = new InputStreamReader(System.in);
            BufferedReader scan = new BufferedReader(input);
            int n = Integer.parseInt(scan.readLine());
            String current = "";
            Stack<String> lifo = new Stack();
            
            lifo.push(current);
            while (n-- > 0) {
                String inputString = scan.readLine();
                String[] inputArray = inputString.split(" ");
                switch (inputArray[0]) {
                case "1":
                    current += inputArray[1];
                    lifo.push(current);
                    break;
                case "2":
                    current = current.substring(0, current.length() - Integer.parseInt(inputArray[1]));
                    lifo.push(current);
                    break;
                case "3":
                    int number = Integer.parseInt(inputArray[1]);
                            
                    System.out.println(current.charAt(number - 1));
                    break;
                case "4":
                    lifo.pop();
                    current = lifo.peek();
                    break;
                }
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}
