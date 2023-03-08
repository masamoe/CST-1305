enum State {
    EMPTY, OCCUPIED, DELETED
};

public class DictionaryUsingHashingUsingSeparateChainingAndQuadraticProbing {
    class Item {
        public String key;
        public String value;
        public State state;

        Item() {
            key = null;
            value = null;
            state = State.EMPTY;
        }
    }

    Item[] table;
    final int TABLE_SIZE = 100;

    public DictionaryUsingHashingUsingSeparateChainingAndQuadraticProbing() {
        table = new Item[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new Item();
        }
    }

    public int hash(String key) {
        int hashValue = 0;
        for (int i = 0; i < key.length(); i++) {
            hashValue = 37 * hashValue + key.charAt(i);
        }
        hashValue %= TABLE_SIZE;
        if (hashValue < 0) {
            hashValue += TABLE_SIZE;
        }
        return hashValue;
    }

    public int hash2(String key) {
        int hashValue = 0;
        for (int i = 0; i < key.length(); i++) {
            hashValue = 37 * hashValue + key.charAt(i);
        }
        hashValue %= TABLE_SIZE;
        if (hashValue < 0) {
            hashValue += TABLE_SIZE;
        }
        return 7 - hashValue % 7;
    }

    public void insert(String key, String value) {
        int hashValue = hash(key);
        int stepSize = hash2(key);
        while (table[hashValue].state != State.EMPTY) {
            hashValue += stepSize;
            hashValue %= TABLE_SIZE;
        }
        table[hashValue].key = key;
        table[hashValue].value = value;
        table[hashValue].state = State.OCCUPIED;
    }

    public String find(String key) {
        int hashValue = hash(key);
        int stepSize = hash2(key);
        while (table[hashValue].state != State.EMPTY) {
            if (table[hashValue].key.equals(key)) {
                return table[hashValue].value;
            }
            hashValue += stepSize;
            hashValue %= TABLE_SIZE;
        }
        return null;
    }

    public void delete(String key) {
        int hashValue = hash(key);
        int stepSize = hash2(key);
        while (table[hashValue].state != State.EMPTY) {
            if (table[hashValue].key.equals(key)) {
                table[hashValue].state = State.DELETED;
                return;
            }
            hashValue += stepSize;
            hashValue %= TABLE_SIZE;
        }
    }

    public void print() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (table[i].state == State.OCCUPIED) {
                System.out.println(table[i].key + " " + table[i].value);
            }
        }
    }

    public static void main(String[] args) {
        DictionaryUsingHashingUsingSeparateChainingAndQuadraticProbing dictionary = new DictionaryUsingHashingUsingSeparateChainingAndQuadraticProbing();
        dictionary.insert("a", "apple");
        dictionary.insert("b", "banana");
        dictionary.insert("c", "cat");
        dictionary.insert("d", "dog");
        dictionary.insert("e", "elephant");
        System.out.println(dictionary.find("c"));
        dictionary.delete("c");
        dictionary.print();
    }
}
