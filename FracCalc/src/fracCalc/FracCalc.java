package fracCalc;
import java.util.Scanner;
public class FracCalc {

    public static void main(String[] args) 
    {
    	Scanner console = new Scanner(System.in);
    	
    	System.out.print("Enter your operation, or enter \"quit\" to end program: ");
    	String input = console.nextLine();
    	
    	while (!input.equals("quit")) {
    		System.out.println(produceAnswer(input));
    		System.out.println();
    		System.out.print("Enter a new operation, or enter \"quit\" : ");
    		input = console.nextLine();
    	}
    	
    		System.out.println();
    		System.out.println("Thank you for using the Java calculator, you may donate to my");
    		System.out.println("bitcoin at aisdf98249jadpguijaq394ri384gose85gowe88384q");
    		System.out.println("if you wish to support future updates.");
    		System.out.println("(Updates are subject to whether or not I feel like it at the time)");
    		
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	String[] operation = input.split("\\s");
    	
    	//This block of code stores each value of the first operand
    	String op1 = operation[0];
    	String[] op1parsed = op1.split("_");
    	String op1wholenum = op1parsed[0];
    	String[] op1frac = op1wholenum.split("/");
    	int op1num;
    	int op1den;
    	
    	if (op1frac.length > 1) {
    		op1num = Integer.parseInt(op1frac[0]);
    		op1den = Integer.parseInt(op1frac[1]);
    		op1wholenum = "0";
    	}
    	else if (op1parsed.length > 1) {
    		String op1mixed = op1parsed[1];
    		String[] op1mixfrac = op1mixed.split("/");
    		op1num = Integer.parseInt(op1mixfrac[0]);
    		op1den = Integer.parseInt(op1mixfrac[1]);
    	}
    	
    	else {
    		op1num = 0;
    		op1den = 1;
    	}
    	int op1whole = Integer.parseInt(op1wholenum);
    	/*
    	 * End of first operand code
   		 * Values are stored as
   		 * op1whole = whole number
   		 * op1num = numerator
   		 * op1den = denominator
    	*/
    	
    	
    	//This stores the operator		
    	String op = operation[1];
    	//End of operator code
    	
    	
    	
    	//This stores the second operand
    	String op2 = operation[2];
    	String[] op2parsed = op2.split("_");
    	String op2wholenum = op2parsed[0];
    	String[] op2frac = op2wholenum.split("/");
    	int op2num;
    	int op2den;
    	
    	if (op2frac.length > 1) {
    		op2num = Integer.parseInt(op2frac[0]);
    		op2den = Integer.parseInt(op2frac[1]);
    		op2wholenum = "0";
    	}
    	else if (op2parsed.length > 1) {
    		String op2mixed = op2parsed[1];
    		String[] op2mixfrac = op2mixed.split("/");
    		op2num = Integer.parseInt(op2mixfrac[0]);
    		op2den = Integer.parseInt(op2mixfrac[1]);
    	}
    	
    	else {
    		op2num = 0;
    		op2den = 1;
    	}
    	int op2whole = Integer.parseInt(op2wholenum);
    	
    	/*
    	 * End of second operand code
   		 * Values are stored as
   		 * op2whole = whole number
   		 * op2num = numerator
   		 * op2den = denominator
    	*/
    	
    	//This will convert the numbers into an improper fraction
    	if (op1whole < 0) {
    		op1num = (-1 * op1num) + (op1whole * op1den);
    	}	
    	else {
    		op1num = op1num + (op1whole * op1den);
    	}
    	
    	if (op2whole < 0) {
    		op2num = (-1 * op2num) + (op2whole * op2den);
    	}	
    	else {
    		op2num = op2num + (op2whole * op2den);
    	}
    	
    	//The calculations begin here:
    	int num = 0;
    	int den = 0;

    	if (op.equals("+")) {
    		num = (op1num * op2den) + (op1den * op2num);
    		den = op1den * op2den;
    	}
    	
    	else if (op.equals("-")) {
    		num = (op1num * op2den) - (op2num * op1den);
    		den = (op1den * op2den);
    	}
    	
    	else if (op.equals("*")) {
    		num = op1num * op2num;
    		den = op1den * op2den;
    	}
    	
    	else if (op.equals("/")) {
    		num = op1num * op2den;
    		den = op1den * op2num;
    	}
    	//End of calculations
    	
    	//Turns the improper fraction into a more simplified mixed fraction
    	int whole = 0;
    	int gcd = 1;
    	if (den < 0) {
    		den = den * (-1);
    		num = num * (-1);
    	}

    	for (int i = 1; i <= Math.abs(num) && i <= Math.abs(den); ++i) {
    		if (Math.abs(num) % i == 0 && Math.abs(den) % i == 0)
    			gcd = i;
    	}
    	num = num / gcd;
    	den = den / gcd;
    	if (Math.abs(num) >= den) {
    		whole = num / den;
    		num = Math.abs(num) % den;
    	}

    	String answer = "0";
    	
    	if (whole != 0 && num != 0) {
    		answer = Integer.toString(whole) + "_" + Integer.toString(num) + "/" + Integer.toString(Math.abs(den));
    	}
    	else if (whole != 0 && num == 0) {
    		answer = Integer.toString(whole);
    	}
    	else if (whole == 0 && num != 0) {
    		answer = Integer.toString(num) + "/" + Integer.toString(Math.abs(den));
    	}
    	else if (whole == 0 && num == 0) {
    		answer = "0";
    	}

    	return answer;
    }
    
    // TODO: Fill in the space below with any helper methods that you think you will need

}
