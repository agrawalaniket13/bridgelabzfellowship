import java.util.Scanner;

public class Factor
{
	public static void main(String[ ] args) 
	{
		Scanner sc = new Scanner(System.in);
		int x, i;
		System.out.println("Enter the number");
		x = sc.nextInt();
		System.out.print("\nThe factors of the " + x + " are: ");
		for (i = 1; i <= x; i++) 
		{
			if (x % i == 0) 
			{
				System.out.print(i + " ");
			}
			i++;
		}
		System.out.print("\n");
	}
}