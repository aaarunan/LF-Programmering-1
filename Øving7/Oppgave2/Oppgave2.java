public class Oppgave2 {
    public static void main(String[] args) {
        Tekst tekst = new Tekst(" Jeg heter Arunan. Jeg liker pizza.");
        System.out.println(tekst.Get());
        System.out.println(" ");
        System.out.println("Lengde: " + tekst.Length());
        System.out.println("Gjennosmnitt per ord: " + tekst.GjennomsnittligLengde());
        System.out.println("Gjennomsnitt per periode: " + tekst.PeriodiskGjennomsnitt());
        tekst.ByttUtOrd("AAA", "aaa");
        System.out.println("Store bokstaver: " + tekst.GetStoreBokstaver());


    }
}
