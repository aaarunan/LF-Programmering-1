import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Klientprogram {
    public static ArrangementRegister arrangementRegister = new ArrangementRegister();

    public static boolean loop = true;


    public static void main(String[] args) {
        List<String> typeListe = new ArrayList<>();
        typeListe.add("Konsert");
        typeListe.add("Rave");
        typeListe.add("Konferanse");

        arrangementRegister.setTypeListe(typeListe);
        arrangementRegister.leggTilArrangement("Alan Walker", "Dødens dal", "UKA", 0, 202120101900L);
        arrangementRegister.leggTilArrangement("Rave m/Abakus og Online", "The Mint", "Thilde", 1, 202121112200L);
        arrangementRegister.leggTilArrangement("UKAtech", "Dødens dal", "UKA", 2, 202020101900L);

        Scanner in = new Scanner(System.in);

        System.out.println(" ");
        System.out.print("-----ArrangementRegister-----");

        while (loop) {
            hovedMeny(in);
        }
        in.close();
    }


    private static void hovedMeny(Scanner in) {
        System.out.println(" ");

        System.out.println("0. Avslutt");
        System.out.println("1. Registrer nytt arrangement");
        System.out.println("2. Finn alle arrangementer på et gitt sted");
        System.out.println("3. Finn alle arrangementer etter dato");
        System.out.println("4. Finn alle arrangementer mellom et intervall");
        System.out.println("5. Alle arrangementer sortert etter");
        System.out.println("6. Slett et arrangement");

        switch (in.nextInt()) {
            case 1 -> leggTilArrangement(in);

            case 2 -> {
                System.out.println("Sted:");
                in.nextLine();
                List<Arrangement> targets = arrangementRegister.finnArrangementEtterSted(in.nextLine());
                skrivUtArray(targets);
            }
            case 3 -> {
                System.out.println("Dato (YYYYMMDD):");
                List<Arrangement> targets = arrangementRegister.finnArrangementEtterDato(in.nextInt());
                skrivUtArray(targets);
            }

            case 4 -> {
                System.out.println("Start dato (YYYYMMDD):");
                int start = in.nextInt();

                System.out.println("Slutt dato (YYYYMMDD):");
                int slutt = in.nextInt();

                List<Arrangement> targets = arrangementRegister.finnArrangementEtterInterval(start, slutt);
                skrivUtArray(targets);
            }

            case 5 -> {
                System.out.println("1. sted");
                System.out.println("2. Dato");
                System.out.println("3. type");
                switch (in.nextInt()) {
                    case 1 -> skrivUtArray(arrangementRegister.sortSted(arrangementRegister.arrangementer));

                    case 2 -> skrivUtArray(arrangementRegister.sortTime(arrangementRegister.arrangementer));

                    case 3 -> skrivUtArray(arrangementRegister.sortType(arrangementRegister.arrangementer));

                }
            }

            case 6 -> {
                System.out.println("Hva er navnet på arrangementet du vil slette?");
                in.nextLine();
                System.out.println(arrangementRegister.fjernArrangement(in.nextLine()));
            }

            case 0 -> {
                System.out.println("Avslutter...");
                loop = false;
            }

            default -> System.out.println("Ikke gyldig menyvalg");
        }

    }

    private static void leggTilArrangement(Scanner in) {
        System.out.println("Navn:");
        in.nextLine();
        String navn = in.nextLine();
        if (arrangementRegister.ifExists(navn)) {
            System.out.println("Det finnes allerede et arrangement med samme navn.");
            leggTilArrangement(in);
        }

        System.out.println("Sted:");
        String sted = in.nextLine();

        System.out.println("Arrangør:");
        String arrangor = in.nextLine();
        System.out.println(" ");
        System.out.println("Type: ");
        int type = typeMeny(in);

        System.out.println("Dato (YYYYMMDDTTTT): ");
        long meta = in.nextLong();

        arrangementRegister.leggTilArrangement(navn, sted, arrangor, type, meta);
        System.out.println("Arrangementet " + navn + " ble registrert.");
    }

    private static int typeMeny(Scanner in) {

        for (int i = 0; i < arrangementRegister.typeListe.size(); i++) {
            System.out.println(i + ". " + arrangementRegister.typeListe.get(i));
        }

        return in.nextInt();
    }

    private static void skrivUtArray(List<Arrangement> targets) {
        if (targets.size() == 0) {
            System.out.println("Fant ingen arrangementer");
        } else {
            for (Arrangement target : targets) {
                System.out.println(target.toString());
            }
        }

    }


}
