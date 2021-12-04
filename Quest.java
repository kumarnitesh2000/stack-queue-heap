import java.util.*;
public class Quest {
    // is popped stack permutation of pushed stack
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();  
        int j=0;
        for(int i=0;i<pushed.length;i++){
            st.push(pushed[i]);
            while(!st.isEmpty() && st.peek()==popped[j]){
              j++;
              st.pop();
            }
        }
        return j==popped.length;
    }
    // celebrity problem depend on elimination concept from stack
    boolean check(int M[][],int c){
        int n = M.length;
        for(int i=0;i<n;i++){
            if(i!=c && M[c][i]!=0){
                return false;
            }
        }
        for(int i=0;i<n;i++){
            if(i!=c && M[i][c]!=1){
                return false;
            }   
        }
        return true;
    }
    int celebrity(int M[][], int n)
    {
    	Stack<Integer> st = new Stack<>();
    	for(int i=0;i<n;i++)st.push(i);
    	//System.out.println(st.size());
    	for(int i=0;i<n-1;i++){
    	    int p1 = st.pop(),p2 = st.pop();
    	    if(M[p1][p2]==1)st.push(p2);else st.push(p1);
    	    //System.out.println(st.size());
    	}
    	int p = st.pop();
    	boolean res = check(M,p);
    	return res ? p : -1; 
    }
}
