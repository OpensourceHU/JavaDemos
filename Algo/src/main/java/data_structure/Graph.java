package data_structure;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 图与图相关的操作
 * @date 2020/5/9 0009 10:53
 */
public class Graph {
  HashMap<Integer, Node> nodeSet;
  HashSet<Edge> edgeSet;

  public Graph() {
    nodeSet = new HashMap<Integer, Node>();
    edgeSet = new HashSet<Edge>();
  }//图的定义 点集+边集

  public static Graph conversion(int[][] matrix)//转化成图
  {
    Graph ret = new Graph();
    for (int i = 0; i < matrix.length; i++) {
      Integer weight = matrix[i][0];
      Integer from = matrix[i][1];
      Integer to = matrix[i][2];
      if (!ret.nodeSet.containsKey(from)) {
        ret.nodeSet.put(from, new Node(from));
      }
      if (!ret.nodeSet.containsKey(to)) {
        ret.nodeSet.put(to, new Node(to));
      }
      Node fromNode = ret.nodeSet.get(from);
      Node toNode = ret.nodeSet.get(to);
      Edge newEdge = new Edge(weight, fromNode, toNode);
      fromNode.outDegree++;
      toNode.inDegree++;
      fromNode.edges.add(newEdge);
      fromNode.nexts.add(toNode);
      ret.edgeSet.add(newEdge);
    }
    return ret;
  }

  public static void width_firstTraverse(Node node)//也有叫Breadth_First_Search的 简称BFS
  {
    Queue<Node> queue = new LinkedList<Node>();
    HashSet<Node> set = new HashSet<Node>();
    queue.add(node);
    set.add(node);//CALL一个HashSet和一个队列出来  任一节点进队列进集合  集合是用来去重的
    while (!queue.isEmpty()) {
      Node cur = queue.poll();
      System.out.print(cur.value + " ");//出队就打印
      for (Node next : cur.nexts
      ) {
        if (!set.contains(next))//如果出队的节点的相邻节点不在集合里,说明还没有进过队列
        {
          queue.add(next);//相邻节点进队列进集合  一层一层地遍历下去
          set.add(next);
        }
      }
    }
  }

  public static void depth_firstTraverse(Node node) {
    Stack<Node> stack = new Stack<>();
    HashSet<Node> set = new HashSet<>();
    stack.push(node);
    set.add(node);
    System.out.print(node.value + " ");//call一个集合和栈出来  进栈即打印
    while (!stack.isEmpty()) {
      Node cur = stack.pop();//每次pop出来的节点相当于一条路到底了依次往回退找岔路
      for (Node next : cur.nexts
      ) {
        if (!set.contains(next))//回退过程中找到一条没有进入过的岔路  进栈进集合 进栈即打印
        {
          set.add(next);
          stack.push(cur);
          stack.push(next);//注意压栈顺序!! 一定要先压cur再压next 因为cur可能还有未发现的岔路这次只走了其中一条
          //以后还要回退到cur节点进行岔路检查
          System.out.print(next.value + " ");
          break;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[][] input = new int[][] {{0, 1, 2}, {0, 1, 3}, {0, 2, 5}, {0, 3, 6}};
    Graph graph = conversion(input);
    width_firstTraverse(graph.nodeSet.get(1));
    System.out.println();
    depth_firstTraverse(graph.nodeSet.get(1));
  }

  private static class Node {
    int value;
    int inDegree;
    int outDegree;
    ArrayList<Node> nexts;//该点相邻的节点(只记录由该点发散出去的)
    ArrayList<Edge> edges;//该节点发散出去的有向边  (无向边可以看作两个反向有向边)

    public Node(int value) {
      this.value = value;
      this.inDegree = 0;
      this.outDegree = 0;
      this.nexts = new ArrayList<Node>();
      this.edges = new ArrayList<Edge>();
    }
  }//点

  private static class Edge {
    int weight;
    Node from;
    Node to;

    public Edge(int weight, Node from, Node to) {
      this.weight = weight;
      this.from = from;
      this.to = to;
    }
  }//边

}
