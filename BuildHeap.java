public class BuildHeap {
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return;
    }
    public static void heapify(int[] arr,int n,int root_index){
        int largest = root_index;
        int l = root_index*2+1;
        int r = root_index*2+2;
        // chose the largest child
        if(l < n && arr[largest] < arr[l])largest = l;
        if(r < n && arr[largest] < arr[r])largest = r;
        if(largest!=root_index){
            swap(arr,largest,root_index);
            heapify(arr,n,largest);
        }
    }
    public static void buildHeap(int[] arr){
        // get index of first non leaf node
        int n = arr.length;
        int first_leaf = (n/2)-1;
        for(int i=first_leaf; i>=0; i--)
        heapify(arr,n,i);
    }
    public static void heapSort(int arr[], int n)
    {
        buildHeap(arr);
        for(int i=n-1; i > 0; i--){
            swap(arr,i,0);
            heapify(arr,i,0);
        }
    }
    public static void main(String[] args){
        //int arr[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
        int[] arr = {4,1,3,9,7};
        //buildHeap(arr);
        heapSort(arr, 5);
        for(int i=0;i<arr.length;i++)System.out.print(arr[i]+" ");
        System.out.println();
    }
}
