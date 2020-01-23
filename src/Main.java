import algorithm.Algorithm;
import algorithm.config.Configurator;
import algorithm.config.bounds.*;
import core.Data;
import core.Parser;
import solution.Solution;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] fnames = {"/Users/Apple1111/Documents/labs/2/Delivering/Task2/task_2_05_n10.txt"};
        Data[] data = new Data[fnames.length];
        for (int i = 0; i < fnames.length; i++) {
            data[i] = Parser.getData(fnames[i]);
        }
        Algorithm baseAlg = new Algorithm(new Configurator(new BaseLBound(), new IUBound[]{new GreedyUBound()}, new OptBranching()));
        Solution[] sol = new Solution[10];
        for (int i = 0; i < 1/*0*/; i++) {
            sol[i] = baseAlg.solve(data[i]);
            sol[i].print();
        }
        //Console.ReadLine();
        Algorithm hybridAlg = new Algorithm(new Configurator(new ModLBound(), new IUBound[]{new GreedyUBound(), new DirTUBound()}, new /*HybridBranching*/H1Branching()));
        System.out.println();
        for (int i = 0; i < 1/*0*/; i++) {
            sol[i] = hybridAlg.solve(data[i]);
            sol[i].print();
        }
        System.in.read();
    }
}
