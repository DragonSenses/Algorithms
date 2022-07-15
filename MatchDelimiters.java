import java.util.Scanner;
import java.util.Stack;

/**
 * Matching delimeters in a String.
 */
public class MatchDelimiters {
    
    public static boolean isMatched(String expression){
        final String opening  = "({[";                  // opening delimiters
        final String closing  = ")}]";                  // respective closing delimiters
        Stack<Character> buffer = new Stack<>(); 

        //For every character c within the expression
        for(char c: expression.toCharArray()){ 
            if(opening.indexOf(c) != -1){               // c is a left delimiter
                buffer.push(c);     
            } else if(closing.indexOf(c) != -1) {       // c is a right delimiter
                if (buffer.isEmpty()) { return false; } // There are no Matches 
                if (closing.indexOf(c) != opening.indexOf(buffer.pop())){
                    return false;                       // Mismatched Delimiter
                }
            }   
        }

        return buffer.isEmpty();    // Empty Stack -> All Opening Delimiters matched
    }

    /** Test Cases **/
    final static String[] valid = {
        "()(()){([()])}",
        "( ) ( ( ) ) {( [ ( )  ] ) } ",
        "(3) (3 + (4 - 5) ) {( [ ( )  ] ) } ",
        "((()(()){([()])}))",
        "[(5+x)-(y+z)]"
      };
    
      final static String[] invalid = {
        ")(()){([()])}",
        "({[])}",
        "("
      };

    public static void main(String[] args) {

        for (String s : valid) {
            if (!isMatched(s))
            System.out.println("Error evaluating valid: " + s);
        }
        for (String s : invalid) {
            if (isMatched(s))
            System.out.println("Error evaluating invalid: " + s);
        }
    }
}
