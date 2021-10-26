import java.util.*;

import static java.util.Calendar.YEAR;

public class Arbeidstaker {

    GregorianCalendar kalender = new GregorianCalendar();
    private final Person personalia;
    int arbeidstakernr;
    int ansettelsesar;
    int manedslonn;
    //skatteprosent/100;
    float skatteprosent;

    public Arbeidstaker(Person personalia, int arbeidstakernr, int ansettelsesar, int manedslonn, float skatteprosent) {
        this.skatteprosent = skatteprosent / 100;
        this.personalia = personalia;
        this.arbeidstakernr = arbeidstakernr;
        this.ansettelsesar = ansettelsesar;
        this.manedslonn = manedslonn;

    }

    public float getSkatteprosent() {
        return skatteprosent;
    }

    public int getAnsettelsesar() {
        return ansettelsesar;
    }

    public int getArbeidstakernr() {
        return arbeidstakernr;
    }

    public int getManedslonn() {
        return manedslonn;
    }

    public Person getPersonalia() {
        return this.personalia;
    }

    public void setAnsettelsesar(int ansettelsesar) {
        this.ansettelsesar = ansettelsesar;
    }

    public void setArbeidstakernr(int arbeidstakernr) {
        this.arbeidstakernr = arbeidstakernr;
    }

    public void setManedslonn(int manedslonn) {
        this.manedslonn = manedslonn;
    }

    public void setSkatteprosent(float skatteprosent) {
        this.skatteprosent = skatteprosent;
    }

    public float getSkattetrekkPerManed() {
        return this.manedslonn * this.skatteprosent;
    }

    public int getBruttoLonnPerAr() {
        return this.manedslonn * 12;
    }

    public float getSkatteTrekkPerAr() {
        return this.getSkattetrekkPerManed() * 10 + this.manedslonn * this.skatteprosent / 2;
    }

    public int getAlder() {
        return kalender.get(YEAR) - this.personalia.getFodselsar();

    }

    public int getAntallArIBedriften() {
        return kalender.get(YEAR) - this.ansettelsesar;
    }

    public boolean ansattHvisAntallAr(int ar) {
        return ar <= this.getAntallArIBedriften();
    }

    @Override
    public String toString() {
        return this.personalia.getfNavn() + ", " + this.personalia.geteNavn();
    }


}

