import java.util.*;
public class Heap_Question {
    // merge k sorted arrays with k elements in each array
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.ele-b.ele);
        //init pq
        for(int i=0;i<k;i++){
            pq.add(new Node(i,0,arr[i][0]));            
        }
        while(pq.size()>0){
            Node min_ele = pq.remove();int r = min_ele.i,c = min_ele.j+1;
            res.add(min_ele.ele);
            if(c<k)
            pq.add(new Node(r,c,arr[r][c]));
        }
        return res;
    }
    // Smallest range in K lists
    static int[] findSmallestRange(int[][] KSortedArray,int n,int k)
	{
	    int max = Integer.MIN_VALUE;
	    PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.ele-b.ele);
	    for(int i=0;i<k;i++){
	        max = Math.max(max,KSortedArray[i][0]);
	        pq.add(new Node(i,0,KSortedArray[i][0]));
	    }
	    int[] ans = {-100000,100000};   
	    while(true){
	       Node mini = pq.remove();
	       int r = mini.i,c = mini.j+1;
	       int min = mini.ele;
	       if(max-min < ans[1]-ans[0]){
	           ans[0] = min;ans[1] = max;
	       }
	       if(c==n){
	           break;
	       }else{
	           pq.add(new Node(r,c,KSortedArray[r][c]));
	           max = Math.max(KSortedArray[r][c],max);
	       }
	    }
	    return ans;
    }
    // kth largest element 
    /*
    we use min heap to find kth largest element because we want to ignore small elements and move the large one in heap
    */
    int[] kLargest(int[] arr, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        for(int i=0;i<k;i++)pq.add(arr[i]);
        for(int i=k;i<n;i++){
            if(pq.peek() < arr[i]){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        int[] res = new int[k];
        // kth largest is pq.remove()
        int index = k-1;
        while(!pq.isEmpty()){
            res[index--] =pq.remove(); 
        }
        return res;
    }
    // reorganize string
    //https://leetcode.com/problems/reorganize-string/
    public static String reorganizeString(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        StringBuilder out = new StringBuilder("");
        for(Character c: s.toCharArray()){
            hm.put(c,hm.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->hm.get(b)-hm.get(a));
        for(Map.Entry<Character,Integer> map: hm.entrySet()){
            pq.add(map.getKey());
        }
        while(pq.size() > 1){
            char most_freq_char_curr = pq.poll();
            char most_freq_char_next = pq.poll();
            out.append(most_freq_char_curr);
            out.append(most_freq_char_next);
            hm.put(most_freq_char_curr,hm.get(most_freq_char_curr)-1);hm.put(most_freq_char_next,hm.get(most_freq_char_next)-1);
            if(hm.get(most_freq_char_curr)>0)pq.add(most_freq_char_curr);
            if(hm.get(most_freq_char_next)>0)pq.add(most_freq_char_next);
        }
        if(!pq.isEmpty()){
            char last = pq.poll();
            if(hm.get(last) > 1){
                return "";
            }else{
                out.append(last);
            }
        }
        return out.toString();
    }
    // convert bst to min heap
    // create a inorder and then overwrite the nodes in preorder
    private static void bstToArray(NodeC root, ArrayList<Integer> arr){
        if(root==null)
            return;
        bstToArray(root.left, arr);
        arr.add(root.data);
        bstToArray(root.right, arr);
     }
  
     static int  index = 0;
     private static void arrToMinHeap(NodeC root, ArrayList<Integer> arr){
        if(root== null)
            return;
        root.data = arr.get(index++);
        arrToMinHeap(root.left, arr);
        arrToMinHeap(root.right, arr);
    }
     static void convertToMinHeap(NodeC root)
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        bstToArray(root, arr);
        arrToMinHeap(root,arr);
    } 
    // kth largest sum in contigous sum subarray
    // in image
}

class Node{
    int i,j,ele;
    Node(int i,int j,int ele){
        this.i=i;
        this.j=j;
        this.ele=ele;
    }
}

class NodeC{
    NodeC left;NodeC right;
    int data;
    NodeC(int d){
        this.data=d;
    }
}