package algorithm.config.bounds;

import core.Data;
import core.Node;

public class BaseLBound implements ILBound {

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
        return lb;
    }
}
