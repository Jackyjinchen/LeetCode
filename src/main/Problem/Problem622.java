/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/11
 * @Content: 622 设计循环队列
 */
public class Problem622 {
    private int front;
    private int rear;
    private int[] queue;
    private int size;

    public Problem622(int k) {
        size = k + 1;
        queue = new int[k+1];
        front = 0;
        rear = 0;
    }

    public boolean enQueue(int value) {
        if(!isFull()) {
            queue[rear] = value;
            rear = (rear + 1) % size;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if(!isEmpty()) {
            front = (front + 1) % size;
            return true;
        }
        return false;
    }

    public int Front() {
        if(!isEmpty()) {
            return queue[front];
        }
        return -1;
    }

    public int Rear() {
        if(!isEmpty()) {
            return queue[((rear - 1) + size) % size];
        }
        return -1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }
}
