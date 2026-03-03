//给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。 
//
// 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求
//： 
//
// 
// 路径途经的所有单元格的值都是 0 。 
// 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。 
// 
//
// 畅通路径的长度 是该路径途经的单元格总数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[0,1],[1,0]]
//输出：2
// 
//
// 示例 2： 
// 
// 
//输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 广度优先搜索 数组 矩阵 👍 416 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dirs = {{-1, -1}, {-1, 0}, {0, -1}, {-1, 1}, {1, -1}, {1, 0}, {0, 1}, {1, 1}};
        Queue<int[]> queue = new ArrayDeque<>();

        if (grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1) {
            return -1;
        }
        if (grid.length == 1) {
            if (grid[0][0] == 0) {
                return 1;
            } else {
                return -1;
            }
        }

        queue.offer(new int[]{0, 0, 1});
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] currNode = queue.poll();
            for (int[] dir : dirs) {
                int nextRow = currNode[0] + dir[0];
                int nextCol = currNode[1] + dir[1];
                if ((nextRow < grid.length) && (nextRow >= 0)
                        && (nextCol < grid.length) && (nextCol >= 0)
                        && (grid[nextRow][nextCol] == 0)) {
                        if (nextRow == grid.length - 1 && nextCol == grid.length - 1) {
                            return currNode[2] + 1;
                        }
                        grid[nextRow][nextCol] = 1;
                        queue.offer(new int[]{nextRow, nextCol, currNode[2] + 1});
                    }
                }
            }
        return -1;
        }



}
//leetcode submit region end(Prohibit modification and deletion)
