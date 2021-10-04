import java.util.Arrays;
import java.util.Objects;

public class Tekst {
    String string;
    public Tekst(String string) {
        this.string = string;
    }

    public int Length() {
        return this.string.split(" ").length;
    }

    public String Get() { return this.string; }

    public String GetStoreBokstaver() { return this.string.toUpperCase(); }

    public float GjennomsnittligLengde() {
        String utenMellomrom = this.string.replaceAll("\\s", "");
        utenMellomrom = utenMellomrom.replaceAll("[!:.?]+", "");
        System.out.println(Arrays.toString(utenMellomrom.split("\\s")));
        return (utenMellomrom.length())/(float)(string.split(" ").length);
    }

    public float PeriodiskGjennomsnitt() {
        String utenMellomrom = this.string.replaceAll("\\s","");
        String[] split = utenMellomrom.split("[!:.?]+");
        utenMellomrom = utenMellomrom.replaceAll("[!:.?]+", "");
        System.out.println(Arrays.toString(split));
        return (utenMellomrom.length())/(float)(split.length);
    }

    public void ByttUtOrd(String gammel, String ny) {
        String[] split = this.string.split(" ");
        StringBuilder nyString = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (Objects.equals(split[i], gammel)) {
                split[i] = ny;
            }
        }
        for (String s : split) {
            nyString.append(s).append(" ");
        }

        this.string = nyString.toString();
    }
}
