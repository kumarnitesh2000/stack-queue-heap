import java.util.*;
public class Recursion {
    // sort the stack
    public static void insertSorted(Stack<Integer> s, int temp){
        if(s.isEmpty() || temp > s.peek()){
            s.push(temp);
        }else{
            int a  = s.pop();
            insertSorted(s, temp);
            s.push(a);
        }
    }
    public static void recurse(Stack<Integer> s){
        if(s.isEmpty()) return;
        int temp = s.pop();
        recurse(s);
        insertSorted(s,temp);
    }
    public static Stack<Integer> sort(Stack<Integer> s)
	{
        recurse(s);
        return s;
    }
    //reverse the stack using recursion
    public static void insert(Stack<Integer> s,int temp){
        if(s.isEmpty())s.push(temp);
        else{
            int a = s.pop();
            insert(s,temp);
            s.push(a);
        }

    }
    public static void reverse(Stack<Integer> s){
        if(s.isEmpty())return;
        int temp = s.pop();
        reverse(s);
        insert(s,temp);
    }
    // reverse a queue using recursion
    public void recurse(Queue<Integer> q){
        if(q.isEmpty())return;
        int temp = q.poll();
        recurse(q);
        q.add(temp);
    }
    public Queue<Integer> rev(Queue<Integer> q){
        recurse(q);
        return q;
    }
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(11);stack.push(2);stack.push(32);stack.push(3);stack.push(41);
        Stack<Integer> out = sort(stack);
        reverse(out);
        while(!out.isEmpty()){
            System.out.print(out.pop()+" ");
        }
        System.out.println("");
    }
}
