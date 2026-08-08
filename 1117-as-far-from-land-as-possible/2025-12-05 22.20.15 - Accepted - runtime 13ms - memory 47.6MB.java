class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new ArrayDeque<>();
        int land = 0, water = 0;

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    land++;
                } else {
                    water++;
                }
            }
        }
        if (land == 0 || water == 0) return -1;

        int distance = -1;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {
            int size = q.size();
            distance++;

            for (int s = 0; s < size; s++) {
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];

                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr, nc});
                        
                    }
                }
            }
        }
        return distance;
    }
}