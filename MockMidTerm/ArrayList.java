import java.util.Set;

public class ArrayList<T> implements SetInterface<T> {
    T[] list;
    int size;
    int capacity;

    public ArrayList() {
        size = 0;
        capacity = 10;
        list = (T[]) new Object[capacity];
    }

    @Override
    public int getCurrentSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(T newEntry) {
        if (size >= capacity * .8) {
            capacity = capacity * 2;
            T[] newList = (T[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                newList[i] = list[i];
            }
            list = newList;
        }
        list[size] = newEntry;
        size++;
        return true;
    }

    @Override
    public boolean remove(T anEntry) {
        for (int i = 0; i < size; i++) {
            if (list[i] == anEntry) {
                for (int j = i; j < size - 1; j++) {
                    list[j] = list[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public boolean contains(T anEntry) {
        for (int i = 0; i < size; i++) {
            if (list[i] == anEntry) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = list[i];
        }
        return array;
    }

    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<Integer>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.getCurrentSize();
        myList.isEmpty();
        myList.remove(3);
        myList.contains(3);
        myList.toArray();
        myList.clear();
        myList.isEmpty();
    }

    public static ArrayList union(ArrayList A, ArrayList B) {
        ArrayList union = new ArrayList();
        for (int i = 0; i < A.size; i++) {
            union.add(A.list[i]);
        }
        for (int i = 0; i < B.size; i++) {
            if (!union.contains(B.list[i])) {
                union.add(B.list[i]);
            }
        }
        return union;
    }

    public static ArrayList intersection(ArrayList A, ArrayList B) {
        ArrayList intersection = new ArrayList();
        for (int i = 0; i < A.size; i++) {
            if (B.contains(A.list[i])) {
                intersection.add(A.list[i]);
            }
        }
        return intersection;
    }

    public static ArrayList difference(ArrayList A, ArrayList B) {
        ArrayList difference = new ArrayList();
        for (int i = 0; i < A.size; i++) {
            if (!B.contains(A.list[i])) {
                difference.add(A.list[i]);
            }
        }
        return difference;
    }
}
