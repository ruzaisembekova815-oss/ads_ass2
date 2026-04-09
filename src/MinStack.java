//Design a "Min-Stack" that supports push, pop, top, and retrieving the minimum element in constant O(1) time.
import java.util.Stack;

class MinStack {

    private Stack<Integer> stack;      // main stack
    private Stack<Integer> minStack;   // keeps track of minimum values

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push element onto stack
    public void push(int x) {
        stack.push(x);

        // Push to minStack only if it's the new minimum
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    // Remove the top element
    public void pop() {
        if (stack.isEmpty()) return;

        int removed = stack.pop();

        // If the removed element was the minimum, remove it from minStack too
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    // Get the top element
    public int top() {
        return stack.peek();
    }

    // Get the minimum element in O(1)
    public int getMin() {
        return minStack.peek();
    }

    
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println("Current min = " + minStack.getMin()); 

        minStack.pop();

        System.out.println("Top element = " + minStack.top());     
        System.out.println("Current min = " + minStack.getMin());  
    }
}
