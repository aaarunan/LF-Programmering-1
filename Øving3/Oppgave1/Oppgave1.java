import java.util.Scanner;

public class Oppgave1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Start: ");
        int start = input.nextInt();
        int slutt;
        do {
            System.out.println("Slutt: (må være høyere)");
            slutt = input.nextInt();
        } while ( start > slutt);

        input.close();

        int max = 10;
        int antall = slutt-start+1;
        int sum = 0;

        for (int i = 1; i <= antall ; i++) {
            System.out.println(" ");
            System.out.println(start + ". gangeren");
            for (int u = 1; u <= max; u++) {
                sum = start * u;
                System.out.println(start + " X " + u + " = " + sum); 
            }
            start++;
        }
    }
}
