/**
 * @author Jeremy Yang
 * EN.605.201.81.FA21
 * Assignment 9
 */

public class ClassCastExceptionCatch {
    public static void main(String[] args) {

        try{
            Object i = String.valueOf(10);
            int s = (int)i;
        } catch (ClassCastException classCastException){
            System.out.println("Exception: The object is unable to be casted");
        }


    }
}
