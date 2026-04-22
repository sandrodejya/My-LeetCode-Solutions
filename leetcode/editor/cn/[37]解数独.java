//编写一个程序，通过填充空格来解决数独问题。 
//
// 数独的解法需 遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 
//
// 
// 
// 
// 示例 1： 
// 
// 
//输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".
//",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".
//","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6
//"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[
//".",".",".",".","8",".",".","7","9"]]
//输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8
//"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],[
//"4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9",
//"6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4",
//"5","2","8","6","1","7","9"]]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
// 
// 
// 
// 
//
//
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 题目数据 保证 输入数独仅有一个解 
// 
//
// Related Topics 数组 哈希表 回溯 矩阵 👍 2026 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean[][] rowUsed = new boolean[9][10];
    boolean[][] colUsed = new boolean[9][10];
    boolean[][] boxUsed = new boolean[9][10];
    List<int[]> list  = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int num = ch - '0';
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    boxUsed[i / 3 * 3 + j / 3][num] = true;
                } else {
                    list.add(new int[]{i, j});
                }
            }
        }
        backward(board, 0);
    }
    private boolean backward(char[][] board, int pos) {
        if (pos == list.size()) {
            return true;
        } else {
            int[] pair = list.get(pos);
            int i = pair[0], j = pair[1];
            for (int num = 1; num <= 9; num++) {
                if (!rowUsed[i][num] && !colUsed[j][num] && !boxUsed[i / 3 * 3 + j / 3][num]) {
                    board[i][j] = (char) (num + '0');
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    boxUsed[i / 3 * 3 + j / 3][num] = true;
                    if (backward(board, pos + 1)) {
                        return true;
                    } else {
                        board[i][j] = '.';
                        rowUsed[i][num] = false;
                        colUsed[j][num] = false;
                        boxUsed[i / 3 * 3 + j / 3][num] = false;
                    }
                }
            }
            return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
