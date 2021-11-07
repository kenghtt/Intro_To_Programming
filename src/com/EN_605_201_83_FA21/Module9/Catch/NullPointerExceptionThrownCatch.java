/**
 * @author Jeremy Yang
 * EN.605.201.81.FA21
 * Assignment 9
 */

public class NullPointerExceptionThrownCatch {

    public static void main(String[] args) {

        try {
            String nullStirng = null;

            System.out.println(nullStirng.length());
        }catch (NullPointerException nullPointerException){

            System.out.println("Exception: Cannot get length of a value that is null");
        }


    }


}
