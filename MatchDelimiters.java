import java.util.Stack;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/** Work In Progress
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
    @Test
    public void simpleDelimeter(){
        assertAll("",
            () -> assertEquals(true,isMatched("()")),
            () -> assertEquals(true,isMatched("{}")),
            () -> assertEquals(true,isMatched("[]"))
        );
    }

    @Test
    public void validOne(){
        assertTrue(isMatched("()(()){([()])}"));
    }

    @Test
    public void validTwo(){
        assertTrue(isMatched("( ) ( ( ) ) {( [ ( )  ] ) } "));
    }

    @Test
    public void validThree(){
        assertTrue(isMatched("(3) (3 + (4 - 5) ) {( [ ( )  ] ) } "));
    }

    @Test
    public void validFour(){
        assertTrue(isMatched("((()(()){([()])}))"));
    }

    @Test
    public void validFive(){
        assertTrue(isMatched("[(5+x)-(y+z)]"));
    }

    @Test
    public void invalidOne(){
        assertEquals(false,isMatched("("));
    }

    @Test
    public void invalidTwo(){
        assertEquals(false,isMatched("({[])}"));
    }

    @Test
    public void invalidThree(){
        assertEquals(false,isMatched(")(()){([()])}"));
    }
}
