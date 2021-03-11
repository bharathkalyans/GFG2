
class BinaryHeap {
     public static class MinHeap{
         int [] arr;
         int size;
         int capacity;

         MinHeap(int c){
             size = 0;
             capacity = c;
             arr = new int[c];
         }

         int left(int i) { return (2*i + 1); }
         int right(int i) { return (2*i + 2); }
         int parent(int i) { return (i-1)/2; }


         public void getHeap(){
             for (int x: arr)
                 System.out.println(x);
         }

         public void insert(int x) {
             if (size == capacity)return;
             size++;
             arr[size-1]=x;

             for (int i=size-1;i!=0 && arr[parent(i)]>arr[i];)
             {
                 swap(arr,i,parent(i));
                 i = parent(i);
             }
         }

         public void extractHeap(int i){
             if (size == 0)
                return;

             if (size == 1){
                 size --;
                 return;
             }


             swap(arr,i,size );
             arr[size --] =0  ;
             heapifyHeap(i);

         }

         public void decreaseKey(int i,int value){
             if(i > size)
                 return;
             arr[i]=value;

             while (i!=0 && arr[parent(i)] > arr[i]){
                 swap(arr,parent(i),i);
                 i=parent(i);
             }

         }

         public void heapifyHeap(int i){
            int lt=left(i),rt =right(i);

            int smallest =i;
            if (lt < size && arr[lt]<arr[i]){
                smallest = lt;
            }
            if (rt < size && arr[rt] < arr[smallest]){
                smallest = rt;
            }

           if (smallest!=i){
               swap(arr,smallest,i);
               heapifyHeap(smallest);
           }

         }

          public void swap(int []arr,int i,int j){
             int temp = arr[i];
             arr[i] = arr[j];
             arr[j] = temp;
         }

     }




     public static void main(String []args)
     {
         MinHeap h= new MinHeap(11);
         h.insert(3);
         h.insert(2);
         h.insert(15);
         h.insert(20);
         h.getHeap();
         h.extractHeap(0);
         h.getHeap();
     }
}

