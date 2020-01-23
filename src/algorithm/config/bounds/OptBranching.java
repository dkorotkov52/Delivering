package algorithm.config.bounds;

import core.Node;

import java.util.List;

public class OptBranching implements IBranching {
    @Override
    public Node branch(List<Node> nodes) {
        Node n = null;
        int LBoundMin = Integer.MAX_VALUE;
        for (Node node : nodes) {
            if (node.getLowerBound() < LBoundMin) {
                LBoundMin = node.getLowerBound();
                n = node;
            }
        }
        return n;
    }
}
