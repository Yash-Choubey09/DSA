import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        k = k % total;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> row = new ArrayList<>(); 
            List<Integer> currentRow = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int current1DIndex = i * n + j;
                int original1DIndex = (current1DIndex - k + total) % total;
                int origR = original1DIndex / n;
                int origC = original1DIndex % n;
                currentRow.add(grid[origR][origC]);
            }
            result.add(currentRow);
        }
        return result;
    }
}