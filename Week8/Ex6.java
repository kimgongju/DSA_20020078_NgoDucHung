package Week8;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int count = 0;
        String previous = "";

        input.nextLine();
        while (n-- > 0) {
            String temp = input.nextLine();

            pq.add(temp);
        }
        while (!pq.isEmpty()) {
            String temp = pq.remove();

            if (!temp.equals(previous)) {
                if (!previous.equals("")) {
                    System.out.println(previous + " " + count);
                }
                count = 0;
                previous = temp;
            }
            ++count;
        }
        System.out.println(previous + " " + count);
    }
}
