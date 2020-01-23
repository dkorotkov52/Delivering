package core;

public class Data {
    private int n;
    private double[][] time;
    private double[] dirTime;

    public Data(int n, double[][] time, double[] dirTime) {
        this.n = n;
        this.time = new double[time.length][];
        for (int i = 0; i < time.length; i++) {
            this.time[i] = time[i];
        }
        this.dirTime = dirTime;
    }

    public int getN() {
        return n;
    }

    public double[] getDirTime() {
        return dirTime;
    }

    public double[][] getTime() {
        return time;
    }
}
