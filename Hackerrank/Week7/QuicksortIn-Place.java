import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<Integer> arr = new ArrayList<>();
        
        while (input.hasNext()) {
            arr.add(input.nextInt());
        }
        quickSort(arr, 0, n - 1);
    }
    
    public static void quickSort(List<Integer> arr, int l, int r) {
        if(l < r) {
            int mid = partition(arr, l, r);
            
            for(int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            quickSort(arr, l, mid - 1);
            quickSort(arr, mid + 1, r);
        }
    }
    
    public static int partition(List<Integer> arr, int l, int r) {
        int pivot = arr.get(r);
        int i = l;
        
        for(int j = l; j < r; ++j) {
            if(arr.get(j) <= pivot) {
                arr = swap(arr, i, j);
                ++i;
            }
        }
        arr = swap(arr, i, r);
        
        return i;
    }
    
    public static List<Integer> swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        
        arr.set(i, arr.get(j));
        arr.set(j, temp);
        
        return arr;
    }
}
