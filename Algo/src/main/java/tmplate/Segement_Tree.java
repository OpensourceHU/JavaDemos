package tmplate;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 线段树模板
 * @date 2021/3/14 0014 9:56
 */
public class Segement_Tree {
  static void build(int[] arr, int[] tree, int start, int end, int node) {
    if (start == end) {
      tree[node] = arr[start];
      return;
    }
    int left_node = node * 2;
    int right_node = node * 2 + 1;
    int mid = (start + end) / 2;
    build(arr, tree, start, mid, left_node);
    build(arr, tree, mid + 1, end, right_node);
    tree[node] = tree[left_node] + tree[right_node];
  }

  static int query(int[] arr, int[] tree, int start, int end, int node, int L, int R) {
    int mid = (start + end) / 2;
    if (start == end || (L <= start && R >= end)) {
      return tree[node];
    }
    if (R < start || L > end) {
      return 0;
    }
    int DPL = query(arr, tree, start, mid, node * 2, L, R);
    int DPR = query(arr, tree, mid + 1, end, node * 2 + 1, L, R);
    return DPL + DPR;

  }

  static void update(int[] arr, int[] tree, int start, int end, int node, int index, int val) {
    if (start == end) {
      arr[index] = val;
      tree[node] = val;
      return;
    }
    int mid = (start + end) / 2;
    if (index <= mid) {
      update(arr, tree, start, mid, node * 2, index, val);
    } else {
      update(arr, tree, mid + 1, end, node * 2 + 1, index, val);
    }
    tree[node] = tree[node * 2] + tree[node * 2 + 1];
  }
}
