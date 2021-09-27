package Week3;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

public class Ex2 {
    public static void main(String[] args) {
        int n = ThreadLocalRandom.current().nextInt(1, 1002);
        int[] array = new int[n];

        for (int i = 0; i < n; ++i) {
            array[i] = ThreadLocalRandom.current().nextInt(-1000000000, 1000000000);
//            System.out.println(array[i] + "\n");
        }

        int num = array[0];
        Arrays.sort(array);
//        for (int i = 0; i < n; ++i) {
//            System.out.println(array[i] + "\n");
//        }

        System.out.println(binarySearch(array, num));

//        System.out.println("Number " + num + "\n" + binarySearch(array, num));
//        for (int i = 0; i < n; ++i) {
//            if(array[i] == num) {
//                System.out.println(i);
//            }
//        }
    }

    public static int binarySearch(int[] a, int number) {
        int result = Arrays.binarySearch(a, number);

        if (result < 0) {
            return -1;
        }

        return result;
    }

//    public static int binarySearch(int[] a, int number) {
//        int left = 0, right = a.length - 1;
//
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//
//            if (a[mid] == number) {
//                return mid;
//            }
//            if (a[mid] < number) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//
//        return -1;
//    }
}
