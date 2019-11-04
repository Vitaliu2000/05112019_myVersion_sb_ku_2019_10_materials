package ru.itvitality.sbrf.cu.rj.atm;

import java.util.HashMap;

public class QA {
    public static void main(String[] args) {
        String str = "olah billo:78517700-1f01-11e3-a6b7-3c970e02b4ec, jiglo piglo:68517700-1f01-11e3-a6b7-3c970e02b4ec, nimho james:98517700-1f01-11e3-a6b7-3c970e02b4ec, kathy ruck:38517700-1f01-11e3-a6b7-3c970e02b4ec";
        String[] splitComma = str.split(",");
        String[] splitColon = splitComma[0].split(":");
        HashMap<String, String> finlMapArr = new HashMap<>();
        for (int j = 0; j < splitComma.length; j++) {
            splitColon = splitComma[j].split(":");
            finlMapArr.put(splitColon[0] , splitColon[1]);
        }

        System.out.println("111 = " + finlMapArr);
    }
}
