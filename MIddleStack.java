class MiddleStack{
    static DoublyNode top=null,mid=null;
    static int cnt=0;
    static boolean flag = false;
    static void print(){
        if(top==null)return;
        DoublyNode ptr = top;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }
    static void push(int data){
        DoublyNode node = new DoublyNode(data);
        if(top==null){
            mid = node;
        }else{
            node.next = top;
            top.prev = node;
        }
        top = node;
        cnt++;
        // false = odd
        if(cnt%2==1 && cnt!=1){
            mid = mid.prev;
        }
    }   
    static int pop(){
        if(top==null)return -1;
        int val = top.data;
        cnt--;
        if(top.next==null){
            top = null;
            mid = null;
        }else{
            top.next.prev = null;
            top = top.next;
            if(cnt%2==0)mid = mid.next;
        }
        return val;
    } 
    static int findMiddle(){
        if(mid==null)return -1;
        return mid.data;
    }
    static int deleteMiddle(){
        if(mid==null)return -1;
        int data = mid.data;
        if(mid.prev!=null){
            mid.prev.next = mid.next;
        }
        if(mid.next!=null){
            mid.next.prev = mid.prev;
        }
        cnt--;
        if(cnt%2==0){
            mid = mid.next;
        }else{
            mid = mid.prev;
        }
        return data;
    }
    public static void main(String[] args){
        //midde element
        System.out.println(findMiddle());
        push(1);push(2);push(3);push(4);
        deleteMiddle();
        deleteMiddle();
        System.out.println(findMiddle());
        //print();

    }
}

class DoublyNode{
    DoublyNode next,prev;
    int data;
    DoublyNode(int data){
        this.data = data;
    }
}