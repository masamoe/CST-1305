public class DequeUsingDoublyLinkedList{
    DoublyNode front;
    DoublyNode back;

    public DequeUsingDoublyLinkedList(){
        front = null;
        back = null;
    }

    void addFirst(int anItem){
        DoublyNode aNewNode = new DoublyNode();
        aNewNode.data = anItem;

        if(front == null){
            front = aNewNode;
            back = aNewNode;
        } else{
            aNewNode.next = front;
            front.prev = aNewNode;    
            front = aNewNode;
        }
    }

    void addLast(int anItem){
        DoublyNode aNewNode = new DoublyNode();
        aNewNode.data = anItem;

        if(back == null){
            front = aNewNode;
            back = aNewNode;
        } else{
            aNewNode.prev = back;
            back.next = aNewNode;
            back = aNewNode;
        }
    }

    void removeFirst(){
        if(front == null){
            System.out.println("Deque is empty");
        } else{
            front = front.next;
            front.prev.next = null;
            front.prev = null;
        }
    }

    void removeLast(){
        if(back == null){
            System.out.println("Deque is empty");
        } else{
            back = back.prev;
            back.next.prev = null;
            back.next = null;
        }
    }

    int getFirst(){
        return front.data;
    }

    int getLast(){
        return back.data;
    }

    public static void main(String[] args) {
        DequeUsingDoublyLinkedList aDeque = new DequeUsingDoublyLinkedList();
        aDeque.addFirst(1);
        aDeque.addFirst(2);
        System.out.println(aDeque.getLast()); //1
        aDeque.addLast(3);
        System.out.println(aDeque.getFirst()); //2
    }
}


