class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder clean = new StringBuilder();
        for (int i =0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                clean.append(Character.toLowerCase(ch));
            }
        }
        String original = clean.toString();
        String reverse = clean.reverse().toString();
        return original.equals(reverse);
    }
}