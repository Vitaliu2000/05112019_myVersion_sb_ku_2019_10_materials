package ru.itvitality.sbrf.cu.rj.atm;

import java.io.*;

public class Test {

    public static void main(String args[]) {
        //String Str = new String("Разделяем эту строку на слова");
        String Str = new String("" +
                "5000:0\n" +
                "500:1\n" +
                "100:0\n" +
                "200:0\n" +
                "1000:1\n" +
                "2000:0");
        for (String retval : Str.split(":")) {
            System.out.println(retval);
        }
    }
}
