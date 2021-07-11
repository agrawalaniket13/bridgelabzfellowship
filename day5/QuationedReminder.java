import java.util.Scanner;

public class QuationedReminder {
   public static void main(String[ ] args){
      int divisor;
      int divident;
      int quotient;
      int remainder;
      System.out.println("Enter the value of the divisor and divident: ");
      Scanner sc = new Scanner(System.in);
      divisor = sc.nextInt();
      divident = sc.nextInt();
      quotient = divident / divisor;
      remainder = divident % divisor;
      System.out.println("Quotient value:"+quotient);
      System.out.println("Remainder value:"+remainder);
   }
}