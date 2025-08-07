import java.util.Scanner;
public class stage2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of points: ");
        int n = sc.nextInt();

        double[] x = new double[n];
        double[] y = new double[n];

        System.out.println("Enter x values:");
        for (int i = 0; i < n; i++) x[i] = sc.nextDouble();

        System.out.println("Enter y values:");
        for (int i = 0; i < n; i++) y[i] = sc.nextDouble();

        double[] coeffs = QuadraticSolver.solve(x, y);
        System.out.printf("Equation: y = %.2fx² + %.2fx + %.2f\n", coeffs[2], coeffs[1], coeffs[0]);
        sc.close();
    }
}
