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
    }

    String get(Integer key) {
        int index = getHashIndex(key);
        if (hashTable[index] == null) {
            return null;
        } else {
            while (hashTable[index].key != key) {
                index = (index + 1) % TABLE_SIZE;
            }
            return hashTable[index].value;
        }
    }

    public static void main(String[] args) {
        DictionaryUsingHashingUsingLinearProbing aDict = new DictionaryUsingHashingUsingLinearProbing();
        aDict.insert(29, "apple"); // should be inserted at index 6
        aDict.insert(32, "banana"); // should be inserted at index 9
        aDict.insert(58, "cherry"); // should be inserted at index 12
        aDict.insert(81, "date"); // should be inserted at index 13
        System.out.println(aDict.get(81)); // should print "date"
    }
}