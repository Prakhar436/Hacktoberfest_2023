import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q;
    public StackUsingQueue(){
    q = new LinkedList<>();
    }

    public void push(int value) {
        q.add(value);
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }
        int val = q.peek();
        q.add(q.remove());
        return val;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }
        return q.remove();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Peeking: "+stack.peek());
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println(stack.pop());//should return -1
    }

}
