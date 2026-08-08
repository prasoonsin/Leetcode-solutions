class Solution {

    public int maxVowels(String s, int k) {

        int count = 0;

        // Build first window
        for(int i = 0; i < k; i++) {

            char ch = s.charAt(i);

            if(ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {

                count++;
            }
        }

        int max = count;

        // Slide window
        for(int i = k; i < s.length(); i++) {

            char left = s.charAt(i - k);

            if(left == 'a' || left == 'e' || left == 'i'
                    || left == 'o' || left == 'u') {

                count--;
            }

            char right = s.charAt(i);

            if(right == 'a' || right == 'e' || right == 'i'
                    || right == 'o' || right == 'u') {

                count++;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}