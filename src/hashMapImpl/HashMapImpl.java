package hashMapImpl;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class HashMapImpl {

    private KeyValue[] array;
    private int arraySize;

    public HashMapImpl(int size) {
        this.arraySize = size;
        this.array = new KeyValue[size];
    }

    public void add(String key, Integer value) {
        int index = key.hashCode() % arraySize;
        while(array[index] != null) {
            ++index;
            index %= arraySize;
        }
        array[index] = new KeyValue(key, value);
    }

    public Integer getValue(String key) {
        int index = key.hashCode() % arraySize;
        while(array[index] != null) {
            if(array[index].key.equals(key)) {
                System.out.println("key \"" + key + "\" found at index " + index);
                return array[index].value;
            }
            ++index;
            index %= arraySize;
        }
        return null;
    }

    public void remove(String key) {
        int index = key.hashCode() % arraySize;
        while(array[index] != null) {
            if(array[index].key.equals(key)) {
                array[index] = null;
                return;
            }
            ++index;
            index %= arraySize;
        }
        throw new NoSuchElementException("The key is not present in the HashMapImpl.");
    }

    public void clearAll() {
        IntStream.range(0, array.length).filter(i -> array[i] != null).forEach(i -> array[i] = null);
    }
}
