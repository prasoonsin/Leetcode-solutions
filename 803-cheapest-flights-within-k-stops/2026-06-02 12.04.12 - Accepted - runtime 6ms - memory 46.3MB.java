import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});

        int stops = 0;

        while (!queue.isEmpty() && stops <= k) {

            int size = queue.size();
            int[] tempCost = cost.clone();

            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();
                int city = current[0];
                int currentCost = current[1];

                for (int[] neighbor : graph.get(city)) {

                    int nextCity = neighbor[0];
                    int price = neighbor[1];

                    if (currentCost + price < tempCost[nextCity]) {
                        tempCost[nextCity] = currentCost + price;
                        queue.offer(new int[]{nextCity, tempCost[nextCity]});
                    }
                }
            }

            cost = tempCost;
            stops++;
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}