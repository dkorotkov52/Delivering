package algorithm.config.bounds;

import core.Data;
import core.Node;

import java.util.ArrayList;
import java.util.Arrays;

public class GreedyUBound implements IUBound {

    @Override
    public int UpperBound(Node node, Data data, int[] x) {
        int[] nodes = node.getNodes();
        int ub = 0;
        double time = data.getTime()[0][nodes[0] + 1];
        x[0] = nodes[0];
        for (int i = 0; i < nodes.length - 1; i++) {
            x[i + 1] = nodes[i + 1];
            if (data.getDirTime()[nodes[i]] < time)
                ub++;
            time += data.getTime()[nodes[i] + 1][nodes[i + 1] + 1];
        }
        if (data.getDirTime()[nodes[nodes.length - 1]] < time)
            ub++;


        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(node.getChildren()));

        for (int i = nodes.length; i < data.getN(); i++) {
            x[i] = getClosest(x[i - 1], nums, data);
            time += data.getTime()[x[i - 1] + 1][x[i] + 1];
            if (data.getDirTime()[x[i]] < time)
                ub++;
            nums.remove(x[i]);
        }
        return ub;
    }

    private int getClosest(int n, ArrayList<Integer> nums, Data data) {
        int num = 0;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            if (min > data.getTime()[n + 1][nums.get(i) + 1]) {
                num = nums.get(i);
                min = data.getTime()[n + 1][nums.get(i) + 1];
            }
        }
        return num;
    }
}
