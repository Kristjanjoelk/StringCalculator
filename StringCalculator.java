import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StringCalculator {
	
	public static int add(String numbers)
	{
		if(numbers.isEmpty())
		{
			return 0;
		}
		else if(!numbers.contains(","))
		{
			return Integer.parseInt(numbers);
		}
		else {
			int result = 0;
			int idx = numbers.indexOf(',');
			String A, B = "";
			
			A = numbers.substring(0, idx);
			B = numbers.substring(++idx, numbers.length());
			
			result = Integer.parseInt(A) + Integer.parseInt(B);
			
			return result;
		}
	}
	
	public static void main(String[] args)
	{
		String input = StdIn.readLine();
		
		int result = add(input);

		StdOut.println(result);
	}
}

