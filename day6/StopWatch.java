import java.util.Scanner;
public class StopWatch
{
	public long startTimer=0;
	public long stopTimer=0;
	public long elapsed;
	
	public void start()
	{
		startTimer=System.currentTimeMillis();
		System.out.println("Start Time is: "+startTimer);
	}
	public void stop()
	{
		stopTimer=System.currentTimeMillis();
		System.out.println("Stop Time is: "+stopTimer);
	}
	public long getElapsedTime()
	{
		elapsed=stopTimer-startTimer;
		return elapsed;
	}
	public static void main(String[ ] args) throws Exception
	{
		StopWatch sw=new StopWatch();
		Scanner u=new Scanner(System.in);
		System.out.println("Press '1' to Start Time:");
		u.nextInt();
		sw.start();
		
		System.out.println();
		System.out.println("Press '2' to Stop Time:");
		u.nextInt();
		sw.stop();

		long l=sw.getElapsedTime();
		System.out.println();
		System.out.println("Total Time Elapsed(in millisec) is:"+1);
		System.out.println();
		System.out.println("Converting millisec to second:"+(1/1000)+"sec");
	}
}