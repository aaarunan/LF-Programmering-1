package Oppgave1.java;

public class Oppgave1 {
    public static void main(String[] args) {
        //Fungerer ikke hvis teller eller nevner er negativ
        Brok brok = new Brok(6, 8);
        Brok brokb = new Brok(6, 0);
        System.out.println("Brøk A: " + brok.get());
        System.out.println("Brøk B: " + brokb.get());
        brok.addere(brokb);

        System.out.println("Svar: " + brok.get());
        brok.forkort();
        System.out.println("Forkortet: " + brok.get());
        if (brok.getTeller() == 3 && brok.getNevner() == 2) {
            System.out.println("Test 1 ok!");
        }
    }

}