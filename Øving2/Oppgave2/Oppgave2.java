import java.util.Scanner;

public class Oppgave2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("pris på kjøttdeig A:");
        double kjottApris = input.nextDouble();

        System.out.println("vekt på kjøttdeig A i gram:");
        double kjottAvekt = input.nextDouble();

        System.out.println("pris på kjøttdeig B:");
        double kjottBpris = input.nextDouble();

        System.out.println("vekt på kjøttdeig B i gram:");
        double kjottBvekt = input.nextDouble();
        input.close();
        
        double kiloprisA = kjottApris/kjottAvekt*1000;
        double kiloprisB = kjottBpris/kjottBvekt*1000;

        if (kiloprisA > kiloprisB) {
            System.out.println("kjottdeig B er billigst");
        } else if ( kiloprisB > kiloprisA) {
            System.out.println("kjottdeig A er billigst");
        } else {
            System.out.println("De er like billige");
        }

    }
}
