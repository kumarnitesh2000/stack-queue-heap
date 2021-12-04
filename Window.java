import java.util.*;

public class Window{
    // maximum element in k size window
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;// n=4, k=3 -> res_length = n-k+1
        int[] res = new int[n-k+1];
        int index = 0;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < nums.length;i++){
            if(!dq.isEmpty() && dq.peek()==i-k)dq.poll();
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])dq.pollLast();
            dq.add(i);
            if(i>=k-1)res[index++] = nums[dq.peek()];
        }
        return res;
    }
    // https://www.geeksforgeeks.org/sum-minimum-maximum-elements-subarrays-size-k/
    public static int SumOfKsubArray(int arr[] , int k){
        int sum = 0;
        int n = arr.length;
        // put max element at the front part always
        Deque<Integer> dq_max = new LinkedList<>();
        // put min element at the back part always
        Deque<Integer> dq_min = new LinkedList<>();
        for(int i=0;i<n;i++){
            // remove outside wind participants
            if(!dq_max.isEmpty() && i-k==dq_max.peek())dq_max.poll();
            if(!dq_min.isEmpty() && i-k==dq_min.peek())dq_min.poll();
            // check for inc/dec order
            while(!dq_max.isEmpty() && arr[dq_max.peekLast()] <= arr[i])dq_max.pollLast();
            while(!dq_min.isEmpty() && arr[dq_min.peekLast()] >= arr[i])dq_min.pollLast();
            // add in dq
            dq_max.add(i);dq_min.add(i);
            // window init
            if(i>=k-1){
                System.out.println(arr[dq_max.peek()]+" "+arr[dq_min.peek()]);
                sum+=arr[dq_min.peek()]+arr[dq_max.peek()];
            }
        }
        return sum;
    }
    // find the first negative element in every k window size
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        long[] res = new long[N-K+1];
        int index = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<N;i++){
            if(!q.isEmpty() && i-K==q.peek())q.poll();
            if(A[i] < 0)q.add(i);
            if(i>=K-1){
                if(!q.isEmpty())res[index++] = A[q.peek()];
                else res[index++] = 0;
            }
        }
        return res;
    }
    // https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1#
    public String FirstNonRepeating(String A)
    {
        Queue<Character> q = new LinkedList<>();
        int n = A.length();
        int[] freq = new int[256];
        StringBuilder out = new StringBuilder("");
        for(int i=0;i<n;i++){
            char c = A.charAt(i);
            if(freq[c]==0)q.add(c);
            freq[c]++;
            
            while(!q.isEmpty() && freq[q.peek()]>1)q.poll();
            
            if(!q.isEmpty())out.append(q.peek());
            else out.append('#');
        }
        return out.toString();
    }
    public static void main(String[] args){
        int[] nums = {3,-1,2,-3,4,5,6,-7};
        int[] res = maxSlidingWindow(nums,3);
        for(int i: res)System.out.print(i+" ");
        System.out.println();        
        System.out.println(SumOfKsubArray(new int[]{2, 5, -1, 7, -3, -1, -2}, 4));// out = 18
    }

}
