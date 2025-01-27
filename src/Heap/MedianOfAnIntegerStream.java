package Heap;

import java.util.PriorityQueue;

public class MedianOfAnIntegerStream {
    private static final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private static final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

    public static void main(String[] args) {
        add(8);
        add(7);
        add(5);
        add(4);
        add(6);
        add(3);
        add(2);
        add(2);
        add(1);
        add(0);
        System.out.println(getMedian());

    }

    private static void add(int num) {

        if (!maxHeap.isEmpty() && maxHeap.peek() > num) {
            maxHeap.add(num);
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }
        } else {
            minHeap.add(num);
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }


    }

    private static double getMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }
}
