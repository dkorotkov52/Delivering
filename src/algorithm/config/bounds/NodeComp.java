package algorithm.config.bounds;

import core.Node;

import java.util.Comparator;

public class NodeComp implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        return o1.getLowerBound() - o2.getLowerBound();
    }
}
