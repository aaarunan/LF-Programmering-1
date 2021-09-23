package valutakalkulator;

public class Valuta {
    private String navn;
    //Verdi er hva valutaen er verdt i norske kroner
    private double verdi;

    public Valuta(String navn, double verdi) {
        this.navn = navn;
        this.verdi = verdi;
    }

    public double regnFra(int antall) {
        return verdi * antall;

    }

    public double regnTil(int antall) {

        return antall / verdi;
    }
}
