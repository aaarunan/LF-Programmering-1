import java.util.*;


public class Oppgaveoversikt {
    private final List<Student> studenter = new ArrayList<>(); //tabellen opprettes i konstruktøren
    private int antStud = 0; //økes med en for hver ny student

    public Oppgaveoversikt () {
        super();
    }

    public int getAntStud() {
        return antStud;
    }

    public int AntallOppgaverLost(int studentId) {
        return this.studenter.get(studentId).getAntOppg();
    }

    public void registrerNyStudent(String navn, int antOppg) {
        this.studenter.add(new Student(navn, antOppg));
        this.antStud++;
    }

    public void leggtilOppgaver(int studentId, int antall) {
        this.studenter.get(studentId).leggTilAntOppg(antall);

    }

    public String getNavn(int studentId) {
        return this.studenter.get(studentId).getNavn();
    }
}
