package linecomparison;
import java.util.Scanner;
/**
 * @author Sakshi Shetty
 * Purpose - Line Comparison and Computation using OOPS concept
 */
public class LineComparison {

	/**
	* Purpose - Function to calculate the length between two points
	* @param x1 and x2 value of x-axis
	* @param y1 and y2 value of y-axis */
	public double FindLength(int x1, int x2, int y1, int y2) {
		double lengthofline = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
		return lengthofline;
	}

	/**
	* Purpose - To compare the two lines 
	* @param Line1 for x-axis
	* @param Line2 for y-axis */
	public void CheckEquality(double Line1, double Line2) {
		if (Line1 > Line2)
			System.out.println("Length of Line 1 is greater than the Length of Line 2");
		else if (Line1 < Line2)
			System.out.println("Length of Line 1 is lesser than the Length of Line 2");
		else
			System.out.println("Both the lines have equal length");
	}

	public static void main(String args[]) {

		/** 
		* Purpose - To take User input for co-ordinates of Line1 and Line2
		* @param x1, x2, y1, y2 for x-axis
		* @param x3, x4, y3, y4 for y-axis */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first co-ordinate  for x-axis of First Line");
		int x1 = sc.nextInt();
		System.out.println("Enter the second co-ordinate for x-axis of First Line");
		int x2 = sc.nextInt();
		System.out.println("Enter the first co-ordinate for y-axis of First Line");
		int y1 = sc.nextInt();
		System.out.println("Enter the second co-ordinate for y-axis of First Line");
		int y2 = sc.nextInt();
		System.out.println("Enter the first co-ordinate  for x-axis of second Line");
		int x3 = sc.nextInt();
		System.out.println("Enter the second co-ordinate for x-axis of second Line");
		int x4 = sc.nextInt();
		System.out.println("Enter the first co-ordinate for y-axis of second Line");
		int y3 = sc.nextInt();
		System.out.println("Enter the second co-ordinate for y-axis of second Line");
		int y4 = sc.nextInt();

		/** 
		*Purpose - To Call Method to calculate and compare the length of lines */
		LineComparison Compare = new LineComparison();
		double lengthOfLine1 = Compare.FindLength(x1, x2, y1, y2);
		System.out.println("The lenth of First Line is :" + lengthOfLine1);
		double lengthOfLine2 = Compare.FindLength(x3, x4, y3, y4);
		System.out.println("The lenth second Line is :" + lengthOfLine2);
		Compare.CheckEquality(lengthOfLine1, lengthOfLine2);
		sc.close();

	}
}
