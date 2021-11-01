package Week8;

import java.util.Scanner;
import java.util.TreeMap;

public class Ex6Upd {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        input.nextLine();
        while (n-- > 0) {
            String temp = input.nextLine();

            if (treeMap.containsKey(temp)) {
                treeMap.put(temp, 1 + treeMap.get(temp));
            } else {
                treeMap.put(temp, 1);
            }
        }
        System.out.println(treeMap);
    }
}
