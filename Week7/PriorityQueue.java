package Week7;

public class PriorityQueue {
    java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();

    void insert(int x) {
        pq.add(x);
    }

    void deleteMin() {
        System.out.println(pq.peek());
        pq.remove();
    }
}
