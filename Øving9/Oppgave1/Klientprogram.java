import java.util.Objects;
import java.util.Scanner;

public class Klientprogram {

    public static boolean loop = true;
    public static Oppgaveoversikt oppgaveoversikt = new Oppgaveoversikt();
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("---Oppgavedatabase---");


        while (loop) {
            hovedMeny(in);
        }
        in.close();
    }



    private static void hovedMeny(Scanner in) {
        System.out.println(" ");

        System.out.println("0. Avslutt");
        System.out.println("1. Finn antall registrerte studenter");
        System.out.println("2. Finn antall oppgaver en student har gjort");
        System.out.println("3. Registrer en ny student");
        System.out.println("4. Legg til oppgaver løst");

        int studentId;

        switch (in.nextInt()) {
            case 1 -> System.out.println("Det er: " + oppgaveoversikt.getAntStud() + " studenter registrert.");

            case 2 -> {
                studentId = finnStudent(in);
                System.out.println(oppgaveoversikt.getNavn(studentId) + " har løst: " + oppgaveoversikt.AntallOppgaverLost(studentId) + " oppgaver tilsammen.");
            }
            case 3 -> leggTilStudentMeny(in);

            case 4 -> {
                studentId = finnStudent(in);
                System.out.println("Legg til antall oppgaver:");
                oppgaveoversikt.leggtilOppgaver(studentId, in.nextInt());
            }

            case 0 -> {
                System.out.println("Avslutter...");
                loop = false;
            }

            default -> System.out.println("Ikke gyldig menyvalg");
        }
    }

    private static void leggTilStudentMeny(Scanner in) {
        System.out.println("Skriv inn navnet til studenten: ");
        in.nextLine();
        String navn = in.nextLine();

        System.out.println("Antall Oppgaver Løst: ");
        int antOppg = in.nextInt();

        oppgaveoversikt.registrerNyStudent(navn, antOppg);
        System.out.println("Studenten ble registrert med student id " + oppgaveoversikt.getAntStud() + ".");


    }

    private static int finnStudent(Scanner in) {

        System.out.println("Skriv ned studentid:");
        int studentId = in.nextInt();

        if (studentId > oppgaveoversikt.getAntStud()-1) {
            System.out.println(" ");
            System.out.println("Ikke gyldig student id.");
            finnStudent(in);
        }

        System.out.println("Heter studenten " + oppgaveoversikt.getNavn(studentId) + "? (Y/n)");
        in.nextLine();
        String valg = in.nextLine();
        if (Objects.equals(valg, "y") || Objects.equals(valg, "Y") || Objects.equals(valg, "")) {
            return studentId;
        } else {
            finnStudent(in);
        }
        return 0;
    }


}
