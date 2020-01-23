package algorithm.config.bounds;

import core.Data;
import core.Node;

public interface IUBound {
    int UpperBound(Node node, Data data, int[] x);
}
