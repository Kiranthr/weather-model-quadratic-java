public class QuadraticSolver {
    public static double[] solve(double[] x, double[] y) {
        int n = x.length;
        double sumX = 0, sumX2 = 0, sumX3 = 0, sumX4 = 0;
        double sumY = 0, sumXY = 0, sumX2Y = 0;

        for (int i = 0; i < n; i++) {
            double xi = x[i];
            double yi = y[i];
            double xi2 = xi * xi;

            sumX += xi;
            sumX2 += xi2;
            sumX3 += xi2 * xi;
            sumX4 += xi2 * xi2;
            sumY += yi;
            sumXY += xi * yi;
            sumX2Y += xi2 * yi;
        }

        double[][] A = {
            {n, sumX, sumX2},
            {sumX, sumX2, sumX3},
            {sumX2, sumX3, sumX4}
        };

        double[] B = {sumY, sumXY, sumX2Y};
        return gaussianElimination(A, B);
    }

    private static double[] gaussianElimination(double[][] A, double[] B) {
        int n = B.length;
        for (int i = 0; i < n; i++) {
            int max = i;
            for (int j = i + 1; j < n; j++)
                if (Math.abs(A[j][i]) > Math.abs(A[max][i])) max = j;

            double[] temp = A[i]; A[i] = A[max]; A[max] = temp;
            double t = B[i]; B[i] = B[max]; B[max] = t;

            for (int j = i + 1; j < n; j++) {
                double f = A[j][i] / A[i][i];
                B[j] -= f * B[i];
                for (int k = i; k < n; k++)
                    A[j][k] -= f * A[i][k];
            }
        }

        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            x[i] = B[i];
            for (int j = i + 1; j < n; j++)
                x[i] -= A[i][j] * x[j];
            x[i] /= A[i][i];
        }
        return x;
    }
}
