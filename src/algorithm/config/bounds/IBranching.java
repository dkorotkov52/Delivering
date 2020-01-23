package algorithm.config.bounds;

import core.Node;

import java.util.List;

public interface IBranching {
    Node branch(List<Node> nodes);
}
