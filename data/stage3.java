import java.io.*;
import java.util.*;

public class stage3 {
    public static void main(String[] args) throws IOException {
        File file = new File("data/single_set.txt");
        Scanner sc = new Scanner(file);

        ArrayList<Double> xList = new ArrayList<>();
        ArrayList<Double> yList = new ArrayList<>();

        while (sc.hasNextLine()) {
            String[] parts = sc.nextLine().split(" ");
            xList.add(Double.parseDouble(parts[0]));
            yList.add(Double.parseDouble(parts[1]));
        }

        double[] x = xList.stream().mapToDouble(Double::doubleValue).toArray();
        double[] y = yList.stream().mapToDouble(Double::doubleValue).toArray();

        double[] coeffs = QuadraticSolver.solve(x, y);
        System.out.printf("Equation: y = %.2fx² + %.2fx + %.2f\n", coeffs[2], coeffs[1], coeffs[0]);
    }
}
