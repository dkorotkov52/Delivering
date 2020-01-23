package algorithm.config.bounds;

import core.Data;
import core.Node;

import java.util.ArrayList;
import java.util.Arrays;

public class DirTUBound implements IUBound {
    @Override
    public int UpperBound(Node node, Data data, int[] x) {
        int[] nodes = node.getNodes();
        int ub = 0;
        double time = data.getTime()[0][nodes[0]+1];
        for (int i = 0; i < nodes.length - 1; i++)
        {
            x[i] = nodes[i];
            if (data.getDirTime()[nodes[i]] < time)
                ub++;
            time += data.getTime()[nodes[i]+1][nodes[i + 1] + 1];
        }
        x[nodes.length - 1] = nodes[nodes.length - 1];
        if (data.getDirTime()[nodes[nodes.length - 1]] < time)
            ub++;

        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(node.getChildren()));

        ArrayList<Integer> overdue = new ArrayList<>();
        for (int i = nodes.length; i < data.getN(); i++)
        {
            x[i] = getClosest(nums, data, overdue, time);
            time += data.getTime()[x[i - 1] + 1][x[i] + 1];
            if (data.getDirTime()[x[i]] < time)
                ub++;
            nums.remove(x[i]);
        }
        return ub;
    }

    private int getClosest(ArrayList<Integer> nums, Data data, ArrayList<Integer> overdue, double time)
    {
        int num = 0;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++)
        {
            if (data.getDirTime()[nums.get(i)] > time)
            {
                overdue.add(nums.get(i));
                nums.remove(i);
            }
            else
            {
                if (min > data.getDirTime()[nums.get(i)])
                {
                    num = nums.get(i);
                    min = data.getDirTime()[nums.get(i)];
                }
            }
        }
        if (nums.size() == 0)
        {
            num = overdue.get(0);
            overdue.remove(0);
        }
        return num;
    }
}
