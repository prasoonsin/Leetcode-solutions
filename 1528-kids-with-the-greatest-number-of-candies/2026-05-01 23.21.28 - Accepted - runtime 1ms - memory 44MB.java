class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        List<Boolean> result = new ArrayList<>();

        int max = 0;
        for (int c : candies) {
            max = Math.max(max, c);
        }

        for (int c : candies) {
            result.add(c + extraCandies >= max);
        }

        return result;
    }
}