// 232. Implement Queue using Stacks  

// Difficulty: Easy
// Implement the following operations of a queue using stacks.

// push(x) -- Push element x to the back of queue.
// pop() -- Removes the element from in front of queue.
// peek() -- Get the front element.
// empty() -- Return whether the queue is empty.

// Notes:
// You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
// Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
// You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).



// ---------------------------------------------------------------------------------------------------
// use two stacks, one revstack as main, always to store the reverse order of push. 
// Another is temp, use to hold the thing coming out of revstack.

// the push operation is to push into revstack, if revstack is not empty, poll all things into temp and push, 
// then poll all of them back.

//Time complexity : O(n)O(n).
// Each element, with the exception of the newly arrived, is pushed and popped twice. The last inserted element is popped and pushed once. Therefore this gives 4 n + 24n+2 operations where nn is the queue size. The push and pop operations have O(1)O(1) time complexity.

// Space complexity : O(n)O(n). We need additional memory to store the queue elements

class MyQueue {
    Stack<Integer> revstack = new Stack<>();
    Stack<Integer> temp = new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
        if(revstack.empty()){
            revstack.push(x);
        }else{
            while(!revstack.empty()){
                temp.push(revstack.pop());
            }
            revstack.push(x);
            while(!temp.empty()){
                revstack.push(temp.pop());
            }
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        revstack.pop();    
    }

    // Get the front element.
    public int peek() {
        return revstack.peek();    
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return revstack.empty();   
    }
}


// ---------------------------------------------------------------------------------------------------
// Amortized O(1)
// use two stack ,one as input , one as output
// use input to store the normal order, use output as reverse order.
// when peek, pull all input into output stack, and then peek.
// when pop, do peek first to find the top in ouput stack and then pop output stack.

// Push - O(1) per operation, Pop - Amortized O(1) per operation.
// n (for push operations) + 2*n (for first pop operation) + n - 1 ( for pop operations) which is O(2*n).
// This gives O(2n/2n) = O(1) average time per operation.
class MyQueue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
        input.push(x);   
    }

    // Removes the element from in front of queue.
    public void pop() {//get the number should pop in output stack and then pop
        peek();
        output.pop();
    }

    // Get the front element.
    public int peek() {// get the reverse order in output stack
        if(output.empty()){
            while(!input.empty()){
                output.push(input.pop());
            }    
        }
        return output.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return input.empty()&&output.empty();   
    }
}

// different outpput of pop()

// public class Queue {
//     private Stack<Integer> stack1;
//     private Stack<Integer> stack2;

//     public Queue() {
//       stack1 = new Stack<Integer>();
//       stack2 = new Stack<Integer>();
//     }
    
//     public void push(int element) {
//         stack1.push(element);
//     }

//     public int pop() {
//         int topnum = this.top();
//         if(!stack2.isEmpty()){
//             stack2.pop();
//         }
//         return topnum;
//     }

//     public int top() {
//         if(stack2.isEmpty()){
//             while(!stack1.isEmpty()){
//                 stack2.push(stack1.pop());
//             }
//         }
//         return stack2.peek();
//     }
// }
