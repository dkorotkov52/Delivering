package core;

import algorithm.config.Configurator;
import algorithm.config.bounds.IUBound;

import java.util.ArrayList;

public class Node {
    private Integer[] nodes;
    private int[] x;
    private Data data;
    private Configurator conf;
    private int lowerBound;
    private int upperBound;

    public Node(Integer[] nodes, Data data, Configurator conf) {
        this.nodes = nodes;
        this.data = data;
        this.conf = conf;
        x = new int[data.getN()];
        lowerBound = getLBound();
        upperBound = getUBound();
    }

    public int[] getNodes() {
        int[] n = new int[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            n[i] = nodes[i];
        }
        return n;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    private int getLBound() {
        return conf.getlBound().LowerBound(this, data);
    }

    private int getUBound() {
        int UBound = data.getN();
        for (IUBound UB : conf.getuBound())
        {
            int[] y = new int[x.length];
            int cur = UB.UpperBound(this, data, y);
            if (cur < UBound) {
                UBound = cur;
                x = y.clone();
            }
        }
        return UBound;
    }

    public Integer[] getChildren() {
        ArrayList<Integer> ch = new ArrayList<>();
        for (int i = 0; i < data.getN(); i++) {
            ch.add(i);
        }
        for (int i = 0; i < nodes.length; i++) {
            ch.remove(nodes[i]);
        }
        return (Integer[]) ch.toArray();
    }

    public int[] getUBoundX() {
        return x;
    }
}
