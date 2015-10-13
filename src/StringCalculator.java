


public class StringCalculator {
	
	public static int add(String numbers)
	{
		if(numbers.isEmpty())
		{
			return 0;
		}
		else {
			int result = 0;
			int index = 0;
			String nothing = " ";
			char delimiter = ',';
			if(numbers.contains("//"))
			{
				delimiter = numbers.charAt(2);
				index = 4;
			}
			for(int i = index; i < numbers.length(); i++)
			{
				String temp = "";
				while(i < numbers.length() && (numbers.charAt(i) != ',' && numbers.charAt(i) != delimiter ))
				{
					temp += numbers.charAt(i);
					i++;
				}
				if(!temp.isEmpty())
					result += Integer.parseInt(temp);
			}
			return result;
		}
	}
	
	public static void main(String[] args)
	{
		String numbers = "";
		String input = "";
		StdOut.println("Input numbers please: ");
		while(!StdIn.isEmpty())
		{
			input = StdIn.readString();
			numbers += input + ",";
		}
		int result = add(numbers);
		StdOut.println("Answers: " + result);
	}
}

