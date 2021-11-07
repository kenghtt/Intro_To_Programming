/**
 * @author Jeremy Yang
 * EN.605.201.81.FA21
 * Assignment 9
 */
public class ArrayIndexOutOfBoundsExceptionCatch {
    public static void main(String[] args) {

        try{
            String[] array = {"One", "Two", "Three"};

            System.out.println(array[10]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Exception: The Array Index is out of range!");
        }




    }
}
