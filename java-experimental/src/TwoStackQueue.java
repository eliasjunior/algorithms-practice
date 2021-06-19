import java.util.ArrayDeque;
import java.util.Deque;

class TwoStackQueue {
    private Deque<Integer> stack;
    private Deque<Integer> aux;

    /** Initialize your data structure here. */
    public TwoStackQueue() {
        stack =  new ArrayDeque<>();
        aux = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(auxEmpty()) {
            while (stack.size() != 0)
                aux.push(stack.pop());
        }
        return aux.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(auxEmpty()) {
            while (stack.size() != 0)
                aux.push(stack.pop());
        }
        return aux.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.size() == 0 && auxEmpty();
    }

    private boolean auxEmpty() {
        return aux.size() == 0;
    }

    public static void main(String[] args) {
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        twoStackQueue.push(1);
        twoStackQueue.push(2);
        twoStackQueue.push(4);
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */