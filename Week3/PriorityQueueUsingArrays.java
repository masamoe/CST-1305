public class PriorityQueueUsingArrays {
    Integer []arr;
    int numberOfItems;

    PriorityQueueUsingArrays(){
        arr = new Integer[10];
        numberOfItems = 0;
    }

    void add(int element){
        arr[numberOfItems] = element;
        numberOfItems++;
    }

    int peek(){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < numberOfItems; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    int remove(){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < numberOfItems; i++){
            if(arr[i] < min){
                min = arr[i];
                minIndex = i;
            }
        }

        //shifting
        for(int i = minIndex; i < numberOfItems - 1; i++){
            arr[i] = arr[i + 1];
        }
        numberOfItems--;
        return min;
    }

    public static void main(String[] args) {
        PriorityQueueUsingArrays aQueue = new PriorityQueueUsingArrays();
        aQueue.add(5);
        aQueue.add(3);
        aQueue.add(2);
        aQueue.add(1);
        aQueue.add(6);

        aQueue.peek(); //1 highest priority
        aQueue.remove(); //remove 1 highest priority
    }
}
