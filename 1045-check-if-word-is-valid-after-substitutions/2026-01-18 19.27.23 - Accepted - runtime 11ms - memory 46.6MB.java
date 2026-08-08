class Solution {
    public boolean isValid(String s) {
        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            stack.append(ch);

            int n = stack.length();
            if (n >= 3 &&
                stack.charAt(n - 3) == 'a' &&
                stack.charAt(n - 2) == 'b' &&
                stack.charAt(n - 1) == 'c') {
                stack.delete(n - 3, n);
            }
        }
        return stack.length() == 0;
    }
}
