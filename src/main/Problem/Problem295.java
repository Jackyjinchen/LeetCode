import java.util.PriorityQueue;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/27
 * @Content: 295. 数据流的中位数
 * 通过一个大根堆一个小根堆，中位数在中间。
 */
public class Problem295 {

    public static void main(String[] args) {
        int num = 3;
        MedianFinder obj = new MedianFinder();
        obj.addNum(num);
        double param_2 = obj.findMedian();
    }

    static class MedianFinder {
        PriorityQueue<Integer> queue1;
        PriorityQueue<Integer> queue2;

        public MedianFinder() {
            queue1 = new PriorityQueue<Integer>((a, b) -> b - a);
            queue2 = new PriorityQueue<Integer>((a, b) -> a - b);
        }

        public void addNum(int num) {
            if (queue1.isEmpty() || num <= queue1.peek()) {
                queue1.offer(num);
                if(queue1.size() - queue2.size() > 1) {
                    queue2.offer(queue1.poll());
                }
            } else {
                queue2.offer(num);
                if(queue2.size() > queue1.size()) {
                    queue1.offer(queue2.poll());
                }
            }
        }

        public double findMedian() {
            if (queue1.size() > queue2.size()) {
                return queue1.peek();
            } else {
                return (queue1.peek() + queue2.peek()) / 2.0;
            }
        }
    }
}
