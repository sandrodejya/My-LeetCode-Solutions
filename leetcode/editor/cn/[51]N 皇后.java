//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 数组 回溯 👍 2470 👎 0


import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> res = new ArrayList<>();
    char[][] board;
    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backward(0, n);
        return res;
    }
    private void backward(int row, int n) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] str : board) {
                list.add(new String(str));
            }
            res.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col)) {
                board[row][col] = 'Q';
                backward(row + 1, n);
                board[row][col] = '.';
            }
        }
    }
    private boolean isValid(int row, int col) {
        for (int up = row - 1, left = col - 1; up >= 0 && left >= 0; up--, left--) {
            if (board[up][left] == 'Q') {
                return false;
            }
        }
        for (int up = row - 1, right = col + 1; up >= 0 && right < board.length; up--, right++) {
            if (board[up][right] == 'Q') {
                return false;
            }
        }
        for (int up = row - 1; up >= 0; up--) {
            if (board[up][col] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
