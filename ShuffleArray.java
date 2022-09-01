import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * An algorithm thatt shuffles the values in an Array, or rearrange the order
 * at which the values appear (indexes of the values in the array).
 */
public class ShuffleArray {
    private static boolean debug = true; 

    private static void shuffle(int[] arr){
        int randomIndex;
        int temp;
        for(int i = 0; i < arr.length; i++){
            randomIndex = ThreadLocalRandom.current().nextInt(arr.length);
            temp = arr[randomIndex]; // Store the integer value at random index
            // Swap the Values
            arr[randomIndex] = arr[i];
            arr[i] = temp;  
        }
        if(debug) {System.out.println(Arrays.toString(arr)); }
    }

    public static void main(String[] args){
        
    }
}
