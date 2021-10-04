import java.util.Arrays;
import java.util.Random;

public class Oppgave1 {

    //initierer variabler
    private static final Random random = new Random();
    private static final int scope = 10;
    private static final int[] antall = new int[scope];

    public static void main(String[] args) {

        int runder = 1000;
        for (int i = 0; i < runder; i++) {
            int tall = random.nextInt(scope);
            antall[tall]++;
        }
        System.out.println(Arrays.toString(antall));

        for (int i = 0; i < scope; i++) {
            int sum = antall[i];
            long antallStjerner = Math.round(sum / (runder / 100.0));
            StringBuilder stjerner = new StringBuilder(" ");
            for (int u = 0; u < antallStjerner; u++) {
                stjerner.append("*");
            }
            System.out.println("Tall" + i + ": " + sum + " " + stjerner);
        }

    }

}
