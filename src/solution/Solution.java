package solution;

public class Solution {
    private int[] x;
    private long nodesCount;

    public Solution(int[] x, long nodesCount)
    {
        this.x = x;
        this.nodesCount = nodesCount;
    }

    public int[] getX() {
        return x;
    }

    public long getNodesCount() {
        return nodesCount;
    }

    public void print()
    {
        System.out.println(nodesCount);
        System.out.println("nodesCount" + nodesCount);
    }
}
