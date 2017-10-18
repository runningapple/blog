class Solution {
    private int max_area = 0;
    private int cnt = 0;

    public void DFS(int[][] grid, int i , int j) {
        grid[i][j] = 0;
        if(i-1 >= 0 && grid[i-1][j] == 1) {
            cnt++;
            DFS(grid, i-1, j);
        }
        if(i+1 < grid.length && grid[i+1][j] == 1) {
            cnt++;
            DFS(grid, i+1, j);
        }
        if(j-1 >= 0 && grid[i][j-1] == 1) {
            cnt++;
            DFS(grid, i, j-1);
        }
        if(j+1 < grid[i].length && grid[i][j+1] == 1) {
            cnt++;
            DFS(grid, i, j+1);
        }
        
    }

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    cnt = 1;
                    DFS(grid, i, j);
                    max_area = Math.max(max_area, cnt);
                    cnt = 0;
                }
            }
        }
        return max_area;
    }
}

//[[0,1,1],
// [1,1,0]]