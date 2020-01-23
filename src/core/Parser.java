package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {

    static public Data getData(String fname) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fname));
        String str;

        ArrayList<String> list = new ArrayList<>();
        while ((str = reader.readLine()) != null) {
            if (!str.isEmpty()) {
                list.add(str);
                System.out.println(str);
            }
        }

        String[] strs = list.toArray(new String[0]);

        int N = Integer.parseInt(strs[0]);
        String[] tmp = strs[1].split(" ");
        double[] dirTime = new double[N];
        for (int i = 0; i < N; i++) {
            dirTime[i] = Integer.parseInt(tmp[i]);
        }

        double[][] time = new double[N + 1][];
        for (int i = 0; i < N + 1; i++) {
            tmp = strs[i + 2].split("\t");
            time[i] = new double[N + 1];
            for (int j = 0; j < N + 1; j++) {
                time[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        return new Data(N, time, dirTime);
    }
}
