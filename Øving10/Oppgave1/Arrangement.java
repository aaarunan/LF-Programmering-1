public class Arrangement {

    String navn;
    long meta;
    String sted;
    String arrangor;
    int type;

    public Arrangement(String navn, String sted, String arrangor, int type, long meta) {
        this.navn = navn;
        this.meta = meta;
        this.sted = sted;
        this.arrangor = arrangor;
        this.type = type;

    }

    public String getNavn() {
        return navn;
    }

    public long getMeta() {
        return meta;
    }

    public String getSted() {
        return sted;
    }

    public String getArrangor() {
        return arrangor;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Navn: " + this.navn + ",    Sted: " + this.sted + ",    Dato (YYYYMMDDhhmm): " + this.meta + " Type: " + this.getType();
    }



}
