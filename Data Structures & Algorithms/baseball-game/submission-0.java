class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int totalSum = 0;

        for (String op : operations) {
            // Number
            if (op.equals("C")) {
                stack.pop();
            }
            // Double previous score
            else if (op.equals("D")) {
                int top = stack.peek();
                stack.push(top * 2);
            }
            // Sum of previous two scores
            else if (op.equals("+")) {
                int top1 = stack.pop();
                int top2 = stack.peek();
                stack.push(top1);
                stack.push(top1 + top2);
            }
            // Integer score
            else {
                stack.push(Integer.parseInt(op));
            }
        }
        for (int score : stack) {
            totalSum += score;
        }

        return totalSum;
    }
}