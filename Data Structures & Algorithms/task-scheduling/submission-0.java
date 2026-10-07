class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int cycle = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);// Max Heap collections.reversedOrder()

        heap.addAll(map.values());// added all the values from map

        while (!heap.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();// created temp list to store the sequence

            for (int i = 0; i < n + 1; i++) {
                if (!heap.isEmpty()) {
                    temp.add(heap.remove());
                }
            }

            for (int i : temp) {
                if (--i > 0) {
                    heap.add(i);
                }
            }
            cycle += heap.isEmpty()?temp.size() : n + 1;
        }

        return cycle;
    }
}
