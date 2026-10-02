// Implementation using ONE STACK
class Pair {
    int key; // current Element
    int val; // min Element
    public Pair(int key, int val) {
        this.key = key;
        this.val = val;
    }
    public int getKey() {
        return this.key;
    }
    public int getValue() {
        return this.val;
    }
}
class MinStack {
    Stack<Pair> stack;
    public MinStack() {
        stack = new Stack();
    }
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Pair(val, val));
        } else {
            int currentMin = stack.peek().getValue();
            stack.push(new Pair(val, Math.min(val, currentMin)));
        }
    }
    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek().getKey();
        }
        return -1;
    }

    public int getMin() {
        if (!stack.isEmpty()) {
            return stack.peek().getValue();
        }
        return -1;
    }
}
