

public final class Person {
    private final String fNavn;
    private final String eNavn;
    private final int fodselsar;


    public Person(String fNavn, String eNavn, int fodselsar) {
        this.fNavn = fNavn;
        this.eNavn = eNavn;
        this.fodselsar = fodselsar;
    }

    public String geteNavn() {
        return eNavn;
    }

    public String getfNavn() {
        return fNavn;
    }

    public int getFodselsar() {
        return fodselsar;
    }

}
