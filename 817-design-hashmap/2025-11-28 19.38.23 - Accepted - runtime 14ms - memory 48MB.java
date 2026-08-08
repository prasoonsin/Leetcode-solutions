class MyHashMap {

  
    class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] buckets;
    private final int SIZE = 1000;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }
    
    public void put(int key, int value) {
        int index = hash(key);

        
        if (buckets[index] == null) {
            buckets[index] = new Node(key, value);
            return;
        }

        Node curr = buckets[index];


        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;  
                return;
            }
            if (curr.next == null) break;  
            curr = curr.next;
        }

        curr.next = new Node(key, value);
    }
    
    public int get(int key) {
        int index = hash(key);
        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key)
                return curr.value;
            curr = curr.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets[index];

        if (curr == null) return;

        if (curr.key == key) {
            buckets[index] = curr.next;
            return;
        }

        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                prev.next = curr.next; 
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}
