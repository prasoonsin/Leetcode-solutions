class Solution {
    public String[] findRelativeRanks(int[] score) {
        int[] sorted = score.clone();
        Arrays.sort(sorted);
        Map<Integer, String> map = new HashMap<>();

        for (int i = sorted.length - 1; i >= 0; i--) {
            int rank = sorted.length - i;
            if (rank == 1) map.put(sorted[i], "Gold Medal");
            else if (rank == 2) map.put(sorted[i], "Silver Medal");
            else if (rank == 3) map.put(sorted[i], "Bronze Medal");
            else map.put(sorted[i], String.valueOf(rank));
        }

        String[] res = new String[score.length];
        for (int i = 0; i < score.length; i++)
            res[i] = map.get(score[i]);
        return res;
    }
}
