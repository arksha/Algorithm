// 155. Min Stack  QuestionEditorial Solution  My Submissions
// Total Accepted: 82619
// Total Submissions: 349045
// Difficulty: Easy
// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// getMin() -- Retrieve the minimum element in the stack.
// Example:
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin();   --> Returns -3.
// minStack.pop();
// minStack.top();      --> Returns 0.
// minStack.getMin();   --> Returns -2.


// ----------------------------------------------------------------------------------------------------
// Analyze: 
// 1. have two stacks to implement.
// 2. use min stack to store current min peek
 
// NB:
// 1. Don't mix up == and equals, use min.peek().equals(s.peek())  instead of ==
// 2. remember the logic when writing code 

public class MinStack {
    Stack<Integer> s;
    Stack<Integer> min;
    public MinStack() {
        // do initialize if necessary
        s = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    public void push(int number) {
        if (min.isEmpty() || number <= min.peek()) {
            min.push(number);
        }
        s.push(number);
        // write your code here
    }

    public int pop() {
        if (min.peek().equals(s.peek())){
            min.pop();
        }
        return s.pop();
        // write your code here
    }

    public int min() {
        return min.peek();
        // write your code here
    }
}


