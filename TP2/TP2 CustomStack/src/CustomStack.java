public class CustomStack {
    public int capacity;
    public int top;
    public int[] stack ;
    public CustomStack(int n){
        capacity = n;
        stack = new int[n];
        top = -1;
    }

    //see if stack is empty or full
    public boolean stackIsEmpty(){
        return top == -1;
    }
    public boolean stackIsFull(){
        return top == (capacity - 1);
    }

    //get the top element
    public int lastInStack(){
        if (top != -1)
            return stack[top];
        else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    //add elements
    public void addElement(int n){
        if( !(this.stackIsFull()) ){
            top++;
            stack[top] = n ;
        }
        else
            System.out.println("Stack is full");
    }

    //remove elements
    public void removeElement(){
        if( !(this.stackIsEmpty()) ){
            top--;
        }
        else
            System.out.println("Stack is already Empty");
    }
}
