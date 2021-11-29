import java.util.*;
public class ImplementOpp {
    
}
// implement queue using stack
class StackQueue
{
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    void Push(int x)
    {
        s1.push(x);
    }
    int Pop()
    {
	   if(s2.isEmpty()){
	       while(!s1.isEmpty()){
	           s2.push(s1.pop());
	       }
	   }
	   if(s2.isEmpty())return -1;
	   return s2.pop();
    }
}
// implement stack using queue
class MyStack {
    Queue<Integer> q1,q2;
    public MyStack() {
      q1 = new LinkedList<>();
      q2 = new LinkedList<>();
    }
    
    public void push(int x) {
      while(!q1.isEmpty()){
        q2.add(q1.poll());
      }
      q1.add(x);
      while(!q2.isEmpty()){
        q1.add(q2.poll());
      }
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}