package oppgave3;
import java.util.Scanner;

public class oppgave3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Antall sekunder:");
        int sekunder = input.nextInt();
        int timer = sekunder/3600;
        int minutter = sekunder/60-timer*60;
        int rest = sekunder-timer*3600-minutter*60;
        System.out.println(timer + " " + minutter + " " + rest);

    }
}
