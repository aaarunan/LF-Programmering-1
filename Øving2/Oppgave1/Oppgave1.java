import java.util.Scanner;

public class Oppgave1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("arstall:");

        int arstall = input.nextInt();
        input.close();
        boolean skuddar = false;
        
        if (arstall%4 == 0 && (arstall%100 != 0 || arstall%400 == 0)) {
            skuddar = true;
        } 
        System.out.println(arstall + " er" + (skuddar ? "" : " ikke") + " et skuddår");
    }
}

