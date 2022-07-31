package darren.gong.leetcode;

public class Construct_427 {
  // 427. 建立四叉树
  public static void main(String[] args) {
    Construct_427 construct_427 = new Construct_427();
    construct_427.construct(new int[][]{{0,1},{1,0}});
  }
  private static class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
      this.val = false;
      this.isLeaf = false;
      this.topLeft = null;
      this.topRight = null;
      this.bottomLeft = null;
      this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
      this.val = val;
      this.isLeaf = isLeaf;
      this.topLeft = null;
      this.topRight = null;
      this.bottomLeft = null;
      this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
      this.val = val;
      this.isLeaf = isLeaf;
      this.topLeft = topLeft;
      this.topRight = topRight;
      this.bottomLeft = bottomLeft;
      this.bottomRight = bottomRight;
    }
  };

  public Node construct(int[][] grid) {
    return construct(grid, 0, grid.length, 0, grid[0].length);
  }
  public Node construct(int[][] grid, int minX, int maxX, int minY, int maxY) {
    if (minX == maxX-1 && minY == maxY-1) {
      return new Node(grid[minX][minY]==1, true);
    }
    int midX = (minX>>>1)+(maxX>>>1);
    int midY = (minY>>>1)+(maxY>>>1);
    Node node = new Node();
    Node topLeft = construct(grid, minX, midX, minY, midY);
    Node topRight = construct(grid, minX, midX, midY, maxY);
    Node bottomLeft = construct(grid, midX, maxX, minY, midY);
    Node bottomRight = construct(grid, midX, maxX, midY, maxY);
    if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
        topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
      node.isLeaf = true;
      node.val = topLeft.val;
    } else {
      node.isLeaf = false;
      node.topLeft = topLeft;
      node.topRight = topRight;
      node.bottomLeft = bottomLeft;
      node.bottomRight = bottomRight;
    }
    return node;
  }
}
