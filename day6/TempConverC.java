import java.util.Scanner;
class TempConverC {
  public static void main(String[] args) {
    float temperature;
    Scanner in = new Scanner(System.in);

    System.out.println("Enter temperature in Fahrenheit");
    temperature = in.nextInt();

    temperature = ((9*c)/5)+32;

    System.out.println("temperature in Celsius = " + temperature);
  }
}