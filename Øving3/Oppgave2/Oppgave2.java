import java.util.Scanner;

class Oppgave2 {
    public static void main(String[] args) {
        sjekk();
    }

    public static void sjekk() {

        Scanner input = new Scanner(System.in);
        System.out.println("Skriv et tall");
        int tall = input.nextInt();
        
        boolean primtall = true;
        for (int i = 2; i < tall; i++) {
            if (tall % i == 0) {
                primtall = false;
                break;
            }
        }

        if (tall == 0 || tall == 1) {
            primtall = false;
        }

        System.out.println(primtall);

        sjekk();
        input.close();
    }
}
