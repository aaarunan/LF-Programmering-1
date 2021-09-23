package oppgave2;
import java.util.Scanner;

public class oppgave2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Antall timer:");
        int timer = input.nextInt();
        System.out.println("Antall minutter:");
        int minutter = input.nextInt();
        System.out.println("Antall sekunder:");
        int sekunder = input.nextInt();
        int total = (timer*60*60)+(minutter*60)+sekunder;
        System.out.println("Det er: " + total + " sekunder");
    }
}
