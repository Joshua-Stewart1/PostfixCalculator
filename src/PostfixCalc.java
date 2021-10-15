
public class PostfixCalc
{
	private LinkedStack<String> stack = new LinkedStack<>();
	
	public void evaluate(String expression)
	{
		String[] expArray = expression.split("\\s");
		
		Boolean error = false;
		String operand1;
		String operand2;
		
		for(int i = 0; i < expArray.length && !error; i++)
		{
			if(isNumber(expArray[i]))
			{
				stack.push(expArray[i]);
			}
			else
			{
				operand2 = stack.pop();
				operand1 = stack.pop();
				
				if(operand1 == null || operand2 == null)
				{
					error = true;
				}
				else
				{
					int op1 = Integer.parseInt(operand1);
					int op2 = Integer.parseInt(operand2);
					int result = 0;
					
					if(expArray[i].equals("+"))
					{
						result = op1 + op2;
					}
					else if(expArray[i].equals("-"))
					{
						result = op1 - op2;
					}
					else if(expArray[i].equals("/"))
					{
						result = op1 / op2;
					}
					else if(expArray[i].equals("*"))
					{
						result = op1 * op2;
					}
					else
					{
						error = true;
					}
					if(!error)
					{
						stack.push(Integer.toString(result));
					}
				}
			}
		}
		
		if(error || stack.isEmpty() || stack.size() > 1)
		{
			System.out.println("Error - Invalid Expression");
		}
		else
		{
			System.out.println(stack.pop());
		}
	}
	
	private Boolean isNumber(String str)
	{
		try
		{  
			Integer.parseInt(str);  
		    return true;
		}
		catch(NumberFormatException e)
		{  
			return false;  
		}  
	}
}