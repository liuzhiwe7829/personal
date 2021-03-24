package offer._30;

import java.util.Stack;

class MinStack {
    Stack<Integer> stackA ;
    Stack<Integer> stackB ;
    /** initialize your data structure here. */
    public MinStack() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void push(int x) {
        stackA.push(x);
        if (stackB.isEmpty() || x <= stackB.peek()) {
            stackB.push(x);
        }
    }

    public void pop() {
        if(stackA.pop()==(int)stackB.peek()) {
            stackB.pop();
        }
    }

    public int top() {
        return stackA.peek();
    }

    public int min() {
        return stackB.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */