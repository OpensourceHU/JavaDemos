//给定一个整数数组 prices，其中第 prices[i] 表示第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
//
// 示例 2: 
//
// 
//输入: prices = [1]
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics 数组 动态规划 
// 👍 1113 👎 0

package leetcode.leetcode.editor.cn;

public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 1) return 0;
            int[] hold = new int[prices.length];
            int[] freeze = new int[prices.length];
            int[] notFreeze = new int[prices.length];
            hold[0] = -prices[0];
            freeze[0] = notFreeze[0] = 0;
            for (int i = 1; i < prices.length; i++) {
                //当日持有的情况  1.一直持有  2.今日买入
                hold[i] = Math.max(hold[i - 1], notFreeze[i - 1] - prices[i]);
                //当日冻结,未持有:  说明今天卖出了
                freeze[i] = hold[i - 1] + prices[i];
                //当日未冻结,未持有:  前一天未冻结or冻结 今日无任何操作
                notFreeze[i] = Math.max(freeze[i - 1], notFreeze[i - 1]);
            }
            return Math.max(freeze[prices.length - 1], notFreeze[prices.length - 1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}