import java.util.ArrayList;
import java.util.Arrays;

public final class Matrise {
    private final double[][] matrise;

    public Matrise(double[][] matrise) {
        this.matrise = matrise;
        System.out.println(Arrays.deepToString(matrise));
    }

    public double[][] getMatrise() {
        return this.matrise;
    }

    private int getAntallRader() {return this.matrise.length;}

    private int getAntallKolonner() {return this.matrise[0].length;};

    public double[][] multipliserMatrise(Matrise m2) {
        if (this.getAntallRader() != m2.getAntallKolonner()) {
            throw new IllegalArgumentException("De er ikke multipliserbare");
        }

        double[][] ny = new double[this.getAntallKolonner()][m2.getAntallRader()];
        for (int r = 0; r < this.getAntallRader(); r++) {
            for (int k = 0; k < m2.getAntallKolonner(); k++) {
                for (int i = 0; i < this.getAntallKolonner(); i++) {
                    ny[r][k] += this.matrise[r][i] * m2.matrise[i][k];
                }
            }
        }
        return ny;
    }

    public double[][] adderMatrise(Matrise m2) {
        if (this.getAntallRader() != m2.getAntallRader() || this.getAntallKolonner() != m2.getAntallKolonner()) {
            throw new IllegalArgumentException("Ikke like multipliserbare");
        }

        double[][] ny = new double[this.getAntallRader()][this.getAntallKolonner()];
        for(int k = 0; k < this.getAntallKolonner(); k++) {
            for (int r = 0; r < this.getAntallRader(); r++) {
                ny[r][k] = this.matrise[r][k]+ m2.matrise[r][k];
            }
        }
        return ny;
    }

    public double[][] transponerMatrise() {
        double[][] ny = new double[this.getAntallRader()][this.getAntallKolonner()];

        for (int r = 0; r < this.getAntallRader(); r++) {
            for (int k = 0; k < this.getAntallKolonner(); k++) {
               ny[k][r] = this.matrise[r][k];
            }
        }
        return ny;
    }
}
