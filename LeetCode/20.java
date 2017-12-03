class Solution {
    public boolean judge(char a, char b) {
        if (a == '(' && b == ')') return true;
        if (a == '{' && b == '}') return true;
        if (a == '[' && b == ']') return true;
        return false;
    }

    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        if (s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<Character>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if (judge(stack.peek(),s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.empty();
    }
}