/*
Credit card numbers follow certain patterns. A credit card number must have between 13
and 16 digits. It must start with:
 4 for Visa cards
 5 for Master cards
 37 for American Express cards
 6 for Discover cards
In 1954, Hans Luhn of IBM proposed an algorithm for validating credit card numbers. The
algorithm is useful to determine whether a card number is entered correctly or whether a
credit card is scanned correctly by a scanner. Credit card numbers are generated following
this validity check, commonly known as the Luhn check or the Mod 10 check, which can be
described as follows (for illustration, consider the card number 4388576018402626):

*/

import java.util.*;
public class creditNumberChecker{

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a credit card number as Long integer: ");
		long number = input.nextLong();
		
		if (isValid(number) == true){
			System.out.print(number + " is Valid ");
		}
		else{
			System.out.print(number + " is Invalid ");
		}

	}

	//To check the Validity of credit number by given conditions
	/** Return true if the card number is valid */
	public static boolean isValid(long number){
		boolean validCreditNumber =(getSize(number) >= 13 && getSize(number) <= 16) && (prefixMatched(number, 4) || prefixMatched(number, 5) 
		||prefixMatched(number, 37) || prefixMatched(number, 6)) &&((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0);
		return validCreditNumber;
	}

	//To add even index numbers
	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long number){
		int sumOfEvenIndex = 0;
		String tempVarForString = number + "";
		for(int count = getSize(number)-2; count>=0; count=count-2){
			sumOfEvenIndex = sumOfEvenIndex + getDigit(Integer.parseInt(tempVarForString.charAt(count)+ "")*2);
		}
		return  sumOfEvenIndex;

	}
	// For greater than 9 numbers 
	/** Return this number if it is a single digit, otherwise,
 * return the sum of the two digits */

	public static int getDigit(int number) {
		if(number==10) number = 1;
		if(number==11) number = 2;
		if(number==12) number = 3;
		if(number==13) number = 4;
		if(number==14) number = 5;
		if(number==15) number = 6;
		if(number==16) number = 7;
		return number;
	}

	//To add odd index numbers
	/** Return sum of odd-place digits in number */

	public static int sumOfOddPlace(long number) {
		int sumOfOddIndex = 0;
		String tempVarForString = number + "";
		for (int count = getSize(number)-1; count>=0; count=count-2){
			sumOfOddIndex = sumOfOddIndex + Integer.parseInt(tempVarForString.charAt(count)+ "");
		}
		return sumOfOddIndex;
	}

	//To match the prefix to meet our given condition
	/** Return true if the digit d is a prefix for number */
	public static boolean prefixMatched(long number, int d) {
		return getPrefix(number, getSize(d)) == d;
	}


	/** Return the number of digits in d */
	public static int getSize(long d){
		String digitsInString = d + "";
		return digitsInString.length();
	}

	
	//To find the prefix by substring
	/** Return the first k number of digits from number. If the
 * number of digits in number is less than k, return number. */
	public static long getPrefix(long number, int k){
		if (getSize(number) > k)  {
			String tempVarForString = number + "";
			return  Long.parseLong(tempVarForString.substring(0, k));
		}
		return number;
	}
}
