class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0 ; i < n; i++){
            pq.add(stones[i]);
        }

        while(pq.size() > 1){
            int heaviest = pq.remove();
            int secondHeaviest = pq.remove();

            int remaining = heaviest - secondHeaviest;
            pq.add(remaining);
        }
        return pq.peek();
    }
        }