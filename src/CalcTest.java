import java.util.Scanner;

public class CalcTest
{
	public static void main(String args[])
	{
		PostfixCalc calculator = new PostfixCalc();
		
		Scanner input = new Scanner(System.in);
		
		String expression = "";
		
		System.out.println("Welcome to the Postfix Caclulator!");
		System.out.println("Enter your expression, or enter \"0\" to exit:\n");
		
		
		while(!expression.equals("0"))
		{
			System.out.print("Expression: ");
			expression = input.nextLine();
			
			if(!expression.equals("0"))
			{
				System.out.print("Result: ");
				calculator.evaluate(expression);
			}
			System.out.println();
		}
		System.out.println("Goodbye!");
	}
}
