import java.util.Scanner;

class CannotDivideByZeroException extends Exception{
	public  CannotDivideByZeroException(String message) {
		super(message);
	}
}

class InvalidInputException extends Exception{
	public InvalidInputException(String message) {
		super(message);
	}
}

class MaxMultiplierReachedException extends Exception{
	public  MaxMultiplierReachedException(String message) {
		super(message);
	}
}

class MaxInputException extends Exception{
	public   MaxInputException(String message) {
		super(message);
	}
}
class Cal{
	public int add(int a, int b) throws InvalidInputException, MaxInputException {
		checkInput(a, b);
		return a + b;
		
	}
	public int subtract(int a, int b) throws InvalidInputException, MaxInputException{
		checkInput(a, b);
		return a - b;
	}
	public int multiply(int a, int b) throws InvalidInputException, MaxInputException, MaxMultiplierReachedException{
		checkInput(a, b);
		if(a > 7000 || b > 7000) {
			throw new MaxMultiplierReachedException("Multiplication input should not be greater than 7000.");
		}
		return a * b;
	}
	public int divide(int a ,  int b) throws InvalidInputException, MaxInputException, CannotDivideByZeroException{
		checkInput(a, b);
		if(b == 0) {
			throw new CannotDivideByZeroException("Cannot divide by zero");
		}
		return a / b;
		
	}
	
	private void checkInput(int a, int b) throws InvalidInputException, MaxInputException{
		if((a == 8 && b == 9) || (a == 9 && b == 8)) {
			throw new InvalidInputException("Invalid input: 8 & 9 cannot be together.");
		}
		if(a > 100000 || b > 100000) {
			throw new MaxInputException("Input must be ≤ 100000"); 
		}
	}

}

public class Calculator{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Cal calc = new Cal();
		
		System.out.println("Enter first number: ");
		int n1 = sc.nextInt();
		
		System.out.println("Enter second number: ");
		int n2 = sc.nextInt();
		
		System.out.println("Enter the operator (+, -, *, /): ");
		char op = sc.next().charAt(0);
		
		try {
			int result = 0;
			switch(op) {
			case '+':
				result = calc.add(n1 , n2);
				break;
			case '-':
				result = calc.subtract(n1 , n2);
				break;
			case '*':
				result = calc.multiply(n1 , n2);
				break;
			case '/':
				result = calc.divide(n1 , n2);
				break;
			default:
				System.out.println("Invalid Operator.");
				return;
			}
			System.out.println("Result: "+ result);
		} catch(Exception e) {
			System.out.println("Error: "+ e.getMessage());
		}
		
		sc.close();
	}

}
	
