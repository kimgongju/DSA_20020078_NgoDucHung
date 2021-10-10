package Week5;

import java.util.concurrent.ThreadLocalRandom;

public class Sort {
    public static void main(String[] args) {
        int n = ThreadLocalRandom.current().nextInt(1, 20);
        int[] array = new int[n];

        for (int i = 0; i < n; ++i) {
            array[i] = ThreadLocalRandom.current().nextInt(-1, 1000);
            System.out.print(array[i] + " ");
        }
        System.out.println("");
        Sort newObject = new Sort();
        newObject.sort(array, 0, array.length - 1);
        for (int i = 0; i < n; ++i) {
            System.out.print(array[i] + " ");
        }
    }

    public void sort(int array[], int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            sort(array, left, mid);
            sort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public void merge(int array[], int left, int mid, int right) {
        int length1 = mid - left + 1;
        int length2 = right - mid;
        int count = left;
        int count1 = 0;
        int count2 = 0;
        int l[] = new int[length1];
        int r[] = new int[length2];

        for (int i = 0; i < length1; ++i) {
            l[i] = array[left + i];
        }
        for (int i = 0; i < length2; ++i) {
            r[i] = array[mid + 1 + i];
        }
        while (count1 < length1 && count2 < length2) {
            if (l[count1] < r[count2]) {
                array[count++] = l[count1++];
            } else {
                array[count++] = r[count2++];
            }
        }
        while(count1 < length1) {
            array[count++] = l[count1++];
        }
        while(count2 < length2) {
            array[count++] = r[count2++];
        }
    }
}
