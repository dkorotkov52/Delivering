package algorithm.config.bounds;

import core.Node;

import java.util.List;

public class H1Branching implements IBranching {
    @Override
    public Node branch(List<Node> nodes) {
        Node n = null;
        int DiffMin = Integer.MAX_VALUE;
        nodes.sort(new NodeComp());
        for (int i = 0; i < nodes.size() / 5 + 1; i++)
        //foreach (Node node in nodes)
        {
            if ((nodes.get(i).getUpperBound() - nodes.get(i).getLowerBound()) < DiffMin) {
                DiffMin = nodes.get(i).getUpperBound() - nodes.get(i).getLowerBound();
                n = nodes.get(i);
            }
        }
        return n;
    }
}
