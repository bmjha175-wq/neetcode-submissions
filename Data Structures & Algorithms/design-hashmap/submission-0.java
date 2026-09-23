class MyHashMap {
    class Node {
        int key;
        int value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    LinkedList<Node> list;

    public MyHashMap() {
        list = new LinkedList<>();
    }

    public void put(int key, int value) {
        // if key already exist
        for (Node node : list) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        // else add key and value pair in the map
        list.add(new Node(key, value));
    }

    public int get(int key) {
        // return value mapped with key
        for (Node node : list) {
            if (node.key == key) {
                return node.value;
            }
        }
        return -1;
        //-1 if there is no mapping
    }

    public void remove(int key) {
        Iterator<Node> iterator = list.iterator();

        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key == key) {
                iterator.remove();
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */