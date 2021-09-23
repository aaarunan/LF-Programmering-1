package oppgave1;
import java.util.Scanner; 

class oppgave1 {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    double tommer;
    System.out.println("Skriv antall tommer"); 
    tommer = myObj.nextDouble(); 
    double centimeter = tommer*2.54;  
       
    System.out.println(tommer + " tommer er " + centimeter + " centimeter");        
  }
}
