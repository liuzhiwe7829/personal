package offer._09;

import java.util.Stack;

class CQueue {
    private Stack<Integer> stack1,stack2;

    public CQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }
    
    public void appendTail(int value) {

        stack1.push(value);
    }
    
    public int deleteHead() {
        if(stack2.empty()){
            return  -1;
        }
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int res = stack2.pop();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return  res;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */