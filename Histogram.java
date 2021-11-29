import java.util.*;
public class Histogram {
    public static void fillLeft(long[] leftNextSmall,long[] hist){
        Stack<Integer> stack  = new Stack<Integer>();
        for(int i=0;i<leftNextSmall.length;i++){
            while(!stack.isEmpty() && hist[stack.peek()] >= hist[i])stack.pop();
            if(!stack.isEmpty())leftNextSmall[i] = (long)stack.peek();
            stack.push(i);
        }
    }
    public static void fillRight(long[] rightNextSmall,long[] hist){
        Stack<Integer> stack  = new Stack<Integer>();
        for(int i=rightNextSmall.length-1;i>=0;i--){
            while(!stack.isEmpty() && hist[stack.peek()] >= hist[i])stack.pop();
            if(!stack.isEmpty())rightNextSmall[i] = (long)stack.peek();
            stack.push(i);
        }
    }
    public static long getMaxArea(long hist[], long n) 
    {
        long[] leftNextSmall = new long[(int)n];Arrays.fill(leftNextSmall,-1);
        long[] rightNextSmall = new long[(int)n];Arrays.fill(rightNextSmall,n);
        long max = (long)Integer.MIN_VALUE;
        fillLeft(leftNextSmall,hist);fillRight(rightNextSmall,hist);
        // for(long i: leftNextSmall)System.out.print(i+" ");
        // System.out.println();
        // for(long i: rightNextSmall)System.out.print(i+" ");
        // System.out.println();
        for(int i=0;i<n;i++){
            long res = (rightNextSmall[i]-(leftNextSmall[i]+1))*hist[i];
            max = Math.max(res,max);
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(getMaxArea(new long[]{6,2,5,4,5,1,6},7));
    }
}
