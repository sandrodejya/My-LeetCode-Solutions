//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1542 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0, col = -1;
        int direction = 0;
        for (int i = 1; i <= n * n; i++) {
            int nextRow = row + directions[direction][0];
            int nextCol = col + directions[direction][1];
//            下个目标位置合法且没有插入过
            if ((nextRow >= 0) && (nextRow < n)
                    && (nextCol >= 0) && (nextCol < n)
                    && result[nextRow][nextCol] == 0) {
            } else {
                direction = (direction + 1) % 4;
                nextRow = row + directions[direction][0];
                nextCol = col + directions[direction][1];
            }
            row = nextRow;
            col = nextCol;
            result[row][col] = i;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
