import java.util.*;
public class NextGreater {
    public static void print(int[] a){
        for(int i=0;i<a.length;i++)System.out.print(a[i]+" ");
        System.out.println();
    }
    // next greater element 1
    public static int[] nextLargerElement(int[] arr, int n)
    { 
        int[] nge = new int[n];Arrays.fill(nge,-1);
        Stack<Integer> st = new Stack<>(); 
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= arr[i])st.pop();
            if(!st.isEmpty())nge[i] = st.peek();
            st.push(arr[i]);
        }
        return nge;
    }
    // next greater element circluar
    public static int[] nextGreaterElementsCircular(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];Arrays.fill(nge,-1);
        Stack<Integer> st = new Stack<>(); 
        for(int i=2*n-1;i>=0;i--){
            int index = i%n;
            while(!st.isEmpty() && st.peek() <= arr[index])st.pop();
            if(!st.isEmpty())nge[index] = st.peek();
            st.push(arr[index]);
        }
        return nge;
    }
    public static void main(String[] args){
        int[] arr = {6,8,0,1,3};
        print(nextLargerElement(arr, 5));
        print(nextGreaterElementsCircular(arr));
    }
}
