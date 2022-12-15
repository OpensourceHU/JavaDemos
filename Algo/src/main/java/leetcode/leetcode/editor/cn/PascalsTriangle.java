//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 375 👎 0

package leetcode.leetcode.editor.cn;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList();

        public List<List<Integer>> generate(int numRows) {
            if (numRows == 0) return new ArrayList<>();
            ArrayList<Integer> list = new ArrayList();
            list.add(1);
            ans.add(list);
            process(list, 2, numRows);
            return ans;
        }

        public void process(List<Integer> preList, int count, int numRows) {
            if (count > numRows) return;
            ArrayList<Integer> ret = new ArrayList();
            ret.add(1);
            for (int i = 0; i < preList.size() - 1; i++) {
                ret.add(preList.get(i) + preList.get(i + 1));
            }
            ret.add(1);
            ans.add(ret);
            process(ret, count + 1, numRows);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}