// 225. Implement Stack using Queues  

// Difficulty: Easy
// Implement the following operations of a stack using queues.

// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// empty() -- Return whether the stack is empty.

// Notes:
// You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
// Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
// You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
// Update (2015-06-11):
// The class name of the Java function had been updated to MyStack instead of Stack.

// ------------------------------------------------------------------------------------------------
// use one queue to store stack. 
// when pop, poll all out expect peek, and then offer back to queue.
// when top, get the stackpeek to the front of the queue, peek, and then offer it back into queue. 

class MyStack {
    Queue<Integer> q = new LinkedList<>();
    int stackpeek;
    // Push element x onto stack.
    public void push(int x) {
        q.offer(x);
        stackpeek = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        for(int i = 0;i<q.size()-1;i++){
            q.offer(q.poll());
        }
        q.poll();
    }

    // Get the top element.
    public int top() {
        for(int i = 0;i<q.size()-1;i++){
            q.offer(q.poll());
        }
        stackpeek = q.peek();
        q.offer(q.poll());//get it back to queue end
        return stackpeek;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();    
    }
}