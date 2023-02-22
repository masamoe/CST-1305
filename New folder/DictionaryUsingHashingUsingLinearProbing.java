enum State {
    EMPTY, OCCUPIED, DELETED
}

class Item {
    public Integer key;
    public String value;
    public State state;

    Item() {
        key = null;
        value = null;
        state = State.EMPTY;
    }
}

class DictionaryUsingHashingUsingLinearProbing {
    Item[] hashTable;
    final int TABLE_SIZE = 23;

    DictionaryUsingHashingUsingLinearProbing() {
        hashTable = new Item[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            hashTable[i] = new Item();
        }
    }

    int getHashIndex(Integer key) {
        int hashCode = key;
        int hashIndex = hashCode % TABLE_SIZE;
        return hashIndex;
    }

    int probe(int index, int key) {
        int i = 0;
        while (hashTable[(index + i) % TABLE_SIZE].state == State.OCCUPIED
                && hashTable[(index + i) % TABLE_SIZE].key != key) {
            i++;
        }
        return (index + i) % TABLE_SIZE;
    }

    void insert(Integer key, String value) {
        hashTable[probe(getHashIndex(key), key)].key = key;
        hashTable[probe(getHashIndex(key), key)].value = value;
        hashTable[probe(getHashIndex(key), key)].state = State.OCCUPIED;
    }

    String get(Integer key) {
        return hashTable[probe(getHashIndex(key), key)].value;
    }

    void delete(Integer key) {
        int index = getHashIndex(key);
        if (hashTable[index] == null) {
            return;
        } else {
            while (hashTable[index].key != key) {
                index = (index + 1) % TABLE_SIZE;
            }
            hashTable[index].state = State.DELETED;
        }
    }

    public static void main(String[] args) {
        DictionaryUsingHashingUsingLinearProbing aDict = new DictionaryUsingHashingUsingLinearProbing();
        aDict.insert(29, "value 1"); // should be inserted at index 6
        aDict.insert(32, "value 2"); // should be inserted at index 9
        aDict.insert(58, "value 3"); // should be inserted at index 12
        aDict.insert(81, "value 4"); // should be inserted at index 13
        aDict.insert(15, "value 5"); // should be inserted at index 15
        System.out.println(aDict.get(15)); // should print "orange"
        aDict.delete(15); // should delete the item with key 15
        aDict.insert(15, "value 6"); // should be inserted at index 15
        System.out.println(aDict.get(15)); // should print "grapefruit"
    }
}