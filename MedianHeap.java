import java.util.*;
public class MedianHeap {
    static PriorityQueue<Integer> max_pq = new PriorityQueue<>((a,b) -> b-a);
    static PriorityQueue<Integer> min_pq = new PriorityQueue<>();
    public static void insertHeap(int x)
    {
        if(max_pq.isEmpty() || max_pq.peek() > x){
            max_pq.add(x);
        }else{
            min_pq.add(x);
        }   
        balanceHeaps();
        return;
    }

    public static void balanceHeaps()
    {
       if(max_pq.size()>min_pq.size()+1){
           min_pq.add(max_pq.remove());
       }else if(max_pq.size()+1<min_pq.size()){
           max_pq.add(min_pq.remove());
       }
       return;
    }
    
    public static double getMedian()
    {
        if(max_pq.size()>min_pq.size()){
            return (double)max_pq.peek();
        }else if(max_pq.size() < min_pq.size()){
            return (double)min_pq.peek();
        }else{
            return (double)(min_pq.peek()+max_pq.peek())/2;
        }
    }
    public static void main(String[] args) {
        int[] arr = {5,15,1};
        for(int i=0;i<arr.length;i++){
            insertHeap(arr[i]);
            System.out.println((int)getMedian());
            System.out.println("max heap: "+max_pq);
            System.out.println("min heap: "+min_pq);
        }
    }
}
