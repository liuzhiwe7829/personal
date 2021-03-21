package Offer._59;

import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length ==0) {
            return new int[0];
        }
        int left =0,right = left + k-1,max=Integer.MIN_VALUE,j=0;
        int[] res=new int[nums.length -k+1];
        while(right  != nums.length ){
            for(int i=left;i<=right;i++){
                if(max < nums[i]) {
                    max=nums[i];
                }
            }
            left++;
            right++;
            res[j] = max;
            j++;
            max=Integer.MIN_VALUE;
        }
        return res;
    }
//
//    class MaxQueue {
//        Queue<Integer> queue ;
//        Queue<Integer> list;
//        public MaxQueue() {
//            queue = new LinkedList<>();
//             list = new LinkedList<>();
//        }
//
//        public int max_value() {
//            if(queue.size()==0) {
//                return -1;
//            }
//            Collections.sort(list, (o1, o2) -> o1-o2);
//            return list.size()!=0?list.get(list.get(0)):-1;
//        }
//
//        public void push_back(int value) {
//            queue.add(value);
//            list.add(value);
//        }
//
//        public int pop_front() {
//            if(queue.size()==0){
//                return -1;
//            }
//            int z = queue.poll();
//            list = new ArrayList<>(queue);
//            list.remove(list.size()-1);
//            return z;
//        }
//    }

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 *
 *
 *
 *
 */

class MaxQueue1 {
    Deque<Integer> res, max;
    public MaxQueue1() {
        res = new LinkedList<Integer>();
        max = new LinkedList<Integer>();
    }

    public int max_value() {
        if(max.isEmpty()) {
            return -1;
        }
        return max.peekFirst();
    }

    public void push_back(int value) {
        res.addLast(value);
        while(!max.isEmpty() && max.peekLast()<value) {
            max.removeLast();
        }
        max.addLast(value);
    }

    public int pop_front() {
        if(res.isEmpty()) {
            return -1;
        }
        int temp= res.pollFirst();
        if(temp == max.peekFirst()) {
            max.removeFirst();
        }
        return temp;
    }
}

    class MaxQueue {
        LinkedList<Integer> list1;
        LinkedList<Integer> list2;
        public MaxQueue() {
            list1 = new LinkedList<>();
            list2 = new LinkedList<>();
        }

        public int max_value() {
            if(list2.isEmpty()) {
                return -1;
            }
            return list2.peekFirst();
        }

        public void push_back(int value) {
            list1.offer(value);
            while(!list2.isEmpty()&&list2.peekLast()<value){
                list2.pollLast();
            }
            list2.offer(value);
        }

        public int pop_front() {
            if(list1.isEmpty()) {
                return -1;
            }
            if(list1.peekFirst().equals(list2.peekFirst())){
                list2.pollFirst();
                return list1.pollFirst();
            }
            return list1.pollFirst();
        }
    }
}