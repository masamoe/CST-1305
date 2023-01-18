public class ListUsingArray {
    Integer []arr;
    int numberOfItems;
    int ARR_SIZE = 11;
    int MAX_CAPACITY = ARR_SIZE-1;

    ListUsingArray(){
        arr = new Integer[ARR_SIZE];
        numberOfItems = 0;
    }

    void add(int element){
        if(numberOfItems != MAX_CAPACITY){
            arr[++numberOfItems] = element;
        }

    }

    void add(int index, int element){
        if(numberOfItems != MAX_CAPACITY){
        //shifting to right
        for(int i = numberOfItems; i >= index; i--){
            arr[i + 1] = arr[i];
        }
        arr[index] = element;
        numberOfItems++;
        }
    }

    void remove(int index){
        if(index < 0 && index >= numberOfItems){
            System.out.println("Invalid index");
            return;
        }
        //shifting to left
        for(int i = index; i < numberOfItems - 1; i++){
            arr[i] = arr[i + 1];
        }
        numberOfItems--;
    }

    int get(int index){
        return arr[index];
    }

    int size(){
        return numberOfItems;
    }

    public static void main(String[] args) {
        ListUsingArray aList = new ListUsingArray();
        aList.add(10);
        aList.add(20);
        aList.add(30);
        System.out.println(aList.get(3));
        aList.add(1,5);
        System.out.println(aList.get(3));
        aList.remove(3); //remove 3
        System.out.println(aList.size());
    }
}
