public class CustomArrayList {
    private static final int DEFAULTCAPACITY = 2 ;
    private int[] array;
    private int size;
    CustomArrayList(){
        array = new int[DEFAULTCAPACITY] ;
    }
    CustomArrayList(int initialSize){
        array = new int[initialSize] ;
    }

    //add at the end of the array :
    public void add(int i){
        this.size++;
        if (size == array.length) {
            int[] newArray = new int[array.length*2];
            for (int j=0 ; j< size ; j++) {
                newArray[j]=array[j];
            }
            array=newArray;
        }
        array[size-1]= i;
    }

    //add at a specific index :
    public void add(int index , int x) {
        if (size == array.length) {
            int[] newArray = new int[array.length*2];
            for (int j=0 ; j<array.length ; j++) {
                newArray[j]=array[j];
            }
            array=newArray;
        }
        for (int i=size ; i>index ; i--) {
            array[i]=array[i-1];
        }
        array[index]=x;
        this.size++;
    }

    //get the element at a specific index :
    public int get(int index) {
        return array[index];
    }

    //to return the size of the array :
    public int size() {
        return(this.size);
    }

    //to check if the array is empty :
    public boolean isEmpty() {
        return size==0;
    }

    //to check if the array contains a specific element :
    public boolean isIn(int x) {
        for(int i=0 ; i<size ; i++) {
            if (this.array[i]==x)
                return(true);
        }
        return false ;
    }

    //to find the index of a specific element :
    public int find(int x) {
        for(int i=0 ; i<size ; i++) {
            if (this.array[i]==x)
                return(i);
        }
        return -1 ;
    }

    //to remove an element from the array :
    public void remove(int x) {
        int index = find(x);
        if (index==-1)
            return;
        for (int i=index ; i<size-1 ; i++) {
            array[i]=array[i+1];
        }
        this.size--;
    }
}
