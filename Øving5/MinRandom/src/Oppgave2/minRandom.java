package Oppgave2;
import java.util.Random;

public class minRandom {
    private final Random random = new Random();


    public double nesteDesimaltall(double nedre, double ovre) {
        double forskjell = ovre-nedre;

        return ((random.nextDouble()*forskjell))+nedre;
    }
    public int nesteHeltall(int nedre, int ovre) {
        int forskjell = ovre-nedre+1;

        return (random.nextInt(forskjell)+nedre);
    }



}