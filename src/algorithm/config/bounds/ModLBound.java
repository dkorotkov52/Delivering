package algorithm.config.bounds;

import core.Data;
import core.Node;

public class ModLBound implements ILBound {
    @Override
    public int LowerBound(Node node, Data data) {
        int[] nodes = node.getNodes();
        int lb = 0;
        double time = data.getTime()[0][nodes[0] + 1];
        for (int i = 0; i < nodes.length - 1; i++) {
            if (data.getDirTime()[nodes[i]] < time)
                lb++;
            time += data.getTime()[nodes[i] + 1][nodes[i + 1] + 1];
        }
        if (data.getDirTime()[nodes[nodes.length - 1]] < time)
            lb++;

        boolean flag = false;
        for (int n : node.getChildren()) {
            if (time + data.getTime()[n + 1][nodes[nodes.length - 1] + 1] <= data.getDirTime()[n]) {
                flag = true;
            }
        }
        if (!flag) lb++;
        return lb;
    }
}
