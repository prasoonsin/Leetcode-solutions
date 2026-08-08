class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr1) map.put(x, map.getOrDefault(x, 0) + 1);

        int idx = 0;
        for (int x : arr2)
            while (map.getOrDefault(x, 0) > 0) {
                arr1[idx++] = x;
                map.put(x, map.get(x) - 1);
            }

        List<Integer> rest = new ArrayList<>();
        for (int x : map.keySet())
            while (map.get(x) > 0) {
                rest.add(x);
                map.put(x, map.get(x) - 1);
            }

        Collections.sort(rest);
        for (int x : rest) arr1[idx++] = x;
        return arr1;
    }
}
