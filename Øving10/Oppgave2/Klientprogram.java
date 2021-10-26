import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Klientprogram {
    public static MenyRegister menyRegister = new MenyRegister();
    public static boolean loop = true;

    public static void main(String[] args) {
        menyRegister.registrerMatrett("Bolognese", 1, 100f);
        menyRegister.registrerMatrett("Hamburger", 1, 10f);
        menyRegister.registrerMatrett("Sjokoladekake", 2, 80f);
        menyRegister.registrerMatrett("brød", 0, 70f);
        menyRegister.registrerMatrett("Taco", 1, 30f);
        menyRegister.registrerMatrett("Nudler", 1, 10.7f);

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
        System.out.println("1. Registrer ny rett");
        System.out.println("2. Finn rett etter navn");
        System.out.println("3. Finn retter etter type");
        System.out.println("4. Registrer ny meny");
        System.out.println("5. Finn meny etter pris");


        switch (in.nextInt()) {
            case 1 -> leggTilRett(in);

            case 2 -> {
                System.out.println("Navn:");
                in.nextLine();
                Matrett target = menyRegister.finnMatrettEtterNavn(in.nextLine());
                if (target == null) {
                    System.out.println("Ingen matrett funnet");
                } else {
                    System.out.println(target.getNavn() + " Pris: " + target.getPris());
                }

            }

            case 3 -> {
                System.out.println("Type:");
                skrivUtTyper();
                skrivUtMatretter(menyRegister.finnMatrettEtterType(Matrett.type[in.nextInt()]));
            }

            case 4 -> {

                LeggTilMeny(in);
            }

            case 5 -> {
                System.out.println("Minimum pris");
                int min = in.nextInt();
                System.out.println("Maks pris");
                int max = in.nextInt();

                skrivUtMenyer(menyRegister.finnMenyEtterPris(min, max));
            }
            case 0 -> {
                System.out.println("Avslutter...");
                loop = false;
            }

            default -> System.out.println("Ikke gyldig menyvalg");
        }
    }

    private static void leggTilRett(Scanner in) {
        System.out.println("Navn:");
        in.nextLine();
        String navn = in.nextLine();
        System.out.println("Type:");
        skrivUtTyper();
        int type = in.nextInt();
        System.out.println("Pris:");
        float pris = in.nextFloat();
        menyRegister.registrerMatrett(navn, type, pris);

    }

    private static void LeggTilMeny(Scanner in) {
        System.out.println("Hvor man matretter vil du legge til?");
        int antall = in.nextInt();
        skrivUtMatretter(menyRegister.matRegister);
        ArrayList<Matrett> targets = new ArrayList<>();
        for (int i = 0; i < antall; i++) {
            int j = i + 1;
            System.out.println("Matrett: " + j + ".");
            targets.add(menyRegister.matRegister.get(in.nextInt()));
        }
        menyRegister.registrerMeny(targets);
        System.out.println("Matrettene ble lagt til");
    }

    private static void skrivUtMatretter(List<Matrett> targets) {
        if (targets.size() == 0) {
            System.out.println("Ingen matretter funnet");
        } else {
            for (int i = 0; i < targets.size(); i++) {
                System.out.println(i + ". " + targets.get(i).getNavn() + "  Pris: " + targets.get(i).getPris());
            }
        }

    }

    private static void skrivUtMenyer(List<Meny> targets) {
        if (targets.size() == 0) {
            System.out.println("Ingen menyer funnet");
        } else {
            for (int i = 0; i < targets.size(); i++) {
                System.out.println("Meny " + i + ". Totalpris: " + targets.get(i).getTotalPris());
                skrivUtMatretter(targets.get(i).matretter);
            }
        }
    }

    private static void skrivUtTyper() {
        for (int i = 0; i < Matrett.type.length; i++) {
            System.out.println(i + ". " + Matrett.type[i]);
        }
    }
}
