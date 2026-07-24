import java.util.HashMap;

class UndergroundSystem {
    HashMap<Integer, Object[]> in = new HashMap<>();
    HashMap<String, double[]> total = new HashMap<>();

    public UndergroundSystem() {}

    public void checkIn(int id, String station, int t) {
        in.put(id, new Object[]{station, t});
    }

    public void checkOut(int id, String station, int t) {
        Object[] p = in.remove(id);
        double[] r = total.computeIfAbsent((String) p[0] + "->" + station, k -> new double[2]);
        r[0] += t - (int) p[1];
        r[1]++;
    }

    public double getAverageTime(String start, String end) {
        double[] r = total.get(start + "->" + end);
        return r[0] / r[1];
    }
}

/*
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
