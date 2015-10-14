public class StringCalculator {
	public static class negNumException extends Exception {
		  public negNumException(String message) { super(message); }
		  public negNumException(String message, Throwable cause) { super(message, cause); }
		}
	public static int add(String numbers)
	{
		String negNum = "";
		if(numbers.isEmpty())
		{
			return 0;
		}
		else {
			int result = 0;
			int index = 0;
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
				{
					try
					{
						if(Integer.parseInt(temp) < 0)
						{
							throw new negNumException(temp);
					    }
						else
						{
							result += Integer.parseInt(temp);
						}
					}
					catch(negNumException ex)
					{
						if(negNum.isEmpty()) negNum += ex.getMessage();
						else negNum += "," + ex.getMessage();
					}					
				}	
			}
			if(!negNum.isEmpty())
			{
				result = 0;
				StdOut.print("Negatives not allowed: ");
				for(int i = 0; i < negNum.length(); i++)
				{
					String temp = "";
					while(i < negNum.length())
					{
						temp += negNum.charAt(i);
						i++;
					}
					if(!temp.isEmpty())
					{
						StdOut.print(temp);
					}
				}
				StdOut.println();
			}
			return result;
		}
	}
	
	public static void main(String[] args)
	{
		String numbers = "";
		String input = "";
		while(!StdIn.isEmpty())
		{
			input = StdIn.readString();
			numbers += input + ",";	

		}
		int result = add(numbers);
		
		if(result > 0)
		{
			StdOut.println(result);
		}
	}
}

