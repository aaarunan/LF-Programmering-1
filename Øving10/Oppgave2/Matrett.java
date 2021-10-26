public final class Matrett extends Type{
    String navn;
    float pris;

    public Matrett(String navn, int type, float pris) {
        super(type);
        this.navn = navn;
        this.pris = pris;
    }

    public String getNavn() {
        return navn;
    }


    public float getPris() {
        return pris;
    }


}
