package Oppgave1;

import java.util.Arrays;
import java.util.Locale;

public class NyString {
    private final String string;

    public NyString(String string) {
        this.string = string;
    }

    public String Forkort() {
        String[] split = this.string.split(" ");
        StringBuilder forkort = new StringBuilder(" ");
        for (String s : split) {
            forkort.append(s.charAt(0));
        }
        return forkort.toString();
    }

    public String Fjern(char c) {
        //Fjerner store og små bokstaver
        StringBuilder nyString = new StringBuilder(this.string.toLowerCase());
        for (int i = 0; i < nyString.length(); i++) {
            if (nyString.charAt(i) == Character.toLowerCase(c)) {
                nyString.deleteCharAt(i);
            }
        }
        return nyString.toString();
    }
}
