package Week9;

public class MaxHeapArr {
    public int[] heap;
    public int size;
    public int maxSize;
    
    public MaxHeapArr(int maxSize) {
        this.size = 0;
        this.maxSize = maxSize;
        heap = new int[this.maxSize + 1];
        heap[0] = Integer.MAX_VALUE;
    }

    public int parent(int pos) {
        return pos / 2;
    }

    public int leftChild(int pos) {
        return pos * 2;
    }

    public int rightChild(int pos) {
        return pos * 2 + 1;
    }

    public boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }

        return false;
    }

    public void swap(int x, int y) {
        int temp = heap[x];
        
        heap[x] = heap[y];
        heap[y] = temp;
    }

    public void changeDown(int pos) {
        if (isLeaf(pos)) {
            return;
        }
        if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
            if (heap[rightChild(pos)] > heap[leftChild(pos)]) {
                swap(pos, rightChild(pos));
                changeDown(rightChild(pos));
            } else {
                swap(pos, leftChild(pos));
                changeDown(leftChild(pos));
            }
        }
    }

    public void changeUp(int pos) {
        int temp = heap[pos];

        while (pos > 0 && heap[parent(pos)] < temp) {
            heap[pos] = heap[parent(pos)];
            pos = parent(pos);
        }
        heap[pos] = temp;
    }

    public void insert(int number) {
        int cur = ++size;

        heap[size] = number;
        changeUp(cur);
    }

    public int remove() {
        int max = heap[1];

        heap[1] = heap[size--];
        changeDown(1);

        return max;
    }

    public static void main(String[] arg) {
        MaxHeapArr heapTest = new MaxHeapArr(20);

        heapTest.insert(5);
        heapTest.insert(3);
        heapTest.insert(17);
        heapTest.insert(10);
        heapTest.insert(84);
        heapTest.insert(19);
        heapTest.insert(6);
        heapTest.insert(22);
        heapTest.insert(9);
        System.out.println(heapTest.remove());
        System.out.println(heapTest.remove());
        System.out.println(heapTest.remove());
        System.out.println(heapTest.remove());
        System.out.println(heapTest.remove());
        System.out.println(heapTest.remove());
        System.out.println(heapTest.remove());
        System.out.println(heapTest.remove());
        System.out.println(heapTest.remove());
    }
}
