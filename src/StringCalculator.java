c class StringCalculator {
	public static class negNumException extends Exception {
		  public negNumException(String message) { super(message); }
		  public negNumException(String message, Throwable cause) { super(message, cause); }
		}
	
	public static void printNegatives(String negNum)
	{
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
	public static String getDelimiter(String numbers)
	{
		String delimiter = "";
		for(int i = 3; i < numbers.length(); i++)
		{
				if(numbers.charAt(i) == ']')
				{
					break;
				}
				else
				{
					delimiter += numbers.charAt(i);
				}
		}
		return delimiter;
	}
	public static String removeDelimiterFromString(String numbers)
	{
		int counter = 0;
		int i;
		for(i = 0; i < numbers.length(); i++)
		{
				if(numbers.charAt(i) == ']')
				{
					break;
				}

		}
		return numbers.substring(i + 2);
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
			String delimiter = ",";
			if(numbers.contains("//"))
			{
				delimiter = getDelimiter(numbers);
				
				// debugging purposes
				StdOut.println("delimiter: " + delimiter);
				numbers = removeDelimiterFromString(numbers);
			}
			for(int i = 0; i < numbers.length(); i++)
			{
				String temp = "";
				while(i < numbers.length() && (numbers.charAt(i) != ',' && !delimiter.contains("" + numbers.charAt(i))))
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
						if(Integer.parseInt(temp) > 1000) {}
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
				printNegatives(negNum);
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

