
package com.TestFolder;

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
