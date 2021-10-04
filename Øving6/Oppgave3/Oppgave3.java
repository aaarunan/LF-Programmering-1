import java.util.Arrays;
import java.util.Scanner;

public class Oppgave3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TestKlient();
        //Matrise matrise1 = new Matrise(LagMatrise(in));
        //Matrise matrise2 = new Matrise(LagMatrise(in));
        in.close();
    }

    private static double[][] LagMatrise(Scanner in) {
        System.out.println("Hvor mange rader har matrisen?");
        int rader = in.nextInt();
        System.out.println("Hvor mange kolonner har matrisen?");
        int kolonner = in.nextInt();
        return FyllMatrise(rader, kolonner, in);
    }


    private static double[][] FyllMatrise(int rader, int kolonner, Scanner in) {
        double[][] matrise = new double[rader][kolonner];
        for (int i = 0; i < rader; i++) {
            for (int u = 0; u < kolonner; u++) {
                System.out.println("Fyll m["+i+"]["+u+"]");
                matrise[i][u] = in.nextInt();
            }
        }
        return matrise;
    }

    private static void TestKlient() {
        double[][] m = new double[][]{{1.0, 2.0}, {2.0, 1.0}};
        double[][] n = new double[][]{{2.0, 1.0}, {1.0, 2.0}};
        Matrise matrise1 = new Matrise(m);
        Matrise matrise2 = new Matrise(n);
        System.out.println("Multiplisering: ");
        System.out.println(Arrays.deepToString(matrise1.multipliserMatrise(matrise2)));
        System.out.println("Addere: ");
        System.out.println(Arrays.deepToString(matrise1.adderMatrise(matrise2)));
        System.out.println("Transponering: ");
        System.out.println(Arrays.deepToString(matrise1.transponerMatrise()));
    }

}
