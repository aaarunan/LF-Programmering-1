public class Student {
    private final String navn;
    private int antOppg; //Holder orden på hvor mange av de oppgavene studenten har levert inn, som er godkjent.

    public Student(String navn, int antOppg) {
        this.navn = navn;
        this.antOppg = antOppg;
    }

    public String getNavn() {
        return navn;
    }

    public int getAntOppg() {
        return antOppg;
    }

    public void leggTilAntOppg(int antall) {
        this.antOppg += antall;
    }


}
