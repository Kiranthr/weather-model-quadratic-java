public class stage1{
    public static void main(String[] args) {
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {30, 32, 35, 39, 45};
        double[] coeffs = QuadraticSolver.solve(x, y);
        System.out.printf("Equation: y = %.2fx² + %.2fx + %.2f\n", coeffs[2], coeffs[1], coeffs[0]);
    }
}
