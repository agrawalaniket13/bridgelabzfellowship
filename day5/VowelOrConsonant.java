import java.util.Scanner;

public class VowelOrConsonant {
   public static void main(String args[ ]){
      char ch;
      System.out.println("Enter a alphabet :");
      Scanner sc = new Scanner(System.in);
      ch = sc.next().charAt(0);
      if(ch == 'a'|| ch == 'e'|| ch == 'i' ||ch == 'o' ||ch == 'u'||ch == ' '){
         System.out.println("Given alphabet is a vowel");
      }else{
         System.out.println("Given alphabet is a consonant");
      }
   }
}