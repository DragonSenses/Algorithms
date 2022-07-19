import java.util.Scanner;

/**
 * The Fibonacci series, is a series of numbers in which each number
 * (Fibonacci number) is the sum of the two preceding numbers.
 * 
 * Fn = {0, 1, 1, 2, 3, 5, 8, 13, 21, 
 *      34, 55, 89, 144, 233, 377, 610, 987....}
 * Fn = Fn-1 + Fn-2
 * 
 * If one were to draw a line starting in the right bottom corner of
 * a golden rectangle within the first square and then touch each 
 * succeeding multiple squares outside corners, you would create a 
 * Fibonacci spiral.
 * 
 * The beauty in this sequence is how it represents structures and 
 * sequences that model physical reality, as it appears in the 
 * smallest to the largest objects in Nature. From petals,
 * rows of seeds, chicken eggs, nautilus shells, and even spirals.
 * 
 * The Fibonacci sequence is a way for information to flow in a very 
 * efficient manner. 
 * 
 * We can generate the progression of Fibonacci numbers by defining
 * recursively 
 * - F0 = 0
 * - F1 = 1
 * - Fn = Fn-2 + Fn-1   (for n > 1)
 * 
 * Time Complexity of Recursive Fibonacci
 * F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2)
 * 
 * The recursive equation is
 * T(n) = T(n-1) + T(n-2) + O(1)
 * 
 * The upper bound of Fibonacci sequence is O(2^n)
 * 
 * Time to calculate fb(n) is equal to sum of time
 * to calculate fb(n-1) and fb(n-2) including 
 * constant time to perform previous additions.
 *  
 * Characteristic equation is 
 * x^2 = x + 1
 * x^2 - x - 1 = 0
 * 
 * Roots: 
 * x1 = (1+sqrt(5))/2 
 * x2 = (1-sqrt(5))/2
 * 
 * Plug in roots to characteristic equation where linear
 * recursive function is
 * F(n) = (x1)^n + (x2)^n
 * F(n) = [(1+sqrt(5))/2]^n + [(1-sqrt(5))/2]^n
 * 
 * T(n) and F(n) are asymptotically the same as both functions
 * represent the same sequence. Therefore, dropping lower order
 * terms via Big O notation, we get: 
 * T(n) = O(([(1+sqrt(5))/2]^n + [(1-sqrt(5))/2]^n))
 * T(n) = O((1+sqrt(5) /2)^n)
 * T(n) = O(1.6180)^n
 * 
 * This is the tight upper bound of fibonacci.
 *  
 * 1.6180 is called the golden ratio
 */
public class Fibonacci {
    /**
     * Returns the nth Fibonacci Number (inefficiently) [O(2^n)]
     * This recursive implementation computes a Fibonacci number
     * by making two recursive calls in each non-base case. 
     * @param n     The nth Fibonacci Number in the sequence
     * @return The nth Fibonacci number
     */
    public static long fibonacciBad(int n){
        if( n <= 1) {
            return n;
        } else {
            return fibonacciBad(n-2) + fibonacciBad(n-1);
        }
    } // Computes fibonacci through binary recursion

    /**
     * Although fibonacciBad() is easy to implement, its inefficiency
     * requires an exponential number of calls to the method. Let us take
     * n = 8, we can see how the number of calls more than doubles for
     * each two consecutive indicies (example c(n=4) has more than twice 
     * calls of c(n=2) and c(n=5) is more than twice the calls of c(n=3))
     * Abstractly this is c(n) > 2^(n/2) 
     * 
     * c0 = 1
     * c1 = 1
     * c2 = 1 + c0 + c1 = 1 + 1 + 1 = 3
     * c3 = 1 + c1 + c2 = 1 + 1 + 3 = 5
     * c4 = 1 + c2 + c3 = 1 + 3 + 5 = 9
     * c5 = 1 + c3 + c4 = 1 + 5 + 9 = 15
     * c6 = 1 + c4 + c5 = 1 + 9 + 15 = 25
     * c7 = 1 + c5 + c6 = 1 + 15 + 25 = 41
     * c8 = 1 + c6 + c7 = 1 + 25 + 41 = 67
     * 
     * Note how c6 has more than twice the calls of c4. It is tempting to
     * use bad recursive formulation because of how Fibonacci number nth
     * depends on two previous values Fn-2 and Fn-1. But after computing
     * Fn-2 the call to compute Fn-1 requires its own recursive call to
     * compute Fn-2, as it has no prior knowledge of the value of Fn-2
     * that was computer at the earlier level of recursion. Even worse,
     * both of those calls will need to recompute the value of Fn-3, as
     * will the computation of Fn-1. This snowballing effect is duplicative
     * work that leads to exponential running time.
     */

     /** Improvement: Method passes more information from one level of recursion
      * to the next will make it easeier to continue the process as it allows us
      * to avoid having to recompute the second value that was already known 
      * within the recursion. To do this we redefine the expectations of the 
      * method and instead compute Fn more efficiently using a recursion in which
      * each invocation makes only one recursive call. Instead of expecting a 
      * single value to be returned, we redfine it such that it returns an array
      * with two consecutive Fibonacci numbers {Fn, Fn-1} with F-1 = 0 (by convention)
      * It may seem a greater burden to report two consecutive FIbonacci numbers
      * instead of one, but this extra infromation avoids recomputing known values
      * within the recursion.
      */
     /** 
      * Returns an array containing the pair of Fibonacci Numbers F(n) and F(n-1)
      *
      * Runs in O(n) time as each recursive call decreases the argument n by 1; so
      * a recursion trace includes a series of n methhod calls. The nonrecursive
      * work for each call uses constant time, then the overall computation 
      * executes in O(n) time
      *  
      * @param n The nth Fibonacci number to retrieve the array from
      * @return A long array containing the pair of Fibonacci Numbers F(n) and F(n-1)
      */
    public static long[] fibonacciGood(int n){
        if(n <= 1) {
            long[] pair = {n, 0};
            return pair;
        } else {
            long[] aux = fibonacciGood(n-1);            // Returns {Fn-1, Fn-2}
            long[] answer = {aux[0] + aux[1], aux[0] }; // Want    {Fn, Fn-1}
            return answer;
        }
    } 

    // Not fully tested: Seems to have negative values at n = 47 and 49
    // Output:   47: -1323752223,  49: -811192543
    // Expected: 47:  2971215073,  49: 7778742049
    /** 
     * An iterative fibonacci method that takes in the n from the user input, and
     * prints out nth number of fibonacci sequence starting from 0. 
     * @return The nth fibonacci number
     */
    public static int fibonacciIterative(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter nth number of fibonacci sequence: ");
        int n = sc.nextInt();
        sc.close();
        System.out.println("Starting Sequence " + n + " times...");
        // We know that the first 2 values in the sequence start with 0 and 1
        int fn1 = 0;
        int fn = 1;
        int answer = 0;
        for(int i = 0; i<n; i++){
            if( i <= 1) {
                answer = i;
            } else {
                answer = fn1 + fn;
                fn1 = fn;
                fn = answer;
            }
            System.out.println(i + ": " + answer);
        }
        
        return answer;
    }


    public static void main(String[] args){
        // Warning: bad Fibonacci runs really slow at 40+, 45 is ok, 50 is horrendous
        final int limit = 50;
        final int badLimit = 40;

        System.out.println("The good...");
        for (int n = 0; n < limit; n++)
            System.out.println(n + ": " + fibonacciGood(n)[0]);

        System.out.println();
        System.out.println("The bad...");
        for (int n = 0; n < badLimit; n++)
            System.out.println(n + ": " + fibonacciBad(n));

        System.out.println();
        System.out.println("Try it yourself");
        fibonacciIterative();

        System.out.println(); //2,147,483,647
        System.out.println("For reference here is MAX_VALUE: " + Integer.MAX_VALUE); 

    }
}
