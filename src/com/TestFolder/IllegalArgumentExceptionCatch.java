
package com.TestFolder;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class IllegalArgumentExceptionCatch {

    public static void main(String[] args) {

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dddddddddd");
;
        }catch (IllegalArgumentException illegalArgumentException){
            System.out.println("Exception: Date format is not correct, it should be in format yyy/MM/dd");
        }


    }


}
