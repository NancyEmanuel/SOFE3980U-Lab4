package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should conatins only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	*/
    public Binary(String number) {
		for (int i = 0; i < number.length(); i++) {
			// check each character if it's not 0 or 1
			char ch=number.charAt(i);
			if(ch!='0' && ch!='1') {
				number="0"; // if not store "0" and end the function
				return;
			}
		}
		// remove any trailing zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg)!='0')
				break;
		}
		//beg has the index of the first non zero digit in the number
		this.number=number.substring(beg); // exclude the trailing zeros if any
		// uncomment the following code
		
		if(this.number=="") { // replace empty strings with a single zero
			this.number="0";
		}
		
    }
	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}
	/**
	* Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1+num2</i>.
	*/
	public static Binary add(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int carry=0;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0 || carry!=0) // loop until all digits are processed
		{
			int sum=carry; // previous carry
			if(ind1>=0){ // if num1 has a digit to add
				sum += (num1.number.charAt(ind1)=='1')? 1:0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to add
				sum += (num2.number.charAt(ind2)=='1')? 1:0; // convert the digit to int and add it to sum
				ind2--; //update ind2
			}
			carry=sum/2; // the new carry
			sum=sum%2;  // the resultant digit
			num3 =( (sum==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
		
	}


// and code 
/**
 * 
 * @param binarynuma The first binary operand for the AND operation
 * @param binarynumb The second binary operand for the AND operation
 * @return A binary variable with a value of <i>binarynuma & binarynuma</i>.
 */

	public static Binary and(Binary binarynuma,Binary binarynumb){

		int lengtha = binarynuma.number.length();
		int lengthb = binarynumb.number.length();

		//sets max binary # length, ex if lengtha is 101 and lengthb is 101111, max length is 6 
		int lengthfinal = Math.max(lengtha, lengthb);

		// pads binarynuma with 0's to ensure binarynuma and binarynumb same length (lengthfinal)
		while (binarynuma.number.length() < lengthfinal) {
            binarynuma.number = "0" + binarynuma.number;
        }

		// pads binarynumb with 0's to ensure binarynuma and binarynumb same length (lengthfinal)
		while (binarynumb.number.length() < lengthfinal) {
            binarynumb.number = "0" + binarynumb.number;
        }

		StringBuilder result = new StringBuilder();

// iterates through each binary # and performs and operation, and gives binary result of and operation 
		for (int i = 0; i < lengthfinal; i++) {
			char binarynumber1 = binarynuma.number.charAt(i);
			char binarynumber2 = binarynumb.number.charAt(i);
			char binaryandresult = (binarynumber1 == '1' && binarynumber2 == '1') ? '1': '0';
			result.append(binaryandresult);
				}

				return new Binary(result.toString());
	}

	// or code 
/**
 * 
 * @param binarynuma The first binary operand for the OR operation
 * @param binarynumb The second binary operand for the OR operation
 * @return A binary variable with a value of <i>binarynuma | binarynuma</i>.
 */
	public static Binary or(Binary binarynuma,Binary binarynumb){

		int lengtha = binarynuma.number.length();
		int lengthb = binarynumb.number.length();

		//sets max binary # length, ex if lengtha is 101 and lengthb is 101111, max length is 6 
		int lengthfinal = Math.max(lengtha, lengthb);

		// pads binarynuma with 0's to ensure binarynuma and binarynumb same length (lengthfinal)
		while (binarynuma.number.length() < lengthfinal) {
            binarynuma.number = "0" + binarynuma.number;
        }

		// pads binarynumb with 0's to ensure binarynuma and binarynumb same length (lengthfinal)
		while (binarynumb.number.length() < lengthfinal) {
            binarynumb.number = "0" + binarynumb.number;
        }

		StringBuilder result = new StringBuilder();

// iterates through each binary # and performs or operation, and gives binary result of or operation 
		for (int i = 0; i < lengthfinal; i++) {
			char binarynumber1 = binarynuma.number.charAt(i);
			char binarynumber2 = binarynumb.number.charAt(i);
			char binaryorresult = (binarynumber1 == '1' || binarynumber2 == '1') ? '1': '0';
			result.append(binaryorresult);
				}

				return new Binary(result.toString());
	}


	//multiply code
	
/**
 * 
 * @param binarynuma The first binary multiplicand for the multiply operation
 * @param binarynumb The second binary multiplier for the multiply operation
 * @return A binary variable with a value of <i>binarynuma * binarynuma</i>.
 */

	public static Binary multiply(Binary binarynuma,Binary binarynumb) {

		int multiplicand = Integer.parseInt(binarynuma.number, 2);
		int multiplier = Integer.parseInt(binarynumb.number, 2);
		int lengthfinal = Math.max(binarynuma.number.length(), binarynumb.number.length());

		// pads binarynuma with 0's to ensure binarynuma and binarynumb same length (lengthfinal)
		while (binarynuma.number.length() < lengthfinal) {
            binarynuma.number = "0" + binarynuma.number;
        }

		// pads binarynumb with 0's to ensure binarynuma and binarynumb same length (lengthfinal)
		while (binarynumb.number.length() < lengthfinal) {
            binarynumb.number = "0" + binarynumb.number;
        }

		// multiplies multiplicand with multiplier and value stored in result 
		int result = multiplicand * multiplier;
		
		// converts the integer result from above operation to binary string 
		String Binarymultiplyresult = Integer.toBinaryString(result);

		//output 
		return new Binary(Binarymultiplyresult);

	}

}	
