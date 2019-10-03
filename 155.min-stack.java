/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 *
 * https://leetcode.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (38.14%)
 * Likes:    2141
 * Dislikes: 231
 * Total Accepted:    353.5K
 * Total Submissions: 907.2K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * 
 * 
 * 
 * 
 */

// @lc code=start
// class MinStack {
//     Stack<Integer> st1;
//     Stack<Integer> st2;
//     /** initialize your data structure here. */
//     public MinStack() {
//          this.st1 = new Stack<>();
//          this.st2 = new Stack<>();
//     }
    
//     public void push(int x) {
//         st1.push(x);
//         if (st2.isEmpty() || x <= st2.peek()) st2.push(x);
//     }
    
//     public void pop() {
//         int temp = st1.pop();
//         if (temp == st2.peek()) st2.pop();
//     }
    
//     public int top() {
//         return st1.peek();
//     }
    
//     public int getMin() {
//         return st2.peek();
//     }
// }


class MinStack {
    Stack<Integer> st;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        this.st = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min) {
            st.push(min);
            min = x;
        }
        st.push(x);
    }

    public void pop() {
        int temp = st.pop();
        if (temp == min) {
            min = st.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

