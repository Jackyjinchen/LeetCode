import java.util.Stack;

// 面试题 03.02. 栈的最小值
class MinStack {
    private Stack<Integer[]> stack = null;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(new Integer[]{x, stack.isEmpty() ? x : Math.min(stack.peek()[1],x)});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }


}