import java.util.Scanner;

public class Try
{
	public static void main(String [ ] args)
	{
		Scanner sc=new Scanner(System.in);
		int x;
		System.out.println("Enter a number");
		x=sc.nextInt();
		if(x%2==0){
			System.out.println("Number is even");
		}
		else{
			System.out.println("Number is odd");
		}
	}
}