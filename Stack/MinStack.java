import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty())
            throw new RuntimeException("Stack is empty");
        int top = stack.pop();
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty())
            throw new RuntimeException("Stack is empty");
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
