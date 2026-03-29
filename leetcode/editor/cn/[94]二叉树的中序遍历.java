//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 2402 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution
{
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            //一直找curr的左子树直到空，所有遍历过的节点进栈
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);
                curr = node.right;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
