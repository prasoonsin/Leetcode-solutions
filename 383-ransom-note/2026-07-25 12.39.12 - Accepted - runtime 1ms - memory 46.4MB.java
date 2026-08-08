class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (int i =0; i<magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }
        for (int i =0; i< ransomNote.length(); i++) {
        int index = ransomNote.charAt(i) - 'a';
            if (count[index] == 0) {
                return false;
            }
            count[index]--; 
        }
        return true;
    }
}