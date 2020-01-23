package algorithm;

import algorithm.config.Configurator;
import core.Data;
import core.Node;
import solution.Solution;

import java.util.ArrayList;

public class Algorithm {
    private Configurator conf;

    public Algorithm(Configurator conf) {
        this.conf = conf;
    }

    public Solution solve(Data data) {
        long nodesCount = 0;
        int k = 0;
        ArrayList<Node> nodes = new ArrayList<>();

        int UBoundMin = data.getN();
        int[] ans = new int[data.getN()];
        for (; ; ) {
            //ветвление
            if (nodes.isEmpty()) {
                for (int i = 0; i < data.getN(); i++) {
                    nodes.add(new Node(new Integer[] {
                        i
                    }, data, conf));
                    nodesCount++;
                    if (nodes.get(i).getUpperBound() < UBoundMin) {
                        UBoundMin = nodes.get(i).getUpperBound();
                        ans = nodes.get(i).getUBoundX();
                    }
                }
            } else {

                Node V = conf.getBranching().branch(nodes);
                nodes.remove(V);

                int n = data.getN() - V.getNodes().length;

                for (int i = 0; i < n; i++) {

                    ArrayList<Integer> tmp = new ArrayList<>();
                    for (int o = 0; i < V.getNodes().length; i++){
                        tmp.add(V.getNodes()[o]);
                    }

                    tmp.add(V.getChildren()[i]);
                    nodes.add(new Node((Integer[]) tmp.toArray(), data, conf));

                    nodesCount++;

                    if (nodes.get(nodes.size() - 1).getUpperBound() < UBoundMin) {
                        UBoundMin = nodes.get(nodes.size() - 1).getUpperBound();
                        ans = nodes.get(nodes.size() - 1).getUBoundX();
                    }
                }
            }

            //отсев
            for (int i = 0; i < nodes.size(); i++) {
                if (nodes.get(i).getLowerBound() >= UBoundMin) {
                    nodes.remove(nodes.get(i));
                    i--;
                    k++;
                }
            }
            if (nodes.size() == 0) {
                System.out.println("Opt = " + UBoundMin);
                return new Solution(ans, nodesCount);
            }

        }
    }
}
