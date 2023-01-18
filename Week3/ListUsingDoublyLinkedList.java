public class ListUsingDoublyLinkedList {
    DoublyNode head;
    DoublyNode tail;
    int size;

    public ListUsingDoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    DoublyNode getNode(int index){
        DoublyNode aNode = head;
        for(int i = 0; i < index; i++){
            aNode = aNode.next;
        }
        return aNode;
    }

    void add(int anItem){
        DoublyNode aNewNode = new DoublyNode();
        aNewNode.data = anItem;

        if(head == null){
            head = aNewNode;
            tail = aNewNode;
        } else{
            tail.next = aNewNode;
            aNewNode.prev = tail;
            tail = aNewNode;
        }
        size++;
    }

    void add(int index, int anItem){
        DoublyNode aNewNode = new DoublyNode();
        aNewNode.data = anItem;

        if(index == 0){
            aNewNode.next = head;
            head.prev = aNewNode;
            head = aNewNode;
        } else if(index == size){
            tail.next = aNewNode;
            aNewNode.prev = tail;
            tail = aNewNode;
        } else{
            DoublyNode aNode = getNode(index);
            aNewNode.next = aNode;
            aNewNode.prev = aNode.prev;
            aNode.prev.next = aNewNode;
            aNode.prev = aNewNode;
        }
        size++;
    }

    void remove(int index){
        if(index == 0){
            head = head.next;
            head.prev.next = null;
            head.prev = null;
        } else if(index == size - 1){
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
        } else{
            DoublyNode aNode = getNode(index);
            aNode.prev.next = aNode.next;
            aNode.next.prev = aNode.prev;
            aNode.next = null;
            aNode.prev = null;
        }
        size--;
    }

    int get(int index){
        DoublyNode aNode = getNode(index);
        return aNode.data;
    }

    int size(){
        return size;
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
