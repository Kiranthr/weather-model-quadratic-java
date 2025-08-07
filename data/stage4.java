import java.io.*;
import java.util.*;

public class stage4 {
    public static void main(String[] args) throws IOException {
        File file = new File("data/multiple_sets.txt");
        Scanner sc = new Scanner(file);

        Map<String, List<Double>> xMap = new HashMap<>();
        Map<String, List<Double>> yMap = new HashMap<>();

        while (sc.hasNextLine()) {
            String[] parts = sc.nextLine().split(" ");
            String set = parts[0];
            double xi = Double.parseDouble(parts[1]);
            double yi = Double.parseDouble(parts[2]);

            xMap.putIfAbsent(set, new ArrayList<>());
            yMap.putIfAbsent(set, new ArrayList<>());

            xMap.get(set).add(xi);
            yMap.get(set).add(yi);
        }

        for (String set : xMap.keySet()) {
            double[] x = xMap.get(set).stream().mapToDouble(Double::doubleValue).toArray();
            double[] y = yMap.get(set).stream().mapToDouble(Double::doubleValue).toArray();

            double[] coeffs = QuadraticSolver.solve(x, y);
            System.out.printf("%s => y = %.2fx² + %.2fx + %.2f\n", set, coeffs[2], coeffs[1], coeffs[0]);
        }
    }
}
