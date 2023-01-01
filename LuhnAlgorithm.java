
/**
 * The Luhn algorithm ("modulus 10" or "mod 10" algorithm, Luhn formula) is a 
 * simple checksum formula used to validate a variety of identification 
 * numbers, such as credit card numbers (PAN) or IMEI numbers. 
 * 
 * @author Hans Peter Luhn - IBM scientist
 * 
 * This algorithm is designed to protect again mistyped or accidental error 
 * rather than malicious attacks. Most credit card companies adopted this 
 * algorithm as this was available in the public domain and can be used by 
 * anyone.
 * 
 * Algorithm from https://en.wikipedia.org/wiki/Luhn_algorithm
 * 
 * ---- Computing Check Digit ----
 * The check digit is computed as follows:
 * 1. If the number already contains the check digit, drop that digit to form 
 * the "payload." The check digit is most often the last digit.
 * 2. With the payload, start from the rightmost digit. Moving left, double 
 * the value of every second digit (including the rightmost digit). 
 * 3. Sum the digits of the resulting value in each position (using the 
 * original value where a digit did not get doubled in the previous step).
 * 4. The check digit is calculated by (10 - (s mod 10)) mod 10. 
 *  This is the least number (possibly zero) that must be added to s to make a 
 *  multiple of 10.
 * 
 * Other valid formulas giving the same value are:
 *  (1000 - s) mod 10 
 * 
 * Assume an example of an account number "7992739871" (just the "payload", 
 * check digit not yet included):
 * 
 *  7992739871
 *  1212121212              [Multipliers]
 * 7(18)9(4)7(6)9(16)7(2)   
 * 7(1+8)9(4)7(6)9(1+6)7(2)  [If product of doubling is greater than 9]
 * 7(9)9(4)7(6)9(7)7(2)      [Sum digits of the products or subtract 9]
 *  = 67                     [Take sum of all digits]
 *  (10-(67 % 10)) % 10      [Check digit = (10 - (67 mod 10))mod 10  ]
 *  = 3                       // Check Digit = 3
 * Full Account Number = 79927398713
 * 
 * 
 * ---- Validating Check Digit ----
 *  1. Drop the check digit (last digit) of the number to validate. 
 *  (e.g. 79927398713 -> 7992739871)
 * 
 *  2. Calculate the check digit 
 * 
 *  3. Compare result with original check digit. If both numbers match, result
 *  is valid
 * 
 * --- Implemented a method that makes an invalid number valid ----
 */
public class LuhnAlgorithm {
    
    // Prevent Instantiation
    private LuhnAlgorithm(){ }

    /**
     * Checks if card number is valid. Validates the check digit.
     * @param card card number
     * @return true if card is valid, false otherwise
     */
    public static boolean luhnCheck(String card){
        if(card == null) { 
            return false;
        }

        // Compute checkDigit
        char checkDigit = card.charAt(card.length() - 1);
        String digit = computeCheckDigit(card.substring(0, card.length() - 1));
        return checkDigit == digit.charAt(0); // Compare checkDigit with result
    }

    /**
     * Calculates the last digits for the card number received as parameter
	 * @param card number
	 * @return the check digit as a String
     */
    public static String computeCheckDigit(String card){
        if (card == null) {
            return null;
        }
    
        // Convert string to array of ints
        int[] digits = new int[card.length()];
        for (int i = 0; i < card.length(); i++) {
            digits[i] = Character.getNumericValue(card.charAt(i));
        }
    
        // From rightmost digit, double every other digit
        for (int i = digits.length - 1; i >= 0; i -= 2)	{
            digits[i] += digits[i];
        
            /* Product of this doubling operation is greater than 9, then sum 
            the digits of the products or alternatively subtract 9 from the 
            product. */
            if (digits[i] >= 10) {
                digits[i] = digits[i] - 9;
            }
        }

        // Take the sum of all the digits.
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
        }

        // (10 - (sum mod 10)) mod 10
        return String.valueOf( (10 - (sum % 10)) % 10);

       /* Alternatively, we can multiply sum by 9, and convert int to
        * String, then return the last digit. Code below to show how.
        */
        // sum = sum * 9;
        // // Convert back to string for last digit extraction
        // String digit = String.valueOf(sum);
        // return digit.substring(digit.length() - 1); 
    }

    /**
     * Turns an invalid number to a valid one. Appends check digit.
     * @return the newly valid number
     */
    public static String makeValidNumber(String num){
        if(!luhnCheck(num)) {
            StringBuilder sb = new StringBuilder(num);
            String checkDigit = computeCheckDigit(num);
            return sb.append(checkDigit).toString();
        } 
        return num;
    }


    /**
     * Outputs to the terminal if the given number is valid.
     */
    private static void outputValidNumber(String card){

        if(luhnCheck(card)){
            System.out.printf("%s is valid.\n", card);
            // System.out.println(card + " is valid as per luhn algorithm");
        } else {
            System.out.printf("%s is invalid.\n", card);
            // System.out.println(card + " is not valid as per luhn algorithm");
        }

    }

    /**
     * Quick Tests
     */
    public static void main(String[] args)	{
		System.out.println("\t\t----- Luhn Algorithm Test -----\n");

        System.out.println("\t\t----- Validate Card number -----\n");
        String cardNumber="79927398713";
        outputValidNumber(cardNumber);

        outputValidNumber("7992739871");

        System.out.println("Turning 7992739871 into valid number -> " 
            + makeValidNumber("7992739871"));

        System.out.println();

        outputValidNumber("42");
        System.out.println();

        outputValidNumber("4552720412345678");

        cardNumber = makeValidNumber("4552720412345678");
        System.out.println("Turning 4552720412345678 into valid number -> " 
            + cardNumber);

        outputValidNumber(makeValidNumber("4552720412345678"));
        System.out.println();

        outputValidNumber("400000683154027");
        outputValidNumber(makeValidNumber("400000683154027"));

        System.out.println("\n\t\t----- Validate PAN numbers -----\n");

        String pan1 = "37828224631000";
		System.out.println("Calculate check digit for: " + pan1);
		String digit = computeCheckDigit(pan1);

		System.out.println("Check digit: " + digit);
		System.out.println();
		

		String pan2 = "4012888888881881";
		System.out.println("Validate pan number '" + pan2 + "': " + luhnCheck(pan2));
		System.out.println();
	}
}