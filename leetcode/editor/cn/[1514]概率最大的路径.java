//给你一个由 n 个节点（下标从 0 开始）组成的无向加权图，该图由一个描述边的列表组成，其中 edges[i] = [a, b] 表示连接节点 a 和 b 
//的一条无向边，且该边遍历成功的概率为 succProb[i] 。 
//
// 指定两个节点分别作为起点 start 和终点 end ，请你找出从起点到终点成功概率最大的路径，并返回其成功概率。 
//
// 如果不存在从 start 到 end 的路径，请 返回 0 。只要答案与标准答案的误差不超过 1e-5 ，就会被视作正确答案。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, 
//end = 2
//输出：0.25000
//解释：从起点到终点有两条路径，其中一条的成功概率为 0.2 ，而另一条为 0.5 * 0.5 = 0.25
// 
//
// 示例 2： 
//
// 
//
// 输入：n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, 
//end = 2
//输出：0.30000
// 
//
// 示例 3： 
//
// 
//
// 输入：n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
//输出：0.00000
//解释：节点 0 和 节点 2 之间不存在路径
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10^4 
// 0 <= start, end < n 
// start != end 
// 0 <= a, b < n 
// a != b 
// 0 <= succProb.length == edges.length <= 2*10^4 
// 0 <= succProb[i] <= 1 
// 每两个节点之间最多有一条边 
// 
//
// Related Topics 图 数组 最短路 堆（优先队列） 👍 192 👎 0

import javax.swing.plaf.nimbus.State;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<State>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(new State(edges[i][1], succProb[i]));
            graph[edges[i][1]].add(new State(edges[i][0], succProb[i]));
        }

        double[] prob = new double[n];
        Arrays.fill(prob, 0.0);
        prob[start_node] = 1.0;

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.offer(new State(start_node, 1.0));

        while (!pq.isEmpty()) {
            State curr = pq.poll();
            int currNode = curr.node;
            double currProb = curr.prob;
            if (currNode == end_node) {
                return currProb;
            }
            if (currProb < prob[currNode]) {
                continue;
            }

            for (State edge : graph[currNode]) {
                if (edge.prob * currProb > prob[edge.node]) {
                    prob[edge.node] = edge.prob * currProb;
                    pq.offer(new State(edge.node, prob[edge.node]));
                }
            }
        }

        return prob[end_node];
    }

    class State {
        int node;
        double prob;
        public State(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
