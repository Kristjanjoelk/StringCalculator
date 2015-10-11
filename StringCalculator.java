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
			
			for(int i = 0; i < numbers.length(); i++)
			{
				String temp = "";
				while(i < numbers.length() && numbers.charAt(i) != ',' )
				{
					temp += numbers.charAt(i);
					i++;
				}
				result += Integer.parseInt(temp);
			}
//			int idx = numbers.indexOf(',');
//			String A, B = "";
//			
//			A = numbers.substring(0, idx);
//			B = numbers.substring(++idx, numbers.length());
//			
//			result = Integer.parseInt(A) + Integer.parseInt(B);
			
			return result;
		}
	}
	
	public static void main(String[] args)
	{
		String numbers = "";
		while(true)
		{
			String input = StdIn.readLine();
			if(input.equals(""))
			{
				break;
			}
			numbers += input +  ",";
		}
		
		int result = add(numbers);

		StdOut.println(result);
	}
}

