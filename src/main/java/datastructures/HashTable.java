package datastructures;

import java.util.*;

public class HashTable {

    private int INITIAL_SIZE = 16;
    private HashEntry[] data; // LinkedList

    class HashEntry {
        String key;
        String value;
        HashEntry next;

        HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    HashTable() {
        data = new HashEntry[INITIAL_SIZE];
    }

    public void put(String key, String value) {

        // Get the index
        int index = getIndex(key);

        // Create the linked list entry
        HashEntry entry = new HashEntry(key, value);

        // If no entry there - add it
        if (data[index] == null) {
            data[index] = entry;
        }
        // Else handle collision by adding to end of linked list
        else {
            HashEntry entries = data[index];
            // Walk to the end...
            while(entries.next != null) {
                entries = entries.next;
            }
            // Add our new entry there
            entries.next = entry;
        }
    }

    public String get(String key) {

        // Get the index
        int index = getIndex(key);

        // Get the current list of entries
        HashEntry entries = data[index];

        // if we have existing entries against this key...
        if (entries != null) {
            // else walk chain until find a match
            while (!entries.key.equals(key) && entries.next !=null) {
                entries = entries.next;
            }
            // then return it
            return entries.value;
        }

        // it we have no entries against this key...
       return null;
    }

    private int getIndex(String key) {
        // Get the hash code
        int hashCode = key.hashCode();
        System.out.println("hashCode = " + hashCode);

        // Convert to index
        int index = (hashCode & 0x7fffffff) % INITIAL_SIZE;
//        int index = hashCode % INITIAL_SIZE;

        // Hack to force collision for testing
        if (key.equals("John Smith") || key.equals("Sandra Dee")) {
            index = 4;
        }

        System.out.println("index = " + index);

        return index;
    }

    @Override
    public String toString() {
        int bucket = 0;
        StringBuilder hashTableStr = new StringBuilder();
        for (HashEntry entry : data) {
            if(entry == null) {
                continue;
            }
            hashTableStr.append("\n bucket[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.toString());
            bucket++;
            HashEntry temp = entry.next;
            while(temp != null) {
                hashTableStr.append(" -> ");
                hashTableStr.append(temp.toString());
                temp = temp.next;
            }
        }
        return hashTableStr.toString();
    }

    public void testHashMap () {
        HashMap <Integer,Integer> map = new HashMap<Integer,Integer>();

        map.put(1,3);
        int result = map.get(1);
        System.out.println("Hashmap result is: " + result);
    }

    /*
    MY OWN TEST

    Hashtable
    Constructors:
        Hashtable() - default
        Hashtable(int size)
        Hashtable(Map m)
    Methods:
        void clear()
        Object clone()
        boolean contains(Object value)
        boolean containsKey(Object value)
        boolean isEmpty()
        Object put(key, value) - return previous value if key exists; else null
        Object get(key)
        Object remove (key) - returns value associated with key. if key is not present, return null
        int size()
     */
    public void testHashTable () {
        // creating a hash table
        Hashtable<Integer, String> h = new Hashtable<Integer, String>();

        Hashtable<Integer, String> h1 = new Hashtable<Integer, String>();

        h.put(3, "Geeks");
        h.put(2, "forGeeks");
        h.put(1, "isBest");

        // create a clone or shallow copy of hash table h
        h1 = (Hashtable<Integer, String>)h.clone();

        // checking clone h1
        System.out.println("Hashtable values in clone: " + h1);

        // contains
        System.out.println("Hashtable 1 contains Geeks: " + h1.contains("Geeks") );
        System.out.println("Hashtable 1 contains abcde: " + h1.contains("abcde") );

        // contains key
        System.out.println("Hashtable 1 contains key 2: " + h1.containsKey(2));
        System.out.println("Hashtable 1 contains key 6: " + h1.containsKey(6));

        // clear hash table h
        h.clear();

        // checking hash table h
        System.out.println("Hashtable after clearing: " + h);
    }
}